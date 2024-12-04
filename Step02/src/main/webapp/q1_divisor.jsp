<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>약수 계산기</title>
</head>
<body>
    <h1>숫자를 입력하여 약수를 구하세요</h1>
    <form action="DivisorServlet" method="post">
        <label for="number">숫자:</label>
        <input type="text" id="number" name="number" required />
        <input type="submit" value="약수 계산" />
    </form>
</body>
</html>
