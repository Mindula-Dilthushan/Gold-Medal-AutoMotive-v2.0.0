$('btn_Login').click(() => {
        if (checkingAdminFeels()){
            $.ajax(
                {
                    method:"GET",
                    url:'http://localhost:8080/GMA/v2/admin'+email+'/'+password,
                    success:function (res) {
                        if (res.message == 'admin'){
                            document.cookie = "name="+res.data.name;
                            document.cookie = "password="+res.data.password;
                            window.location.replace("admin.html")
                        }
                    }
                }
            );
        }
    }
);

function checkingAdminFeels() {

    let name = $('#txtEmail').val();
    let password = $('#txtPassword').val();

    if (name != "") {
        if (password != "") {
            return true;
        } else {
            alert("Please Enter Password");
            return false;
        }
    } else {
        alert("Please Enter Email");
        return false;
    }
}