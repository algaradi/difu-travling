<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息管理</title>
 <%@ include file="head.jsp" %>
</head>
    <link rel="stylesheet" href="static/css/tablestyle.css">
    <link rel="stylesheet" href="static/css/ud-btn.css">
<script type="text/javascript">

    function dodele(param1){
        var flag = confirm("你确定要删除["+param1+"]？");
        if(flag == true){
            location.href="customerServlet?action=delete&custName="+param1;
        }else{

        }
    }
</script>
</head>
<body>
<form action="customerServlet?action=listCN" method="post">

 <input name="custName" class="textarea" name="name" placeholder="输入用户名">
        <input type="submit" class="button_getidcode_text" value="查询">
</form>
<table class="hovertable" id="customer" >
    <tr>
        <th colspan="5">
            <span style="color: red; font-size: large">${msg}</span>
        </th>
        <th>
            <a href="addCutomer.jsp">
                <button class="button button3"  >添加</button>
            </a>
        </th>
    </tr>

    <tr>
        <th>用户姓名</th>
        <th>密码</th>
        <th>用户类型</th>
        <th>联系方式</th>
        <!--        <th>联系方式</th>-->
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${customers}" var="c">
        <tr>
            <td>${c.custName}</td>
            <td>${c.password}</td>
            <td>${c.type}</td>
            <td>${c.custPhone}</td>
            <!--        <th>联系方式</th>-->
            <td><a href="customer_modify.jsp?custName=${c.custName}&password=${c.password}&type=${c.type}&custPhone=${c.custPhone}">
                <button class="button button1">编辑</button>
            </a></td>
            <td>
                <a href="JavaScript:;">
                    <button class="button button3"  onclick="dodele('${c.custName}')" >删除</button>
                </a>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>