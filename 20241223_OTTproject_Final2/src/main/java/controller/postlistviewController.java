package controller;

import java.io.IOException;
import java.util.List;

import dto.PostDTO;
import dto.UsersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PostService;
import view.ModelAndView;

public class postlistviewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsersDTO user = (UsersDTO)request.getSession().getAttribute("user");
		
		List<PostDTO> list = PostService.getInstance()
				.platformnumPostList(request.getParameter("platformnum"));
		
		for (PostDTO post : list) {
		    System.out.println("Platformnum: " + post.getPlatformNum());
		    System.out.println("Post Num: " + post.getPostNum());
	        System.out.println("Now Num: " + post.getNowNum());
		}
		
		ModelAndView view = new ModelAndView();
		view.addObject("postList", list);
		view.addObject("user", user);
		view.setPath("postlist.jsp");
		return view;
	}

}
