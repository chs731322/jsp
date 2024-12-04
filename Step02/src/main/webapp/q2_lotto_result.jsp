<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>로또 번호 결과</title>
</head>
<body>
    <h1>로또 번호 생성 결과</h1>
    <c:choose>
        <c:when test="${not empty errorMessage}">
            <p style="color:red;">${errorMessage}</p>
            <p><a href="q2_lotto.jsp">다시 시도하기</a></p>
        </c:when>
        <c:otherwise>
            <p>생성된 로또 세트 수: <strong>${count}</strong></p>
            <table border="1">
                <tr>
                    <th>세트 번호</th>
                    <th>로또 번호</th>
                </tr>
                <c:forEach var="lottoSet" items="${lottoSets}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>
                            <c:forEach var="number" items="${lottoSet}">
                                ${number}

                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p><a href="q2_lotto.jsp">다른 세트 수로 생성하기</a></p>
        </c:otherwise>
    </c:choose>
</body>
</html>
