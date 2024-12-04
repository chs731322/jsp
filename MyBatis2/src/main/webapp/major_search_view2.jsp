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
	font-family: Arial, sans-serif;
	margin: 20px;
	padding: 0;
	background-color: #f9f9f9;
	color: #333;
}

h2 {
	text-align: center;
	margin-bottom: 20px;
	font-size: 24px;
	color: #555;
}

table {
	border-collapse: collapse;
	width: 80%;
	margin: 0 auto;
	background-color: #fff;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.25);
	border-radius: 8px;
	overflow: hidden;
}

thead {
	background-color: #f2f2f2;
}

th, td {
	padding: 10px 15px;
	text-align: center;
	border-bottom: 1px solid #e9e9e9;
}

th {
	font-weight: bold;
	color: #444;
}

td {
	color: #666;
}

tr:last-child td {
	border-bottom: none;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

tr:hover {
	background-color: #f1f1f1;
}
</style>

</head>

<body>
	<form action="./searchMajor2.do" method="get">
		<select name="type">
			<option value="major_no">학과번호</option>
			<option value="major_name">학과명</option>
		</select> <input type="text" name="search">
		<button>검색</button>
	</form>
	<hr>
	<c:if test="${requestScope.majorList != null }">
		<table>
			<thead>
				<tr>
					<th>학과 번호</th>
					<th>학과 이름</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="major" items="${majorList}">
					<tr>
						<td>${major.majorNo}</td>
						<td>${major.majorName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>