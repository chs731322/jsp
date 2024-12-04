package servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("비밀번호 해싱 실패", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id"); // 사용자 ID 가져오기
        memberInfoMapper mapper = DBManager.getInstance().getSession().getMapper(memberInfoMapper.class);
        UsersDTO user = mapper.selectUserById(id); // 사용자 정보 조회
        if (user != null) {
            request.setAttribute("user", user); // JSP로 사용자 정보 전달
            request.getRequestDispatcher("mypage.jsp").forward(request, response);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("<script>alert('사용자 정보를 불러오는 데 실패했습니다.'); location.href='mypage.jsp';</script>");
        }
    }

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String birth = request.getParameter("birth");
        String email = request.getParameter("email");

        response.setContentType("text/html;charset=UTF-8");

        // 입력값이 비어있을 경우
        if (name == null || name.isEmpty() || password == null || password.isEmpty() 
            || birth == null || birth.isEmpty() || email == null || email.isEmpty()) {
            response.getWriter().write("<script>alert('모든 필드를 채워주세요.'); location.href='mypage.jsp';</script>");
            return;
        }

        // 비밀번호가 일치하지 않을 경우
        if (!password.equals(password2)) {
            response.getWriter().write("<script>alert('비밀번호가 일치하지 않습니다.'); location.href='mypage.jsp';</script>");
            return;
        }
        
        // 이메일 형식이 올바르지 않을 경우
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            response.getWriter().write("<script>alert('이메일 형식이 올바르지 않습니다.'); location.href='mypage.jsp';</script>");
            return;
        }

        String hashedPassword = hashPassword(password);

        UsersDTO dto = new UsersDTO();
        dto.setId(id);
        dto.setPassword(hashedPassword);
        dto.setBirth(birth);
        dto.setName(name);
        dto.setEmail(email);

        try {
            memberInfoMapper mapper = DBManager.getInstance().getSession().getMapper(memberInfoMapper.class);
            int count = mapper.updateMemberInfo(dto);
            if (count > 0) {
                response.getWriter().write("<script>alert('프로필이 성공적으로 업데이트되었습니다.'); location.href='mypage.jsp';</script>");
            } else {
                response.getWriter().write("<script>alert('프로필 업데이트에 실패했습니다. 관리자에게 문의하세요.'); location.href='mypage.jsp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("<script>alert('서버 오류가 발생했습니다. 나중에 다시 시도해주세요.'); location.href='mypage.jsp';</script>");
        }
	
	}

}
