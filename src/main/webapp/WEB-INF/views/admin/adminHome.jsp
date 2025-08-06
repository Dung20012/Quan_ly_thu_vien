<%@ page import="com.data.library.model.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User currentUser = (User) session.getAttribute("loginUser");
%>
<html>
<head>
    <title>Trang Quản Trị</title>
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap");

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
            max-width: 700px;
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
            font-size: 32px;
            margin-bottom: 25px;
            color: #ffdd99;
            text-shadow: 1px 1px 2px #000;
        }

        p {
            font-size: 18px;
            margin-bottom: 20px;
        }

        a {
            display: inline-block;
            margin: 10px 0;
            color: #ffdd99;
            font-weight: 600;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 25px;
            background-color: rgba(255, 204, 102, 0.8);
            color: #3b2f1e;
            transition: background 0.3s;
        }

        a:hover {
            background-color: rgba(255, 190, 90, 0.9);
        }
    </style>
</head>
<body>
<div class="wrapper">
    <h2>Trang Quản Trị Viên</h2>
    <% if (currentUser != null) { %>
    <p>Xin chào, <strong><%= currentUser.getUsername() %></strong>!</p>
    <% } %>

    <% if (currentUser != null && "ADMIN".equals(currentUser.getRole())) { %>
    <a href="/admin/books"><i class='bx bx-book'></i> Quản lý sách</a><br>
    <a href="/admin/borrowings"><i class='bx bx-time-five'></i> Quản lý mượn sách</a><br>
    <% } %>

    <a href="/auth/logout"><i class='bx bx-log-out'></i> Đăng xuất</a>
</div>
</body>
</html>
