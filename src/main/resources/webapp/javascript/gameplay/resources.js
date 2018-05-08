const POWER = "24";
var resourceFullList = {};
var resourceQuantityList = {
    "24": {quantity: 100, persecond: 100}
};
var resourceEnemyQuantityList = {
    "24": {quantity: 50, persecond: 100}
};

const IMG_RESOURCES_URL = {
    "1": "images/resources/wheat_resource.png",
    "2": "images/resources/egg_resource.png",
    "3": "images/resources/chick_resource.png",
    "4": "images/resources/droppings_resource.png",
    "5": "images/resources/worker_resource.png",
    "6": "images/resources/recruit_resource.png",
    "7": "images/resources/warrior_resource.png",
    "8": "images/resources/stone_resource.png",
    "9": "images/resources/hammer_resource.png",
    "10": "images/resources/throwing_cock_resource.png",
    "11": "images/resources/metal_resource.png",
    "12": "images/resources/sword_resource.png",
    "13": "images/resources/axe_resource.png",
    "14": "images/resources/wood_resource.png",
    "15": "images/resources/archer_resource.png",
    "16": "images/resources/spear_resource.png",
    "17": "images/resources/gunpowder_resource.png",
    "18": "images/resources/machine_gun_resource.png",
    "19": "images/resources/bazooka_resource.png",
    "20": "images/resources/mana_resource.png",
    "21": "images/resources/wizard_resource.png",
    "22": "images/resources/prophet_resource.png",
    "24": "images/resources/power_resource.png"
};

const IMG_KING_URL = {
    won: "images/power_chicken_won.png",
    lost: "images/power_chicken_lost.png",
    plaing: "images/power_chicken_plaing.png"
};

var myImage = IMG_KING_URL.plaing, enemyImage = myImage;

function prepareResourceFullList(dataObject) {
    var jsonResourceFullList = JSON.parse(dataObject);
    resourceFullList = {};
    for (var num in jsonResourceFullList) {
        resourceFullList[jsonResourceFullList[num]['id']] = jsonResourceFullList[num];
    }
}

function createResourceList(dataObject) {
    var accountResourceList = JSON.parse(dataObject);
    var content = '';
    var count = 0;
    for (var i in accountResourceList) {
        if((count%3) == 0){
            var num = accountResourceList.length - count;
            if (num > 3) content += '<div style="grid-template-columns: auto auto auto" class="inner-container">';
            else if (num == 2) content += '<div style="grid-template-columns: auto auto auto 55px" class="inner-container">';
            else if (num == 1) content += '<div style="grid-template-columns: auto auto 55px auto 55px" class="inner-container">';
        }
        var id = accountResourceList[i]['resourceId'];
        content += '<div class="resource-item">';
        content += '<img class="resource-item-img" width="55px" height="55px" src="'
            + IMG_RESOURCES_URL[resourceFullList[id]['id'].toString()] + '"' +
            ' onmousemove="prepareResourceTooltip(' + id + '); showTooltip(event)"' +
            ' onmouseout="hideTooltip()">';
        content += '<span class="small-text">' + accountResourceList[i]['quantity'] + '</span>';
        count++;
        if((count%3) == 0) content += '</div>';
        content += '</div>';
        if (resourceFullList[id]['id'] == POWER) {
            prepareKingImages();
            createKing();
        }
    }
    content += '</div>';
    document.getElementById("left_resource_container").innerHTML = content;
}

function createEnemyResourceList(dataObject) {
    var accountResourceList = JSON.parse(dataObject);
    var content = '';
    var count = 0;
    for (var i in accountResourceList) {
        if((count%3) == 0){
            var num = accountResourceList.length - count;
            if (num > 3) content += '<div style="grid-template-columns: auto auto auto" class="inner-container">';
            else if (num == 2) content += '<div style="grid-template-columns: auto 55px auto 55px" class="inner-container">' +
                    '<div class="resource-item"></div><div class="resource-item"></div>';
            else if (num == 1) content += '<div style="grid-template-columns: auto 55px" class="inner-container">' +
                '<div class="resource-item"></div>';
        }
        var id = accountResourceList[i]['resourceId'];
        content += '<div class="resource-item">';
        content += '<img class="resource-item-img" width="55px" height="55px" src="'
            + IMG_RESOURCES_URL[resourceFullList[id]['id'].toString()] + '"' +
            ' onmousemove="prepareResourceTooltip(' + id + '); showTooltip(event)"' +
            ' onmouseout="hideTooltip()">';
        content += '<span class="small-text">' + accountResourceList[i]['quantity'] + '</span>';
        count++;
        if((count%3) == 0) content += '</div>';
        content += '</div>';
        if (resourceFullList[id]['id'] == POWER) {
            prepareKingImages();
            createKing();
        }
    }
    content += '</div>';
    document.getElementById("right_resource_container").innerHTML = content;
}

function prepareResourceTooltip(num) {
    var content = '';
    content += 'Resource: ' + resourceFullList[num]['name'].split('_').join(' ');
    content += ' (' + resourceFullList[num]['description'] + ')';
    document.getElementById("tooltip_component").innerHTML = content;
}

function prepareKingImages() {
    if (resourceQuantityList[POWER]['quantity'] >= 100 && resourceEnemyQuantityList[POWER]['quantity'] < 100) {
        myImage = IMG_KING_URL.won;
        enemyImage = IMG_KING_URL.lost;
    } else if (resourceQuantityList[POWER]['quantity'] < 100 && resourceEnemyQuantityList[POWER]['quantity'] >= 100) {
        myImage = IMG_KING_URL.lost;
        enemyImage = IMG_KING_URL.won;
    } else if (resourceQuantityList[POWER]['quantity'] > 0 && resourceEnemyQuantityList[POWER]['quantity'] <= 0) {
        myImage = IMG_KING_URL.won;
        enemyImage = IMG_KING_URL.lost;
    } else if (resourceQuantityList[POWER]['quantity'] <= 0 && resourceEnemyQuantityList[POWER]['quantity'] > 0) {
        myImage = IMG_KING_URL.lost;
        enemyImage = IMG_KING_URL.won;
    }
}

function createKing() {
    document.getElementById("left_king").innerHTML = getCylinder(resourceQuantityList[POWER]['quantity'] % 100)
        + '<img src="'+ myImage +'" class="left-chicken-img" style="bottom:'
        + (resourceQuantityList[POWER]['quantity'] % 100 * 3 - 8) + 'px">';
}

function createEnemyKing() {
    document.getElementById("right_king").innerHTML = getCylinder(resourceEnemyQuantityList[POWER]['quantity'] % 100)
        + '<img src="' + enemyImage + '" class="right-chicken-img" style="bottom:'
        + (resourceEnemyQuantityList[POWER]['quantity'] % 100 * 3 - 8) + 'px">';
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