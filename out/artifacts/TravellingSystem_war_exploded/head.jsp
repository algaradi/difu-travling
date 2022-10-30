<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部导航栏的封装</title>
  <link rel="stylesheet" href="static/css/regist.css">
   <script  src="static/js/function.js"></script>
</head>
<body>

<div class="header">
    <a href="index.html" class="logo">
    </a>
    <a href="index.html" class="mark" title="备注"></a>
    <%--如果用户还没有登录，显示     【登录 和注册的菜单】 --%>
    <c:if test="${empty sessionScope.cust}">
    <nav class="navbar">

        <ul>
            <li> <a href="login.jsp">登录</a></li>
            <li>   &nbsp;&nbsp;|&nbsp;&nbsp;</li>
            <li> <a href="regist.jsp">注册</a> </li>
        </ul>

     </nav>
    </c:if>

        <%--如果已经登录，则显示 登录 成功之后的用户信息。--%>
        <c:if test="${ !empty sessionScope.cust}">


            <nav class="navbar">


                <ul>
                    <li>
                        <span style="font-size: large; color: #3F3D56">欢迎光临贵客:<span style="color: #2c3064; font-size: large;">${sessionScope.cust.custName}</span></span>
                    </li>
                    <li><a href="index1.jsp">首页</a></li>

            <%--如果已经登录，则显示 登录 成功之后的用户信息。--%>
            <c:if test="${sessionScope.cust.type eq 1}">
                    <li><a href="">后台人员管理</a>
                        <ul class="hide">
                            <li><a href="customerServlet?action=list">用户管理</a></li>
                            <li><a href="HotelServlet?action=list">旅馆管理</a></li>
                            <li><a href="CarServlet?action=list">出租车管理</a></li>
                            <li><a href="FlightServlet?action=list">航班管理</a></li>
                            <li><a  href="ScenicSpotServlet?action=listManage">景点管理</a></li>
                        </ul>
                    </li>

            </c:if>
                    <li><a href="#">旅行守护</a>
                        <ul class="hide">
                            <li><a href="HotelServlet?action=rlist">旅馆预定</a></li>
                            <li><a href="CarServlet?action=rlist">出租车服务</a></li>
                            <li><a href="FlightServlet?action=rlist">航班预定</a></li>
                            <li><a href="ScenicSpotServlet?action=rlist">景点预定</a></li>
                            <li><a href="ScenicSpotServlet?action=getEchart">城市景点排名</a></li>
                        </ul>
                    </li>
                    <li><a href="#">个人信息</a>
                        <ul class="hide">
                            <li><a href="Mycustomer_modify.jsp">信息修改</a></li>
                            <li><a href="ReservationServlet?action=mylist">我的订单</a></li>
                            <li><a href="login.jsp">退出登录</a></li>
                        </ul>
                    </li>

                </ul>


            </nav>

        </c:if>
</div>







</body>
</html>
