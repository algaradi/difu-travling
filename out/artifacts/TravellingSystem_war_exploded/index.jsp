<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>旅行首页</title>
<link rel="stylesheet" href="static/css/regist.css">
<link rel="stylesheet" href="static/css/btn.css">
 <%@ include file="head.jsp" %>

</head>
<body>
旅行首页

<div class="img_container">
<section>
    <div id="imgbox" ></div>
</section>
  </div>
</body>
<c:forEach items="${scenicSpots}" var="s">

<div class="card" style="float: left; margin-left:100px;">
    <img src="${s.photo}"  alt="富士山"  style="width:100%;height:80%"/>
    <div class="card_container">
     <label style="background-color: #82af3a; width: 150px; height: 150px; color: white; font-size: medium;" >
         价格：￥[${s.price}]/人
     </label>
     <label style="background-color: #82af3a; width: 150px; height: 150px; margin-left: 20px; color: white; font-size: medium;" >
            可预订票数量：[${s.ticketNum}]
     </label>
     <span>
         <label>
             <p>
                 ${s.descSpot}
             </p>
         </label>
        <a href="booking.jsp?resvKey=${s.spotName}&type=4" style="margin-left:90%">
            <button class="button button1">预定</button>
        </a>

        </span>
    </div>
</div>
</c:forEach>
<%--<script type="text/javascript">--%>


<%--    var html="";--%>
<%--    var imgdata=[--%>
<%--        {id:1,url:"static/img/pic_1.jpg"},--%>
<%--        {id:2,url:"static/img/pic_2.jpg"},--%>
<%--        {id:3,url:"static/img/pic_3.jpg"},--%>
<%--        {id:4,url:"static/img/pic_4.jpg"},--%>
<%--    ];--%>
<%--   <c:forEach items="${scenicSpots}" var="s">--%>
<%--    html+='<div class="card" style="float: left; margin-left:100px;">\n' +--%>
<%--        '    <img src="${s.photo}"  alt="富士山"  style="width:100%;height:80%"/>\n' +--%>
<%--        '    <div class="card_container">\n' +--%>
<%--        '     <span class="price" style="font-size: medium; color: green;" >\n' +--%>
<%--        '         价格：￥[${s.price}]/人\n' +--%>
<%--        '     </span>\n' +--%>
<%--        '    <p class="href_price">\n' +--%>
<%--        '        <a href="http://www.baidu.com" style="margin-left:90%">\n' +--%>
<%--        '            <h3 style="font-size: medium; color: red;">预定</h3>\n' +--%>
<%--        '        </a>\n' +--%>
<%--        '    </p>\n' +--%>
<%--        '    </div>\n' +--%>
<%--        '</div>';--%>

<%--    </c:forEach>--%>
<%--&lt;%&ndash;    document.getElementById("imgbox").innerHTML=html;&ndash;%&gt;--%>

<%--//</script>--%>

</html>