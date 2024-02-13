window.onload = function() {
    //AJAX요청
    $.ajax({
        type: "Post",
        url: "QueryServletTotal",
        data: {name: name},
        success: function(response) {
            /* 서버에서 받은 응답 처리 */
            console.log(response)
            createTable(response)
        }
    })
}

function createTable(data) {
    let table = "<table border='1'>"
    table += "<tr><th>Category</th><th>Product</th><th>Gender</th><th>Color</th><th>Qty</th><th>Price</th><th>Method</th><th>Date</th></tr>"
    //데이터 행 추가
    for (let i = 0; i < data.length; i++) {
        table += "<tr>" +
             "<td style='width: 10%; height: 2%'>"+ (data[i].proCategory ? data[i].proCategory : '') + "</td>" +
             "<td style='width: 18%'>" + (data[i].proName ? data[i].proName : '') + "</td>" +
             "<td style='width: 18%'>" + (data[i].proGender ? data[i].proGender : '') + "</td>" +
            "<td style='width: 7%'>"+ (data[i].proColor ? data[i].proColor : '') + "</td>" +
            "<td style='width: 7%'>" + (data[i].pQty ? data[i].pQty : '') + "</td>" +
            "<td style='width: 7%'>" + (data[i].pPrice ? data[i].pPrice : '') + "</td>" +
            "<td style='width: 7%'>"+ (data[i].pMethod ? data[i].pMethod : '') + "</td>" +
             "<td style='width: 7%'>"+ (data[i].pDate ? data[i].pDate : '') + "</td>" +
            "</tr>";
    }
    table += "</table>"
     $("#result").html(table); //result 는 index에 있는 div id="result"
   	 $("#result").css("width", "100%");
   	  $(".activeHeader").css("width", "50%"); 
}

$(document).ready(function() {
    /* 버튼 클릭시 AJAX 요청 */
    $("#queryButton").click(function() {
        /* 입력된 데이터 가져오기 */
        let name = $("#name").val();
         var selectedDate = $("#datepicker").val();
        /* AJAX 요청 */
        $.ajax({
            type: "POST",
            url: "QueryServletTotal",
            data: {name: name, selectedDate: selectedDate},
            success: function(response) {
                /* 서버에서 받은 응답 처리 */
                //$("#result").html(response)
                createTable(response)
            }
        })
    })
})

$("#name").addClass("dataInput");
