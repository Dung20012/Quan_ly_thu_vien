<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Thêm sách mới</title>
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="/css/admin.css">
</head>
<body>

<div class="wrapper">
<h2>Thêm Sách Mới</h2>

<form:form method="post" modelAttribute="books">
  <p>Tiêu đề: <form:input path="title" /></p>
  <p>Tác giả: <form:input path="author" /></p>
  <p>Thể loại: <form:input path="category" /></p>
  <p>Mô tả: <form:textarea path="description" /></p>
  <p>Năm xuất bản: <form:input path="publication_year" /></p>
  <p>Số lượng: <form:input path="quantity" /></p>
  <button type="submit">Lưu</button>
</form:form>

<a href="/admin/books">
  <i class='bx bx-left-arrow-alt'></i>
  Quay lại danh sách
</a>
</div>
</body>
</html>
