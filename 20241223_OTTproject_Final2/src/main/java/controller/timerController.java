package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import dto.GroupMemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GroupMemberService;
import view.ModelAndView;

public class timerController implements Controller {

    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 작업 예약
        scheduleUpdateTask();

        // 사용자에게 응답
        response.getWriter().write("작업이 예약되었습니다. 1분 뒤 실행됩니다.");

        ModelAndView view = new ModelAndView();
        view.setPath("ott_view.do"); // OTT 화면으로 이동
        view.setRedirect(false);
        return view;
    }

    private void scheduleUpdateTask() {
        Timer timer = new Timer();
        System.out.println("타이머 시작: 1분 뒤 작업이 실행됩니다.");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("타이머 작업 실행 중...");
                updateExpiredPayments();
                System.out.println("타이머 작업 완료.");
            }
        }, 60000); // 1분 = 60,000ms
    }

    private void updateExpiredPayments() {
        List<GroupMemberDTO> members = GroupMemberService.getInstance().getAllGroupMembers();

        for (GroupMemberDTO member : members) {
            if (member.getCreatedDate() != null && isDateExpired(member.getCreatedDate())) {
                member.setPayment(0); // payment를 0으로 설정
                member.setCreatedDate(null); // created_date를 null로 설정
                GroupMemberService.getInstance().updatePayment(member); // DB 갱신
                System.out.println("갱신 완료: " + member.getId());
            }
        }
    }

    private boolean isDateExpired(LocalDateTime createdDate) {
        // 30일 대신 1분 확인
        return createdDate.plusMinutes(1).isBefore(LocalDateTime.now());
    }
}
