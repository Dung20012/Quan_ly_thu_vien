<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sách</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="wrapper">
<h2>Danh sách sách</h2>

<!-- Form tìm kiếm -->
<form method="get" action="/books">
    <input type="text" name="keyword" placeholder="Tìm theo tiêu đề..." value="${param.keyword}">
    <button type="submit">Tìm kiếm</button>
</form>

<!-- Bảng hiển thị sách -->
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Tác giả</th>
        <th>Thể loại</th>
        <th>Mô tả</th>
        <th>Năm xuất bản</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.category}</td>
            <td>${book.description}</td>
            <td>${book.publication_year}</td>
            <td>${book.quantity}</td>
            <th>
                <form method="post" action="/borrowings/request/${book.id}">
                    <button type="submit">Mượn sách</button>
                </form>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Phân trang -->
<c:if test="${not empty totalPage && totalPage > 1}">
    <p>Trang:
        <c:forEach var="i" begin="1" end="${totalPage}">
            <c:choose>
                <c:when test="${i == currentPage}">
                    <strong>${i}</strong>
                </c:when>
                <c:otherwise>
                    <a href="/books?page=${i}&size=5">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </p>
</c:if>
<br>
<a href="/borrowings/my-borrows">Sách đã mượn</a>
<br>
<a href="/user/home">
    <i class='bx bx-left-arrow-alt'></i>
    Quay lại
</a>
</div>
</body>
</html>
