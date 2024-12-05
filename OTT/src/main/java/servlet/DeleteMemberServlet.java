package servlet;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapper.memberInfoMapper;

/**
 * Servlet implementation class deleteMemberServlet
 */
@WebServlet("/deleteMember.do")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMemberServlet() {
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션 또는 요청에서 id 가져오기
        String id = (String) request.getSession().getAttribute("id");

        try (SqlSession session = DBManager.getInstance().getSession()) {
            memberInfoMapper mapper = session.getMapper(memberInfoMapper.class);

            // 회원번호를 기준으로 삭제
            int result = mapper.deleteMember(id);

            if (result > 0) {
                response.getWriter().write("<script>alert('회원탈퇴가 완료되었습니다.'); location.href='login.jsp';</script>");
            } else {
                response.getWriter().write("<script>alert('회원탈퇴에 실패했습니다. 관리자에게 문의하세요.'); location.href='mypage.jsp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace(); // 서버 로그 기록
            response.getWriter().write("<script>alert('서버 오류가 발생했습니다. 관리자에게 문의하세요.'); location.href='mypage.jsp';</script>");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
