<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>出租车管理</title>
    <link rel="stylesheet" href="static/css/tablestyle.css">
    <link rel="stylesheet" href="static/css/ud-btn.css">
    <%@ include file="head.jsp"%>
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
<form action="CarServlet?action=listBycity" method="post">
 <input name="cityName" class="textarea" name="name" placeholder="输入城市">
        <input type="submit" class="button_getidcode_text" value="查询" >
</form>
<table class="hovertable" id="car">
    <tr>
        <th colspan="5">
            <span style="color: red; font-size: large">${msg}</span>
        </th>
        <th>
            <a href="addCar.jsp">
                <button class="button button3"  >添加</button>
            </a>
        </th>
    </tr>
    <tr>
        <th>车牌号</th>
        <th>出租价格</th>
        <th>所在城市</th>
        <th>车主</th>
<!--        <th>联系方式</th>-->
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr οnmοuseοver="this.style.backgroundColor='#ffff66';" οnmοuseοut="this.style.backgroundColor='#d4e3e5';">
            <td>${car.carNum}</td>
            <td>${car.price}</td>
            <td>${car.cityName}</td>
            <td>${car.driver}</td>
            <td><a href="car_modify.jsp?carNum=${car.carNum}&price=${car.price}&cityName=${car.cityName}&driver=${car.driver}">
                <button class="button button1">编辑</button>
            </a></td>
            <td>
                <a href="JavaScript:;">
                <button class="button button3"  onclick="dodele('${car.carNum}')" >删除</button>
                </a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>