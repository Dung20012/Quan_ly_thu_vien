<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Duyệt yêu cầu mượn sách</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>

<div class="wrapper">
<table border="1">
    <tr>
        <th>Người mượn</th><th>Sách</th><th>Ngày mượn</th><th>Hành động</th>
    </tr>
    <c:forEach var="r" items="${requests}">
        <tr>
            <td>${r.user.username}</td>
            <td>${r.book.title}</td>
            <td>${r.borrowDate}</td>
            <td>
                <a href="/admin/borrowings/approve/${r.id}">Duyệt</a>
                <a href="/admin/borrowings/reject/${r.id}" onclick="return confirm('Từ chối yêu cầu?');">Từ chối</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/admin/home">
    <i class='bx bx-left-arrow-alt'></i>
    Quay lại
</a>
</div>
</body>
</html>
