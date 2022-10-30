$(document).ready(function(){
	$("flight_form").hide();	
	  $('#starttime').mouseleave(function(){
	    	var starttime=$('#starttime').val();
	    	starttime = starttime.replace("T", " ");
	    	console.log("时间为："+starttime);
	    });
	    $("#submit").click(()=>{
	    	var selection=$("#choice option:selected").text(); //获取选中记录的text
			var resDate=$(".resDate").val();
			resDate=resDate.replace("T"," ");
			alert("您选中了："+selection+"          您预定的时间为："+resDate);
	    })
});
