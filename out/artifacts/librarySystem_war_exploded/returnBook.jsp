<%--
  Created by IntelliJ IDEA.
  User: 李怡嘉
  Date: 2023/5/30
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<form action="/librarySystem_war/updateServlet" method="get">
    请确认书籍编号是否正确
    书籍编号<input type="text" name="bno"  value="${bno}" >
    <input type="submit" id="btn" value="确认" >
</form>

</body>
</html>
