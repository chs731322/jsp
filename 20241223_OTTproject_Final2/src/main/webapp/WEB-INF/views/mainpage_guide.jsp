<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>요금 가이드</title>
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath() %>/css/mainpage_guide.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<main>
		<h1>요금 가이드</h1>
		<p class="subtitle">
			각 OTT 별 요금 가이드를 확인해보세요!<br>버튼을 클릭하면 각 사이트로 이동합니다.
		</p>
		<div class="guide-container">
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/netflix_logo_1.png"
					alt="Netflix"  style="width: 35px; height: 50px;">
				<h2>넷플릭스</h2>
				<p>
					45% 할인!!(파티장 기준) <br>월 9,490원 ~
				</p>
				<a href="./insertpost.do">글쓰기 ></a>
			</div>
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/Disney+_logo.png"
					alt="Disney+"  style="width: 80px; height: 50px;">
				<h2>디즈니</h2>
				<p>
					72% 할인!!(파티장 기준) <br>월 3,965원 ~
				</p>
				<a href="./insertpost.do">글쓰기 ></a>
			</div>
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/youtube_logo_1.png"
					alt="YouTube Premium"  style="width: 50px; height: 50px;">
				<h2>유튜브 프리미엄</h2>
				<p>
					27% 할인!!(파티장 기준) <br>월 10,900원 ~
				</p>
				<a href="./insertpost.do">글쓰기 ></a>
			</div>
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/coupang_logo_1.png"
					alt="Coupang Play"  style="width: 40px; height: 50px;">
				<h2>쿠팡 플레이</h2>
				<p>
					25% 할인!!(파티장 기준) <br>월 1,975원 ~
				</p>
				<a href="./insertpost.do">글쓰기 ></a>
			</div>
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/wavve_logo_1.png"
					alt="Wavve"  style="width: 50px; height: 50px;">
				<h2>웨이브</h2>
				<p>
					72% 할인!!(파티장 기준) <br>월 3,965원 ~
				</p>
				<a href="./insertpost.do">글쓰기 ></a>
			</div>
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/tving_logo_1.png"
					alt="Tving"  style="width: 50px; height: 50px;">
				<h2>티빙</h2>
				<p>
					73% 할인!!(파티장 기준) <br>월 4,740원 ~
				</p>
				<a href="./insertpost.do">글쓰기 ></a>
			</div>
		</div>
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
