
function getAllUsers() {
    fetch('http://localhost:8080/alluser', {
        method: 'GET',
    })
        .then((response) => response.json()
        )
        .then((result) => {
            //content = content+"<tr><td>"+result.id+"</td><td>"+result.name+"</td></tr>";
            var i;
            var userTable = document.getElementById("userdata");
            var userTableBody = userTable.getElementsByTagName("tbody")[0];
            for (i = 0; i < result.length; i++) {
                var row = userTableBody.insertRow(i);
                var userIdCell = row.insertCell(0);
                var userNameCell = row.insertCell(1);
                userIdCell.innerHTML = result[i].id;
                userNameCell.innerHTML = result[i].name;
            }
            console.log('Success:', result);
        })
        .catch((error) => {
            console.error('Error:', error);
        });

}

function addUser() {
    var uid = document.getElementById("id").value;
    var uname = document.getElementById("name").value;
    var newuser = {
        id: uid,
        name: uname
    }
    fetch('http://localhost:8080/adduser', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newuser)})
    
    .then(function(res){
        return res.json();
    })
    .catch(function(res){
        alert(JSON.stringify(newuser))
    });
}
function updateUser() {
    var uid = document.getElementById("id").value;
    var uname = document.getElementById("name").value;
    var newuser = {
        id: uid,
        name: uname
    }
    fetch('http://localhost:8080/put', {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newuser)})
    
    .then(function(res){
        return res.json();
    })
    .catch(function(res){
        alert(JSON.stringify(newuser))
    });
}

function deleteUser() {
    var uid = document.getElementById("id").value;
    fetch('http://localhost:8080/delete/'+uid, {
        method: 'DELETE'
        });
}