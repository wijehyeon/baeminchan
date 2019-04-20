document.addEventListener("DOMContentLoaded",()=>{
    init();
})
function $(selector){
    return document.querySelector(selector)
}
function init(){
    const longinButton = $("#loginButton")
    longinButton.addEventListener("click", loginProcess)
}

function loginProcess(evt){
    evt.preventDefault()
    const email = $("#member_id").value
    const password = $("#pwd").value

    fetchManager({
        url: '/users/login',
        method: 'post',
        headers: {'content-type' : 'application/json; charset=utf-8'},
        body: JSON.stringify({
            "email": email,
            "password": password
        }),
        callback: function(response){
            console.log(response)
            location.href='/'
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