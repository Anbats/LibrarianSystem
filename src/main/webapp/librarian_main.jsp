<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/8
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    *{
        box-sizing: border-box;
    }

    a:link{
        font-size: 20px;
        color: rgb(109,109,109);
        text-decoration: none;
    }

    a:visited{
        font-size: 20px;
        color: rgb(109,109,109);
        text-decoration: none;
    }

    a:hover{
        font-size: 20px;
        color: white;
        text-decoration: none;
    }

</style>

<body>

<div >

    <div style="background-color: rgb(0,21,41);width: 20%; height: 800px;float:left;">

        <div style="background-color: rgb(0,40,77);">
            <img src="img/touxiang.png" style="width:250px; height: 250px; padding:20px 0px 25px 45px; "/>
        </div>

        <div style="text-align: center; padding:30px 0px 15px 0px; ">
            <a href="librarian_user.html">用户管理</a>
        </div>

        <div style="text-align: center; padding:20px 0px 15px 0px; ">
            <a href="librarian_book.html">图书管理</a>
        </div>

        <div style="text-align: center; padding:20px 0px 20px 0px; ">
            <a href="login.html">退出登录</a>
        </div>

    </div>

</div>

</body>
</html>