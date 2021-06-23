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
                                $('#adCustContact').css({
                                    'border': '2px #FF0000FF solid'
                                });
                                $('#adCustContact').focus();
                                alert("Please Enter Contact");
                                return false;
                            }
                        } else {
                            $('#adCustDl').css({
                                'border': '2px #FF0000FF solid'
                            });
                            $('#adCustDl').focus();
                            alert("Please Enter Driver License");
                            return false;
                        }
                    } else {
                        $('#adCustNic').css({
                            'border': '2px #FF0000FF solid'
                        });
                        $('#adCustNic').focus();
                        alert("Please Enter Nic");
                        return false;
                    }
                } else {
                    $('#adCustEmail').css({
                        'border': '2px #FF0000FF solid'
                    });
                    $('#adCustEmail').focus();
                    alert("Please Enter Email");
                    return false;
                }
            } else {
                $('#adCustAddress').css({
                    'border': '2px #FF0000FF solid'
                });
                $('#adCustAddress').focus();
                alert("Please Enter Address");
                return false;
            }
        } else {
            $('#adCustName').css({
                'border': '2px #FF0000FF solid'
            });
            $('#adCustName').focus();
            alert("Please Enter Name");
            return false;
        }
    } else {
        $('#adCustId').css({
            'border': '2px #FF0000FF solid'
        });
        $('#adCustId').focus();
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
                    loadAllCustomer();
                }
            },
            error: function (ob, textStatus, error) {
            }
        });
    }
});
//End Admin Save Section


//Start Get Admin Customer Section
function loadAllCustomer() {
    $('#tblCustomerBody').empty();
    $.ajax({
        url: 'http://localhost:8080/GMA/v2/customer',
        method: 'GET',
        success: function (res) {
            let values = res.data;
            for (i in values) {
                let cID = values[i].customerId;
                let cNIC = values[i].customerNIC;
                let cNAME = values[i].customerName;
                let cAddress = values[i].customerAddress;
                let cEmail = values[i].customerEmail;
                let cDLIC = values[i].customerDrivingLIC;
                let cContact = values[i].customerContact;

                $('#tblCustomerBody').append(`<tr><th>${cID}</th><td>${cNIC}</td><td>${cNAME}</td><td>${cAddress}</td><td>${cEmail}</td><td>${cDLIC}</td><td>${cContact}</td></tr>`)
            }
        }
    });
}
//End Get Admin Customer Section