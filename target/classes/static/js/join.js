document.addEventListener("DOMContentLoaded", () => {
    initEvents();
})

function $(selector) {
    return document.querySelector(selector);
}

function initEvents() {
    const submitBtn = $("#joinSubmit");
    submitBtn.addEventListener("click", registerUserSignUpHandler);
}

function registerUserSignUpHandler(evt) {
    evt.preventDefault();
    const email = $('#email_id').value;
    const emailDomain = $('#email_domain').value;
    const password = $('#pw1').value;
    const name = $('#name').value;
    const phoneNumber = $('#cell1').value + $('#cell2').value + $('#cell3').value;

    fetchManager({
        url: "/users",
        method: "post",
        headers: {'content-type': 'application/json; charset=utf-8'},
        body: JSON.stringify({
            "email": email + '@' + emailDomain,
            "password": password,
            "password2": password,
            "name": name,
            "phoneNumber": phoneNumber
        }),
        callback: function (response) {
            console.log(response)
            location.href = '/'
        }
    })
}

function fetchManager({url, method, body, headers, callback}) {
    fetch(url, {method, body, headers, credentials: "same-origin"})
        .then((response) => {
            return response.json()
        }).then((result) => {
        callback(result)
    })
}