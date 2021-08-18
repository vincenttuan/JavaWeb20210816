<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet"
		href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
	
	<title>Food Chart</title>
	
	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>
	
	<script type="text/javascript">
	
		google.charts.load('current', {
			'packages' : [ 'corechart' ]
		});
		google.charts.setOnLoadCallback(drawChart);
	
		function drawChart() {
	
			var data = google.visualization.arrayToDataTable([
					[ 'Task', 'Hours per Day' ], [ 'Work', 11 ], [ 'Eat', 2 ],
					[ 'Commute', 2 ], [ 'Watch TV', 2 ], [ 'Sleep', 7 ] ]);
	
			var options = {
				title : 'My Daily Activities'
			};
	
			var chart = new google.visualization.PieChart(document
					.getElementById('piechart'));
	
			chart.draw(data, options);
		}
		
	</script>
</head>
<body style="padding: 15px">
	<div id="piechart" style="width: 900px; height: 500px;"></div>
	${ foods }
</body>
</html>