<%--
  Created by IntelliJ IDEA.
  User: 李怡嘉
  Date: 2023/6/3
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>




<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Java web邮箱验证码</title>
</head>

<body>

<form id="form0" name="form0" AUTOCOMPLETE="OFF" action="/librarySystem_war/updatePswServlet" method="get">
    <table>
        <tr height="35px">
            <td >账户名：</td>
            <td>
                <input type="text" name="name" id="name" placeholder="输入邮箱" />
            </td>
        </tr>
        <tr height="35px">
            <td >密码：</td>
            <td>
                <input type="text" name="psw" id="psw" placeholder="输入新密码" />
            </td>
        </tr>
        <tr height="35px">
            <td >收件邮箱：</td>
            <td>
                <input type="text" name="email" id="email" placeholder="输入邮箱" />
            </td>
            <td>
                <button id="btnGetVcode" style="cursor:pointer">获取验证码</button>
            </td>
        </tr>
        <tr height="35px">
            <td >验证码：</td>
            <td>
                <input type="text" name="vcode" id="vcode" placeholder="输入验证码"/>
            </td>
            <td id="message"></td>
        </tr>

    <a target="_self">
        <button type="submit" id="btnVerify" style="cursor:pointer">重置密码</button></a>

    </table>
</form>

<!-- 引入jQuery -->
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/jsEmail.js"></script>
<script>
    var time0 = 60;
    var time = time0;
    var t;  // 用于验证按钮的60s计时

    $(document).ready(function() {

        // 获取验证码按钮
        $("#btnGetVcode").click(function() {
            var btnGet = document.getElementById("btnGetVcode");
            btnGet.disabled = true;  // 为了防止多次点击
            $.ajax({
                url: 'emailServlet?method=getVCode',
                type: 'post',
                data: {email: $("input[name='email']").val()},
                dataType: 'text',
                success: function(msg) {
                    if(msg == -1){
                        window.alert("请输入正确的邮箱！");
                        btnGet.disabled = false;
                    }
                    else{
                        useChangeBTN();  // 控制下一次重新获取验证码
                    }
                },
                error:function(msg){
                }
            });
        });

        // 验证按钮
        $("#btnVerify").click(function() {
            var message = document.getElementById("message");  // 显示提示信息
            $.ajax({
                url: 'emailServlet?method=verify',
                type: 'post',
                data: {vcode: $("input[name='vcode']").val()},
                dataType: 'text',
                success: function(msg) {
                    if(t<=0){
                        message.innerHTML = "验证码错误！";
                        $("#message").css("color","red");
                    }
                    else if(msg == 1){
                        message.innerHTML = "验证码正确！";
                        $("#message").css("color","green");

                    }
                    else{
                        message.innerHTML = "验证码错误！";
                        $("#message").css("color","red");

                    }
                },
                error:function(msg){
                }
            });
        });
    });

    //修改按钮，控制验证码重新获取
    function changeBTN(){
        if(time > 0){
            $("#btnGetVcode").text("("+time+"s)"+"重新获取");
            time = time - 1;
        }
        else{
            var btnGet = document.getElementById("btnGetVcode");
            btnGet.disabled = false;
            $("#btnGetVcode").text("获取验证码");
            clearInterval(t);
            time = time0;
        }
    }
    function useChangeBTN(){
        $("#btnGetVcode").text("("+time+"s)"+"重新获取");
        time = time - 1;
        t = setInterval("changeBTN()", 1000);  // 1s调用一次
    }

</script>
</body>

</html>

