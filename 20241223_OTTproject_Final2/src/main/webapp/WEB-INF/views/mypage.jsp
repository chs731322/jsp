<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" type="text/css" href="css/mypage.css">
<script>
  window.onload = () => {
    const deleteLink = document.getElementById("deleteLink");

    deleteLink.addEventListener("click", (event) => {
      const confirmation = confirm("탈퇴하시겠습니까?");
      if (!confirmation) {
        event.preventDefault(); 
      }
    });
    
    const updateInfo = document.getElementById("updateInfo");

    updateInfo.addEventListener("click", (event) => {
      const confirmation = confirm("회원 정보를 수정하시겠습니까?");
      if (!confirmation) {
        event.preventDefault(); 
      }
    });
    
  };
</script>

</head>
<body>

	<%@ include file="/WEB-INF/views/header.jsp"%>

		<div class="main-content">
			<div class="profile-section">
			<h1 class="mypage-title">마이 페이지</h1>
				<form action="profileImgUpdate.do" method="post"
					enctype="multipart/form-data">
					<div class="profile-image-container">
						<c:choose>
							<c:when test='${user.profileImg != null}'>
								<img src="profileImage?path=${user.profileImg}" alt="프로필 사진"
									class="profile-image" >
							</c:when>
							<c:otherwise>
								<img alt="프로필 기본" src="img/profile.png" class="profile-image">
							</c:otherwise>
						</c:choose>
						<label for="profileImg" class="camera-icon"> 
						<img src="img/camera.png" alt="사진 변경">
						</label> <input type="file" name="profileImg" id="profileImg" accept="image/*">
					</div>
					<div class="button-container">
					<button type="submit" class="profile-submit-button">프로필 사진 저장</button>
					<a href="deleteProfileImg.do?profileImg=${user != null ? user.profileImg : ''}" id="deleteImg">프로필 사진 삭제</a>
					</div>
				</form>
				<h2>
					<c:if test="${user != null}">${user.name} 님</c:if>
				</h2>
			</div>
			<div class="form-section">
				<form action="userUpdate.do" method="post">
					<label for="id">아이디</label> <input type="text" id="id" name="id"
						readonly="readonly"
						value="<c:if test="${user != null}">${user.id}</c:if>"> <label
						for="name">이름</label> <input type="text" id="name" name="name"
						value="<c:if test="${user != null}">${user.name}</c:if>">

					<label for="birth">생년월일</label> <input type="date" id="birth"
						name="birth"
						value="<c:if test="${user != null}">${user.birth}</c:if>">

					<label for="password">비밀번호 변경</label> <input type="password"
						id="password" name="password" placeholder="비밀번호 변경"> <label
						for="password2">비밀번호 확인</label> <input type="password"
						id="password2" name="password2" placeholder="비밀번호 확인"> <label
						for="email">이메일</label> <input type="text" id="email" name="email"
						value="<c:if test="${user != null}">${user.email}</c:if>">

					<label for="account">등록 계좌</label> <input type="text" id="account"
						name="account"
						value="<c:if test="${user != null}">${user.account}</c:if>"
						placeholder="등록 계좌">

					<div class="actions">
						<a href="userDelete.do?id=${user != null ? user.id : ''}"
							id="deleteLink">회원탈퇴</a>

						<button type="submit" id="updateInfo">저장</button>
					</div>
				</form>
			</div>
		</div>
		<footer>
		<div class="footer">
			<p id="footer_values">Connecting the world, one click at a time.</p>
			<p>Contact us: support@shareME.com | Phone: +82-10-1234-5678</p>
			<p>Address: 123 Dangsan-dong, Yeongdeungpo-gu, Seoul, South Korea</p>
			<p>&copy; 2024 shareME. All rights reserved.</p>
		</div>
		</footer>
	</div>
	
</body>
</html>