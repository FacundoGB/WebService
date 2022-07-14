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
    const request = await fetch('user/123',{
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

}



//$(document).ready(function() ---> que ejecute la funcion una vez cargada toda la pagina
//$('#usersDB').DataTable()---> libreria JS que selecciona la tabla # y le pone la funcionalidad de paginacion y tablas