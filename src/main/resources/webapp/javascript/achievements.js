/**
 * Created by ruslangramatic on 4/24/18.
 */
function createAchievementsTable(dataObject) {
    dataObject = JSON.parse(dataObject);
    var content = "";
    for (var x in dataObject) {
        if(!content) {
            content += "<tr>";
            content +=      "<th width='100px'>Achievement Number</th>";
            content +=      "<th>Achievement Name</th>";
            content +=      "<th>Achievement Description</th>";
            content += "</tr>"
        }
        content +=  "<tr>";
        content +=      "<td>" + dataObject[x]['id'] + "</td>";
        content +=      "<td>" + dataObject[x]['name'] + "</td>";
        content +=      "<td>" + dataObject[x]['description'] + "</td>";
        content +=  "</tr>"
    }
    document.getElementById("achievements_table").innerHTML = "<h1 class='achievements-header'>Achievements</h1>"
        + "<table class='achievements-table'>" + content + "</table>";
}

function logout() {
    window.location.replace(RESOURCE_URL + '/login.html');
}