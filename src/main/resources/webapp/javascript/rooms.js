function createRoomsTable(dataObject) {
    dataObject = JSON.parse(dataObject);
    var content = "";
    for (var x in dataObject) {
        if(!content) {
            content += "<tr>";
            for (var prop in dataObject[x]) {
                content += "<th>" + prop + "</th>";
            }
            content += "<th>Select room</th>";
            content += "</tr>"
        }
        content += "<tr>";
        for (var prop in dataObject[x]) {
            content += "<td>" + dataObject[x][prop] + "</td>";
        }
        content += "<td style='text-align: right'><button"
            + " onclick=\"restRequest('GET', REST_API_URL + '/room/"
            + (dataObject[x]['id']) + "/enter', jsonToString);"
            + " window.location.replace(RESOURCE_URL + '/gameplay.html');\">"
            + "Join Game</button></td>";
        content += "</tr>"
    }
    document.getElementById("roomsTable").innerHTML = "<table class='info-table'>" + content + "</table>";
}