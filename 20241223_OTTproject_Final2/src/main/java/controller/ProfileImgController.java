package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dto.UsersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.UserService;
import view.ModelAndView;

public class ProfileImgController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsersDTO user = (UsersDTO) request.getSession().getAttribute("user");

		// 파일 업로드 처리
		File root = new File("c:\\profileimage");
		// 해당 경로가 있는지 체크, 없으면 해당 경로 생성
		if (!root.exists()) {
			System.out.println("파일 업로드할 폴더 및 경로 생성");
			root.mkdirs();
		}
		

		Iterator<Part> it = request.getParts().iterator();
		List<String> fileList = new ArrayList<String>(); // 파일 경로 저장
		// 업로드할 파일 정보를 읽는 부분
		while (it.hasNext()) {
			Part part = it.next();
			if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().isEmpty()) {
				// 파일 저장
				String filePath = root.getAbsolutePath() + "/" + part.getSubmittedFileName();
				filePath = filePath.replace("\\", "/"); // 백슬래시를 슬래시로 변환
				part.write(filePath);
				fileList.add(filePath);
				System.out.println("업로드된 파일 경로: " + filePath);

			}
		}
		
		// 가장 최근 업로드된 파일 경로를 사용자 DTO에 설정
        if (!fileList.isEmpty()) {
            String uploadedFilePath = fileList.get(fileList.size() - 1); // 마지막 파일 경로 사용
            user.setProfileImg(uploadedFilePath);
            System.out.println("업데이트된 프로필 이미지 경로: " + uploadedFilePath);

            // 데이터베이스에 경로 저장
            UserService.getInstance().profileUpdate(user);

            // 세션 업데이트
            request.getSession().setAttribute("user", user);
        } else {
            System.out.println("업로드된 파일이 없습니다.");
        }
		

		// 마이페이지로 리다이렉트
		ModelAndView view = new ModelAndView();
		view.setPath("./mypage_view.do");
		view.setRedirect(true);
		return view;

	}

}
