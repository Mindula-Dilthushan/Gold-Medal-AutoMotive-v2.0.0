$('#btnOrdersRefresh').click(function () {
    loadAllOrders();
});

function loadAllOrders() {
    $('#tblOrderBody').empty();
    $.ajax({
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/booking',
        method: 'GET',
        async: false,
        dataType: 'json',
        success: function (res) {
            let values = res.data;
            for (i in values) {
                let id = values[i].bookingId;
                let date = values[i].bookingDate;
                let note = values[i].bookingNote;
                let pickdate = values[i].bookingPickDate;
                let returndate = values[i].bookingReturnDate;
                let status = values[i].bookingStatus;
                let car = values[i].carId;
                let customer = values[i].customerId;
                let driver = values[i].driverId;


                $('#tblOrderBody').append(`<tr><td>${id}</td>
<td>${car}</td>
<td>${customer}</td>
<td>${driver}</td>
<td>${date}</td>
<td>${note}</td>
<td>${pickdate}</td>
<td>${returndate}</td>
<td>${status}</td>

</tr>`)
            }
        }
    });

}