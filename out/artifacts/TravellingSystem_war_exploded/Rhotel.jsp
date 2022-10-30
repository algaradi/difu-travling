<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>酒店管理</title>
    <link rel="stylesheet" href="static/css/tablestyle.css">
    <link rel="stylesheet" href="static/css/btn.css">

    <%@ include file="head.jsp" %>
</head>
<body>
<form action="HotelServlet?action=listBycity" method="post">
    <input name="cityName" class="textarea" name="name" placeholder="输入城市名">
    <input type="submit" class="button_getidcode_text" value="查询">
</form>
<table class="hovertable" id="hotel">
    <tr>
        <th>酒店名</th>
        <th>价格</th>
        <th>房间数量</th>
        <th>所在城市</th>
        <th>详细地址</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${hotels}" var="h">
        <tr οnmοuseοver="this.style.backgroundColor='#ffff66';" οnmοuseοut="this.style.backgroundColor='#d4e3e5';">
            <td>${h.hotelName}</td>
            <td>${h.price}</td>
            <td>${h.numRooms}</td>
            <td>${h.cityName}</td>
            <td>${h.address}</td>
            <td><a href="booking.jsp?resvKey=${h.hotelName}&type=3">
                <button class="button button1">预定</button>
            </a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>