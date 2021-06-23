//Start Admin Validation Section
function checkValidationAdminProfile() {

    let id = $('#adminID').val();
    let email = $('#adminEmail').val();
    let name = $('#adminName').val();
    let password = $('#adminPassword').val();
    let confPassword = $('#adminConfirmPassword').val();

    if (id != "") {
        if (email != "") {
            if (name != "") {
                if (password != "") {
                    if (confPassword) {
                        return true;
                    } else {
                        $('#adminConfirmPassword').css({
                            'border': '2px #FF0000FF solid'
                        });
                        $('#adminConfirmPassword').focus();
                        // alert("Please Enter Confirm Password");
                        return false;

                    }
                } else {
                    $('#adminPassword').css({
                        'border': '2px #FF0000FF solid'
                    });
                    $('#adminPassword').focus();
                    // alert("Please Enter Password");
                    return false;
                }
            } else {
                $('#adminName').css({
                    'border': '2px #FF0000FF solid'
                });
                $('#adminName').focus();
                // alert("Please Enter Name");
                return false;
            }
        } else {
            $('#adminEmail').css({
                'border': '2px #FF0000FF solid'
            });
            $('#adminEmail').focus();
            // alert("Please Enter Email");
            return false;
        }
    } else {
        $('#adminID').css({
            'border': '2px #FF0000FF solid'
        });
        $('#adminID').focus();
        // alert("Please Enter Id");
        return false;
        // alert("Please Enter Confirm Password");
    }
}

//End Admin Validation Section

//Start Admin Save Section
$('#btnAdminSave').click(() => {

    if (checkValidationAdminProfile()) {
        let admin_id = $('#adminID').val();
        let admin_email = $('#adminEmail').val();
        let admin_name = $('#adminName').val();
        let admin_cpw = $('#adminConfirmPassword').val();

        $.ajax({
            method: "POST",
            url: "http://localhost:8080/GMA/v2/admin",
            data: JSON.stringify({
                "adminId": admin_id,
                "adminEmail": admin_email,
                "adminName": admin_name,
                "adminPassword": admin_cpw
            }),
            dataType: 'Json',
            contentType: "application/json; charset=utf-8",
            success: function (res) {
                if (res.message == 'Success') {

                }
            },
            error: function (ob, textStatus, error) {
                if (res.message != 'Success') {
                }
            }
        });
    }

});
//End Admin Save Section




