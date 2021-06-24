// $('#btn_Login').click(function () {
//     let userName = $('#txtEmail').val();
//     let password = $('#txtPassword').val();
//     if (userName == ""){
//         alert('Enter User Name..!');
//     }else if(password == ""){
//         alert('Enter Password..!');
//     }else{
//         $.ajax({
//             method: "GET",
//             url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/customer/'+userName+'/'+password,
//             success:function (res) {
//                 if(res.message == 'customer'){
//                     document.cookie = "user="+res.data.name;
//                     document.cookie = "userID="+res.data.customerId;
//                     window.location.replace("index.html");
//                     console.log(userName);
//                     console.log(password);
//                     console.log(name);
//                 }else if(res.message == 'driver'){
//                     // document.cookie = "user="+res.data.name;
//                     // document.cookie = "userID="+res.data.DriverID;
//                     // localStorage.setItem('loggedUser', res);
//                     // window.location.replace("DriverDashboard.html");
//                 }else if(res.message == 'admin'){
//                     // document.cookie = "user="+res.data.name;
//                     // document.cookie = "userID="+res.data.adminID;
//                     // localStorage.setItem('loggedUser', res);
//                     // window.location.replace("AdminDashboard.html");
//                 }
//             },
//             error:function (ob, textStatus, error) {
//                 console.log("error from : " + error);
//             }
//         });
//     }
//
// });

$("#btn_Login").click(function () {
    let userName = $('#txtEmail').val();
    let password = $('#txtPassword').val();

    if (userName != "" && password != "") {
        console.log(userName);
        console.log(password);
        $.ajax({
            method:'GET',
            url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/customer/' + userName + '/' + password,
            success: function (response) {
                if (response == 1) {
                    document.cookie = "user="+response.data.name;
                    document.cookie = "userID="+response.data.customerId;
                    window.location = "../../index.html";
                } else {

                }
            }
        });
    }
});
