package controller;

import java.io.IOException;

import dto.UsersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import view.ModelAndView;

public class UserInfoUpdateController implements Controller {

    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 입력값 가져오기
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String birth = request.getParameter("birth");
        String email = request.getParameter("email");
        String account = request.getParameter("account");

        // 입력값 검증
        if (name == null || name.isEmpty() ||
            password == null || password.isEmpty() ||
            email == null || email.isEmpty()) {
            response.getWriter().write("<script>alert('모든 필드를 채워주세요.'); history.back();</script>");
            return null;
        }

        if (!password.equals(password2)) {
            response.getWriter().write("<script>alert('비밀번호가 일치하지 않습니다.'); history.back();</script>");
            return null;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            response.getWriter().write("<script>alert('이메일 형식이 올바르지 않습니다.'); history.back();</script>");
            return null;
        }

        // 계좌번호는 선택 항목
        if (account != null && !account.isEmpty() && !account.matches("\\d+")) {
            response.getWriter().write("<script>alert('계좌 란에는 숫자만 입력할 수 있습니다.'); history.back();</script>");
            return null;
        }

        // 생년월일 기본값 설정
        if (birth == null || birth.isEmpty()) {
            birth = "1980-01-01"; // 기본값 설정
        }

        // DTO 생성
        UsersDTO dto = new UsersDTO(id, name, email, birth, password, account);

        try {
            UserService.getInstance().updateUserInfo(dto);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("<script>alert('서버 오류가 발생했습니다. 다시 시도해주세요.'); history.back();</script>");
            return null;
        }

        // 성공 시 뷰 설정
        ModelAndView view = new ModelAndView();
        view.setPath("mypage_view.do");
        view.setRedirect(true);

        return view;
    }
}
