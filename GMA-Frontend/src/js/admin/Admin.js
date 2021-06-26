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

