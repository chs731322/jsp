package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import dto.GroupMemberDTO;
import dto.UsersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GroupMemberService;
import view.ModelAndView;

public class UpdatePaymentController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");

	    // 세션에서 사용자 정보 가져오기
	    UsersDTO sessionUser = (UsersDTO) request.getSession().getAttribute("user");

	    if (sessionUser == null) {
	        response.getWriter().write("<script>alert('로그인이 필요합니다.'); location.href='login.jsp';</script>");
	        return null;
	    }

	    String userId = sessionUser.getId();
	    String platformNum = request.getParameter("platformNum");
	    String gno = request.getParameter("gno");

	    if (platformNum == null || gno == null) {
	        response.getWriter().write("<script>alert('플랫폼 번호와 그룹 번호가 필요합니다.'); location.href='dashboard.jsp';</script>");
	        return null;
	    }

	    try {
	        List<GroupMemberDTO> groupMemberList = GroupMemberService.getInstance().getGroupMemberById(userId);

	        if (groupMemberList == null || groupMemberList.isEmpty()) {
	            response.getWriter().write("<script>alert('데이터가 존재하지 않습니다.'); location.href='dashboard.jsp';</script>");
	            return null;
	        }

	        boolean isUpdated = false;

	        for (GroupMemberDTO member : groupMemberList) {
	            if (member.getId().equals(userId) && member.getPlatformNum().equals(platformNum) && member.getGno().equals(gno)) {
	                member.setPayment(1); // payment 값을 1로 설정
	                member.setCreatedDate(LocalDateTime.now()); // 현재 시간 추가
	                GroupMemberService.getInstance().updatePayment(member);
	                isUpdated = true;
	                break;
	            }
	        }

	        if (!isUpdated) {
	            response.getWriter().write("<script>alert('일치하는 데이터가 없습니다.'); location.href='dashboard.jsp';</script>");
	            return null;
	        }

	        ModelAndView view = new ModelAndView();
	        view.setPath("timer.do"); // TimerController로 경로 설정
	        view.setRedirect(false);
	        return view;

	    } catch (ClassCastException e) {
	        e.printStackTrace();
	        response.getWriter().write("<script>alert('타입 오류가 발생했습니다. 관리자에게 문의하세요.'); location.href='error.jsp';</script>");
	        return null;
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.getWriter().write("<script>alert('알 수 없는 오류가 발생했습니다. 관리자에게 문의하세요.'); location.href='error.jsp';</script>");
	        return null;
	    }
	}
}