<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" href="static/css/regist.css">
</head>
<body style="background-image: url('static/img/login_image.jpg');">
	<form action ="customerServlet?action=login" method="post">
	<div class="loginbox">
	    <br/>
	          <h1 style="margin-left: 250px;">&nbsp;用户登录</h1>
	    <br/>
		        <lable class="label_text" style="color: red">${msg}</lable>
		<br/>
	            <lable class="label_text"> 用户名:&nbsp;&nbsp;&nbsp;&nbsp;</lable><input name="custName" class="textarea" type="text" placeholder=" 请输入用户名"> </input><br/><br/>
	            <lable class="label_text"> 密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</lable> <input name="password" class="textarea" type="password" placeholder= "请输入密码"> </input><br/>

	    <br/>
	    <br/>
	    <br/>
	    <input type="submit" name="getidcode" class="regist_button" value="登录"></input>
	    <br/>
	</div>
	</form>
</body>
</html>