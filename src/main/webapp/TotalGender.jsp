<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
body, html {
    height: 100%;
    margin: 0;
    padding: 0;
}

.chart-container {
    width: 100%;
    height: 80vh; /* 차트 컨테이너의 높이 설정 */
}

.canvas-container {
    width: 100%;
    height: 100%;
}

canvas {
    width: 100%;
    height: 100%;
}
</style>
</head>
<body>
<div class="chart-container">
    <div class="canvas-container">
        <canvas id="myChart"></canvas>
    </div>
</div>

<%
    ArrayList<String> labels1 = (ArrayList<String>) session.getAttribute("labels1");
    ArrayList<Integer> data1 = (ArrayList<Integer>) session.getAttribute("data1"); 
  
%>

 <script>
        const labels = <%= new Gson().toJson(labels1) %>;
        const data = <%= new Gson().toJson(data1) %>;

        const ctx = document.getElementById('myChart').getContext('2d');
        const myChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Price by Gender',
                    data: data,
                    backgroundColor: [
                        'rgba(54, 162, 235, 0.5)',
                        'rgba(255, 99, 132, 0.5)'
                    ],
                    borderColor: [
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 99, 132, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Price by Gender'
                    }
                }
            }
        });
    </script>
</body>
</html>