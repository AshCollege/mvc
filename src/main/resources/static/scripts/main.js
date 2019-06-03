/**
 * Created by Sigal on 5/21/2016.
 */
$(document).ready(function () {


    $(".ping-service-button").click(function () {
        $.post("/ping-service.json?", "service=" + $(this).attr("name"), pingServiceResponse);
    });

    function pingServiceResponse(data, status) {
        alert((data.error ? "Error! " : "Success!") + ", ping time: " + data.pingTime);
    }

    function generalResponse (data, status) {
        if (data.error) {
            alert(getErrorMessage(data.code));
            $(this).attr("disabled", false);
        } else {
            alert("השינויים נשמרו בהצלחה");
        }
    }

    function hasText(text) {
        return !(isUndefined(text) || text == "" || text === "");
    }



});


function login() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    $.post("/login?", "userName=" + userName + "&password=" + password, loginResponse);
}

function loginResponse (data) {
    if (data == "OK") {
        window.location = "/dasboard";
    } else {
        $("#errorResponse").show();
    }
}

function disconneft() {
    window.location = "/login-page";

}



