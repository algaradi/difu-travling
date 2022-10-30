<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="static/css/tablestyle.css">
    <link rel="stylesheet" href="staic/css/regist.css">
    <script src="static/js/jquery-3.3.1.min.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人信息修改</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<form action="customerServlet"  method="post" style=" height:100%; width: 100%; text-align: center; " >
    <input type="hidden" name="action" value="add">
    <table align="center" id="modify_table_hotel" class="modify_table">

        <tr>
            <td colspan="2" style="text-align: center">
                <span style="color: red; font-size: large">${msg}</span>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <span style="color: red; font-size: medium">*代表必填项</span>
            </td>
        </tr>
        <tr>
            <td>用户姓名:</td>
            <%-- readonly属性规定字段只能读，不能编辑修改--%>
            <td><input class="textarea" id="custName" name="custName" ></td>
        </tr>
        <tr>
            <td>密码：</td>
            <%--  required 属性规定必需在提交表单之前填写输入字段  --%>
            <td><input class="textarea" id="password" name="password" ><font
                    color="red">*</font></td>
        </tr>
        <tr>
            <td>用户类型：</td>
            <td><input class="textarea" id="type" name="type" "></td>
        </tr>
        <tr>
            <td>联系方式：</td>
            <td><input class="textarea" id="custPhone" name="custPhone" ></td>
        </tr>
    </table>
    <table align="center">
        <tr style="text-align: center">
            <td>
                <input class="button_getidcode_text" type="submit" value="确认修改">
            </td>
            <td>
                <input class="button_getidcode_text"  type="button" value="返回" onclick="window.location.href='SearchAllServlet'">
            </td>
        </tr>
    </table>
</form>
</body>
</html>













