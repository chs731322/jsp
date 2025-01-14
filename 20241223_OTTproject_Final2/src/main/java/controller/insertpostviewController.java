package controller;

import java.io.IOException;

import dto.UsersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import view.ModelAndView;

public class insertpostviewController implements Controller {

    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 세션에서 사용자 정보 가져오기
        UsersDTO sessionUser = (UsersDTO) request.getSession().getAttribute("user");

        // null 체크: 로그인 여부 확인
        if (sessionUser == null) {
            // 세션에 사용자 정보가 없으면 로그인 페이지로 이동
            response.getWriter().write("<script>alert('로그인이 필요합니다. 로그인 페이지로 이동합니다.'); location.href='login.jsp';</script>");
            return null;
        }

        // DB에서 최신 사용자 정보 가져오기
        UsersDTO updatedUser = UserService.getInstance().selectUserById(sessionUser.getId());

        if (updatedUser != null) {
            request.getSession().setAttribute("user", updatedUser); // 세션 업데이트
        } else {
            // 사용자 정보 업데이트 실패 시 로그인 페이지로 리다이렉트
            response.getWriter().write("<script>alert('사용자 정보를 불러올 수 없습니다. 다시 로그인해주세요.'); location.href='login.jsp';</script>");
            return null;
        }

        // 로그인된 상태에서 글 작성 페이지로 이동
        ModelAndView view = new ModelAndView();
        view.setRedirect(false);
        view.setPath("insertpost.jsp");
        return view;
    }
}
