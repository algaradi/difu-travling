<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="static/css/tablestyle.css">
    <link rel="stylesheet" href="static/css/regist.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/test.js"></script>
    <%@ include file="head.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>?????</title>

</head>
<body>

<form action="ReservationServlet" method="post" style="text-align: center">
    <input type="hidden" name="action" value="reservation">
    <table align="center" id="modify_table_car" class="modify_table">
        <tr>
            <td colspan="2" style="text-align: center">
                <span style="color: red; font-size: large">提示：${msg}</span>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <span style="color: red; font-size: medium">预订号表示：座位号，或房间号，或景点门票号</span>
            </td>
        </tr>
        <tr>
            <td>预订编号:</td>
            <%-- readonly属性规定字段只能读，不能编辑修改--%>
            <td><input class="textarea"  name="resvKey" value="${param.resvKey}" required readonly></td>
        </tr>
        <tr>
            <td>顾客姓名：</td>
            <%--  required 属性规定必需在提交表单之前填写输入字段  --%>
            <td><input class="textarea"  name="custName" value="${sessionScope.cust.custName}"  required readonly><font
                    color="red">*</font></td>
        </tr>
        <tr>
            <td>预订类型：</td>
            <td><input class="textarea"  name="type" value="${param.type}"  required readonly></td>
        </tr>
        <tr>
            <td>预订时间：</td>
            <td><input class="textarea" type="date" name="resDate" ></td>
        </tr>
        <tr>
            <td>预订号：</td>
            <td><input class="textarea"  name="null" value="后台随机完成，请看上面的提示信息" required readonly></td>
        </tr>
    </table>
    <table align="center">
        <tr style="text-align: center">
            <td>
                <input class="button_getidcode_text" type="submit" value="确认修改">
            </td>
            <td>
                <input class="button_getidcode_text"  type="button" value="返回" onclick="window.location.href='CarServlet?action=list'">
            </td>
        </tr>
    </table>
</form>



<%--<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%;margin-top:400px;" color=#111 SIZE=3>--%>
<%--<div>--%>

<%--    <form action="#" method="post" class="booking">--%>
<%--        <h1 style="margin-left:200px;margin-top:20px;">预定信息</h1>--%>
<%--        <label class="lable_style">预订编号:</label>--%>
<%--        <input type="text" readonly="readonly" class="textarea" name="resvKey"  value="${param.resvKey}" /><br/> <br/>--%>
<%--        <label class="lable_style">姓名:&nbsp;&nbsp;&nbsp;</label>--%>
<%--        <input type="text" readonly="readonly" class="textarea" name="custName" value="${sessionScope.cust.custName}" /></br> <br/>--%>
<%--        <br/><label class="lable_style">预定类型：</label>--%>
<%--        <input type="text" readonly ="readonly" name="type" value="${param.type}">--%>
<%--        <select name="choice" id="choice">--%>
<%--        <option>请选择您的订单信息</option>--%>
<%--        <option value="1">航班预定</option>--%>
<%--        <option value="2">出租车预定</option>--%>
<%--        <option value="3">酒店预定</option>--%>
<%--        <option value="4">景点票预订</option>--%>
<%--    </select>--%>
<%--        <br/>--%>
<%--        <br/>--%>
<%--        <label class="lable_style">预定时间：</label>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--        <input type="date" class="resDate" name="resDate" placeholder="请选择日期"></input><br/> <br/>--%>
<%--        <label class="lable_style">预定号：</label>&nbsp;--%>
<%--        <c:if test="${param.type == 1}" >--%>
<%--              A--%>
<%--        </c:if>--%>
<%--        <c:if test="${param.type == 2}" >--%>
<%--              B--%>
<%--        </c:if>--%>
<%--        <c:if test="${param.type == 3}" >--%>
<%--              C--%>
<%--        </c:if>--%>
<%--        <c:if test="${param.type == 4}" >--%>
<%--             D--%>
<%--        </c:if>--%>
<%--&lt;%&ndash;        <input type="text" class="textarea" id="number" name="number" placeholder="请输入预定号"/><br/> <br/>&ndash;%&gt;--%>
<%--        <input type="submit" class="button_getidcode_text" value="提交预定"/>  <a href="index.jsp" style="margin-left:200px;font-family: 'Poppins';font-size: 20px">返回首页</a>--%>
<%--    </form>--%>
<%--</div>--%>
<%--<script>--%>

<%--</script>--%>
</body>
</html>