<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022-1-11 , 0011
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


    <script>
        window.onload = function () {

            if(location.href == "ScenicSpotServlet?action=list"){
                location.herf = "";
            }else{
                location.href ="ScenicSpotServlet?action=list";
                location.herf = "";
            }



        }
    </script>
</head>
<body>

</body>
</html>
