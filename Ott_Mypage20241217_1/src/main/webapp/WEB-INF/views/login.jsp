<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <!-- 타이틀과 문구 -->
    <div class="title-container">
        <h2>로그인</h2>
        <p class="subtitle">로그인 한 후 OOO의<br>다양한 서비스를 만나보세요.</p>
    </div>
<body>
      <div class="login-container">
        <form action="./login.do" method="post">
            <div class="form-group">
                <label for="id">아이디</label>
                <input type="text" id="id" name="id" placeholder="아이디" required>
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="비밀번호" required>
            </div>
            <button type="submit" class="login-button">로그인</button>
        </form>
        <div class="register-link">
            <p>회원이 아니신가요? <a href="./registerView.do">회원가입하기</a></p>
        </div>
    </div>
</body>
</html>
