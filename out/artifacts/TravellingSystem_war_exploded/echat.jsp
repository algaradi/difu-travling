<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
		<title></title>
		<script src="static/js/echarts.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			
			 
			 function val(){
				var arr =  [120,200,150,80,70,110,130];
				 return arr;
			 }
			 
			 function btn(){
			 	document.getElementById("map2").style.display="";
			  }
			 
			 
		</script>
	</head>
	<body>
		
	

		
<%--		<input type="button"  onclick="btn()" value="显示"/>--%>
		<div id="map2" style="width: 800px; height: 800px; ">
			
		</div>
		
		
		
		
		
		<script type="text/javascript">
		
		var keys = new Array;
		var vals = new Array;
		
		<c:forEach items="${hash}" var="h">
		   	   var val  =  ${h.value};
		   	   var key = '${h.key }';
		   	vals.push(val);
		   	keys.push(key);
		</c:forEach>
		
		
			var chartDom = document.getElementById('map2');
			var myChart = echarts.init(chartDom);
			var option;
			
			
			   
			option = {
			  xAxis: {
			    type: 'category',
			    data: keys 
			    	<!-- ['c1', 'c2', 'c3', 'c4', 'c5']  -->
			  },
			  yAxis: {
			    type: 'value'
			  },
			  series: [
			    {
			      data: vals,
			      type: 'bar',
					animationDuration: 2800,
					animationEasing: "cubicInOut",
			    }
			  ]
			};
			
			option && myChart.setOption(option);

		</script>
	</body>
</html>