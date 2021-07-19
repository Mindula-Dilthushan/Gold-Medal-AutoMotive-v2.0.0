$(document).ready(function () {
    getCustomerCount();
    getCarCount();
    getOrderCount();
    getDriverCount();
});
$('#btn_mainPage').click(function () {
    $('#admin_Home_Page').css({
        'display': 'block'
    });
    $('#admin_profile_Page').css({
        'display': 'none'
    });
    $('#admin_Customer_Page').css({
        'display': 'none'
    });
    $('#admin_Car_Page').css({
        'display': 'none'
    });
    $('#admin_Driver_Page').css({
        'display': 'none'
    });
    $('#admin_Order_Page').css({
        'display': 'none'
    });
    $('#admin_Payment_Page').css({
        'display': 'none'
    });
    getCustomerCount();
    getCarCount();
    getDriverCount();
    getOrderCount();
});

$('#btn_ProfilePage').click(function () {
    $('#admin_Home_Page').css({
        'display': 'none'
    });
    $('#admin_profile_Page').css({
        'display': 'block'
    });
    $('#admin_Customer_Page').css({
        'display': 'none'
    });
    $('#admin_Car_Page').css({
        'display': 'none'
    });
    $('#admin_Driver_Page').css({
        'display': 'none'
    });
    $('#admin_Order_Page').css({
        'display': 'none'
    });
    $('#admin_Payment_Page').css({
        'display': 'none'
    });
    getAdmin();
});

$('#btn_CustomerPage').click(function () {
    $('#admin_Home_Page').css({
        'display': 'none'
    });
    $('#admin_profile_Page').css({
        'display': 'none'
    });
    $('#admin_Customer_Page').css({
        'display': 'block'
    });
    $('#admin_Car_Page').css({
        'display': 'none'
    });
    $('#admin_Driver_Page').css({
        'display': 'none'
    });
    $('#admin_Order_Page').css({
        'display': 'none'
    });
    $('#admin_Payment_Page').css({
        'display': 'none'
    });
    loadAllCustomer();
    getLastCustomerId();
    // getCustomerDLIC();
});

$('#btn_CarPage').click(function () {
    $('#admin_Home_Page').css({
        'display': 'none'
    });
    $('#admin_profile_Page').css({
        'display': 'none'
    });
    $('#admin_Customer_Page').css({
        'display': 'none'
    });
    $('#admin_Car_Page').css({
        'display': 'block'
    });
    $('#admin_Driver_Page').css({
        'display': 'none'
    });
    $('#admin_Order_Page').css({
        'display': 'none'
    });
    $('#admin_Payment_Page').css({
        'display': 'none'
    });
    loadAllCars();
    getLastCarId();
    getCarRegNo();

});

$('#btn_DriverPage').click(function () {
    $('#admin_Home_Page').css({
        'display': 'none'
    });
    $('#admin_profile_Page').css({
        'display': 'none'
    });
    $('#admin_Customer_Page').css({
        'display': 'none'
    });
    $('#admin_Car_Page').css({
        'display': 'none'
    });
    $('#admin_Driver_Page').css({
        'display': 'block'
    });
    $('#admin_Order_Page').css({
        'display': 'none'
    });
    $('#admin_Payment_Page').css({
        'display': 'none'
    });
    loadAllDriver();
    getLastDriverId();
});

$('#btn_OrderPage').click(function () {
    $('#admin_Home_Page').css({
        'display': 'none'
    });
    $('#admin_profile_Page').css({
        'display': 'none'
    });
    $('#admin_Customer_Page').css({
        'display': 'none'
    });
    $('#admin_Car_Page').css({
        'display': 'none'
    });
    $('#admin_Driver_Page').css({
        'display': 'none'
    });
    $('#admin_Order_Page').css({
        'display': 'block'
    });
    $('#admin_Payment_Page').css({
        'display': 'none'
    });
    loadAllOrders();
});

$('#btn_PaymentPage').click(function () {
    $('#admin_Home_Page').css({
        'display': 'none'
    });
    $('#admin_profile_Page').css({
        'display': 'none'
    });
    $('#admin_Customer_Page').css({
        'display': 'none'
    });
    $('#admin_Car_Page').css({
        'display': 'none'
    });
    $('#admin_Driver_Page').css({
        'display': 'none'
    });
    $('#admin_Order_Page').css({
        'display': 'none'
    });
    $('#admin_Payment_Page').css({
        'display': 'block'
    });
});

$('#btnAdminProfile').click(function () {
    $('#admin_Home_Page').css({
        'display': 'none'
    });
    $('#admin_profile_Page').css({
        'display': 'block'
    });
    $('#admin_Customer_Page').css({
        'display': 'none'
    });
    $('#admin_Car_Page').css({
        'display': 'none'
    });
    $('#admin_Driver_Page').css({
        'display': 'none'
    });
    $('#admin_Order_Page').css({
        'display': 'none'
    });
    $('#admin_Payment_Page').css({
        'display': 'none'
    });
});

function getAdmin(){
    console.log("hello");
}

//get count customer
function getCustomerCount() {
    $.ajax({
        method: "get",
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/customer/customerCount',
        async: true,
        success: function (response) {
            var resp = response.data;
            console.log(resp);
            $('#TxtCustomerCount').text(resp);
        }

    });
}

function getCarCount() {
    $.ajax({
        method: "get",
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/car/carCount',
        async: true,
        success: function (response) {
            var resp = response.data;
            console.log(resp);
            $('#txtCarCount').text(resp);
        }

    });
}
function getOrderCount() {
    $.ajax({
        method: "get",
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/booking/bookingCount',
        async: true,
        success: function (response) {
            var resp = response.data;
            console.log(resp);
            $('#txtOrderCount').text(resp);
        }

    });
}
function getDriverCount() {
    $.ajax({
        method: "get",
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/driver/driverCount',
        async: true,
        success: function (response) {
            var resp = response.data;
            console.log(resp);
            $('#txtDriverCount').text(resp);
        }

    });
}

function getLastCustomerId() {
    $.ajax({
        method: "get",
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/customer/lastCustomerId',
        async: false,
        success: function (response) {
            var data = response.data;
            console.log("data" + data);
            $('#adCustId').val(data)
            console.log($('#adCustId').val());
        }

    });
}
function getLastCarId() {
    $.ajax({
        method: "get",
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/car/lastCarId',
        async: false,
        success: function (response) {
            var data = response.data;
            console.log("data" + data);
            $('#adCarId').val(data)
            console.log($('#adCarId').val());
        }

    });
}
function getLastDriverId() {
    $.ajax({
        method: "get",
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/driver/lastDriverId',
        async: false,
        success: function (response) {
            var data = response.data;
            console.log("data" + data);
            $('#adDriverId').val(data)
            console.log($('#adDriverId').val());
        }

    });
}
function getCarRegNo() {
    $.ajax({
        method: "get",
        url: 'http://localhost:8080/GMA_Backend_war_exploded/v2/car/lastCarRegNo',
        async: false,
        success: function (response) {
            var data = response.data;
            console.log("data" + data);
            $('#adCarRegistration').val(data)
            console.log($('#adCarRegistration').val());
        }

    });
}