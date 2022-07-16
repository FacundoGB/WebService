// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});


async function logIn() {
let data = {};
/*
we extract the specific inputs for the object from the boxes
*/
data.email = document.getElementById('txtEmail').value
data.password = document.getElementById('txtPassword').value

//call to server
const request = await fetch('api/login',{
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
});
//we bring info of the session. Not needed in registration
const response = await request.text();

//The response will no longer be Ok. Now we should return an error 401 auth server error
if (response != 'FAIL') {

//In the response is the info we want to save
localStorage.token = response;
//we save more info like email for session
localStorage.email = data.email;

window.location.href = 'users.html'
}else {
alert('Las credenciales son incorrectas. Intente nuevamente.');
}
}
