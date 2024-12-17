<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="css/member_insert.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
        // 아이디 중복 체크 함수
        function checkId() {
            const id = document.querySelector("input[name='id']").value;
            if (!id) {
                alert("아이디를 입력하세요.");
                return;
            }

            $.ajax({
                url: "checkId.do", // 중복 체크 요청 URL
                type: "POST",
                data: { id: id },
                success: function (response) {
                    if (response === "available") {
                        $(".check-result").text("사용 가능한 아이디입니다.").css("color", "green");
                    } else {
                        $(".check-result").text("이미 사용 중인 아이디입니다.").css("color", "red");
                    }
                },
                error: function () {
                    $(".check-result").text("중복 체크 중 문제가 발생했습니다.").css("color", "red");
                }
            });
            
        }
    </script>
</head>
<body>
    <div class="signup-container">
        <h1>회원가입</h1>
        <form action="register.do" method="post">
            <!-- 아이디 입력 및 중복확인 버튼 -->
            <div class="id-group">
                <input type="text" class="id-input" name="id" placeholder="아이디"
                    required>
                <button type="button" class="check-button" onclick="checkId()">중복체크</button>
            </div>
            <p class="check-result"></p>
            <!-- 비밀번호 -->
            <input type="password" name="password" placeholder="비밀번호" required>
            <input type="password" name="confirm_password" placeholder="비밀번호 확인"
                required>

            <!-- 이름 -->
            <input type="text" name="name" placeholder="이름" required>

            <!-- 이메일 -->
            <input type="email" name="email" placeholder="이메일" required>

            <!-- 생년월일 -->
            <input type="date" name="birth" placeholder="생년월일">

            <!-- 계좌번호 -->
            <input type="text" name="account" placeholder="계좌번호 (선택)">

            <!-- 회원가입 버튼 -->
            <button type="submit">회원가입</button>
        </form>
    </div>
</body>
</html>