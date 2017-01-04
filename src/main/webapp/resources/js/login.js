function doLogin() {
    console.log("fasfsafsafadsa");
    $.ajax({
        type: "POST",
        url: "/UserLogin/loginWithUserAccount.htmls",
        data: {
            "telephone": $('#username').val(),
            "password": $('#password').val()
        },
        success: function (data) {
            if (data.result == "success") {
                console.log("success");
            } else {
                console.log("error");
            }
        }
    })
}