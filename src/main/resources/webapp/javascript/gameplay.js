/**
 * Created by ruslangramatic on 4/24/18.
 */
function createCardList() {
    var content = "";
    for (var x = 0; x < 50; x++) {
        content += '<button style="height: 150px; width: 130px" class="glow-effect" '
            +'onclick="restRequest("GET", REST_API_URL + "/cards/list", jsonToTable)">Card: ' + x + '</button>';
    }
    document.getElementById("cards").innerHTML = content;
}

function createResourceBuildingsUpdatesList() {
    var content = "";
    for (var x = 0; x < 50; x++) {
        content += '<button style="height: 130px; width: 150px" class="glow-effect" '
            +'onclick="restRequest("GET", REST_API_URL + "/resources/list", jsonToTable)">Buildings<br>Updates: ' + x + '</button>';
    }
    document.getElementById("items").innerHTML = content;
}

function createEnemyResourceBuildingsUpdatesList() {
    var content = "";
    for (var x = 0; x < 50; x++) {
        content += '<button style="height: 130px; width: 150px" class="glow-effect" '
            +'onclick="restRequest("GET", REST_API_URL + "/resources/list", jsonToTable)">Buildings<br>Updates: ' + x + '</button>';
    }
    document.getElementById("enemy_items").innerHTML = content;
}
