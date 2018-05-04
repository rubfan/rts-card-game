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

    document.getElementById("left_king").innerHTML = getCylinder(myPercent)
        + '<img src="'+ myImage +'" class="left-chicken-img" style="bottom:' + (myPercent * 3 - 8) + 'px">';

    document.getElementById("right_king").innerHTML = getCylinder(enemyPercent)
        + '<img src="' + enemyImage + '" class="right-chicken-img" style="bottom:' + (enemyPercent * 3 - 8) + 'px">';
}

function getCylinder(percent) {
    if (percent > 100) percent = 100;
    if (percent < 0) percent = 0;
    var cylinderSize = percent * 3;
    return  '<div class="bottom"></div>' +
            '<div class="middle" style="height:' + cylinderSize + 'px"></div>' +
            '<div class="top" style="top:' + (-cylinderSize - 15) + 'px;"></div>' +
            '<b class="power-percent" style="line-height:' + cylinderSize + 'px;">'+ percent + '%</b>';
}

function createAccountInfo(dataObject) {
    dataObject = JSON.parse(dataObject);
    var content = dataObject['user'] != undefined ? "User: " + dataObject['user']['name'] : "";
    content += " / " + (dataObject['room'] != undefined ? "Current Room: "
        + dataObject['room']['name'] + " (" + dataObject['room']['description'] + ")" : "");
    document.getElementById("accountInfo").innerHTML = content;
}

var hours = 1;
var countDownDate = (new Date().getTime()) + (hours * 60 * 60 * 1000);
var x = setInterval(function() {
    var now = new Date().getTime();
    var distance = countDownDate - now;
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);

    document.getElementById("count_down_time").innerHTML = minutes + ":" + seconds;
    if (distance < 0) {
        clearInterval(x);
        document.getElementById("count_down_time").innerHTML = "EXPIRED";
    }
}, 1000);

