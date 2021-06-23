//Start Admin Driver Validation Section
function checkValidationAdminDriver() {

    let adminDriverId = $('#adDriverId').val();
    let adminDriverName = $('#adDriverName').val();
    let adminDriverNic = $('#adDriverNIC').val();
    let adminDriverContact = $('#adDriverContact').val();
    let adminDriverEmail = $('#adDriverEmail').val();

    if (adminDriverId != "") {
        if (adminDriverName != "") {
            if (adminDriverNic != "") {
                if (adminDriverContact != "") {
                    if (adminDriverEmail) {
                        return true;
                    } else {
                        $('#adDriverEmail').css({
                            'border': '2px #FF0000FF solid'
                        });
                        $('#adDriverEmail').focus();
                        alert("Please Enter Email");
                        return false;
                    }
                } else {
                    $('#adDriverContact').css({
                        'border': '2px #FF0000FF solid'
                    });
                    $('#adDriverContact').focus();
                    alert("Please Enter Contact");
                    return false;
                }
            } else {
                $('#adDriverNIC').css({
                    'border': '2px #FF0000FF solid'
                });
                $('#adDriverNIC').focus();
                alert("Please Enter Nic");
                return false;
            }
        } else {
            $('#adDriverName').css({
                'border': '2px #FF0000FF solid'
            });
            $('#adDriverName').focus();
            alert("Please Enter Name");
            return false;
        }
    } else {
        $('#adDriverId').css({
            'border': '2px #FF0000FF solid'
        });
        $('#adDriverId').focus();
        alert("Please Enter Id");
        return false;
    }
}

//End Admin Driver Validation Section


//Start Admin Driver Save Section
$('#btnAdminDriverSave').click(() => {

    if (checkValidationAdminDriver()) {
        let adminDriverId = $('#adDriverId').val();
        let adminDriverName = $('#adDriverName').val();
        let adminDriverNic = $('#adDriverNIC').val();
        let adminDriverContact = $('#adDriverContact').val();
        let adminDriverEmail = $('#adDriverEmail').val();

        $.ajax({
            method: "POST",
            url: "http://localhost:80f80/GMA/v2/driver",
            data: JSON.stringify({
                "driverId": adminDriverId,
                "driverName": adminDriverName,
                "driverNIC": adminDriverNic,
                "driverContact": adminDriverContact,
                "driverEmail": adminDriverEmail
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
//End Admin Driver Save Section