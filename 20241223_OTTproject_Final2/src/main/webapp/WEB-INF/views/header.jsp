<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<a href="./Main.do" id="logo"></a>
	<nav>
		<a href="./insertpost.do">글 작성하기</a>
        <a href="./postlistview.do?platformnum=Netflix">공유글 보기</a>
        <a href="./mainpage_guide.do">요금 가이드</a>
        <a href="./mypage_view.do">마이페이지</a>
        <a href="./ott_view.do">구독</a>
	</nav>
	<div class="user-info">
        <!-- 프로필 사진 추가 -->
        <c:choose>
            <c:when test="${user != null && user.profileImg != null}">
                <img src="profileImage?path=${user.profileImg}" alt="프로필 사진" class="profile-icon">
            </c:when>
            <c:otherwise>
                <img src="img/profile.png" alt="기본 프로필 사진" class="profile-icon">
            </c:otherwise>
        </c:choose>
		<span><c:if test="${user != null}">${user.name} 님</c:if></span> 
		<a href="./logout.do">로그아웃</a>
	</div>
</header>

<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath() %>/css/header.css">
