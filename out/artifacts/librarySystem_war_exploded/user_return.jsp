<%--
  Created by IntelliJ IDEA.
  User: 李怡嘉
  Date: 2023/5/30
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
            <a href="/librarySystem_war/selectAllServlet">查询与借阅</a>
        </div>

        <div style="text-align: center; padding:20px 0px 15px 0px; ">
            <a href="/librarySystem_war/bookRecordServlet">借书记录</a>
        </div>

        <div style="text-align: center; padding:20px 0px 15px 0px; ">
            <a href="/librarySystem_war/returnRecordServlet">归还图书</a>
        </div>

        <div style="text-align: center; padding:20px 0px 20px 0px; ">
            <a href="login.jsp">退出登录</a>
        </div>

    </div>

    <div style="width:80%; height: 800px; float:left;">
        <div style="height: 70px; color: rgb(109,109,109); font-size: 18px; line-height: 70px; font-weight: bold; padding-left: 20px;">
            >&nbsp;&nbsp;归还图书
        </div>

        <div style="background-color: rgb(240,242,245);height: 730px;padding: 20px;">
            <div style="background-color: white;height: 730px;border:none;border-radius: 5px;">

                <div style=" width:100%; height: 400px; overflow-y:scroll">
                    <div  style="height:1000px">
                        <nav>
                            <span id="add" onclick="openDialog1()">还书</span>
                        </nav>

                        <div id="light1" class="container">
                            <div class="drag-bar">
                                <div style="width:5%;margin-left:90%"><a href = "javascript:void(0)" onclick = "closeDialog1()" class="close" >×</a></div>
                            </div>
                            <div class="content">
                                <form action="/librarySystem_war/returnBookServlet" method="get">
                                    <table align="center">
                                        <caption>请输入还书编号</caption>
                                        <tr>
                                            <td>书籍编号：</td>
                                            <td>
                                                <input type="text" name="bno"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="3" style="text-align: center; padding: 5px;">
                                                <input type="submit" value="确认"/>
                                                <input type="button" value="重置"/>
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                        </div>

                        <script src="index.js"></script>

                        <table width="80%" cellspacing="0" border="1" style="margin-top:20px; margin-left:100px" id="showReturn">
                            <thead align="center">

                            <tr>
                                <th>编号</th>
                                <th>书名</th>
                                <th>借书时间</th>
                                <th>应还日期</th>

                            </tr>

                            </thead>
                            <tbody>
                            <c:forEach items="${records}" var="r">
                                <tr>
                                    <th>${r.rbno}</th>
                                    <th>${r.rbname}</th>
                                    <th>${r.rbdate}</th>
                                    <th>${r.day}</th>

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
