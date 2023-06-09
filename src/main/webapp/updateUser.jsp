<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/9
  Time: 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="light2" class="container">
    <div class="drag-bar">
        <div style="width:5%;margin-left:90%"><a href = "javascript:void(0)" onclick = "closeDialog2()" class="close" >×</a></div>
    </div>
    <div class="content">
        <form action="/librarySystem/updateUserServlet" method="post">
            <table align="center">
                <caption>修改用户</caption>
                <tr>
                    <td>用户号：</td>
                    <td>
                        <input name="uname" type="text"/>
                    </td>
                </tr>
                <tr>
                    <td>姓名：</td>
                    <td>
                        <input name="uno" type="text" value="${user.uno}"/>
                    </td>
                </tr>

                <tr>
                    <td>性别：</td>
                    <td>
                        <input type="radio" text="男" name="sex2" value="${user.sex2}"/>
                        <input type="radio" text="女" name="sex2" value="${user.sex2}"/>
                    </td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td>
                        <input type="text" name="password" value="${user.password}"  />
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
