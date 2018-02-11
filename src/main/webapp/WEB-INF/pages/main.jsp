<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welvome to Book Store</title>

</head>
<body>

<table border="1">
    <th>Name</th>
    <th>Author</th>
    <th>Price</th>
    <th>Action</th>
<c:forEach items="${books}" var="book">

  <tr>
        <td>${book.getName()}</td>
        <td>${book.getAuthor()}</td>
        <td>${book.getPrice()}</td>
         <td><a href ="edit?id=${book.getId()}">Edit</a></td>
         <td><a href ="delete?id=${book.getId()}">Delete</a></td>
    </tr>

</c:forEach>
</table>
<a href="add">Add new book</a>

</body>
</html>