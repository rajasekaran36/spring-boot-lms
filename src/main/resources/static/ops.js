
fetch('http://localhost:8080/alluser', {
    method: 'GET',
})
    .then((response) => response.json()
    )
    .then((result) => {
        //content = content+"<tr><td>"+result.id+"</td><td>"+result.name+"</td></tr>";
        var i;
        var content = "<table>";
        for (i = 0; i < result.length; i++) {
            content = content + "<tr><td>" + result[i].id + "</td><td>" + result[i].name + "</td></tr>";
        }
        content = content + "<table>";
        console.log('Success:', result);
    })
    .catch((error) => {
        console.error('Error:', error);
    });

var uid = document.getElementById("id").value;
var uname = document.getElementById("name").value;
var addUser = fetch('http://localhost:8080/adduser', {
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ id: uid, name: uname })
});