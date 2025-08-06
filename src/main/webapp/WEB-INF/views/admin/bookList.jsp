<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Danh sách sách</title>
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="/css/admin.css">
</head>
<body>

<div class="wrapper">
<h2>Danh sách Sách</h2>

<form method="get" action="">
  <input type="text" name="keyword" placeholder="Tìm kiếm tiêu đề..." value="${param.keyword}">
  <button type="submit">Tìm</button>
</form>

<a href="/admin/books/create">Thêm sách mới</a>

<table border="1" cellpadding="5" cellspacing="0">
  <tr>
    <th>ID</th>
    <th>Tiêu đề</th>
    <th>Tác giả</th>
    <th>Thể loại</th>
    <th>Mô tả</th>
    <th>Năm XB</th>
    <th>Số lượng</th>
    <th>Thao tác</th>
  </tr>
  <c:forEach var="book" items="${books}">
    <tr>
      <td>${book.id}</td>
      <td>${book.title}</td>
      <td>${book.author}</td>
      <td>${book.category}</td>
      <td>${book.description}</td>
      <td>${book.publication_year}</td>
      <td>${book.quantity}</td>
      <td>
        <a href="/admin/books/edit/${book.id}"><i class='bx bxs-pencil'></i></a>
        <a href="/admin/books/delete/${book.id}"
           onclick="return confirm('Bạn có chắc chắn muốn xóa không?');">
          <i class='bx bxs-trash-alt'></i>
        </a>
      </td>
    </tr>
  </c:forEach>
</table>

<!-- Phân trang -->
<c:if test="${totalPage > 1}">
  <div>
    <c:forEach var="i" begin="1" end="${totalPage}">
      <a href="?page=${i}&size=5">${i}</a>
    </c:forEach>
  </div>
</c:if>
<br>
<a href="/admin/borrowings/history">Lịch sử mượn sách</a>
<br>
<a href="/admin/home">
  <i class='bx bx-left-arrow-alt'></i>
  Quay lại
</a>
</div>
</body>
</html>
