/*
function reloadAndView(){
    window.location.reload();
    document.getElementById("viewall").click();
}
function displayAsTable(result){
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
} */

function clearInputs(){
    document.getElementById("id").value = '';
    document.getElementById("name").value = '';
}
function displayAsTable(result){
    var html = "";
    var i;
    html = html+"<table>";
    html = html+"<tr>";
    html = html+"<th>ID</th><th>Username</th>";
    for(i=0;i<result.length;i++){
        html = html+"<tr>";
        html = html+"<td>"+result[i].id+"</td><td>"+result[i].name+"</td>";
        html = html+"<tr>";
    }
    html = html+"</tr>";
    html = html+"</table>";
    document.getElementById("box").innerHTML = html;
}
function displayAsTableWithOptions(result){
    var html = "";
    var i;
    html = html+"<table>";
    html = html+"<tr>";
    html = html+"<th>ID</th><th>Username</th>";
    html = html+"</tr>";
    for(i=0;i<result.length;i++){
        html = html+"<tr>";
        html = html+"<td>"+result[i].id+"</td>";
        html = html+"<td>"+result[i].name+"</td>";
        html = html+"<td><button id='u"+result[i].id+"'onclick='loadDataUsingId("+result[i].id+")'>Edit</button></td>";
        html = html+"<td><button id='"+result[i].id+"'onclick='deleteUser(this.id)'>Delete</button></td>";
        html = html+"<tr>";
    }
    html = html+"</table>";
    document.getElementById("box").innerHTML = html;
}
function getAllUsers() {
    fetch('http://localhost:8080/alluser', {
        method: 'GET',
    })
        .then((response) => response.json()
        )
        .then((result) => {
            displayAsTableWithOptions(result);
            clearInputs();
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
        getAllUsers();
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
        getAllUsers();
        document.getElementById('add').innerHTML = "Add User";
        document.getElementById('add').onclick = function(){addUser()};
        return res.json();
    })
    .catch(function(res){
        alert(JSON.stringify(newuser))
    });
}

function loadDataUsingId(uid){
    
    fetch('http://localhost:8080/get/'+uid, {
        method: 'GET'
        })
        .then(function(res){
            return res.json();
        })
        .then(function(result){
            document.getElementById('id').value = result.id;
            document.getElementById('name').value = result.name;
            document.getElementById('add').innerHTML = "Update";
            document.getElementById('add').onclick = function(){updateUser()};
            console.log("ddd",result);
        })
        .catch(function(){
            alert("Error")
        });
} 

function deleteUser(id) {
    //var uid = document.getElementById("id").value;
    var uid = id;
    fetch('http://localhost:8080/delete/'+uid, {
        method: 'DELETE'
        })
        .then(function(){
            getAllUsers();  
        });
}