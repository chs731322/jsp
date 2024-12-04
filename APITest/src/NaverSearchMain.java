import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class NaverSearchMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("검색어 입력 : ");
		System.out.println(naverNewsSearch(sc.nextLine()));
	}

	public static String naverNewsSearch(String text) {
		String clientId = "z8Nvqaqt8vfJIquySpp4";
		String clientSecret = "mR9ZoRWR2m";
		String result = "";

		try {
			// 보낼 데이터를 인코딩 - UTF-8
			text = URLEncoder.encode(text, "UTF-8");

			// URL 세팅 - query 스트링도 적용
			String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;

			// URL 생성 및 Connection 생성
			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// Connection 설정
			// 헤더 설정 > 인증 정보 (클라이언트 키값, 시크릿값, API 키값)
			// Method 설정

			conn.setRequestMethod("GET");
			conn.addRequestProperty("X-Naver-Client-Id", clientId);
			conn.addRequestProperty("X-Naver-Client-Secret", clientSecret);

			// 응답 결과 - 200 정상, 404 경로 X, 401 인증 X, 403 접속 권한 X
			int responseCode = conn.getResponseCode();

			if (responseCode != 200) {
				throw new Exception("호출 오류");
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
				String str = "";
				StringBuilder sb = new StringBuilder();

				while ((str = br.readLine()) != null)
					sb.append(str);

				result = sb.toString();
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
