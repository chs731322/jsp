package servlet;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.UsersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapper.memberInfoMapper;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/updateProfile.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id = request.getParameter("id");
	    String password = request.getParameter("password");

	    if (id == null || id.isEmpty()) {
	        id = "12341234"; // 테스트용 id 설정
	    }

	    if (password == null || password.isEmpty()) {
	        password = "1234"; // 테스트용 password 설정
	    }

	    System.out.println("ID: " + id + ", Password: " + password);

	    // 요청 전달
	    memberInfoMapper mapper = DBManager.getInstance().getSession().getMapper(memberInfoMapper.class);
	    UsersDTO user = mapper.selectUserById(id);
	    if (user != null) {
	        request.setAttribute("user", user);
	        request.getRequestDispatcher("mypage.jsp").forward(request, response);
	    } else {
	        response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().write("<script>alert('사용자 정보를 불러오는 데 실패했습니다.'); location.href='mypage.jsp';</script>");
	    }
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		
		// Form 데이터 읽기
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String memberNum = request.getParameter("memberNum");

        // 디버깅: 폼 데이터 출력
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Birth: " + birth);
        System.out.println("Password: " + password);
        System.out.println("Password2: " + password2);
        System.out.println("MemberNum: " + memberNum);

        // 입력 데이터 검증
        if (id == null || name == null || email == null || birth == null || password == null || memberNum == null ||
                id.isEmpty() || name.isEmpty() || email.isEmpty() || birth.isEmpty() || password.isEmpty() || memberNum.isEmpty()) {
            response.getWriter().write("<script>alert('모든 필드를 입력하세요.'); location.href='mypage.jsp';</script>");
            return;
        }

        if (!password.equals(password2)) {
            response.getWriter().write("<script>alert('비밀번호가 일치하지 않습니다.'); location.href='mypage.jsp';</script>");
            return;
        }

		// 이메일 형식이 올바르지 않을 경우
		if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			response.getWriter().write("<script>alert('이메일 형식이 올바르지 않습니다.'); location.href='mypage.jsp';</script>");
			return;
		}

		// UsersDTO 객체 생성 및 값 설정
        UsersDTO user = new UsersDTO();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setBirth(birth);
        user.setPassword(password);
        user.setMemberNum(memberNum);

        // MyBatis를 사용한 데이터 업데이트
        try (SqlSession sqlSession = DBManager.getInstance().getSession()) {
            memberInfoMapper mapper = sqlSession.getMapper(memberInfoMapper.class);

            int result = mapper.updateMemberInfo(user); // 업데이트 실행

            System.out.println("MyBatis Update Result: " + result);
            if (result > 0) {
                response.getWriter().write("<script>alert('프로필 업데이트 성공'); location.href='mypage.jsp';</script>");
            } else {
                response.getWriter().write("<script>alert('프로필 업데이트에 실패했습니다. 관리자에게 문의하세요.'); location.href='mypage.jsp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("<script>alert('서버 오류가 발생했습니다. 관리자에게 문의하세요.'); location.href='mypage.jsp';</script>");
        }
    }

}
