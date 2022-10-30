<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="static/css/tablestyle.css">
    <link rel="stylesheet" href="static/css/selecetBox.css">
    <link rel="stylesheet" href="static/css/ud-btn.css">

<title>旅游订单查询</title>
    <%@ include file="head.jsp" %>
</head>
<body>



<table class="hovertable" id="reservation">
    <tr>
        <td colspan="5" align="center">
    <div class="dropdown">
        <button class="dropbtn">请选择预订类型</button>
        <div class="dropdown-content">
            <a href="JavaScript:;" onclick="location.href='ReservationServlet?action=listType&type=1'">我的航班预订</a>
            <a href="JavaScript:;" onclick="location.href='ReservationServlet?action=listType&type=2'">我的出租车预订</a>
            <a href="JavaScript:;" onclick="location.href='ReservationServlet?action=listType&type=3'">我的宾馆预订</a>
            <a href="JavaScript:;" onclick="location.href='ReservationServlet?action=listType&type=4'">我的景点预订</a>
        </div>
    </div>
        </td>
    </tr>
    <tr>
        <td colspan="5">
            <span style="color: red; font-size: medium">预定号，代表座位号，或房间号，或门票号</span>
        </td>
    </tr>
    <tr>
        <th>预定编号</th>
        <th>用户姓名</th>
        <th>预定类型</th>
        <th>预定日期</th>
        <th>预订号</th>
    </tr>
  <c:forEach items="${reservations}" var="r">
        <tr οnmοuseοver="this.style.backgroundColor='#ffff66';" οnmοuseοut="this.style.backgroundColor='#d4e3e5';">
            <td>${r.resvKey}</td>
            <td>${r.custName}</td>
            <td>${r.type}</td>
            <td>${r.resDate}</td>
            <td>${r.number}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>