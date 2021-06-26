//Start Driver Validation Section
function checkValidationDriverProfile() {

    let driverProfileId = $('#DriverID').val();
    let driverProfileName = $('#DriverName').val();
    let driverProfileNic = $('#DriverNIC').val();
    let driverProfileEmail = $('#DriverEmail').val();
    let driverProfilePassword = $('#DriverPassword').val();
    let driverProfileContact = $('#DriverContact').val();

    if (driverProfileId != "") {
        if (driverProfileName != "") {
            if (driverProfileNic != "") {
                if (driverProfileEmail != "") {
                    if (driverProfileContact != "") {
                        if (driverProfilePassword) {
                            return true;
                        } else {
                            $('#DriverContact').css({
                                'border': '2px #FF0000FF solid'
                            });
                            $('#DriverContact').focus();
                            alert("Please Enter Password");
                            return false;
                        }
                    } else {
                        $('#DriverPassword').css({
                            'border': '2px #FF0000FF solid'
                        });
                        $('#DriverPassword').focus();
                        alert("Please Enter Contact");
                        return false;
                    }
                } else {
                    $('#DriverEmail').css({
                        'border': '2px #FF0000FF solid'
                    });
                    $('#DriverEmail').focus();
                    alert("Please Enter Email");
                    return false;
                }
            } else {
                $('#DriverNIC').css({
                    'border': '2px #FF0000FF solid'
                });
                $('#DriverNIC').focus();
                alert("Please Enter Nic");
                return false;
            }
        } else {
            $('#DriverName').css({
                'border': '2px #FF0000FF solid'
            });
            $('#DriverName').focus();
            alert("Please Enter Name");
            return false;
        }
    } else {
        $('#DriverID').css({
            'border': '2px #FF0000FF solid'
        });
        $('#DriverID').focus();
        alert("Please Enter id");
        return false;
    }
}
//End Driver Validation Section

//Start Driver Save Section
$('#btnDriverUpdate').click(() => {

    if (checkValidationDriverProfile()) {
        let driverProfileId = $('#DriverID').val();
        let driverProfileName = $('#DriverName').val();
        let driverProfileNic = $('#DriverNIC').val();
        let driverProfileEmail = $('#DriverEmail').val();
        let driverProfilePassword = $('#DriverPassword').val();
        let driverProfileContact = $('#DriverContact').val();

        $.ajax({
            method: "PUT",
            url: "http://localhost:8080/GMA/v2/driver",
            data: JSON.stringify({
                "driverId": driverProfileId,
                "driverName": driverProfileName,
                "driverNIC": driverProfileNic,
                "driverContact": driverProfileContact,
                "driverEmail": driverProfileEmail,
                "driverPassword":driverProfilePassword
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
//End Driver Save Section

$('#btnDriverProfile').click(function () {
    $('#driverProfile').css({
        'display': 'block'
    });
    $('#driverSchedule').css({
        'display': 'none'
    });
});
$('#btnDriverSchedule').click(function () {
    $('#driverProfile').css({
        'display': 'none'
    });
    $('#driverSchedule').css({
        'display': 'block'
    });
});