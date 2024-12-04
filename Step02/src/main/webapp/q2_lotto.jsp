<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>로또 번호 생성기</title>
</head>
<body>
    <h1>원하는 로또 세트 수를 입력하세요</h1>
    <form action="LottoServlet" method="post">
        <label for="count">로또 세트 수:</label>
        <input type="number" id="count" name="count" min="1" required />
        <input type="submit" value="로또 번호 생성" />
    </form>
</body>
</html>
