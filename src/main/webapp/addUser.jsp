<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/9
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="light1" class="container">
    <div class="drag-bar">
        <div style="width:5%;margin-left:90%"><a href = "javascript:void(0)" onclick = "closeDialog1()" class="close" >×</a></div>
    </div>
    <div class="content">
        <form action="/librarySystem/addUserServlet" method="post">
            <table align="center">
                <caption>新增用户</caption>
                <tr>
                    <td>用户名：</td>
                    <td>
                        <input type="text" name="uname"/>
                    </td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td>
                        <input type="radio" name="sex1" value="0"/>男
                        <input type="radio" name="sex1" value="1"/>女
                    </td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td>
                        <input type="text" name="upassword"/>
                    </td>
                </tr>
                <tr>
                    <td>邮箱：</td>
                    <td>
                        <input type="text" name="email"/>
                    </td>
                </tr>
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
