//Start Login Validation Section
function checkValidationRegister() {

    let loginFName = $('#txtFName').val();
    let loginLName = $('#txtLName').val();
    let loginEmail = $('#txtEmail').val();
    let loginPassword = $('#txtPassword').val();
    let loginConfirmPassword = $('#txtConfirmPassword').val();

    if (loginFName != "") {
        if (loginLName != "") {
            if (loginEmail != "") {
                if (loginPassword != "") {
                    if (loginConfirmPassword) {
                        return true;
                    } else {
                        alert("Please Enter Confirm Password");
                        return false;
                    }
                } else {
                    alert("Please Enter Password");
                    return false;
                }
            } else {
                alert("Please Enter Email");
                return false;
            }
        } else {
            alert("Please Enter Last Name");
            return false;
        }
    } else {
        alert("Please Enter First Name");
        return false;
    }
}
//End Login Validation Section

//Start Admin Save Section
$('#btn_Register').click(() => {

    if (checkValidationRegister()) {
        let loginFName = $('#txtFName').val();
        let loginLName = $('#txtLName').val();
        let loginEmail = $('#txtEmail').val();
        let loginPassword = $('#txtPassword').val();
        let loginConfirmPassword = $('#txtConfirmPassword').val();

        $.ajax({
            method: "POST",
            url: "http://localhost:8080/GMA/v2/login",
            data: JSON.stringify({
                "loginEmail": loginFName,
                "loginFName": loginLName,
                "loginLName": loginEmail,
                "loginPassword": loginConfirmPassword
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
//End Admin Save Section