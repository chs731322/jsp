package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import dto.BoardCommentDTO;
import dto.BoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BoardService;
import view.ModelAndView;

public class BoardUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title); dto.setContent(content); dto.setBno(bno);
		
		BoardService.getInstance().updateBoard(dto);
		
		ModelAndView view = new ModelAndView();
		view.setPath("./boardView.do?bno=" + bno);
		view.setRedirect(true);
		return view;
	}

}
