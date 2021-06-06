//отображение таблицы всех пользователей
let table = $('#tableAllUsers');
fetch('/app/all_users')
    .then(res => res.json())
    .then(users => {
        users.forEach(user => {
            let tableFilling = "";
            tableFilling += '<tr>';
            tableFilling += '<td>' + user.id + '</td>';
            tableFilling += '<td>' + user.name + '</td>';
            tableFilling += '<td>' + user.lastName + '</td>';
            tableFilling += '<td>' + user.age + '</td>';
            tableFilling += '<td>' + user.email + '</td>';
            tableFilling += '<td>';
            user.userRoles.forEach(r => {
                tableFilling += r.role + ' ';
            })
            tableFilling += '</td>';
            tableFilling += '<td><button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editBTN+${user.id}" id="editsBTN"> edit</button></td>'
            tableFilling += '<td><button class="btn btn-danger" ' +
                'data-bs-toggle="modal" ' +
                'data-bs-target="#modalDelete" ' +
                'id="deleteBTN"' +
                'type="button"> delete</button></td>'
            tableFilling += '</tr>';

            table.append(tableFilling);
        })
    })