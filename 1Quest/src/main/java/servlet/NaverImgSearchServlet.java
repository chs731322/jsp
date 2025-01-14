package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/naverImgSearch.do")
public class NaverImgSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search = request.getParameter("search");
		System.out.println(search);
		String result = naverImgSearch(search);
		System.out.println(result);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(result);
	}

	public String naverImgSearch(String search) {
		String clientId = "6UBhCfjedOpSOuhskcCF";
		String clientSecret = "GU3p5IZHHp";

		try {
			search = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		String apiURL = "https://openapi.naver.com/v1/search/image?query=" + search; 
		
		HttpURLConnection con = null;
		String result = null;
		try {
			URL url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			int responseCode = con.getResponseCode();
			InputStreamReader ir = null;
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				ir = new InputStreamReader(con.getInputStream());
			} else { // 오류 발생
				ir = new InputStreamReader(con.getErrorStream());
			}
			try (BufferedReader lineReader = new BufferedReader(ir)) {
				StringBuilder responseBody = new StringBuilder();

				String line;
				while ((line = lineReader.readLine()) != null) {
                    responseBody.append(line);
                }
				
				result = responseBody.toString();
			} catch (IOException e) {
				throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
		return result;

	}

}
