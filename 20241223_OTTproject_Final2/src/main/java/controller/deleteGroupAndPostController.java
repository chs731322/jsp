package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GroupMemberService;
import service.PostService;
import view.ModelAndView;

public class deleteGroupAndPostController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String postnum = request.getParameter("postnum");
		int c = GroupMemberService.getInstance().deleteGM(postnum);
		c = PostService.getInstance().deleteGroup(postnum);
		c = PostService.getInstance().deletePost(postnum);
		ModelAndView view = new ModelAndView();
		view.setRedirect(false);
		view.setPath("./postlistview.do?platformnum=" + request.getParameter("platformnum"));
		return view;
	}

}
