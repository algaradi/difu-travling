<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>酒店管理</title> 
    <link rel="stylesheet" href="static/css/tablestyle.css">
    <link rel="stylesheet" href="static/css/ud-btn.css">
     <%@ include file="head.jsp" %>
    <script type="text/javascript">

        function dodele(param1){
            alert(12);
            var flag = confirm("你确定要删除["+param1+"]？");
            if(flag == true){
                location.href="HotelServlet?action=delete&hotelName="+param1;
            }else{

            }
        }
    </script>
</head>
<body>
<form action="HotelServlet?action=listBycity" method="post">
 <input name="cityName" class="textarea" name="name" placeholder="输入城市">
        <input type="submit" class="button_getidcode_text" value="查询">
</form>
<table class="hovertable" id="hotel">
    <tr>
        <th colspan="6">
            <span style="color: red; font-size: large">${msg}</span>
        </th>
        <th>
            <a href="addHotel.jsp">
                <button class="button button3"  >添加</button>
            </a>
        </th>
    </tr>

    <tr>
        <th>酒店名</th>
        <th>价格</th>
        <th>房间数量</th>
        <th>所在城市</th>
        <th>详细地址</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${hotels}" var="h">
        <tr οnmοuseοver="this.style.backgroundColor='#ffff66';" οnmοuseοut="this.style.backgroundColor='#d4e3e5';">
           <td>${h.hotelName}</td>
           <td>${h.price}</td>
           <td>${h.numRooms}</td>
           <td>${h.cityName}</td>
           <td>${h.address}</td>
            <td><a href="hotel_modify.jsp?hotelName=${h.hotelName}&price=${h.price}&numRooms=${h.numRooms}&cityName=${h.cityName}&address=${h.address}">
                <button class="button button1">编辑</button>
            </a></td>
            <td>
                <a href="JavaScript:;">
                    <button class="button button3"  onclick="dodele('${h.hotelName}')" >删除</button>
                </a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>