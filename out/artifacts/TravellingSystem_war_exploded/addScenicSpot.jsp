<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="static/css/tablestyle.css">
    <link rel="stylesheet" href="static/css/regist.css">
    <script src="static/js/jquery-3.3.1.min.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>景点信息修改</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<form action="ScenicSpotServlet" method="post" style="text-align: center">
    <input type="hidden" name="action" value="add">
    <table align="center" id="modify_table_flight" class="modify_table">
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
            <td>景点名:</td>
            <%-- readonly属性规定字段只能读，不能编辑修改--%>
            <td><input type="text"   class="textarea"  name="spotName" /></td>
        </tr>
        <tr>
            <td>价格/单：</td>
            <%--  required 属性规定必需在提交表单之前填写输入字段  --%>
            <td><input type="text"  class="textarea"  name="price" ><font
                    color="red">*</font></td>
        </tr>
        <tr>
            <td>所在城市：</td>
            <td><input type="text" class="textarea"  name="cityName"  /></td>
        </tr>
        <tr>
            <td>详细地址:</td>
            <td><input  type="text"  class="textarea" name="address" ></td>
        </tr>
        <tr>
            <td>票数量:</td>
            <td><input type="text"   class="textarea"  name="ticketNum"></td>
        </tr>
        <tr>
            <td>照片路径:</td>
            <td><input  type="text"  class="textarea"  name="photo" ></td>
        </tr>
        <tr>
            <td>描述:</td>
            <td><input type="text"  class="textarea"  name="descSpot"  placeholder="描述号景点"></td>
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