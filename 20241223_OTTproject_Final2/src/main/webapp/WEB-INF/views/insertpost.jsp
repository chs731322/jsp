
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>모집 글 작성하기</title>
<link rel="stylesheet" type="text/css" href="css/postinsert.css">
</head>
<body>

<%@ include file="/WEB-INF/views/header.jsp"%>

<main>
    <h1>글 작성하기</h1>
    <form id="postForm" action="./insertGroupAndPost.do" method="post">
        <div class="form-group">
            <label for="postdata">글 내용</label>
            <textarea id="postdata" name="postdata"
                      placeholder="글 내용을 자유롭게 작성해주세요."></textarea>
        </div>
        <div class="ott-section">
            <h2>OTT 설정</h2>
            <p>팀원을 구할 OTT를 선택하세요.</p>
            <div class="ott-icons2">
                <input type="radio" id="ottservice1" name="platformnum"
                       value="Netflix"> 
                <label for="ottservice1">
                    <img src="<%= request.getContextPath() %>/img/netflix_logo_1.png" alt="Netflix">
                </label> 
                <input type="radio" id="ottservice2" name="platformnum"
                       value="Disneyplus"> 
                <label for="ottservice2">
                    <img src="<%= request.getContextPath() %>/img/Disney+_logo.png" alt="Disney+">
                </label> 
                <input type="radio" id="ottservice4" name="platformnum"
                       value="YouTube"> 
                <label for="ottservice4">
                    <img src="<%= request.getContextPath() %>/img/youtube_logo_1.png" alt="YouTube Premium">
                </label> 
                <input type="radio" id="ottservice3" name="platformnum"
                       value="Coupang"> 
                <label for="ottservice3">
                    <img src="<%= request.getContextPath() %>/img/coupang_logo_1.png" alt="Coupang Play">
                </label> 
                <input type="radio" id="ottservice5" name="platformnum"
                       value="Wavve"> 
                <label for="ottservice5">
                    <img src="<%= request.getContextPath() %>/img/wavve_logo_1.png" alt="Wavve" class="wave">
                </label> 
                <input type="radio" id="ottservice6" name="platformnum"
                       value="Tving"> 
                <label for="ottservice6">
                    <img src="<%= request.getContextPath() %>/img/tving_logo_1.png" alt="Tving">
                </label>
            </div>
            <br>
            <br>
            <label for="ottid">공유할 ott계정:</label> 
            <input type="text" id="ottid" name="ottid"> <br>
            <br>
            <label for="ottpasswrod">공유할 ott비밀번호:</label> 
            <input type="text" id="ottpassword" name="ottpassword"> <br>
            <br>
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

<script>
    document.getElementById("postForm").addEventListener("submit", function (event) {
        // 폼 필드 값 가져오기
        const postdata = document.getElementById("postdata").value.trim();
        const ottid = document.getElementById("ottid").value.trim();
        const ottpassword = document.getElementById("ottpassword").value.trim();
        const platformnum = document.querySelector('input[name="platformnum"]:checked');

        // 필드 검증
        if (!postdata) {
            alert("글 내용을 작성해주세요.");
            event.preventDefault();
            return;
        }

        if (!platformnum) {
            alert("OTT 플랫폼을 선택해주세요.");
            event.preventDefault();
            return;
        }

        if (!ottid) {
            alert("공유할 OTT 계정을 입력해주세요.");
            event.preventDefault();
            return;
        }

        if (!ottpassword) {
            alert("공유할 OTT 비밀번호를 입력해주세요.");
            event.preventDefault();
            return;
        }

        // 모든 검증 통과
    });
</script>

</body>
</html>
