package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import view.ModelAndView;

public class DeleteProfileImgController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청 파라미터로부터 이미지 정보 가져오기
		String profileImg = request.getParameter("profileImg");

		// 이미지 삭제 결과 처리
		UserService.getInstance().deleteProfileImg(profileImg);

		ModelAndView view = new ModelAndView();

		view.setPath("./mypage_view.do");
		view.setRedirect(true);

		return view;
	}
}
