<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OTT 구독 관리</title>
<link rel="stylesheet" type="text/css" href="css/ott_view.css">
<script src="js/timer.js"></script>
</head>
<body>

    <%@ include file="/WEB-INF/views/header.jsp"%>

    <main>
        <h1>구독 현황</h1>
        <p class="subtitle">현재 구독 중인 OTT 정보를 확인할 수 있습니다.</p>
        <div class="main-container">
            <c:forEach var="member" items="${group_member}">
                <div class="card">
                    <h2>Platform: ${member.platformNum}</h2>
                    <c:choose>
                        <c:when test="${member.payment == 1}">
                            <h3>OTT 계정 정보</h3>
                            <p>OTT ID: ${member.ottId}</p>
                            <p>OTT Password: ${member.ottPassword}</p>
                            <p class="timer-display" id="timer-${member.gno}">남은 시간: 60초</p>
                        </c:when>
                        <c:otherwise>
                            <h3>결제 대기 상태</h3>
                            <p>결제가 완료되지 않았습니다.</p>
                            <button class="payment-button" data-id="${member.gno}">결제하기</button>
                            <div class="ott-info" id="ott-info-${member.gno}" style="display: none;">
                                <p>OTT ID: ${member.ottId}</p>
                                <p>OTT Password: ${member.ottPassword}</p>
                                <p class="timer-display" id="timer-${member.gno}">남은 시간: 60초</p>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
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
