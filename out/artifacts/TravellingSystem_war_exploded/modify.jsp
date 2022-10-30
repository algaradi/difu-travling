<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="static/css/tablestyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%@ include file="head.jsp" %>
<title>个人信息修改</title>
</head>
<body>
<form action="index.jsp" style="text-align: center">
        <table align="center">
            <tr>
                <td colspan="2" style="text-align: center">
                    <font color="red">*代表必填项</font>
                </td>
            </tr>
            <tr>
                <td>用户姓名:</td>
                <%-- readonly属性规定字段只能读，不能编辑修改--%>
                <td><input class="textarea" id="custName" name="custName" value="<%=request.getParameter("custName")%>" required readonly></td>
            </tr>
            <tr>
                <td>密码：</td>
                <%--  required 属性规定必需在提交表单之前填写输入字段  --%>
                <td><input class="textarea" id="password" name="password" value="<%=request.getParameter("password")%>" required><font
                        color="red">*</font></td>
            </tr>
            <tr>
                <td>用户类型：</td>
                <td><input class="textarea" id="type" name="sex" value="<%=request.getParameter("type")%>"></td>
            </tr>
            <tr>
                <td>联系方式：</td>
                <td><input class="textarea" id="custPhone" name="classid" value="<%=request.getParameter("custPhone")%>"></td>
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