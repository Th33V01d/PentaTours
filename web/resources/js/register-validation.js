var validated;
var jsondata;

$(function(){
    $.getJSON('/resources/other/restrictions/user.json', function(data) {
        jsondata = data;
    });
});

function showError(container, errorMessage) {
    var msgElem = document.createElement('span');
    msgElem.className = "error-message";
    msgElem.innerHTML = "<font size='2' color='red'>" + errorMessage + "</font>";
    container.appendChild(msgElem);
}

function resetError(container) {
    if (container.lastChild.className == "error-message") {
        container.className = "";
        container.removeChild(container.lastChild);
    }
}

function resetAllErrors(elems) {
    resetError(elems.login.parentNode);
    resetError(elems.password.parentNode);
    resetError(elems.password2.parentNode);
    resetError(elems.name.parentNode);
    resetError(elems.lastname.parentNode);
    resetError(elems.phone.parentNode);
    resetError(elems.email.parentNode);
}

function validateElem(container, condition, message, maxval, bigfieldmsg) {
    if (condition) {
        showError(container.parentNode, message);
        validated = false;
    }
    else if (container.value.length > maxval) {
        showError(container.parentNode, bigfieldmsg + maxval);
        validated = false;
    }
}

function validate(form, document) {
    var errmsg = document.ownerDocument.getElementById('err').getAttribute('data-txt');
    var bigfieldmsg = document.ownerDocument.getElementById('bigfielderr').getAttribute('data-txt');
    var passmatcherr = document.ownerDocument.getElementById('passmatcherr').getAttribute('data-txt');
    var phoneoremailerr = document.ownerDocument.getElementById('phoneoremailerr').getAttribute('data-txt');
    var emailerr = document.ownerDocument.getElementById('emailerr').getAttribute('data-txt');

    validated = true;

    var elems = form.elements;

    var logincheck = !elems.login.value;
    var passcheck = !elems.password.value;
    var passmatchcond = (elems.password.value != elems.password2.value);
    var namecheck = !elems.name.value;
    var lastnamecheck = !elems.lastname.value;
    var phonecheck = !elems.phone.value;
    var emailregex = /^\w+@\w+\.\w{1,4}$/i;
    var emailcheck = (!emailregex.test(elems.email.value));

    resetAllErrors(elems);

    validateElem(elems.login, logincheck, errmsg, jsondata.login, bigfieldmsg);
    validateElem(elems.password, passcheck, errmsg, jsondata.password_, bigfieldmsg);
    validateElem(elems.password2, passmatchcond, passmatcherr, jsondata.password_, bigfieldmsg);
    validateElem(elems.name, namecheck, errmsg, jsondata.name_, bigfieldmsg);
    validateElem(elems.lastname, lastnamecheck, errmsg, jsondata.lastname, bigfieldmsg);
    validateElem(elems.phone, phonecheck, phoneoremailerr, jsondata.phone, bigfieldmsg);
    validateElem(elems.email, emailcheck, emailerr, jsondata.email, bigfieldmsg);

    if (validated) {
        form.submit();
    }
}