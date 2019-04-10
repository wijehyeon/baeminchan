function $(selector){
    return document.querySelector(selector)
}

function init(){
    const joinButton = $('#joinSubmit')
    joinButton.addEventListener("click", joinUser)
}

function fetchManager({ url, method, body, headers, callback }) {
    fetch(url, {method,body,headers,credentials: "same-origin"})
        .then((response) => {
            if(response.status == 200) {
                location.href = '/'
                return
            }
            return callback(response.json());
        })
}

function joinUser(event){
    const joinForm = $(".tb_join")
    let userId = joinForm.querySelector('#email_id').value + "@" + joinForm.querySelector('email_domain')
    let password = joinForm.querySelector('#pw1').value
    let password2 = joinForm.querySelector('#pw2').value
    let name = joinForm.querySelector('#name').value
    let phoneNumber = joinTable.querySelector('#cell1').value +'-'+ joinTable.querySelector('#cell2').value + '-'+ joinTable.querySelector('#cell3').value;
    fetchManager({
        url: '/api/users',
        method: 'POST',
        headers: { 'content-type': 'application/json'},
        body: JSON.stringify({
            "userId" : userId,
            "password" : password,
            "password2" : password2,
            "name" : name,
            "phoneNumber" : phoneNumber
        }),
        callback: alertError
    })
}

