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
                                    alert("Please Enter Password");
                                    return false;
                                }
                            } else {
                                alert("Please Enter Contact");
                                return false;
                            }
                        } else {
                            alert("Please Enter Driver License");
                            return false;
                        }
                    } else {
                        alert("Please Enter Nic");
                        return false;
                    }
                } else {
                    alert("Please Enter Email");
                    return false;
                }
            } else {
                alert("Please Enter Address");
                return false;
            }
        } else {
            alert("Please Enter Name");
            return false;
        }
    } else {
        alert("Please Enter Id");
        return false;
    }
}

//End Customer Validation Section


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
                "customerPassword":cPassword
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