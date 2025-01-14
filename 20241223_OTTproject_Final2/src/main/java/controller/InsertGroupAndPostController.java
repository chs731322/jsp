package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import dto.PostDTO;
import dto.GroupMemberDTO;
import dto.UsersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GroupMemberService;
import service.PostService;
import service.UserService;
import view.ModelAndView;

public class InsertGroupAndPostController implements Controller {

    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 세션에서 사용자 정보 가져오기
        UsersDTO sessionUser = (UsersDTO) request.getSession().getAttribute("user");
        
        // null 체크
        if (sessionUser == null) {
            response.getWriter().write("<script>alert('로그인이 필요합니다. 다시 로그인해주세요.'); location.href='login.jsp';</script>");
            return null;
        }

        // DB에서 최신 사용자 정보 가져오기
        UsersDTO updatedUser = UserService.getInstance().selectUserById(sessionUser.getId());
        if (updatedUser != null) {
            request.getSession().setAttribute("user", updatedUser); // 세션 업데이트
        } else {
            response.getWriter().write("<script>alert('사용자 정보를 불러올 수 없습니다. 다시 로그인해주세요.'); location.href='login.jsp';</script>");
            return null;
        }

        // DTO 객체 생성 및 설정
        PostDTO dto = new PostDTO();
        String platformNum = request.getParameter("platformnum");
        dto.setPlatformNum(platformNum);
        dto.setId(sessionUser.getId());
        dto.setOttid(request.getParameter("ottid")); 
        
        // 중복 계정 체크
        ArrayList<PostDTO> list = (ArrayList<PostDTO>) PostService.getInstance().searchott(dto);

        ModelAndView view = new ModelAndView();
        view.setRedirect(false);
        view.setPath("./postlistview.do?platformnum=" + platformNum);

        if (list.size() != 0) {
            request.setAttribute("errorMessage", "이미 공유중인 OTT 계정입니다.");
            return view; // 중복 계정 오류 처리
        }

        // Unique PostNum 생성
        int seconds = (int) ChronoUnit.SECONDS.between(LocalDateTime.of(1970, 1, 1, 0, 0, 0), LocalDateTime.now());
        seconds -= 1000000000; // 밀리초 보정
        String postNum = String.valueOf(seconds);

        // DTO에 나머지 값 설정
        dto.setPostNum(postNum);
        dto.setPostData(request.getParameter("postdata"));
        dto.setOttpassword(request.getParameter("ottpassword"));
        dto.setShareNum(request.getParameter("sharenum"));

        // DB 작업
        try {
            int groupInserted = PostService.getInstance().insertGroup(dto);
            int postInserted = PostService.getInstance().insertPost(dto);
            int groupMemberInserted = PostService.getInstance().insertGroupMember(dto);

            // Payment 업데이트
            GroupMemberDTO groupMemberDTO = new GroupMemberDTO();
            groupMemberDTO.setId(sessionUser.getId());
            groupMemberDTO.setGno(postNum);
            groupMemberDTO.setPlatformNum(platformNum);
            groupMemberDTO.setPayment(1);
            
            int paymentUpdated = GroupMemberService.getInstance().updateOnlyPayment(groupMemberDTO);

            if (groupInserted > 0 && postInserted > 0 && groupMemberInserted > 0 && paymentUpdated > 0) {
                request.setAttribute("successMessage", "게시글 작성이 성공적으로 완료되었습니다.");
            } else {
                request.setAttribute("errorMessage", "게시글 작성 중 오류가 발생했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "게시글 작성 중 예기치 못한 오류가 발생했습니다.");
        }

        return view;
    }
}
