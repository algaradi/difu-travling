<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>景点管理</title>
    <link rel="stylesheet" href="static/css/tablestyle.css">
    <link rel="stylesheet" href="static/css/btn.css">
    <%@ include file="head.jsp" %>
    <script type="text/javascript">

        function dodele(param1){
            alert(12);
            var flag = confirm("你确定要删除["+param1+"]？");
            if(flag == true){
                location.href="ScenicSpotServlet?action=delete&spotName="+param1;
            }else{

            }
        }
    </script>
</head>
<body>
<form action="HotelServlet?action=listBycity" method="post" style="">
    <input name="cityName" class="textarea" name="name" placeholder="输入城市">
    <input type="submit" class="button_getidcode_text" value="查询">
</form>
<table class="hovertable" id="hotel" >
    <tr>
        <th colspan="9">
            <span style="color: red; font-size: large">${msg}</span>
        </th>
    </tr>
    <tr>
        <th>景点名</th>
        <th>价格/单</th>
        <th>所在城市</th>
        <th>详细地址</th>
        <th>票数量</th>
        <th>照片路径</th>
        <th>描述</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${scenicSpots}" var="s">
        <tr οnmοuseοver="this.style.backgroundColor='#ffff66';" οnmοuseοut="this.style.backgroundColor='#d4e3e5';">
            <td>${s.spotName}</td>
            <td>${s.price}</td>
            <td>${s.cityName}</td>
            <td>${s.address}</td>
            <td>${s.ticketNum}</td>
            <td>${s.photo}</td>
            <td>${s.descSpot}</td>

            <td><a href="booking.jsp?resvKey=${s.spotName}&type=4">
                <button class="button button1">预定</button>
            </a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>