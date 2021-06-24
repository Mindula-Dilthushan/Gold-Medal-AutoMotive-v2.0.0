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