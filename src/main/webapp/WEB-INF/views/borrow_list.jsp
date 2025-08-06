<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sách đã mượn</title>
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="wrapper">
<h2>Danh sách sách đã mượn</h2>

<table border="1">
  <tr>
    <th>Tên sách</th>
    <th>Ngày mượn</th>
    <th>Ngày trả</th>
    <th>Trạng thái</th>
    <th>Hành động</th>
  </tr>
  <c:forEach var="b" items="${borrowings}">
    <tr>
      <td>${b.book.title}</td>
      <td>${b.borrowDate}</td>
      <td>${b.returnDate}</td>
      <td>
        <c:choose>
          <c:when test="${b.returned}">Đã trả</c:when>
          <c:when test="${!b.approved}">Chờ duyệt</c:when>
          <c:otherwise>Đang mượn</c:otherwise>
        </c:choose>
      </td>
      <td>
        <c:if test="${b.approved && !b.returned}">
          <form method="post" action="/borrowings/return/${b.id}">
            <button type="submit">Trả sách</button>
          </form>
        </c:if>
      </td>
    </tr>
  </c:forEach>
</table>
<a href="/books">
  <i class='bx bx-left-arrow-alt'></i>
  Quay lại
</a>
</div>
</body>
</html>
