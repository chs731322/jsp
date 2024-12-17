<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>모집 글 작성하기</title>
<link rel="stylesheet" type="text/css" href="css/write_post.css">
</head>
<body>
	<header>
		<div class="logo">
			<a href="./Main.do">logo</a>
		</div>
		<nav>
			<a href="./write_post_view.do">글 작성하기</a> <a href="./list_post.do">공유글
				보기</a> <a href="./mainpage_guide.do">요금 가이드</a> <a
				href="./mypage_view.do">마이페이지</a>
		</nav>
	</header>
	<main>
		<h1>모집 글 작성하기</h1>
		<p class="subtitle">같이 쉐어할 팀원을 모집할 게시글을 작성할 수 있습니다.</p>
		<form action="./write_post.do" method="post">
			<div class="form-group">
				<label for="title">글 제목</label> <input type="text" id="title"
					name="title" placeholder="내 OTT 아이디로 팀원을 구하고 싶어요!" required>
			</div>
			<div class="form-group">
				<label for="content">글 내용</label>
				<textarea id="content" name="content"
					placeholder="글 내용을 자유롭게 작성해주세요." required></textarea>
			</div>
			<div class="ott-section">
				<h2>OTT 설정</h2>
				<p>팀원을 구할 OTT를 선택하세요.</p>
				<div class="ott-icons">
					<!-- Coupang -->
					<label> <input type="radio" name="platformNum"
						value="Coupang"> <img src="img/coupang_logo_1.png"
						alt="Coupang">
					</label>

					<!-- Disney+ -->
					<label> <input type="radio" name="platformNum"
						value="Disneyplus"> <img src="img/Disney+_logo.png"
						alt="Disneyplus">
					</label>

					<!-- Netflix -->
					<label> <input type="radio" name="platformNum"
						value="Netflix"> <img src="img/netflix_logo_1.png"
						alt="Netflix">
					</label>

					<!-- Tving -->
					<label> <input type="radio" name="platformNum"
						value="Tving"> <img src="img/tving_logo_1.png"
						alt="Tving">
					</label>

					<!-- Wavve -->
					<label> <input type="radio" name="platformNum"
						value="Wavve"> <img src="img/wavve_logo_1.png"
						alt="Wavve">
					</label>

					<!-- YouTube -->
					<label> <input type="radio" name="platformNum"
						value="YouTube"> <img src="img/youtube_logo_1.png"
						alt="YouTube">
					</label>

				</div>
			</div>
			<div class="settings"></div>

			</div>
			<button class="submit" type="submit">글 작성하기</button>
		</form>
	</main>
	<footer>
		<div class="footer">
			<p id="footer_values">Connecting the world, one click at a time.</p>
			<p>Contact us: support@shareME.com | Phone: +82-10-1234-5678</p>
			<p>Address: 123 Dangsan-dong, Yeongdeungpo-gu, Seoul, South Korea</p>
			<p>&copy; 2024 shareME. All rights reserved.</p>
		</div>
	</footer>
</body>
</html>
