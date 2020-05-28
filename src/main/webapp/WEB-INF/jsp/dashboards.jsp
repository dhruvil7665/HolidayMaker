<%-- 
    Document   : dashboards
    Created on : Apr 17, 2020, 5:40:20 AM
    Author     : shahd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
window.onload = function() {
	
var dps = [[]];
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	exportEnabled: true,	
	title:{
		text: "Most Travelled Country"
	},
	data: [{
		type: "pie",    
	    yValueFormatString: "#,###\"%\"",
	    showInLegend: true,
	    indexLabel: "{y}", 
	    indexLabelPlacement: "inside",
		dataPoints: dps[0]
	}]
});
 
var yValue;
var name;
 
<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
	<c:forEach items="${dataPoints}" var="dataPoint">
		yValue = parseFloat("${dataPoint.y}");
		name = "${dataPoint1.name}";
		dps[parseInt("${loop.index}")].push({
			name : name,
			y : yValue
		});
	</c:forEach>
</c:forEach>
 
chart.render();

var dps = [[]];
var chart2 = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	exportEnabled: true,	
	title:{
		text: "Most Travelled Country"
	},
	data: [{
		type: "pie",    
	    yValueFormatString: "#,###\"%\"",
	    showInLegend: true,
	    indexLabel: "{y}", 
	    indexLabelPlacement: "inside",
		dataPoints: dps[0]
	}]
});
 
var yValue2;
var name2;
 
<c:forEach items="${dataPointsList}" var="dataPoints2" varStatus="loop">
	<c:forEach items="${dataPoints2}" var="dataPoint2">
		yValue2 = parseFloat("${dataPoint2.y}");
		name2 = "${dataPoint2.name}";
		dps[parseInt("${loop.index}")].push({
			name : name2,
			y : yValue2
		});
	</c:forEach>
</c:forEach>
 
chart2.render();

var dps = [[]];
var chart3 = new CanvasJS.Chart("chartContainer3", {
	animationEnabled: true,
	exportEnabled: true,	
	title:{
		text: "Most Travelled Country"
	},
	data: [{
		type: "pie",    
	    yValueFormatString: "#,###\"%\"",
	    showInLegend: true,
	    indexLabel: "{y}", 
	    indexLabelPlacement: "inside",
		dataPoints: dps[0]
	}]
});
 
var yValue3;
var name3;
 
<c:forEach items="${dataPointsList}" var="dataPoints3" varStatus="loop">
	<c:forEach items="${dataPoints3}" var="dataPoint3">
		yValue3 = parseFloat("${dataPoint3.y}");
		name3 = "${dataPoint3.name}";
		dps[parseInt("${loop.index}")].push({
			name : name3,
			y : yValue3
		});
	</c:forEach>
</c:forEach>
 
chart3.render();

var dps = [[]];
var chart4 = new CanvasJS.Chart("chartContainer4", {
	animationEnabled: true,
	exportEnabled: true,	
	title:{
		text: "Most Travelled Country"
	},
	data: [{
		type: "pie",    
	    yValueFormatString: "#,###\"%\"",
	    showInLegend: true,
	    indexLabel: "{y}", 
	    indexLabelPlacement: "inside",
		dataPoints: dps[0]
	}]
});
 
var yValue4;
var name4;
 
<c:forEach items="${dataPointsList}" var="dataPoints4" varStatus="loop">
	<c:forEach items="${dataPoints4}" var="dataPoint4">
		yValue4 = parseFloat("${dataPoint4.y}");
		name4 = "${dataPoint4.name}";
		dps[parseInt("${loop.index}")].push({
			name : name4,
			y : yValue4
		});
	</c:forEach>
</c:forEach>
 
chart4.render();

}

</script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 50%; float:left;"></div>
<div id="chartContainer2" style="height: 370px; width: 50%;float:left;"></div>
<div id="chartContainer3" style="height: 370px; width: 50%;float:left;"></div>
<div id="chartContainer4" style="height: 370px; width: 50%;float:left;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>  