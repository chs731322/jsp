<%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>넷플릭스 공유하기</title>

<link rel="stylesheet" type="text/css" href="css/list_post.css">
</head>
<body>
    <header>
         <div class="logo"><a href="./Main.do">logo</a></div>
        <nav>
            <a href="./write_post_view.do">글 작성하기</a>
            <a href="./list_post.do">공유글 보기</a>
            <a href="./mainpage_guide.do">요금 가이드</a>
            <a href="./mypage_view.do">마이페이지</a>
        </nav>
        <div class="user-info">
            <span><c:if test="${user != null}">${user.name} 님</c:if></span>
            <a href="#">로그아웃</a>
        </div>
    </header>

    <main>
        <div class="title-section">
        	<c:choose>
	        	<c:when test="${platformNum eq 'Netflix' }">
	        		<h1>넷플릭스 공유하기</h1>
	        	</c:when>
	        	<c:when test="${platformNum eq 'Disneyplus' }">
					<h1>디즈니+ 공유하기</h1>
				</c:when>
				<c:when test="${platformNum eq 'YouTube' }">
					<h1>유투브 프리미엄 공유하기</h1>
				</c:when>
				<c:when test="${platformNum eq 'Coupang' }">
					<h1>쿠팡 플레이 공유하기</h1>
				</c:when>
				<c:when test="${platformNum eq 'Wavve' }">
					<h1>웨이브 공유하기</h1>
				</c:when>
				<c:when test="${platformNum eq 'Tving' }">
					<h1>티빙 공유하기</h1>
				</c:when>
				<c:otherwise>
	        		<h1>전체 리스트</h1>
	        	</c:otherwise>
        	</c:choose>
            <button  onclick="location.href='./write_post_view.do'">글 작성하기</button>
        </div>

        <table>
            <thead>
                <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성일</th>
                    <th>모집 상태</th>
                    <th>삭제버튼</th>
                </tr>
            </thead>
            <tbody>
                <!-- 10개의 빈 행 추가 -->
                <c:forEach var="postList" items="${postList }" >
	                <tr>
	                    <td>${postList.postNum}</td>
	                    <td>${postList.postData}</td>
	                    <td>${postList.postDate}</td>
	                    <td class="recruiting">모집중 ${postList.shareNum}</td>
	                    <c:choose>
	                    	<c:when test="${user.id eq postList.id}">
	                    		<td class="recruiting"><button  onclick="location.href='./delete_post.do?postNum=${postList.postNum}&platformNum=${platformNum }'">삭제</button></td>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<td class="recruiting">삭제불가</td>
	                    	</c:otherwise>
	                    </c:choose>
	                    
	                </tr>
                </c:forEach>
            </tbody>
        </table>
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
