function startRoomLoop() {
    restRequest('GET', REST_API_URL + '/room/list', createRoomsTable);
    setInterval(function () {
        restRequest('GET', REST_API_URL + '/room/list', createRoomsTable);
    }, 30000);
}

function createRoomsTable(dataObject) {
    dataObject = JSON.parse(dataObject);
    var content = "";
    for (var x in dataObject) {
        if(!content) {
            content += "<tr>";
            content +=      "<th>Room Number</th>";
            content +=      "<th>Room Name</th>";
            content +=      "<th>Room Description</th>";
            content +=      "<th>Occupant 1</th>";
            content +=      "<th>Occupant 2</th>";
            content +=      "<th>Click to join</th>";
            content += "</tr>"
        }
        content +=  "<tr>";
        content +=      "<td>" + dataObject[x]['id'] + "</td>";
        content +=      "<td>" + dataObject[x]['name'] + "</td>";
        content +=      "<td>" + dataObject[x]['description'] + "</td>";
        content +=      "<td>" + (dataObject[x]['account1'] != undefined ? dataObject[x]['account1']['user']['name'] : '') + "</td>";
        content +=      "<td>" + (dataObject[x]['account2'] != undefined ? dataObject[x]['account2']['user']['name'] : '') + "</td>";
        content +=      "<td style='text-align: right'>" + (dataObject[x]['account1'] == undefined || dataObject[x]['account2'] == undefined ?
                        "<button onclick=\"joinRoom(" + dataObject[x]['id'] + ")\">Join Game</button>" : "") + "</td>";
        content +=  "</tr>"
    }
    document.getElementById("roomsTable").innerHTML = "<table class='info-table'>" + content + "</table>";
}

function joinRoom(roomId) {
    restRequest('GET', REST_API_URL + '/room/' + roomId + '/join', function() {
        window.location.replace(RESOURCE_URL + '/gameplay.html');
    });
}