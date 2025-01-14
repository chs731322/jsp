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

public class insertgroupmemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = ((UsersDTO) request.getSession().getAttribute("user")).getId();
		try {
			String postnum = request.getParameter("postnum");
			String platformnum = request.getParameter("platformnum");
			System.out.println(id);
			System.out.println(postnum);
			System.out.println(platformnum);

			// 데이터 삽입
			PostDTO dto = new PostDTO();
			dto.setId(id);
			dto.setPlatformNum(platformnum);
			dto.setPostNum(postnum);
			int result = PostService.getInstance().insertGroupMember(dto);
			System.out.println("result: " + result);
			
			List<PostDTO> list = PostService.getInstance().platformnumPostList(platformnum);
			
			
			ModelAndView view = new ModelAndView();
			view.addObject("postList", list);
			view.addObject("result", result);
			view.setPath("postlistview.do");
//			view.setPath("./postlistview.do?platformnum=" + dto.getPlatformNum());

			view.setRedirect(false);
			return view;
		} catch (Exception e) {
			e.getStackTrace();
			ModelAndView view = new ModelAndView();
			view.setPath("postlistview.do");
			view.setRedirect(false);
			return view;
		}
	}
}
