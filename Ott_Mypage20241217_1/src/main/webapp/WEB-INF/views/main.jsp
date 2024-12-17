<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>OTT 메인</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
</head>
<body>
    <header>
    <a href="./Main.do" id="logo"></a>
        <nav>
            <a href="./write_post_view.do">글 작성하기</a>
            <a href="./list_post.do">공유글 보기</a>
            <a href="./mainpage_guide.do">요금 가이드</a>
            <a href="./mypage_view.do">마이페이지</a>
        </nav>
        <div class="user-info">
            <span><c:if test="${user != null}">${user.name} 님</c:if></span>
            <a href="./logout.do">로그아웃</a>
        </div>
    </header>

   <main>
    <h1>ShardME에 오신것을 환영합니다</h1>
    <p class="subtitle">각 OTT 별 요금 가이드를 확인해보세요!<br>버튼을 클릭하면 각 사이트로 이동합니다.</p>
    <div class="guide-container">
        <div class="card">
            <img src="<%= request.getContextPath() %>/img/netflix_logo_1.png" alt="Netflix">
            <h2>넷플릭스 요금가이드</h2>
            <p>넷플릭스는 다양한 콘텐츠를 제공합니다. 요금제를 비교하여 선택하세요.</p>
            <a href="./list_post.do?platformNum=Netflix">바로가기 ></a>
        </div>
        <div class="card">
            <img src="<%= request.getContextPath() %>/img/Disney+_logo.png" alt="Disney+">
            <h2>디즈니+ 요금가이드</h2>
            <p>디즈니+는 가족 모두를 위한 콘텐츠를 제공합니다. 요금제를 확인해보세요.</p>
            <a href="./list_post.do?platformNum=Disneyplus">바로가기 ></a>
        </div>
        <div class="card">
            <img src="<%= request.getContextPath() %>/img/youtube_logo_1.png" alt="YouTube Premium">
            <h2>유튜브 프리미엄 요금가이드</h2>
            <p>광고 없이 유튜브를 즐기세요. 유튜브 프리미엄 요금제를 확인하세요.</p>
            <a href="./list_post.do?platformNum=YouTube">바로가기 ></a>
        </div>
        <div class="card">
            <img src="<%= request.getContextPath() %>/img/coupang_logo_1.png" alt="Coupang Play">
            <h2>쿠팡 플레이 요금가이드</h2>
            <p>쿠팡 멤버십과 함께 즐길 수 있는 다양한 콘텐츠를 제공합니다.</p>
            <a href="./list_post.do?platformNum=Coupang">바로가기 ></a>
        </div>
        <div class="card">
            <img src="<%= request.getContextPath() %>/img/wavve_logo_2.png" alt="Wavve">
            <h2>웨이브 요금가이드</h2>
            <p>국내 및 해외 콘텐츠를 즐길 수 있는 웨이브의 요금제를 확인하세요.</p>
            <a href="./list_post.do?platformNum=Wavve">바로가기 ></a>
        </div>
        <div class="card">
            <img src="<%= request.getContextPath() %>/img/tving_logo_1.png" alt="Tving">
            <h2>티빙 요금가이드</h2>
            <p>티빙에서만 볼 수 있는 독점 콘텐츠를 확인하세요. 요금제를 비교해보세요.</p>
            <a href="./list_post.do?platformNum=Tving">바로가기 ></a>
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
