// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});


async function registerUser() {
let data = {};
/*
we extract the specific inputs for the object from the boxes
*/
data.name = document.getElementById('txtName').value
data.surname = document.getElementById('txtSurname').value
data.email = document.getElementById('txtEmail').value
data.password = document.getElementById('txtPassword').value

/*
We verify that the password is the same
*/
let repeatPassword = document.getElementById('txtRepeatPassword').value;

if(repeatPassword != data.password) {
    alert('Make sure your password matches!')
    return;
}

const request = await fetch('api/users',{
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
});
}

