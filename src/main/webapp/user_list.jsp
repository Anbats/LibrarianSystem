<%--
  Created by IntelliJ IDEA.
  User: 李怡嘉
  Date: 2023/6/2
  Time: 22:45
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
            >&nbsp;&nbsp;借书记录
        </div>

        <div style="background-color: rgb(240,242,245);height: 730px;padding: 20px;">
            <div style="background-color: white;height: 730px;border:none;border-radius: 5px;">

                <div style=" width:100%; height: 400px; overflow-y:scroll">
                    <div  style="height:1000px">

                        <table width="80%" cellspacing="0" border="1" style="margin-top:20px; margin-left:100px" id="showRecord">

                            <thead align="center">

                            <tr>
                                <th>编号</th>
                                <th>书名</th>
                                <th>借书时间</th>
                                <th>应归还时间</th>
                                <th>是否归还</th>
                            </tr>

                            </thead>
                            <tbody>
                            <c:forEach items="${records}" var="r">
                                <tr align="center">
                                    <td>${r.bno}</td>
                                    <td>${r.bname}</td>
                                    <td>${r.bdate}</td>
                                    <td>${r.ldate}</td>
                                    <td>${r.state}</td>

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
