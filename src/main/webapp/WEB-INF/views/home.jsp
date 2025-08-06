<%@ page import="com.data.library.model.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User currentUser = (User) session.getAttribute("loginUser");
%>
<html>
<head>
    <title>Trang chủ</title>
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap");

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            min-height: 100vh;
            background: url('https://png.pngtree.com/background/20250104/original/pngtree-d-illustration-of-old-library-or-bookshop-with-many-books-on-picture-image_15710808.jpg') no-repeat center center;
            background-size: cover;
            background-attachment: fixed;
            padding: 40px;
            color: #fff9e6;
        }

        .wrapper {
            max-width: 600px;
            margin: auto;
            padding: 30px 40px;
            background: rgba(0, 0, 0, 0.5);
            border: 2px solid rgba(255, 255, 255, 0.2);
            backdrop-filter: blur(10px);
            border-radius: 12px;
            box-shadow: 0 0 20px rgba(0, 0, 0, .4);
        }

        h2 {
            text-align: center;
            font-size: 30px;
            margin-bottom: 20px;
            color: #ffdd99;
            text-shadow: 1px 1px 2px #000;
        }

        p {
            font-size: 18px;
            margin-bottom: 20px;
        }

        a, button {
            display: inline-block;
            margin: 10px 0;
            padding: 10px 20px;
            font-weight: 600;
            border-radius: 25px;
            text-decoration: none;
            transition: background 0.3s;
            cursor: pointer;
            background-color: rgba(255, 204, 102, 0.9);
            color: #3b2f1e;
            border: none;
        }

        a:hover, button:hover {
            background-color: rgba(255, 190, 90, 1);
        }

        .btn-group {
            display: flex;
            flex-direction: column;
            gap: 10px;
            align-items: flex-start;
        }

        .icon-left {
            margin-right: 8px;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <h2>Chào mừng đến trang Home!</h2>
    <% if (currentUser != null) { %>
    <p>Xin chào, <strong><%= currentUser.getUsername() %></strong>!</p>
    <% } %>

    <div class="btn-group">
        <a href="/books"><i class='bx bx-book icon-left'></i> Danh sách sách</a>
        <form action="${pageContext.request.contextPath}/auth/logout" method="get">
            <button type="submit"><i class='bx bx-log-out icon-left'></i> Đăng xuất</button>
        </form>
    </div>
</div>
</body>
</html>
