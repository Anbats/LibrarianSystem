<%@ page import="com.library.service.bookService" %><%--
  Created by IntelliJ IDEA.
  User: 李怡嘉
  Date: 2023/5/30
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>借阅书籍</title>
</head>
<body>

<form action="/librarySystem_war/updateServlet" method="get">
    请确认书籍编号是否正确
    <br>
    <input type="hidden" name="bno"  value="${bno}" >
    是否借阅书籍${bno}
    <input type="submit" id="btn" value="是" >
    <input type="button" id="btn" value="否" >
</form>

</body>
</html>
