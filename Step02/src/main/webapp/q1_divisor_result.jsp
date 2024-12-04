<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>약수 결과</title>
</head>
<body>
    <h1>약수 계산 결과</h1>
    <c:choose>
        <c:when test="${not empty errorMessage}">
            <p style="color:red;">${errorMessage}</p>
            <p><a href="q1_divisor.jsp">다시 시도하기</a></p>
        </c:when>
        <c:otherwise>
            <p><strong>${number}</strong>의 약수는 다음과 같습니다:</p>
            <ul>
                <c:forEach var="divisor" items="${divisors}">
                    <li>${divisor}</li>
                </c:forEach>
            </ul>
            <p><a href="q1_divisor.jsp">다른 숫자 계산하기</a></p>
        </c:otherwise>
    </c:choose>
</body>
</html>
