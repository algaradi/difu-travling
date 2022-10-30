<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>出租车管理</title>
    <link rel="stylesheet" href="static/css/tablestyle.css">
    <link rel="stylesheet" href="static/css/btn.css">
    <%@ include file="head.jsp"%>
</head>
<body>
<form action="CarServlet?action=listBycity" method="post">
    <input name="cityName" class="textarea" name="name" placeholder="输入城市">
    <input type="submit" class="button_getidcode_text" value="查询" >
</form>
<table class="hovertable" id="car">
    <tr>
        <th>车牌号</th>
        <th>出租价格</th>
        <th>所在城市</th>
        <th>车主</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr οnmοuseοver="this.style.backgroundColor='#ffff66';" οnmοuseοut="this.style.backgroundColor='#d4e3e5';">
            <td>${car.carNum}</td>
            <td>${car.price}</td>
            <td>${car.cityName}</td>
            <td>${car.driver}</td>

            <td><a href="booking.jsp?resvKey=${car.carNum}&type=2">
                <button class="button button1">预定</button>
            </a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>