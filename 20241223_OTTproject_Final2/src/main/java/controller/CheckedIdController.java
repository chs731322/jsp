package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import view.ModelAndView;

public class CheckedIdController implements Controller {

    private UserService memberService = new UserService(); // 회원 서비스 클래스

    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 클라이언트로부터 전달된 ID 가져오기
        String id = request.getParameter("id");

        // 현재 날짜와 시간 가져오기
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // ID 중복 여부 확인
        boolean isAvailable = UserService.isIdAvailable(id); // 데이터베이스에서 확인

        // 중복 여부 결과를 요청에 저장
        request.setAttribute("isAvailable", isAvailable);
        request.setAttribute("currentTime", currentTime);

        // 응답 데이터 준비
        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().write(isAvailable ? "available" : "unavailable");
        
        return null;

    }
}
