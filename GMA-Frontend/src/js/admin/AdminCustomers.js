//Start Admin Customer Validation Section
function checkValidationAdminCustomer() {

    let custId = $('#adCustId').val();
    let custName = $('#adCustName').val();
    let custAdd = $('#adCustAddress').val();
    let custEmail = $('#adCustEmail').val();
    let custNic = $('#adCustNic').val();
    let custDl = $('#adCustDl').val();
    let custContact = $('#adCustContact').val();

    if (custId != "") {
        if (custName != "") {
            if (custAdd != "") {
                if (custEmail != "") {
                    if (custNic != "") {
                        if (custDl != "") {
                            if (custContact) {
                                return true;
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
//End Admin Customer Validation Section


//Start Admin Save Section
$('#btnAdminCustomerSave').click(() => {

    if (checkValidationAdminCustomer()) {
        let custId = $('#adCustId').val();
        let custName = $('#adCustName').val();
        let custAdd = $('#adCustAddress').val();
        let custEmail = $('#adCustEmail').val();
        let custNic = $('#adCustNic').val();
        let custDl = $('#adCustDl').val();
        let custContact = $('#adCustContact').val();

        $.ajax({
            method: "POST",
            url: "http://localhost:8080/GMA/v2/customer",
            data: JSON.stringify({
                "customerId": custId,
                "customerName": custName,
                "customerAddress": custAdd,
                "customerEmail": custEmail,
                "customerNIC": custNic,
                "customerDrivingLIC": custDl,
                "customerContact": custContact
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




//Start Get Admin Customer Section

//End Get Admin Customer Section