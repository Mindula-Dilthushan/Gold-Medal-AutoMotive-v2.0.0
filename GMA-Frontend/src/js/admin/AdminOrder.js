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
                let bookId = values[i].bookingId;
                let bookCarId = values[i].carId;
                let bookDriverId = values[i].driverId;
                let bookCustId = values[i].customerId;
                let bookDate = values[i].bookingDate;
                let bookNote = values[i].bookingNote;
                let bookPickDate = values[i].bookingPickDate;
                let bookReturnDate = values[i].bookingReturnDate;
                let bookStatus = values[i].bookingStatus;

                $('#tblOrderBody').append(`<tr>
                    <td>${bookId}</td>
                    <td>${bookCarId}</td>
                    <td>${bookDriverId}</td>
                    <td>${bookCustId}</td>
                    <td>${bookDate}</td>
                    <td>${bookNote}</td>
                    <td>${bookPickDate}</td>
                    <td>${bookReturnDate}</td>
                    <td>${bookStatus}</td>
                </tr>`)
            }
        }
    });
}