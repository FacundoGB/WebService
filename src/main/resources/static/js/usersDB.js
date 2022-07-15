// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
  $('#usersDB').DataTable();
});

/*
In load Users will be our logic.
To call the server we must use the FETCH function
*/
async function loadUsers() {
const request = await fetch('api/users',{
    method: 'GET',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
});

const users = await request.json();
/*
'request' is the name of the result of the request
'users' is the result of the request transformed into json
*/
console.log(users);


let htmlList = '';
for (let user of users) {
    let delButton = '<a href="#" onclick="delUser('+ user.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'
    //user.name
    let phone = user.phone == null ? '-' : user.phone;
    let userhtml = '<tr><td>'+ user.id +'</td><td>'+ user.name +' '+ user.surname +'</td><td>'
                + user.email +'</td><td>'+ phone
                +'</td><td>'+ delButton +'</td></tr>'
    htmlList += userhtml;
}

/*
We want the body of the table to be saved in a variable and to automatically
generate new entries with different data.
The whole new auto filled userhtml will be saved in a list called htmlList
*/

document.querySelector('#usersDB tbody').outerHTML = htmlList;


}

async function delUser(id) {

    if (!confirm("Do you wish to delete this User?")) {
        return;
    }
    const request = await fetch('api/users/'+ id,{
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    location.reload();
}


//$(document).ready(function() ---> que ejecute la funcion una vez cargada toda la pagina
//$('#usersDB').DataTable()---> libreria JS que selecciona la tabla # y le pone la funcionalidad de paginacion y tablas