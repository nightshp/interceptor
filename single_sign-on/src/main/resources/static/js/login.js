$(function () {

    //获取cookie
    var uName = getCookie('uName');
    var uPassword = getCookie('uPassword');
    if (uName != "" && uPassword != "") {
        $("#uName").val(uName);
        $("#uPassword").val(uPassword);
    }
});


function login() {
    var uName = $("#uName").val();
    var uPassword = $("#uPassword").val();
    var param = {uName: uName, uPassword: uPassword};
    if ($('#rememberMe').is(':checked')) {
        setCookie('uName', $('#uName').val().trim(), 7);
        setCookie('uPassword', $('#uPassword').val().trim(), 7);
    }
    $.ajax({
        url: "/query",
        data: JSON.stringify(param),
        async: true,
        type: "post",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            window.open("main.html");
        }
    })
}

// 设置cookie key value 保存时间
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

// 获取cookie 每个值之间以;和空格隔开
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}

//清除cookie
function clearCookie(cname) {
    setCookie(cname, "", -1);
}
