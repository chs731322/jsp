package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.StudentVO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class JSTLServlet
 */
@WebServlet({ "/JSTLServlet", "/jstl.do" })
public class JSTLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSTLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. StudentVO 생성
		StudentVO vo = new StudentVO("20230001", "김철수", "컴퓨터공학", 3.8);
		
		// 2. ArrayList 하나 생성, StudentVO 객체를 5개 저장
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
        list.add(new StudentVO("20230002", "이영희", "경영학", 3.5));
        list.add(new StudentVO("20230003", "박민수", "전기공학", 4.0));
        list.add(new StudentVO("20230004", "최지혜", "심리학", 3.7));
        list.add(new StudentVO("20230005", "홍길동", "수학", 3.9));
        list.add(new StudentVO("20230007", "윤서연", "화학", 3.4));

		// 3. 정수 하나 선언해서 임의의 값으로 초기화
        int age = 44;
        
		// 4. request 영역에 데이터를 전부 저장
        request.setAttribute("vo", vo);
		request.setAttribute("list", list);
		request.setAttribute("age", age);
		
		// 5. 페이지 이동은 jstl_el.jsp로 이동 - forward
		request.getRequestDispatcher("jstl_el.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
