function startRoomLoop() {
    restRequest('GET', REST_API_URL + '/room/list', createRoomsTable);
    setInterval(function () {
        restRequest('GET', REST_API_URL + '/room/list', createRoomsTable);
    }, 5000);
}

function createRoomsTable(dataObject) {
    dataObject = JSON.parse(dataObject);
    var content = "";
    for (var x in dataObject) {
        if(!content) {
            content += "<tr>";
            content +=      "<th width='100px'>Room Number</th>";
            content +=      "<th>Room Name</th>";
            content +=      "<th>Room Description</th>";
            content +=      "<th>Occupant 1</th>";
            content +=      "<th>Occupant 2</th>";
            content += "</tr>"
        }
        content +=  "<tr>";
        content +=      "<td>" + dataObject[x]['id'] + "</td>";
        content +=      "<td>" + dataObject[x]['name'] + "</td>";
        content +=      "<td>" + dataObject[x]['description'] + "</td>";
        content +=      "<td>" + (dataObject[x]['account1'] != undefined
                            ? "<img src='images/power_chicken_plaing.png' width='50px' height='50px' "
                            + "style='margin-bottom: -20px; margin-top: -20px;-webkit-transform: scaleX(-1); transform: scaleX(-1);'>"
                            + "<b style='line-height: 43px'>" + dataObject[x]['account1']['user']['name'] + "</b>"
                            : "<button class='room-button' onclick=\"joinRoom(" + dataObject[x]['id'] + ")\">Join Game</button>") +
                        "</td>";
        content +=      "<td>" + (dataObject[x]['account2'] != undefined
                            ? "<b style='line-height: 43px'>" + dataObject[x]['account2']['user']['name'] + "</b>"
                            + "<img style='margin-bottom: -20px; margin-top: -20px' src='images/power_chicken_plaing.png' width='50px' height='50px'>"
                            : "<button class='room-button' onclick=\"joinRoom(" + dataObject[x]['id'] + ")\">Join Game</button>") +
                        "</td>";
        content +=  "</tr>"
    }
    document.getElementById("roomsTable").innerHTML = "<h1 class='rooms-header'>Game Rooms</h1>"
        + "<table class='room-table'>" + content + "</table>";
}

function joinRoom(roomId) {
    restRequest('GET', REST_API_URL + '/room/' + roomId + '/join', function() {
        window.location.replace(RESOURCE_URL + '/gameplay.html');
    });
}

function logout() {
    window.location.replace(RESOURCE_URL + '/login.html');
}

