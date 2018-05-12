const POWER = "24";
var resourceFullList = {};

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
    "23": "images/resources/experience_resource.png",
    "24": "images/resources/power_resource.png"
};

const IMG_KING_URL = {
    won: "images/power_chicken_won.png",
    lost: "images/power_chicken_lost.png",
    plaing: "images/power_chicken_plaing.png"
};

var myImage = IMG_KING_URL.plaing, enemyImage = myImage;
var myPower = 0, enemyPower = 0;

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
        if((count%6) == 0){
            var num = accountResourceList.length - count;
            if (num >= 6) content += '<div style="grid-template-columns: auto auto auto auto auto auto" class="inner-container">';
            else if (num == 5) content += '<div style="grid-template-columns: auto auto auto auto auto 55px" class="inner-container">';
            else if (num == 4) content += '<div style="grid-template-columns: auto auto auto auto 55px 55px" class="inner-container">';
            else if (num == 3) content += '<div style="grid-template-columns: auto auto auto 55px 55px 55px" class="inner-container">';
            else if (num == 2) content += '<div style="grid-template-columns: auto auto 55px 55px 55px 55px" class="inner-container">';
            else if (num == 1) content += '<div style="grid-template-columns: auto 55px 55px 55px 55px 55px" class="inner-container">';
        }
        var id = accountResourceList[i]['resourceId'];
        content += '<div class="resource-item">';
        content += '<img class="resource-item-img" width="55px" height="55px" src="'
            + IMG_RESOURCES_URL[resourceFullList[id]['id'].toString()] + '"' +
            ' onmousemove="prepareResourceTooltip(' + id + '); showTooltip(event)"' +
            ' onmouseout="hideTooltip()">';
        content += '<span class="small-text">' + accountResourceList[i]['quantity'] + '</span>';
        count++;
        if((count%6) == 0) content += '</div>';
        content += '</div>';
        if (resourceFullList[id]['id'] == POWER) {
            myPower = accountResourceList[i]['quantity'];
            createKings();
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
        if((count%6) == 0){
            var num = accountResourceList.length - count;
            if (num >= 3) content += '<div style="grid-template-columns: auto auto auto auto auto auto" class="inner-container">';
            else if (num == 5) content += '<div style="grid-template-columns: auto auto auto auto auto 55px" class="inner-container">' +
                    '<div class="resource-item"></div><div class="resource-item"></div>';
            else if (num == 4) content += '<div style="grid-template-columns: auto auto auto auto 55px 55px" class="inner-container">' +
                 '<div class="resource-item"></div>';
            else if (num == 3) content += '<div style="grid-template-columns: auto auto auto 55px 55px 55px" class="inner-container">' +
                '<div class="resource-item"></div>';
            else if (num == 2) content += '<div style="grid-template-columns: auto auto 55px 55px 55px 55px" class="inner-container">' +
                '<div class="resource-item"></div>';
            else if (num == 1) content += '<div style="grid-template-columns: auto 55px 55px 55px 55px 55px" class="inner-container">' +
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
        if((count%6) == 0) content += '</div>';
        content += '</div>';
        if (resourceFullList[id]['id'] == POWER) {
            enemyPower = accountResourceList[i]['quantity'];
            createKings();
        }
    }
    content += '</div>';
    document.getElementById("right_resource_container").innerHTML = content;
}

function prepareResourceTooltip(num) {
    var content = '';
    content += '<b style="font-size: 20px; color: #ff8000">Resource: '
        + resourceFullList[num]['name'].split('_').join(' ') + '</b><br>';
    content += ' (' + resourceFullList[num]['description'] + ')';
    document.getElementById("tooltip_component").innerHTML = content;
}

function createKings() {
    if (myPower >= 100 && enemyPower < 100) {
        myImage = IMG_KING_URL.won;
        enemyImage = IMG_KING_URL.lost;
    } else if (myPower < 100 && enemyPower >= 100) {
        myImage = IMG_KING_URL.lost;
        enemyImage = IMG_KING_URL.won;
    } else if (myPower > 0 && enemyPower <= 0) {
        myImage = IMG_KING_URL.won;
        enemyImage = IMG_KING_URL.lost;
    } else if (myPower <= 0 && enemyPower > 0) {
        myImage = IMG_KING_URL.lost;
        enemyImage = IMG_KING_URL.won;
    }
    document.getElementById("left_king").innerHTML = getCylinder(myPower % 100)
        + '<img src="'+ myImage +'" class="left-chicken-img" style="bottom:'
        + (myPower % 100 * 3 - 8) + 'px">';
    document.getElementById("right_king").innerHTML = getCylinder(enemyPower % 100)
        + '<img src="' + enemyImage + '" class="right-chicken-img" style="bottom:'
        + (enemyPower % 100 * 3 - 8) + 'px">';
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