<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="static/css/tablestyle.css">
    <link rel="stylesheet" href="static/css/regist.css">
    <link rel="stylesheet" href="static/css/btn.css">
    <script src="static/js/jquery-3.3.1.min.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>航班信息管理</title>
    <%@ include file="head.jsp" %>
</head>
<body>

<form action="FlightServlet" method="post" style="margin-left: 300px">
    <input type="hidden" name="action" value="listWithDP">

        <span id="date_text1" style="font-size: large; color: #2e6da4">出发时间</span>
        <input type="date"  name="fromDate" onmouseout placeholder="请选择日期">
        <input  class="textarea" name="fromCity"  placeholder="出发城市">
        <span style="font-size: large; color: #2e6da4">预计到达时间</span>
        <input type="date"  name="arivDate" placeholder="请选择日期">

        <input  class="textarea" name="arivCity" placeholder="到达城市">
        <input type="submit" class="button_getidcode_text" value="查询">

</form>



<script>


    // $('.starttime').mouseleave(function(){
    //     var starttime=$('.starttime').val();
    //     starttime = starttime.replace("T", " ");
    //     alert("时间为："+starttime);
    // });
    // $('.starttime').mouseleave(function(){
    //     var starttime=$('.starttime').val();
    //     starttime = starttime.replace("T", " ");
    //
    //     alert("时间为："+starttime);
    // })
</script>
<table class="hovertable" id="flight">
    <tr>
        <th colspan="8">
            <span style="color: red; font-size: large">${msg}</span>
        </th>
    </tr>
    <tr>
        <th>航班号</th>
        <th>价格</th>
        <th>座位数</th>
        <th>出发地点</th>
        <th>出发时间</th>
        <th>目的地点</th>
        <th>到达时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${flights}" var="f">
        <tr οnmοuseοver="this.style.backgroundColor='#ffff66';" οnmοuseοut="this.style.backgroundColor='#d4e3e5';">
            <td>${f.flightNum}</td>
            <td>${f.price}</td>
            <td>${f.numSeats}</td>
            <td>${f.fromCity}</td>
            <td>${f.fromDate}</td>
            <td>${f.arivCity}</td>
            <td>${f.arivDate}</td>
            <td><a href="booking.jsp?resvKey=${f.flightNum}&type=1">
                <button class="button button1">预定</button>
            </a></td>
        </tr>

    </c:forEach>

</table>

</body>
</html>