<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/8
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
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

    *{
        box-sizing: border-box;
    }

    div.search {
        padding: 10px 0;
    }

    form {
        position: relative;
        width: 500px;
        margin: 0 auto;
    }

    input,button {
        border: none;
        outline: none;
    }

    .search input {
        width: 100%;
        height: 42px;
        padding-left: 13px;
        border: 2px solid #c5464a;
        border-radius: 19px;
        background: transparent;
    }

    .search button {
        height: 42px;
        width: 42px;
        cursor: pointer;
        position: absolute;
        background: #c5464a;
        border-radius: 0 19px 19px 0;
        width: 60px;
        right: 0;
    }
    .search button:hover {
        background-color: #c7585c;
    }

    .search button:before {
        content: "查询";
        font-size: 13px;
        color: #F9F0DA;
    }
    nav {
        width: 100%;
        height: 40px;
        box-shadow: 0 2px 4px 0 rgba(0,0,0,.05);
        background-color: #fff;
        line-height: 40px;
        text-align: center;
    }
    nav>span {
        display: inline-block;
        font-size: 15px;
        padding: 0 5px;
    }
    nav>span:hover {
        color: #f00;
        cursor: pointer;
    }
    nav>span.select {
        color: #f00;
    }
    .container{
        display: none;
        width:400px;
        height:400px;
        position:absolute;
        left:50%;
        top:50%;
        transform:translate(-50%,-50%);
    }
    .drag-bar{
        width:100%;
        height:30px;
        background-color:#d8dadb;
    }
    .content{
        width:100%;
        height:370px;
        background-color:#f1f3f4;
        display:flex;
        justify-content:center;
        align-items:center;
    }
    .close{
        display:block;
        position:relative;
        text-align:right;
        left:-10px;
        top:15px;
        color:red;
        font-size:25px;
        transform:translateY(-50%);
        text-decoration:none;
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
    <div style="width:80%; height: 800px; float:left;">
        <div style="height: 70px; color: rgb(109,109,109); font-size: 18px; line-height: 70px; font-weight: bold; padding-left: 20px;">
            >&nbsp;&nbsp;用户管理
        </div>

        <div style="background-color: rgb(240,242,245);height: 730px;padding: 20px;">
            <div style="background-color: white;height: 730px;border:none;border-radius: 5px;">

                <div class="search" style="box-sizing: border-box;">
                    <form action="" method="post">
                        <input placeholder="请输入用户的相关信息" name="keyword" type="text">
                        <button type="submit"></button>
                    </form>
                </div>

                <nav>
                    <span id="add" onclick="openDialog1()">添加</span>
                    <span id="mod" onclick="openDialog2()">修改</span>
                    <span id="del" onclick="openDialog3()">删除</span>
                    <span id="fre" onclick="openDialog4()">冻结/解冻</span>
                </nav>

                <div id="light1" class="container">
                    <div class="drag-bar">
                        <div style="width:5%;margin-left:90%"><a href = "javascript:void(0)" onclick = "closeDialog1()" class="close" >×</a></div>
                    </div>
                    <div class="content">
                        <form>
                            <table align="center">
                                <caption>新增用户</caption>
                                <tr>
                                    <td>用户名：</td>
                                    <td>
                                        <input type="text"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>性别：</td>
                                    <td>
                                        <input type="radio" text="男" name="sex1"/>
                                        <input type="radio" text="女" name="sex1"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>密码：</td>
                                    <td>
                                        <input type="text"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="3" style="text-align: center; padding: 5px;">
                                        <input type="button" value="提交"/>
                                        <input type="button" value="重置"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
                <div id="light2" class="container">
                    <div class="drag-bar">
                        <div style="width:5%;margin-left:90%"><a href = "javascript:void(0)" onclick = "closeDialog2()" class="close" >×</a></div>
                    </div>
                    <div class="content">
                        <form>
                            <table align="center">
                                <caption>修改用户</caption>
                                <tr>
                                    <td>用户号：</td>
                                    <td>
                                        <input type="text"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>姓名：</td>
                                    <td>
                                        <input type="text"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>性别：</td>
                                    <td>
                                        <input type="radio" text="男" name="sex2"/>
                                        <input type="radio" text="女" name="sex2"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>密码：</td>
                                    <td>
                                        <input type="text">
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="3" style="text-align: center; padding: 5px;">
                                        <input type="button" value="提交"/>
                                        <input type="button" value="重置"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>

                <div id="light3" class="container">
                    <div class="drag-bar">
                        <div style="width:5%;margin-left:90%"><a href = "javascript:void(0)" onclick = "closeDialog3()" class="close" >×</a></div>
                    </div>
                    <div class="content">
                        <form>
                            <table align="center">
                                <caption>删除用户</caption>
                                <tr>
                                    <td>用户号：</td>
                                    <td>
                                        <input type="text"/>
                                    </td>
                                <tr>
                                    <td colspan="3" style="text-align: center; padding: 5px;">
                                        <input type="button" value="提交"/>
                                        <input type="button" value="重置"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
                <div id="light4" class="container">
                    <div class="drag-bar">
                        <div style="width:5%;margin-left:90%"><a href = "javascript:void(0)" onclick = "closeDialog4()" class="close" >×</a></div>
                    </div>
                    <div class="content">
                        <form>
                            <table align="center">
                                <caption>冻结/解冻</caption>
                                <tr>
                                    <td>用户名：</td>
                                    <td>
                                        <input type="text"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="3" style="text-align: center; padding: 5px;">
                                        <input type="button" value="提交"/>
                                        <input type="button" value="重置"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
                <script src="index.js"></script>

                <div style=" width:100%; height: 400px; overflow-y:scroll">
                    <div  style="height:1000px">

                        <table width="80%" cellspacing="0" border="1" style="margin-top:20px; margin-left:100px">
                            <thead align="center">
                            <tr>
                                <th>用户号</th>
                                <th>用户名</th>
                                <th>性别</th>
                                <th>用户状态</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${users}" var="user" varStatus="status">
                            <tr align="center">

                                <td>${user.uno}</td>
                                <td>${user.uname}</td>
                                <td>${user.sex}</td>
                                <c:if test="${user.status == 1}">
                                    <td>未冻结</td>
                                </c:if>
                                <c:if test="${user.status == 0}">
                                    <td>冻结</td>
                                </c:if>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
