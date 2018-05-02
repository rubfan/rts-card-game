/**
 * Created by ruslangramatic on 4/24/18.
 */
const IMG_URL = {
    "0": "images/worker_resource.png",
    "1": "images/axe_resource.png",
    "2": "images/bazooka_resource.png",
    "3": "images/droppings_resource.png",
    "4": "images/egg_resource.png",
    "5": "images/gunpowder_resource.png",
    "6": "images/hammer_resource.png",
    "7": "images/machine_gun_resource.png",
    "8": "images/mana_resource.png",
    "9": "images/metal_resource.png",
    "10": "images/power_resource.png",
    "11": "images/prophet_resource.png",
    "12": "images/recruit_resource.png",
    "13": "images/spear_resource.png",
    "14": "images/stone_resource.png",
    "15": "images/sword_resource.png",
    "16": "images/warrior_resource.png",
    "17": "images/wheat_resource.png",
    "18": "images/wizard_resource.png",
    "19": "images/wood_resource.png"
};

const KING_WON = "images/power_chicken_won.png";
const KING_LOST = "images/power_chicken_lost.png";
const KING_PLAING = "images/power_chicken_plaing.png";

function createCardList() {
    var content = "";
    for (var x = 0; x < 50; x++) {
        content += '<button style="height: 150px; width: 130px" class="glow-effect" '
            +'onclick="restRequest("GET", REST_API_URL + "/cards/use", jsonToTable)">Card: ' + x + '</button>';
    }
    document.getElementById("cards").innerHTML = content;
}

function createBuildingsUpdatesList() {
    var content = "";
    for (var x = 0; x < 50; x++) {
        content += '<button style="height: 130px; width: 150px" class="glow-effect" '
            +'onclick="restRequest("GET", REST_API_URL + "/resources/list", jsonToTable)">Buildings<br>Updates: ' + x + '</button>';
    }
    document.getElementById("items").innerHTML = content;
}

function createEnemyBuildingsUpdatesList() {
    var content = "";
    for (var x = 0; x < 50; x++) {
        content += '<button style="height: 130px; width: 150px" class="glow-effect" '
            +'onclick="restRequest("GET", REST_API_URL + "/resources/list", jsonToTable)">Buildings<br>Updates: ' + x + '</button>';
    }
    document.getElementById("enemy_items").innerHTML = content;
}

function createResourceList() {
    var content = "";
    for (var x = 0; x < 20; x++) {
        content += '<img class="resource-item" src="'+ IMG_URL[x] + '">';
    }
    document.getElementById("left_resource_container").innerHTML = content;
}

function createEnemyResourceList() {
    var content = "";
    for (var x = 0; x < 20; x++) {
        content += '<img class="resource-item" src="'+ IMG_URL[x] + '">';
    }
    document.getElementById("right_resource_container").innerHTML = content;
}

function createChatMessageList(dataObject) {
    dataObject = JSON.parse(dataObject);
    var content = "";
    for (var x in dataObject) {
        content += "<tr>";
        content += "<td style='text-align: right; color: darkblue'>" + dataObject[x]['name'] + ":</td>";
        content += "<td style='font-size: 12px'>" + dataObject[x]['message'] + "</td>";
        content += "</tr>"
    }
    document.getElementById("chat_items").innerHTML = "<table class='chat-table'>" + content + "</table>";
}

function createKings(myPercent , enemyPercent) {
    var myImage = KING_PLAING;
    var enemyImage = myImage;
    if (myPercent >= 100 && enemyPercent < 100) {
        myImage = KING_WON;
        enemyImage = KING_LOST;
    } else if (myPercent < 100 && enemyPercent >= 100) {
        myImage = KING_LOST;
        enemyImage = KING_WON;
    } else if (myPercent > 0 && enemyPercent <= 0) {
        myImage = KING_WON;
        enemyImage = KING_LOST;
    } else if (myPercent <= 0 && enemyPercent > 0) {
        myImage = KING_LOST;
        enemyImage = KING_WON;
    }

    document.getElementById("left_king").innerHTML =
        '<img src="'+ myImage +'" width="140px" height="140px"'
        + 'style="-webkit-transform: scaleX(-1); transform: scaleX(-1);">'
        + '<div class="pedestal-left" style="height: '+ (20 + myPercent * 3) +'px"></div>';

    document.getElementById("right_king").innerHTML =
        '<img src="' + enemyImage + '" width="140px" height="140px">'
        + '<div class="pedestal-right" style="height: '+ (20 + enemyPercent * 3) +'px"></div>';
}

function createAccountInfo(dataObject) {
    dataObject = JSON.parse(dataObject);
    var content = dataObject['user'] != undefined ? "User: " + dataObject['user']['name'] : "";
    content += " / " + (dataObject['room'] != undefined ? "Current Room: "
        + dataObject['room']['name'] + " (" + dataObject['room']['description'] + ")" : "");
    document.getElementById("accountInfo").innerHTML = content;
}
