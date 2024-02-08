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
</head>
<body>
<div>
    <canvas id="myChart"></canvas>
</div>
<%
    ArrayList<String> labels = (ArrayList<String>) session.getAttribute("labels");
    ArrayList<Integer> data = (ArrayList<Integer>) session.getAttribute("data");
  
%>
<script>
    const labels = JSON.parse('<%= new Gson().toJson(labels) %>');
    const data = JSON.parse('<%= new Gson().toJson(data) %>');

    // 차트 생성
    const ctx = document.getElementById('myChart');
    const chart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels, // 과목명으로 labels 설정
            datasets: [{
                label: '일자별 가입자 수',
                data: data, // 점수로 data 설정
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true, // y축 기준값을 0으로 설정
                    stepSize: 5 // y축 간격을 5로 설정
                    
                }
            }
        }
    });
    </script>
</body>
</html>