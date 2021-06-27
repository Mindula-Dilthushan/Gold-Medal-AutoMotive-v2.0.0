//Start Customer Validation Section
function checkValidationCustomerProfile() {

    let cId = $('#custId').val();
    let cName = $('#custName').val();
    let cAdd = $('#custAddress').val();
    let cEmail = $('#custEmail').val();
    let cNic = $('#custNic').val();
    let cDl = $('#custDl').val();
    let cContact = $('#custContact').val();
    let cPassword = $('#custPassword').val();

    if (cId != "") {
        if (cName != "") {
            if (cAdd != "") {
                if (cEmail != "") {
                    if (cNic != "") {
                        if (cDl != "") {
                            if (cContact != "") {
                                if (cPassword) {
                                    return true;
                                } else {
                                    $('#custPassword').css({
                                        'border': '2px #FF0000FF solid'
                                    });
                                    $('#custPassword').focus();
                                    alert("Please Enter Password");
                                    return false;
                                }
                            } else {
                                $('#custContact').css({
                                    'border': '2px #FF0000FF solid'
                                });
                                $('#custContact').focus();
                                alert("Please Enter Contact");
                                return false;
                            }
                        } else {
                            $('#custDl').css({
                                'border': '2px #FF0000FF solid'
                            });
                            $('#custDl').focus();
                            alert("Please Enter Driver License");
                            return false;
                        }
                    } else {
                        $('#custNic').css({
                            'border': '2px #FF0000FF solid'
                        });
                        $('#custNic').focus();
                        alert("Please Enter Nic");
                        return false;
                    }
                } else {
                    $('#custEmail').css({
                        'border': '2px #FF0000FF solid'
                    });
                    $('#custEmail').focus();
                    alert("Please Enter Email");
                    return false;
                }
            } else {
                $('#custAddress').css({
                    'border': '2px #FF0000FF solid'
                });
                $('#custAddress').focus();
                alert("Please Enter Address");
                return false;
            }
        } else {
            $('#custName').css({
                'border': '2px #FF0000FF solid'
            });
            $('#custName').focus();
            alert("Please Enter Name");
            return false;
        }
    } else {
        $('#custId').css({
            'border': '2px #FF0000FF solid'
        });
        $('#custId').focus();
        alert("Please Enter Id");
        return false;
    }
}

//End Customer Validation Section

//Start Customer Save Section
$('#btnCustSave').click(() => {

    if (checkValidationCustomerProfile()) {
        let cId = $('#custId').val();
        let cName = $('#custName').val();
        let cAdd = $('#custAddress').val();
        let cEmail = $('#custEmail').val();
        let cNic = $('#custNic').val();
        let cDl = $('#custDl').val();
        let cContact = $('#custContact').val();
        let cPassword = $('#custPassword').val();

        $.ajax({
            method: "POST",
            url: "http://localhost:8080/GMA/v2/customer",
            data: JSON.stringify({
                "customerId": cId,
                "customerName": cName,
                "customerAddress": cAdd,
                "customerEmail": cEmail,
                "customerNIC": cNic,
                "customerDrivingLIC": cDl,
                "customerContact": cContact,
                "customerPassword": cPassword
            }),
            dataType: 'Json',
            contentType: "application/json; charset=utf-8",
            success: function (res) {
                if (res.message == 'Success') {
                }
            },
            error: function (ob, textStatus, error) {
            }
        });
    }
});
//End Customer Save Section

//Start Customer get all car Section
$('#btnCarsRefresh').click(function () {
    loadAllCars();
});

function loadAllCars() {
    $('#tblCarBody').empty();
    $.ajax({
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/car',
        method: 'GET',
        async: false,
        dataType: 'json',
        success: function (res) {
            let values = res.data;
            for (i in values) {
                let adminCarId = values[i].carId;
                let adminCarBrand = values[i].carBrand;
                let adminCarPass = values[i].carNmbOfPassengers;
                let adminCarTran = values[i].carTransmissionType;
                let adminCarType = values[i].carType;
                let adminCarColor = values[i].carColour;
                let adminCarFuel = values[i].carFuelType;

                $('#tblCarBody').append(`<tr>
                                            <td>${adminCarId}</td>
                                            <td>${adminCarBrand}</td>
                                            <td>${adminCarPass}</td>
                                            <td>${adminCarTran}</td>
                                            <td>${adminCarType}</td>
                                            <td>${adminCarColor}</td>
                                            <td>${adminCarFuel}</td>
                                       
                                            </tr>`)
            }
        }
    });
}

//End Customer get all car Section

//Start Customer PlaceOrder Section
$('#btnPlaceOrder').click(function () {

    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0');
    var yyyy = today.getFullYear();
    today = mm + '-' + dd + '-' + yyyy;

    let pickupDate = $('#pickUpDate').val();
    let returnDate = $('#returnDate').val();
    let cusID = "C001";
    let driverId = "D001";
    let carid = "CR001";
    let bookingId = "B001";
    let customer;
    let car;
    let driver;

    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/customer/' + cusID,
        async: false,
        success: function (res) {
            customer = res.data;
        }
    });

    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/car/' + carid,
        async: false,
        success: function (res) {
            car = res.data;
        }
    });

    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/driver/' + driverId,
        async: false,
        success: function (res) {
            driver = res.data;
        }
    });

    console.log(customer);
    console.log(car);
    console.log(driver);

    $.ajax({
        method: 'POST',
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/booking',
        data: JSON.stringify({
            "bookingId": bookingId,
            "bookingDate": today,
            "bookingPickDate": pickupDate,
            "bookingStatus": "Ordered",
            "bookingNote": "normal",
            "bookingReturnDate": returnDate,
            "customerId": cusID,
            "carId": carid,
            "driverId": driverId
        }),
        async: false,
        dataType: 'Json',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            if (res.message == 'Success') {
                alert('Booking successFul..!');
                $("#tblOrderBody").empty();
                clearOrderPage();
                getBookingID();
            }
        }
    });
});
//End Customer PlaceOrder Section

function clearOrderPage(){
    $('#driver').val("");
    $('#pickUpDate').val("");
    $('#returnDate').val("");
    $('#carType').val("");
    $('#carid').val("");

}















$('#btnCustProfile').click(function () {
    $('#custProfilePage').css({
        'display': 'block'
    });
    $('#customer_Car_Page').css({
        'display': 'none'
    });
    $('#custOrderPage').css({
        'display': 'none'
    });
    $('#customer_Pay_Page').css({
        'display': 'none'
    });
});
$('#btnCustCars').click(function () {
    $('#custProfilePage').css({
        'display': 'none'
    });
    $('#customer_Car_Page').css({
        'display': 'block'
    });
    $('#custOrderPage').css({
        'display': 'none'
    });
    $('#customer_Pay_Page').css({
        'display': 'none'
    });
});
$('#btnCustOrders').click(function () {
    $('#custProfilePage').css({
        'display': 'none'
    });
    $('#customer_Car_Page').css({
        'display': 'none'
    });
    $('#custOrderPage').css({
        'display': 'block'
    });
    $('#customer_Pay_Page').css({
        'display': 'none'
    });
    getBookingID();
});
$('#btnCustPay').click(function () {
    $('#custProfilePage').css({
        'display': 'none'
    });
    $('#customer_Car_Page').css({
        'display': 'none'
    });
    $('#custOrderPage').css({
        'display': 'none'
    });
    $('#customer_Pay_Page').css({
        'display': 'block'
    });
});
//Start Search Customer Section
function searchCustomerProfile() {
    // $("#tblCustomerBody").empty();
    let id = $("#custId").val();
    if (id != "") {
        $.ajax({
            method: "get",
            url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/customer/' + id,
            async: true,
            dataType: 'json',
            success: function (response) {
                var data = response.data;

                $('#custId').val(data.customerId);
                $('#custName').val(data.customerName);
                $('#custAddress').val(data.customerAddress);
                $('#custEmail').val(data.customerEmail);
                $('#custNic').val(data.customerNIC);
                $('#custDl').val(data.customerDrivingLIC);
                $('#custContact').val(data.customerContact);
                $('#custPassword').val(data.customerPassword);
            }
        });
    } else {
    }
}
//End Search Customer Section
//Start Customer Update
$('#btnAdminCustomerUpdate').click(() => {
    updateCustomer();
});
function updateCustomer() {
    if (checkValidationAdminCustomer()) {
        let custId = $('#custId').val();
        let custName = $('#custName').val();
        let custAdd = $('#custAddress').val();
        let custEmail = $('#custEmail').val();
        let custNic = $('#custNic').val();
        let custDl = $('#custDl').val();
        let custContact = $('#custContact').val();
        let custPassword = $('#custPassword').val();

        $.ajax({
            method: "put",
            url: "http://localhost:8080/GMA_Backend_war_exploded/v2/customer",
            contentType: "application/json",
            async: false,
            data: JSON.stringify(
                {
                    "customerId": custId,
                    "customerName": custName,
                    "customerAddress": custAdd,
                    "customerEmail": custEmail,
                    "customerNIC": custNic,
                    "customerDrivingLIC": custDl,
                    "customerContact": custContact
                    // "password":custPassword
                }
            ),
            success: function (data) {
                return true;
            }
        });
    }
}
//End Customer Update
function searchCustomerCar() {
    let bookingId = $('#custBookingID').val();
    let id = $("#carid").val();
    if (id != "") {
        $.ajax({
            method: "GET",
            url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/car/' + id,
            async: true,
            dataType: 'json',
            success: function (response) {
                var data = response.data;

                $('#carid').val(data.carId);
                $('#carType').val(data.carType);
                $('#carPrice').val(data.car)
                $('#tblOrderBody').append(`<tr>
                                      
                                  <td>${bookingId}</td>
                                  <td>${data.carBrand}</td>
                                  <td>${data.carNmbOfPassengers}</td>
                                  <td>${data.carTransmissionType}</td>
                                  <td>${data.carType}</td>
                                  <td>${data.carColour}</td>
                                  <td>${data.carFuelType}</td>
                               
                                     </tr>`)

                let getPickDate = $('#pickUpDate').val();
                let getReturn = $('#returnDate').val();


                let tot = $('carPrice').val();
                let time = getReturn - getPickDate;
                let price = tot * time;
                console.log(price);
            }
        });
    } else {
    }
}
// function total(){
//
// }


function getBookingID() {
    $.ajax({
        method: "get",
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/booking/getBookingLastID',
        async: false,
        success: function (response) {
            var data = response.data;
            console.log("data" + data);
            $('#custBookingID').val(data)
            console.log($('#custBookingID').val());
        }

    });
}

