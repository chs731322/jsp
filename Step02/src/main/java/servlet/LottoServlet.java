package servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LottoServlet")
public class LottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String countStr = request.getParameter("count");
        int count = 0;
        List<List<Integer>> lottoSets = new ArrayList<>();

        try {
            count = Integer.parseInt(countStr);
            if (count <= 0) {
                throw new NumberFormatException("양의 정수를 입력해야 합니다.");
            }

            for (int i = 0; i < count; i++) {
                List<Integer> lottoSet = generateLottoNumbers();
                lottoSets.add(lottoSet);
            }

            // 데이터 request 영역에 저장
            request.setAttribute("count", count);
            request.setAttribute("lottoSets", lottoSets);
        } catch (NumberFormatException e) {
            // 유효하지 않은 입력 처리
            request.setAttribute("errorMessage", "올바른 양의 정수를 입력해주세요.");
        }

        // 결과 JSP 페이지로 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("q2_lotto_result.jsp");
        dispatcher.forward(request, response);
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> lottoSet = numbers.subList(0, 6);
        Collections.sort(lottoSet);
        return lottoSet;
    }
}
