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
if (response == 'ok.') {
window.location.href = 'users.html'
}else {
alert('Las credenciales son incorrectas. Intente nuevamente.');
}
}
