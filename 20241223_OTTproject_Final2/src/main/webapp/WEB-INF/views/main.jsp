<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OTT 메인</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/header.jsp"%>

	<main>
		<h1>ShardME에 오신것을 환영합니다!</h1>
		<p class="subtitle">
			각 OTT 별 게시판을 확인해보세요!<br>버튼을 클릭하면 해당 OTT 신청 게시판으로 이동합니다.
		</p>
		<div class="guide-container">
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/netflix_logo_1.png"
					alt="Netflix">
				<h2>넷플릭스 게시판</h2>
				<p>넷플릭스는 다양한 콘텐츠를 제공합니다.</p>
				<a href="./postlistview.do?platformnum=Netflix">바로가기 ></a>
			</div>
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/Disney+_logo.png"
					alt="Disney+">
				<h2>디즈니+ 게시판</h2>
				<p>디즈니+는 가족 모두를 위한 콘텐츠를 제공합니다.</p>
				<a href="./postlistview.do?platformnum=Disneyplus">바로가기 ></a>
			</div>
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/youtube_logo_1.png"
					alt="YouTube Premium">
				<h2>유튜브 프리미엄 게시판</h2>
				<p>광고 없이 유튜브를 즐기세요.</p>
				<a href="./postlistview.do?platformnum=YouTube">바로가기 ></a>
			</div>
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/coupang_logo_1.png"
					alt="Coupang Play">
				<h2>쿠팡 플레이 게시판</h2>
				<p>쿠팡 멤버십과 함께 즐길 수 있는 다양한 콘텐츠를 제공합니다.</p>
				<a href="./postlistview.do?platformnum=Coupang">바로가기 ></a>
			</div>
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/wavve_logo_1.png"
					alt="Wavve">
				<h2>웨이브 게시판</h2>
				<p>국내 및 해외 콘텐츠를 즐길 수 있는 웨이브를 확인하세요.</p>
				<a href="./postlistview.do?platformnum=Wavve">바로가기 ></a>
			</div>
			<div class="card">
				<img src="<%= request.getContextPath() %>/img/tving_logo_1.png"
					alt="Tving">
				<h2>티빙 게시판</h2>
				<p>티빙에서만 볼 수 있는 독점 콘텐츠를 확인하세요.</p>
				<a href="./postlistview.do?platformnum=Tving">바로가기 ></a>
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
