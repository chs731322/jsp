<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 20px;
        color: #333;
    }

    h2 {
        text-align: center;
        color: #1E90FF;
        margin-bottom: 20px;
    }

    table {
        width: 80%;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: white;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }

    th, td {
        border: 1px solid #ddd;
        text-align: center;
        padding: 12px;
    }

    th {
        background-color: #1E90FF;
        color: white;
        font-weight: bold;
        text-transform: uppercase;
    }

    td.password {
        width: 500px;
        text-overflow: ellipsis;
        overflow: hidden;
        white-space: nowrap;
        max-width: 500px;
        color: #555;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #eaf4ff;
        transition: background-color 0.3s;
    }

    a {
        text-decoration: none;
        color: #1E90FF;
        font-weight: bold;
    }

    a:hover {
        text-decoration: underline;
        color: #0056b3;
    }
</style>




</head>
<body>
	<h2>전체 회원 정보</h2>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>닉네임</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${requestScope.list }">
				<tr>
					<td>${member.id }</td>
					<td class="password">${member.password }</td>
					<td>${member.userName }</td>
					<td>${member.nickName }</td>
					<td><a href="./deleteMember.do?id=${member.id }">삭제</a>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>