<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="static/css/regist.css">
    <script type="text/javascript">
        function fun1() {
             var pwd = document.getElementsByName("password");
             var rpwd =document.getElementsByName("rpwd");
             var msg =document.getElementsByName("msg");
             if(pwd!=rpwd){
                 msg.value = "确认密码和密码不一致"
             }
        }
    </script>
</head>
<body style="background-image: url('static/img/login_image.jpg');">
<form action ="customerServlet" method="post">
    <input type="hidden" name="action" value="regist">
    <div class="registbox">
        <br/>
        <h1 style="margin-left: 250px;">&nbsp;用户注册</h1>
        <br/>
        <lable class="label_text" style="color: red" name="msg">${msg}</lable>
        <br/>
        <lable class="label_text"> 用户名:&nbsp;&nbsp;</lable><input class="textarea" type="text" name="custName" placeholder=" 请输入用户名"> </input><br/><br/>
        <lable class="label_text"> 密码:&nbsp;&nbsp;&nbsp;</lable> <input class="textarea" type="text" onmouseover="fun1()" name="password" placeholder= "请输入密码"> </input><br/>
        <!--        <button name="getidcode" class="button_getidcode_text">获取验证码</button><br/>-->
        <lable class="label_text"> 确认密码:</lable>
        <input class="textarea" type="text" name="rpwd" placeholder=" 再次输入密码"> </input><br/><br/>
        <lable class="label_text"> 手机号:&nbsp;&nbsp;</lable><input class="textarea" type="text" name="custPhone" placeholder=" 请输入手机号"> </input><br/>
        <br/>
        <br/>
<%--        <br/>--%>
<%--        <lable class="label_text" style="margin-left: 150px"> 用户类型: 管理员</lable><input type="radio" name= authority value="1">--%>
<%--        <lable class="label_text"> 普通用户</lable><input type="radio" name= authority value="0">--%>
<%--        <br/>--%>

        <br/>
        <button name="getidcode" class="regist_button">注册</button>
        <br/>
    </div>
</form>
</body>
</html>