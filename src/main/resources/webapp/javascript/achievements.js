/**
 * Created by ruslangramatic on 4/24/18.
 */
function createAchievementsTable(dataObject) {
    dataObject = JSON.parse(dataObject);
    var content = "";
    for (var x in dataObject) {
        if(!content) {
            content += "<tr>";
            for (var prop in dataObject[x]) {
                content += "<th>" + prop + "</th>";
            }
            content += "</tr>";
        }
        content += "<tr>";
        for (var prop in dataObject[x]) {
            content += "<td>" + dataObject[x][prop] + "</td>";
        }
        content += "</tr>";
    }
    document.getElementById("achievementsTable").innerHTML = "<h1 class='achievements-header'>Achievements</h1>"
        + "<table class='achievements-table'>" + content + "</table>";
}

function logout() {
    window.location.replace(RESOURCE_URL + '/login.html');
}