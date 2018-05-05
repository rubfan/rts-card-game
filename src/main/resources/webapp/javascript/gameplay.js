/**
 * Created by ruslangramatic on 4/24/18.
 */
var upgradeFullList = [];
var resourceFullList = [];
var accountInfo = {};
var hours = 1;
var countDownDate = (new Date().getTime()) + (hours * 60 * 60 * 1000);

const IMG_RESOURCES_URL = {
    "0": "images/resources/power_resource.png",
    "1": "images/resources/wheat_resource.png",
    "2": "images/resources/egg_resource.png",
    "4": "images/resources/droppings_resource.png",
    "5": "images/resources/worker_resource.png",
    "6": "images/resources/recruit_resource.png",
    "7": "images/resources/warrior_resource.png",
    "8": "images/resources/stone_resource.png",
    "9": "images/resources/hammer_resource.png",
    "11": "images/resources/metal_resource.png",
    "12": "images/resources/sword_resource.png",
    "13": "images/resources/axe_resource.png",
    "14": "images/resources/wood_resource.png",
    "16": "images/resources/spear_resource.png",
    "17": "images/resources/gunpowder_resource.png",
    "18": "images/resources/machine_gun_resource.png",
    "19": "images/resources/bazooka_resource.png",
    "20": "images/resources/mana_resource.png",
    "21": "images/resources/wizard_resource.png",
    "22": "images/resources/prophet_resource.png"
};

const IMG_BUILDINGS_URL = {
    "1": "Granary", // Амбар
    "2": "images/buildings/chicken_house_building.png", // Курятник
    "3": "images/buildings/incubator_building.png", // Инкубатор
    "4": "images/buildings/cleaning_center_building.png", // Клининг Центр
    "5": "images/buildings/chicken_yard_building.png", // Куринный Двор
    "6": "images/buildings/cock_house_building.png", // Петушатня
    "7": "images/buildings/cock_barrack_building.png", // Петушинные бараки
    "8": "images/buildings/quarry_building.png", // Каменоломня
    "9": "images/buildings/hammer_stonecutter_building.png", // Молото-Каменотес
    "10": "images/buildings/throwing_school_building.png", // Школа Метания
    "11": "images/buildings/blast_furnace_building.png", // Доменная печь
    "12": "images/buildings/smithy_building.png", // Кузница
    "13": "images/buildings/axe_school_building.png", // Школа Топора
    "14": "images/buildings/wood_logger_building.png", // Лесорубка
    "15": "images/buildings/carpentry_building.png", // Плотницкая
    "16": "images/buildings/joinery-building.png", // Столярка
    "17": "images/buildings/alchemical_lab_building.png", // Алхимическая лаба
    "18": "images/buildings/armory_building.png", // Оружейная
    "19": "images/buildings/ballistic_base_building.png", // Балистическая лаба
    "20": "images/buildings/sanctuary_building.png", // Алтарь
    "21": "images/buildings/magic_school_building.png", // Школа колдовства
    "22": "images/buildings/ziggurat_building.bmp", // Зиккурат
};


const IMG_KING_URL = {
    won: "images/power_chicken_won.png",
    lost: "images/power_chicken_lost.png",
    plaing: "images/power_chicken_plaing.png"
};

function showTooltip(event) {
    var style = document.getElementById("tooltip_component").style;
    style.left = style.right = style.top = style.bottom = null;
    if(event.clientX > window.innerWidth / 2) {
        style.right = window.innerWidth - event.clientX + "px";
    } else {
        style.left = event.clientX + "px";
    }
    if(event.clientY > window.innerHeight / 2) {
        style.bottom = window.innerHeight - event.clientY + "px";
    } else {
        style.top = event.clientY;
    }
    style.visibility = 'visible';
}
function hideTooltip() {
    document.getElementById("tooltip_component").style.visibility = 'hidden';
    document.getElementById("tooltip_component").innerHTML = '';
}

function prepareUpgradeFullList(dataObject) {
    upgradeFullList = JSON.parse(dataObject);
    console.log(upgradeFullList);
}

function prepareResourceFullList(dataObject) {
    resourceFullList = JSON.parse(dataObject);
    console.log(resourceFullList);
}

function prepareAccountInfo(dataObject) {
    accountInfo = JSON.parse(dataObject);
    console.log(accountInfo);
}

function createAccountInfo() {
    var content = accountInfo['user'] != undefined ? "User: " + accountInfo['user']['name'] : "";
    content += " / " + (accountInfo['room'] != undefined ? "Current Room: "
            + accountInfo['room']['name'] + " (" + accountInfo['room']['description'] + ")" : "");
    document.getElementById("accountInfo").innerHTML = content;
}

function createCardList() {
    var content = "";
    for (var x = 0; x < 50; x++) {
        content += '<button style="height: 150px; width: 130px" class="glow-effect" '
            +'onclick="restRequest("GET", REST_API_URL + "/cards/use", jsonToTable)">Card: ' + x + '</button>';
    }
    document.getElementById("cards").innerHTML = content;
}

function createBuildingList() {
    var content = "";
    for (var x = 0; x < 50; x++) {
        content += '<button style="height: 130px; width: 150px" class="glow-effect" '
            +'onclick="restRequest("GET", REST_API_URL + "/resources/list", jsonToTable)">Buildings<br>Upgrades: ' + x + '</button>';
    }
    document.getElementById("items").innerHTML = content;
}

function createUpgradeList() {
    var content = "";
    for (var num in upgradeFullList) {
        content += '<button class="glow-effect update-button tooltip-left" '+
                        'onmouseover="prepareUpgradeTooltip(' + num + '); showTooltip(event)"' +
                        'onmouseout="hideTooltip()">' +
                        upgradeFullList[num]['upgradeDto']['name'].split('_').join(' ') + '<br>' +
                    '</button>';
    }
    document.getElementById("items").innerHTML = content;
}

function prepareUpgradeTooltip(num) {
    var content = '';
    content += 'Upgrade: ' + upgradeFullList[num]['upgradeDto']['name'].split('_').join(' ');
    content += ' (' + upgradeFullList[num]['upgradeDto']['description'] + ')<br><br>';
    if(upgradeFullList[num]['resourceQuantityDtoList'] != undefined) {
        content += '<br>This Upgrade is improving production of following resources:' + '<br>';
        for (var numRes in upgradeFullList[num]['resourceQuantityDtoList']) {
            content += '* ' + upgradeFullList[num]['resourceQuantityDtoList'][numRes]['name'];
            content += ' (' + upgradeFullList[num]['resourceQuantityDtoList'][numRes]['description'] + ')';
            content += ' to ' +upgradeFullList[num]['resourceQuantityDtoList'][numRes]['quantity'] + '% <br>';
        }
    }
    if(upgradeFullList[num]['buildingDtoList'] != undefined) {
        content += '<br>For following buildings:' + '<br>';
        for (var numBld in upgradeFullList[num]['buildingDtoList']) {
            content += '* ' + upgradeFullList[num]['buildingDtoList'][numBld]['name'];
            content += ' (' + upgradeFullList[num]['buildingDtoList'][numBld]['description'] + ')<br>';
        }
    }
    document.getElementById("tooltip_component").innerHTML = content;
}

function createEnemyBuildingList() {
    var content = "";
    for (var x = 0; x < 50; x++) {
        content += '<button style="height: 130px; width: 150px" class="glow-effect" '
            +'onclick="restRequest("GET", REST_API_URL + "/resources/list", jsonToTable)">Buildings<br>Upgrades: ' + x + '</button>';
    }
    document.getElementById("enemy_items").innerHTML = content;
}

function createEnemyUpgradeList() {
    var content = "";
    for (var num in upgradeFullList) {
        content += '<button class="glow-effect update-button" '+
                        'onmouseover="prepareUpgradeTooltip(' + num + '); showTooltip(event)"' +
                        'onmouseout="hideTooltip()">' +
                        upgradeFullList[num]['upgradeDto']['name'].split('_').join(' ') + '<br>' +
                    '</button>';
    }
    document.getElementById("enemy_items").innerHTML = content;
}

function createResourceList() {
    var content = "";
    for (var num in resourceFullList) {
        content += '<img class="resource-item" src="' + IMG_RESOURCES_URL[resourceFullList[num]['id'].toString()] + '"' +
                        ' onmouseover="prepareResourceTooltip(' + num + '); showTooltip(event)"' +
                        ' onmouseout="hideTooltip()">';
    }
    document.getElementById("left_resource_container").innerHTML = content;
}

function prepareResourceTooltip(num) {
    var content = '';
    content += 'Resource: ' + resourceFullList[num]['name'].split('_').join(' ');
    content += ' (' + resourceFullList[num]['description'] + ')';
    document.getElementById("tooltip_component").innerHTML = content;
}

function createEnemyResourceList() {
    var content = "";
    for (var num in resourceFullList) {
        content += '<img class="resource-item" src="' + IMG_RESOURCES_URL[resourceFullList[num]['id'].toString()] + '"' +
            ' onmouseover="prepareResourceTooltip(' + num + '); showTooltip(event)"' +
            ' onmouseout="hideTooltip()">';
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
    var myImage = IMG_KING_URL.plaing;
    var enemyImage = myImage;
    if (myPercent >= 100 && enemyPercent < 100) {
        myImage = IMG_KING_URL.won;
        enemyImage = IMG_KING_URL.lost;
    } else if (myPercent < 100 && enemyPercent >= 100) {
        myImage = IMG_KING_URL.lost;
        enemyImage = IMG_KING_URL.won;
    } else if (myPercent > 0 && enemyPercent <= 0) {
        myImage = IMG_KING_URL.won;
        enemyImage = IMG_KING_URL.lost;
    } else if (myPercent <= 0 && enemyPercent > 0) {
        myImage = IMG_KING_URL.lost;
        enemyImage = IMG_KING_URL.won;
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

setInterval(function() {
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

function logout() {
    window.location.replace(RESOURCE_URL + '/login.html');
}

