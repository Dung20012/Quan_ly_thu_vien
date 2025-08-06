<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Lịch sử mượn sách</title>
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
        integrity="sha512-RandomHashHere" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="/css/admin.css">
</head>
<body>

<div class="wrapper">
<h2>Lịch sử mượn sách của người dùng</h2>

<table border="1">
  <tr>
    <th>Người mượn</th>
    <th>Tên sách</th>
    <th>Ngày mượn</th>
    <th>Ngày trả</th>
    <th>Đã trả?</th>
    <th>Đã duyệt?</th>
  </tr>
  <c:forEach var="b" items="${borrowings}">
    <tr>
      <td>${b.user.username}</td>
      <td>${b.book.title}</td>
      <td>${b.borrowDate}</td>
      <td>${b.returnDate}</td>
      <td><c:if test="${b.returned}">
        <i class='bx bx-check-double'></i>
      </c:if><c:if test="${!b.returned}">
        <i class="fa-solid fa-x"></i>
      </c:if></td>
      <td><c:if test="${b.approved}">
        <i class='bx bx-check-double'></i>
      </c:if><c:if test="${!b.approved}">
        <i class="fa-solid fa-x"></i>
      </c:if></td>
    </tr>
  </c:forEach>
</table>
<a href="/admin/books">
  <i class='bx bx-left-arrow-alt'></i>
  Quay lại
</a>
</div>
</body>
</html>
