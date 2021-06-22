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
                                                            alert("Please Enter Car Duration");
                                                            return false;
                                                        }
                                                    } else {
                                                        alert("Please Enter Car M Price");
                                                        return false;
                                                    }
                                                } else {
                                                    alert("Please Enter adminCarMRate");
                                                    return false;
                                                }
                                            } else {
                                                alert("Please Enter adminCarDRate");
                                                return false;
                                            }
                                        } else {
                                            alert("Please Enter adminCarDam");
                                            return false;
                                        }
                                    } else {
                                        alert("Please Enter adminCarReg");
                                        return false;
                                    }
                                } else {
                                    alert("Please Enter Driver adminCarExKm");
                                    return false;
                                }
                            } else {
                                alert("Please Enter adminCarFuel");
                                return false;
                            }
                        } else {
                            alert("Please Enter adminCarTran");
                            return false;
                        }
                    } else {
                        alert("Please Enter adminCarPass");
                        return false;
                    }
                } else {
                    alert("Please Enter adminCarType");
                    return false;
                }
            } else {
                alert("Please Enter adminCarColor");
                return false;
            }
        } else {
            alert("Please Enter adminCarBrand");
            return false;
        }
    } else {
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
            url: "http://localhost:8080/GMA/v2/car",
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
            dataType: 'Json',
            contentType: "application/json; charset=utf-8",
            success: function (res) {
                if (res.message == 'Success') {
                    loadCustomers();
                }
            },
            error: function (ob, textStatus, error) {
            }
        });
    }
});

//End Admin Car Save Section