<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đăng ký</title>
    <link rel="stylesheet" href="/css/auth.css"/>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <style>
        .error {
            color: red;
            font-size: 0.8em;
            margin-top: 4px;
            text-align: left;
        }
    </style>
</head>
<body>
<section class="container forms">
    <div class="form signup">
        <div class="form-content">
            <header>Đăng ký</header>

            <form:form method="post" action="/auth/register" modelAttribute="user">

                <!-- Tên đăng nhập -->
                <div class="field input-field">
                    <form:input path="username" placeholder="Tên đăng nhập" cssClass="input"/>
                    <i class='bx bxs-user'></i>
                    <form:errors path="username" cssClass="error"/>
                </div>

                <!-- Email -->
                <div class="field input-field">
                    <form:input path="email" placeholder="Email" cssClass="input"/>
                    <i class='bx bxs-envelope'></i>
                    <form:errors path="email" cssClass="error"/>
                </div>

                <!-- Mật khẩu -->
                <div class="field input-field">
                    <form:password path="password" placeholder="Mật khẩu" cssClass="input"/>
                    <i class='bx bxs-lock-alt'></i>
                    <form:errors path="password" cssClass="error"/>
                </div>

                <!-- Nhập lại mật khẩu -->
                <div class="field input-field">
                    <input type="password" name="confirmPassword" placeholder="Nhập lại mật khẩu" class="input"/>
                    <i class='bx bxs-lock'></i>
                </div>

                <!-- Lỗi confirm password hoặc các lỗi khác -->
                <c:if test="${not empty error}">
                    <div class="error"><i class='bx bx-error-circle'></i> ${error}</div>
                </c:if>

                <!-- Nút đăng ký -->
                <div class="field button-field">
                    <button>Đăng ký</button>
                </div>

            </form:form>

            <div class="form-link">
                <span>Đã có tài khoản? <a href="/auth/login" class="link login-link">Đăng nhập</a></span>
            </div>
        </div>
    </div>
</section>
</body>
</html>
