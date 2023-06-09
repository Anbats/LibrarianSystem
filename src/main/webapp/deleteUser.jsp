<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/9
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="light3" class="container">
    <div class="drag-bar">
        <div style="width:5%;margin-left:90%"><a href = "javascript:void(0)" onclick = "closeDialog3()" class="close" >×</a></div>
    </div>
    <div class="content">
        <form action="/librarySystem/deleteUserServlet" method="post">
            <table align="center">
                <caption>删除用户</caption>
                <tr>
                    <td>用户号：</td>
                    <td>
                        <input type="text"/>
                    </td>
                <tr>
                    <td colspan="3" style="text-align: center; padding: 5px;">
                        <input type="submit" value="提交"/>
                        <input type="reset" value="重置"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
