// $('#btn_mainPage').on('click', function () {
//     $('#admin_Home_Page').css({
//         'display': 'block'
//     });
//     $('#admin_Customer_Page').css({
//         'display': 'none'
//     });
//     $('#admin_profile_Page').css({
//         'display': 'none'
//     });
// });
//
// $('#btn_ProfilePage').on('click', function () {
//     $('#admin_Home_Page').css({
//         'display': 'none'
//     });
//     $('#admin_Customer_Page').css({
//         'display': 'none'
//     });
//     $('#admin_profile_Page').css({
//         'display': 'block'
//     });
// });
//
// $('#btn_CustomerPage').on('click', function () {
//     $('#admin_Home_Page').css({
//         'display': 'none'
//     });
//     $('#admin_Customer_Page').css({
//         'display': 'block'
//     });
//     $('#admin_profile_Page').css({
//         'display': 'none'
//     });
// });

$('#btn_mainPage').click(() => {
    $('#btn_mainPage').addClass('btn-custom-selected');
    $('#admin_Home_Page').fadeIn(1000);

});