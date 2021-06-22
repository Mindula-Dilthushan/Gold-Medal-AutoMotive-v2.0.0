$('#btn_Login').click(function () {
    let email = $('#txtEmail').val();
    let password = $('#txtPassword').val();
    if (email == ""){
        alert('Enter Email..!');
    }else if(password == ""){
        alert('Enter Password..!');
    }else{
        $.ajax({
            method: "GET",
            url: 'http://localhost:8080/GMA/v2/customer'+email+'/'+password,
            success:function (res) {
                if(res.message == 'customer'){
                    document.cookie = "email="+res.data.customerEmail;
                    document.cookie = "password="+res.data.customerPassword;
                    window.location.replace("src/common/customer.html");
                // }else if(res.message == 'driver'){
                //     document.cookie = "user="+res.data.name;
                //     document.cookie = "userID="+res.data.DriverID;
                //     localStorage.setItem('loggedUser', res);
                //     window.location.replace("DriverDashboard.html");
                // }else if(res.message == 'admin'){
                //     document.cookie = "user="+res.data.name;
                //     document.cookie = "userID="+res.data.adminID;
                //     localStorage.setItem('loggedUser', res);
                //     window.location.replace("AdminDashboard.html");
                // }
                    }
            },
            error:function (ob, textStatus, error) {
                console.log("error from : " + error);
            }
        });
    }

});