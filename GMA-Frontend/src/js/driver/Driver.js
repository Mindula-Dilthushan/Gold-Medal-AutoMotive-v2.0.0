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
                            alert("Please Enter Password");
                            return false;
                        }
                    } else {
                        alert("Please Enter Contact");
                        return false;
                    }
                } else {
                    alert("Please Enter Email");
                    return false;
                }
            } else {
                alert("Please Enter Nic");
                return false;
            }
        } else {
            alert("Please Enter Name");
            return false;
        }
    } else {
        alert("Please Enter id");
        return false;
    }
}

//End Driver Validation Section
//Start Driver Save Section
$('#btnDriverSave').click(() => {

    if (checkValidationDriverProfile()) {
        let driverProfileId = $('#DriverID').val();
        let driverProfileName = $('#DriverName').val();
        let driverProfileNic = $('#DriverNIC').val();
        let driverProfileEmail = $('#DriverEmail').val();
        let driverProfilePassword = $('#DriverPassword').val();
        let driverProfileContact = $('#DriverContact').val();

        $.ajax({
            method: "POST",
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