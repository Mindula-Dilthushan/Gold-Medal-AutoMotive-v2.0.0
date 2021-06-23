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
            data:JSON,
            url: 'http://localhost:8080/GMA/v2/login',
            success:function (res) {
                if(res.message == 'customer'){
                    // document.cookie = "customerEmail="+res.data.email;
                    // document.cookie = "customerPassword="+res.data.password;
                    // window.location.replace("common/customer.html");
                    console.log(email);
                    console.log(password);
                    }
            },
            error:function (ob, textStatus, error) {
                console.log("error from : " + error);
            }
        });
        console.log(email);
        console.log(password);
    }

});