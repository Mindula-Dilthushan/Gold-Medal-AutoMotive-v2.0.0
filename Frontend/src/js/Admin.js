let btnArray = ['#btn_mainPage', '#btn_ProfilePage','btn_CustomerPage'];

function setClass() {
    for (id in btnArray) {
        $(btnArray[id]).removeClass(
            'btn-custom-selected').
        addClass('btn-custom');
    }
}

let hide = ['#Main_Page', '#Profile_Page', '#Customers_Page'];

function hideAll() {
    for (let i in hide) {
        $(hide[i]).hide();
    }

}

$('#btn_mainPage').click(() => {
    hideAll();
    setClass();
    $('#btn_mainPage').addClass('btn-custom-selected');
    $('#Main_Page').fadeIn(1000);

});

$('#btn_ProfilePage').click(() => {
    hideAll();
    setClass();
    $('#btn_ProfilePage').addClass('btn-custom-selected');
    $('#Profile_Page').fadeIn(1000);

});

$('#btn_CustomerPage').click(() => {
    hideAll();
    setClass();
    $('#btn_CustomerPage').addClass('btn-custom-selected');
    $('#Customers_Page').fadeIn(1000);

});