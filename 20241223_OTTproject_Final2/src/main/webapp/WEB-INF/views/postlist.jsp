<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>모집 글 작성하기</title>
<link rel="stylesheet" type="text/css" href="css/postlist.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/header.jsp"%>


	<main>
		<h2>OTT별 게시글 보기</h2>
		<div class="ott-icons2">
			<input type="radio" id="ottservice1" name="platformnum"
				value="Netflix"
				<c:if test="${param.platformnum == 'Netflix'}">checked</c:if>>
			<label for="ottservice1"> <img
				src="<%=request.getContextPath()%>/img/netflix_logo_2.png"
				alt="Netflix">
			</label> <input type="radio" id="ottservice2" name="platformnum"
				value="Disneyplus"
				<c:if test="${param.platformnum == 'Disneyplus'}">checked</c:if>>
			<label for="ottservice2"> <img
				src="<%=request.getContextPath()%>/img/Disney+_logo.png"
				alt="Disney+">
			</label> <input type="radio" id="ottservice4" name="platformnum"
				value="YouTube"
				<c:if test="${param.platformnum == 'YouTube'}">checked</c:if>>
			<label for="ottservice4"> <img
				src="<%=request.getContextPath()%>/img/youtube_logo_2.png"
				alt="YouTube Premium">
			</label> <input type="radio" id="ottservice3" name="platformnum"
				value="Coupang"
				<c:if test="${param.platformnum == 'Coupang'}">checked</c:if>>
			<label for="ottservice3"> <img
				src="<%=request.getContextPath()%>/img/coupang_logo_2.png"
				alt="Coupang Play">
			</label> <input type="radio" id="ottservice5" name="platformnum"
				value="Wavve"
				<c:if test="${param.platformnum == 'Wavve'}">checked</c:if>>
			<label for="ottservice5"> <img
				src="<%=request.getContextPath()%>/img/wavve_logo_2.png" alt="Wavve"
				class="wave">
			</label> <input type="radio" id="ottservice6" name="platformnum"
				value="Tving"
				<c:if test="${param.platformnum == 'Tving'}">checked</c:if>>
			<label for="ottservice6"> <img
				src="<%=request.getContextPath()%>/img/tving_logo_2.png" alt="Tving">
			</label>
		</div>
		<button class="submit" onclick="location.href='./insertpost.do'">글
			작성하기</button>
		<table>
			<thead>
				<tr>
					<th>글 번호</th>
					<th>내용</th>
					<th>작성자</th>
					<th>게시글 작성일</th>
					<th>그룹 현황</th>
					<th>신청 및 삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty postList}">
					<c:forEach var="post" items="${postList}">
						<tr>
							<td>${post.postNum}</td>
							<td>${post.postData}</td>
							<td>${post.id}</td>
							<td>${post.postDate}</td>
							<td>${post.nowNum}/${post.shareNum}</td>
							<td><c:choose>
									<c:when test="${post.id eq user.id}">
										<a
											href="./deleteGroupAndPost.do?postnum=${post.postNum}&platformnum=${post.platformNum}"
											class="delete-link">삭제하기</a>
									</c:when>
									<c:when test="${post.nowNum >= post.shareNum}">
										<p style="color: #ff1493;">
											<strong>모집 완료 
										</p>
									</c:when>
									<c:otherwise>
										<a
											href="./insertgroupmember.do?postnum=${post.postNum}&platformnum=${post.platformNum}"
											class="apply-link" onclick="applyHandler(event, this)">신청하기</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty postList}">
					<tr>
						<td colspan="7">현재 등록된 게시글이 없습니다.</td>
					</tr>
				</c:if>
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
<script>
window.onload = () => {
    <%String errorMessage = (String) request.getAttribute("errorMessage");
if (errorMessage != null) {%>
    alert("<%=errorMessage%>");
    location.href = './postlistview.do?platformnum=' + '${post.platformNum}';
    <%}%>
    const radioButtons = document.querySelectorAll('input[type="radio"]');
    
    radioButtons.forEach(radio => {
        radio.addEventListener('click', () => {
            const value = radio.value;
            location.href = './postlistview.do?platformnum=' + value;
        });
    });
    
    

};


    function applyHandler(event, element) {
        event.preventDefault(); // 기본 링크 동작 방지
        alert('신청하였습니다.');
        element.textContent = '신청 완료';
        element.style.backgroundColor = '#6c757d'; // 회색으로 변경
        element.style.pointerEvents = 'none'; // 클릭 비활성화
    }
</script>
</html>
