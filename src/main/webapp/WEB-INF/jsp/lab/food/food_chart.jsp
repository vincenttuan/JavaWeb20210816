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
			'packages' : [ 'corechart', 'table' ]
		});
		google.charts.setOnLoadCallback(drawChart);
	
		function drawChart() {
	
			var data = google.visualization.arrayToDataTable([
						[ 'name', 'asset' ], 
						<c:forEach var="food" items="${ foods }">					
							[ '${ food.name }', ${ food.price * food.amount } ],
						</c:forEach>
					]);
			
			var data2 = google.visualization.arrayToDataTable([
						[ 'name', 'amount' ], 
						<c:forEach var="food" items="${ foods }">					
							[ '${ food.name }', ${ food.amount } ],
						</c:forEach>
					]);
			var data3 = google.visualization.arrayToDataTable([
						[ 'name', 'price' ], 
						<c:forEach var="food" items="${ foods }">					
							[ '${ food.name }', ${ food.price } ],
						</c:forEach>
					]);
			
			var data4 = new google.visualization.DataTable();
				data4.addColumn('number', 'Id');
	        	data4.addColumn('string', 'Name');
		        data4.addColumn('number', 'Price');
		        data4.addColumn('number', 'Amount');
		        data4.addColumn('number', 'Subtotal');
		        data4.addRows([
		        	<c:forEach var="food" items="${ foods }">	
		          		[ 
		          			${ food.id }, 
		          			'${ food.name }',  
		          			{v: ${ food.price }, f: '$${ food.price }'}, 
		          			${ food.amount }, 
		          			{v: ${ food.price*food.amount }, f: '$${ food.price*food.amount }'}
		          		],
		          	</c:forEach>
		        ]);
	
			var options = {
				title : 'Food Asset',
				is3D : true
			};
			
			var options2 = {
				title : 'Food Amount'
			};
			
			var options3 = {
				title : 'Food Price'
			};
			
			var options4 = {
				showRowNumber: true, 
				width: '100%', 
				height: '100%'
			};
			
			// PieChart, BarChart, ColumnChart, LineChart
			var chart = new google.visualization.PieChart(document
					.getElementById('piechart'));
			var chart2 = new google.visualization.ColumnChart(document
					.getElementById('columnchart'));
			var chart3 = new google.visualization.LineChart(document
					.getElementById('linechart'));
			var chart4 = new google.visualization.Table(document.getElementById('table_div'));
	        
			chart.draw(data, options);
			chart2.draw(data2, options2);
			chart3.draw(data3, options3);
			chart4.draw(data4, options4);
		}
		
	</script>
</head>
<body style="padding: 15px">
	<div id="piechart" style="width: 900px; height: 500px;"></div>
	<div id="columnchart" style="width: 900px; height: 500px;"></div>
	<div id="linechart" style="width: 900px; height: 500px;"></div>
	<div id="table_div" style="width: 900px; height: 200px;"></div>
	<p />
	庫存數量:
	<table class="pure-table pure-table-bordered">
		<thead>
			<tr>
				<th>id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="food" items="${ foods }" >
				<tr>
					<td>${ food.id }</td>
					<td>${ food.name }</td>
					<td>${ food.price }</td>
					<td>${ food.amount }</td>
				</tr>
				</c:forEach>
		</tbody>
	</table>
</body>
</html>