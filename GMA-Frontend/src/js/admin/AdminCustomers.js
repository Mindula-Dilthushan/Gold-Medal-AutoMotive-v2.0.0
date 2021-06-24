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

function clearCustomerFields() {
    $('#adCustId').val(null);
    $('#adCustName').val("");
    $('#adCustAddress').val("");
    $('#adCustEmail').val("");
    $('#adCustNic').val("");
    $('#adCustDl').val("");
    $('#adCustContact').val("");
}

//Start Admin Save Section
$('#btnAdminCustomerSave').click(function () {

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
            url: "http://localhost:8080/GMA_Backend_war_exploded/v2/customer",
            dataType: 'Json',
            async: true,
            contentType: "application/json",
            data: JSON.stringify({
                customerId: custId,
                customerName: custName,
                customerAddress: custAdd,
                customerEmail: custEmail,
                customerNIC: custNic,
                customerDrivingLIC: custDl,
                customerContact: custContact
            }),
            success: function (res) {
                loadAllCustomer();
                clearCustomerFields();

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
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/customer',
        method: 'GET',
        async: false,
        dataType: 'json',
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

                $('#tblCustomerBody').append(`<tr><td>${cID}</td><td>${cNIC}</td><td>${cNAME}</td><td>${cAddress}</td><td>${cEmail}</td><td>${cDLIC}</td><td>${cContact}</td></tr>`)
            }
        }
    });
}

//Admin Customer Delete
$('#btnAdminCustomerDelete').click(() => {
    let customId = $('#adCustId').val();
    $.ajax({
        method: "delete",
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/customer/?customerId=' + customId,
        async: true,
        success: function (response) {
        },
        error: function (response) {
        }
    });
});

$('#btnAdminCustomerGetAll').click(function () {
    loadAllCustomer();
    clearCustomerFields();
});

$('#btnAdminCustomerUpdate').click(() => {

    let custId = $('#adCustId').val();
    let custName = $('#adCustName').val();
    let custAdd = $('#adCustAddress').val();
    let custEmail = $('#adCustEmail').val();
    let custNic = $('#adCustNic').val();
    let custDl = $('#adCustDl').val();
    let custContact = $('#adCustContact').val();

    $.ajax({
        method: "POST",
        url: "http://localhost:8080/GMA_Backend_war_exploded/v2/customer",
        contentType: "application/json",
        async: true,
        data: JSON.stringify(
            {
                customerId: custId,
                customerName: custName,
                customerAddress: custAdd,
                customerEmail: custEmail,
                customerNIC: custNic,
                customerDrivingLIC: custDl,
                customerContact: custContact
            }
        ),
        success: function (data) {
            loadAllCustomer();
        }
    });
});
//End Get Admin Customer Section