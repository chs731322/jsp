package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.StudentVO;

import java.io.IOException;

/**
 * Servlet implementation class StudentRegister
 */
@WebServlet("/studentRegister.do")
public class StudentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentRegister() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentNo = request.getParameter("studentNo");
		String studentName = request.getParameter("studentName");
		String majorName = request.getParameter("majorName");
		String studentScore = request.getParameter("studentScore");

		String result = "학생 정보 : " + studentNo + " / " + studentName + " / " + majorName + " / " + studentScore;
		System.out.println(result);

		StudentVO vo = new StudentVO(studentNo, studentName, majorName, Double.parseDouble(studentScore));


		// student_result.jsp로 이동해서 vo에 있는 내용을 전부 출력
		request.setAttribute("vo", vo);

		request.getRequestDispatcher("student_result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글이 깨지는 현상이 발생할 시
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
