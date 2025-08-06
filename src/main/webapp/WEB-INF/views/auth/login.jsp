<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="/css/auth.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<div class="wrapper">
    <h1>Đăng nhập</h1>

    <c:if test="${not empty error}">
        <div class="toast">
            <i class='bx bx-error-circle'></i> ${error}
        </div>
    </c:if>

    <form action="/auth/login" method="post">
        <div class="input-box">
            <input type="text" name="username" placeholder="Tên đăng nhập" required />
            <i class='bx bxs-user'></i>
        </div>

        <div class="input-box">
            <input type="password" name="password" placeholder="Mật khẩu" required />
            <i class='bx bxs-lock-alt'></i>
        </div>

        <button type="submit" class="btn">Đăng nhập</button>

        <div class="register-link">
            <p>Bạn chưa có tài khoản? <a href="/auth/register">Đăng ký</a></p>
        </div>
    </form>
</div>
</body>
</html>
