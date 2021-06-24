//Start Admin Car Validation Section
function checkValidationAdminCar() {

    let adminCarId = $('#adCarId').val();
    let adminCarBrand = $('#adCarBrand').val();
    let adminCarColor = $('#adCarColor').val();
    let adminCarType = $('#adCarType').val();
    let adminCarPass = $('#adCarPassengers').val();
    let adminCarTran = $('#adCarTransmission').val();
    let adminCarFuel = $('#adCarFuel').val();
    let adminCarExKm = $('#adCarExtraKm').val();
    let adminCarReg = $('#adCarRegistration').val();
    let adminCarDam = $('#adCarDamage').val();
    let adminCarDRate = $('#adCarDailyRate').val();
    let adminCarMRate = $('#adCarMonthlyRate').val();
    let adminCarMPrice = $('#adCarMillagePrice').val();
    let adminCarDuration = $('#adCarDuration').val();

    if (adminCarId != "") {
        if (adminCarBrand != "") {
            if (adminCarColor != "") {
                if (adminCarType != "") {
                    if (adminCarPass != "") {
                        if (adminCarTran != "") {
                            if (adminCarFuel != "") {
                                if (adminCarExKm != "") {
                                    if (adminCarReg != "") {
                                        if (adminCarDam != "") {
                                            if (adminCarDRate != "") {
                                                if (adminCarMRate != "") {
                                                    if (adminCarMPrice != "") {
                                                        if (adminCarDuration) {
                                                            return true;
                                                        } else {
                                                            $('#adCarDuration').css({
                                                                'border': '2px #FF0000FF solid'
                                                            });
                                                            $('#adCarDuration').focus();
                                                            alert("Please Enter Car Duration");
                                                            return false;
                                                        }
                                                    } else {
                                                        $('#adCarMillagePrice').css({
                                                            'border': '2px #FF0000FF solid'
                                                        });
                                                        $('#adCarMillagePrice').focus();
                                                        alert("Please Enter Car M Price");
                                                        return false;
                                                    }
                                                } else {
                                                    $('#adCarMonthlyRate').css({
                                                        'border': '2px #FF0000FF solid'
                                                    });
                                                    $('#adCarMonthlyRate').focus();
                                                    alert("Please Enter adminCarMRate");
                                                    return false;
                                                }
                                            } else {
                                                $('#adCarDailyRate').css({
                                                    'border': '2px #FF0000FF solid'
                                                });
                                                $('#adCarDailyRate').focus();
                                                alert("Please Enter adminCarDRate");
                                                return false;
                                            }
                                        } else {
                                            $('#adCarDamage').css({
                                                'border': '2px #FF0000FF solid'
                                            });
                                            $('#adCarDamage').focus();
                                            alert("Please Enter adminCarDam");
                                            return false;
                                        }
                                    } else {
                                        $('#adCarRegistration').css({
                                            'border': '2px #FF0000FF solid'
                                        });
                                        $('#adCarRegistration').focus();
                                        alert("Please Enter adminCarReg");
                                        return false;
                                    }
                                } else {
                                    $('#adCarExtraKm').css({
                                        'border': '2px #FF0000FF solid'
                                    });
                                    $('#adCarExtraKm').focus();
                                    alert("Please Enter Driver adminCarExKm");
                                    return false;
                                }
                            } else {
                                $('#adCarFuel').css({
                                    'border': '2px #FF0000FF solid'
                                });
                                $('#adCarFuel').focus();
                                alert("Please Enter adminCarFuel");
                                return false;
                            }
                        } else {
                            $('#adCarTransmission').css({
                                'border': '2px #FF0000FF solid'
                            });
                            $('#adCarTransmission').focus();
                            alert("Please Enter adminCarTran");
                            return false;
                        }
                    } else {
                        $('#adCarPassengers').css({
                            'border': '2px #FF0000FF solid'
                        });
                        $('#adCarPassengers').focus();
                        alert("Please Enter adminCarPass");
                        return false;
                    }
                } else {
                    $('#adCarType').css({
                        'border': '2px #FF0000FF solid'
                    });
                    $('#adCarType').focus();
                    alert("Please Enter adminCarType");
                    return false;
                }
            } else {
                $('#adCarColor').css({
                    'border': '2px #FF0000FF solid'
                });
                $('#adCarColor').focus();
                alert("Please Enter adminCarColor");
                return false;
            }
        } else {
            $('#adCarBrand').css({
                'border': '2px #FF0000FF solid'
            });
            $('#adCarBrand').focus();
            alert("Please Enter adminCarBrand");
            return false;
        }
    } else {
        $('#adCarId').css({
            'border': '2px #FF0000FF solid'
        });
        $('#adCarId').focus();
        alert("Please Enter adminCarId");
        return false;
    }
}

//End Admin Car Validation Section


//Start Admin Car Save Section
$('#btnAdminCarSave').click(() => {

    if (checkValidationAdminCar()) {
        let adminCarId = $('#adCarId').val();
        let adminCarBrand = $('#adCarBrand').val();
        let adminCarColor = $('#adCarColor').val();
        let adminCarType = $('#adCarType').val();
        let adminCarPass = $('#adCarPassengers').val();
        let adminCarTran = $('#adCarTransmission').val();
        let adminCarFuel = $('#adCarFuel').val();
        let adminCarExKm = $('#adCarExtraKm').val();
        let adminCarReg = $('#adCarRegistration').val();
        let adminCarDam = $('#adCarDamage').val();
        let adminCarDRate = $('#adCarDailyRate').val();
        let adminCarMRate = $('#adCarMonthlyRate').val();
        let adminCarMPrice = $('#adCarMillagePrice').val();
        let adminCarDuration = $('#adCarDuration').val();

        $.ajax({
            method: "POST",
            url: "http://localhost:8080/GMA_Backend_war_exploded/v2/car",
            dataType: 'Json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify({
                "carId": adminCarId,
                "carBrand": adminCarBrand,
                "carColour": adminCarColor,
                "carType": adminCarType,
                "carNmbOfPassengers": adminCarPass,
                "carTransmissionType": adminCarTran,
                "carFuelType": adminCarFuel,
                "carPriceForExtraKM": adminCarExKm,
                "carRegistrationNumber": adminCarReg,
                "carLossDamageWaiver": adminCarDam,
                "carDailyRate": adminCarDRate,
                "carMonthlyRate": adminCarMRate,
                "carFreeMillagePrice": adminCarMPrice,
                "carFreeMillageDuration": adminCarDuration
            }),

            success: function (res) {
                if (res.message == 'Success') {
                    loadAllCars();
                }
            },
            error: function (ob, textStatus, error) {
            }
        });
    }
});
$('#btnAdminCarGetAll').click(function () {
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
                let adminCarReg = values[i].carRegistrationNumber;
                let adminCarBrand = values[i].carBrand;
                let adminCarPass = values[i].carNmbOfPassengers;
                let adminCarTran = values[i].carTransmissionType;
                let adminCarType = values[i].carType;
                let adminCarColor = values[i].carColour;
                let adminCarFuel = values[i].carFuelType;

                console.log(adminCarId);
                $('#tblCarBody').append(`<tr><td>${adminCarId}</td><td>${adminCarReg}</td><td>${adminCarBrand}</td><td>${adminCarPass}</td><td>${adminCarTran}</td><td>${adminCarType}</td><td>${adminCarColor}</td><td>${adminCarFuel}</td></tr>`)
            }
        }
    });
}


//End Admin Car Save Section