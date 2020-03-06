
var serverpath = "http://localhost:8080";
var playLists = [];
var playlistArea = document.getElementById("play");
var playListId = 1;
var userId = 1;

function getPlayListById(playListId) {
    fetch(serverpath + '/api/playlist/get/' + playListId, {
        method: 'GET',
    })
        .then((response) => response.json()
        )
        .then((result) => {        
            console.log(result);
            return result;
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    
}

function playListToTable(playList){
    var html = "";
    html = html+"<table>";
        html = html+"<tr>";
            html = html+"<th>ID</th><th>PlayListID</th><th>LR ID</th>";
        html = html+"</tr>";
        html = html+"<tr>";
            html = html+"<td>"+playList.id+"</td>";
            html = html+"<td>"+playList.playListId+"</td>";
            html = html+"<td>"+playList.learningResourceId+"</td>";
        html = html+"</tr>";
        
    html = html+"</table>";
    return html;
}

function getPlayListByIdsByUsers(userId) {
    console.log("Uinvoke");
    var apipath = "/api/userplaylistmapping/getplaylistids/";
    var ids;
    fetch(serverpath + apipath + userId, {
        method: 'GET',
    })
        .then((response) => response.json()
        )
        .then((result) => {
            console.log(result);
            console.log("Udone");
            ids = result;
        })
        .catch((error) => {
            console.error('Error:', error);
        });

        return ids;
}

function loadPlayList() {
    console.log("invoke");
    //var playListIds = JSON.parse(getPlayListByIdsByUsers(userId));
    var playListIds = [];
    var plObj = getPlayListByIdsByUsers(userId);
    console.log(plObj);
    for(key in plObj){
        
        playListIds.push(plObj[key]);
    }
    var i;
    for(i=0;i<playListIds.length;i++){
        //console.log("idnn");
        playLists.push(getPlayListById(playListIds[i]))
    } 

    var finaldisplay = "";
    for(i=0;i<playLists.length;i++){
        finaldisplay = finaldisplay + playListToTable(playLists[i]);
        finaldisplay = finaldisplay + "<br><br><br>";
    }

    console.log(finaldisplay);
    playlistArea.innerHTML = finaldisplay;
}

getPlayListByIdsByUsers(userId);