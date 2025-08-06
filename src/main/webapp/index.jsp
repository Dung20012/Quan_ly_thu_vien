<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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
            background: url('https://png.pngtree.com/background/20240413/original/pngtree-a-3d-rendering-of-a-living-room-library-room-picture-image_8474370.jpg') no-repeat center center;
            background-size: cover;
            background-attachment: fixed;
            padding: 40px;
            color: #fff9e6;
        }

        .wrapper {
            max-width: 500px;
            margin: auto;
            padding: 30px 40px;
            background: rgba(0, 0, 0, 0.5);
            border: 2px solid rgba(255, 255, 255, 0.2);
            backdrop-filter: blur(10px);
            border-radius: 12px;
            box-shadow: 0 0 20px rgba(0, 0, 0, .4);
            text-align: center;
        }

        h1 {
            font-size: 36px;
            margin-bottom: 30px;
            color: #ffdd99;
            text-shadow: 1px 1px 2px #000;
        }

        a {
            display: inline-block;
            margin: 10px;
            padding: 10px 25px;
            background-color: rgba(255, 204, 102, 0.9);
            color: #3b2f1e;
            font-weight: 600;
            border-radius: 25px;
            text-decoration: none;
            transition: background 0.3s ease;
        }

        a:hover {
            background-color: rgba(255, 190, 90, 1);
        }

        i {
            margin-right: 8px;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <h1><%= "Hello World!" %></h1>
    <a href="/auth/login"><i class='bx bx-log-in'></i> Đăng nhập</a>
    <a href="/auth/register"><i class='bx bx-user-plus'></i> Đăng ký</a>
</div>
</body>
</html>
