const POWER = "24";
var resourceFullList = {};
var resourcePerMin =[];
var resourceEnemyPerMin =[];
var lastDate = new Date();
var lastEnemyDate = new Date();

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
    createHtmlTableResources();
}

setInterval(function() {
    refreshResources();
    refreshEnemyResources();
}, 1000);

function refreshResources() {
    for (var i in resourcePerMin) {
        var id = resourcePerMin[i]['id'];
        var quantity = resourcePerMin[i]['quantity'];
        var perMin = resourcePerMin[i]['per_min'];
        var now = new Date().getTime();
        var delta = Math.abs(now - lastDate) / 1000;
        var resResult = Math.floor(quantity + perMin / 60 * delta).toString();
        document.getElementById("resource_quantity" + id).innerHTML = resResult;
    }
}

function refreshEnemyResources() {
    for (var i in resourceEnemyPerMin) {
        var id = resourceEnemyPerMin[i]['id'];
        var quantity = resourceEnemyPerMin[i]['quantity'];
        var perMin = resourceEnemyPerMin[i]['per_min'];
        var now = new Date().getTime();
        var delta = Math.abs(now - lastEnemyDate) / 1000;
        var resResult = Math.floor(quantity + perMin / 60 * delta).toString();
        document.getElementById("resource_enemy_quantity" + id).innerHTML = resResult;
    }
}

function createHtmlTableResources() {
    var content = '<table class="resource-table">';
    var tdNum = 9;
    var resId = 1;
    for (var i = 0; i < 4; i++) {
        content += '<tr>';
        for (var j = 0; j < tdNum; j++) {
            const id = (resId + j);
            content += '<td><div id="p1res' + id + '" class="resource-item">';
            content += '<img class="resource-item-img" width="55px" height="55px"'
                + 'src="' + IMG_RESOURCES_URL[id.toString()] + '"'
                + ' onmousemove="prepareResourceTooltip(' + id + '); showTooltip(event)"'
                + ' onmouseout="hideTooltip()">';
            content += '<span id="resource_quantity' + id + '" class="small-text"></span>';
            content += '</div></td>';
        }
        content += '<td colspan="' + (i * 4 + 1) + '" style="width:100%"></td>';
        for (var k = 0; k < tdNum; k++) {
            const id = (resId + (tdNum - k - 1));
            content += '<td><div id="p2res' + id + '" class="resource-item">';
            content += '<img class="resource-item-img" width="55px" height="55px"'
                + 'src="' + IMG_RESOURCES_URL[id.toString()] + '"'
                + ' onmousemove="prepareResourceTooltip(' + id + '); showTooltip(event)"'
                + ' onmouseout="hideTooltip()">';
            content += '<span id="resource_enemy_quantity' + id + '" class="small-text"></span>';
            content += '</div></td>';
        }
        content += '</tr>';
        resId += tdNum;
        tdNum -= 2;
    }
    document.getElementById("resource_container").innerHTML = content + '</table>';
}

function createResourceList(dataObject) {
    var accountResourceList = JSON.parse(dataObject);
    resourcePerMin = [];
    var num = 1;
    for (var i in accountResourceList) {
        var id = accountResourceList[i]['resourceId'];
        var quantity = accountResourceList[i]['resourceNumber']; //['quantity'];
        var resourcePerMIn = accountResourceList[i]['resourcePerMIn'];
        resourcePerMin.push({id: id, quantity: quantity, per_min: resourcePerMIn});
        for (var j = num; j < id; j++) {
            document.getElementById("p1res" + j).style.visibility = 'hidden';
        }
        if (resourceFullList[id]['id'] == POWER) {
            myPower = quantity;
            createKings();
        }
        num = id + 1;
    }
    lastDate = new Date();
}

function createEnemyResourceList(dataObject) {
    var accountResourceList = JSON.parse(dataObject);
    resourceEnemyPerMin = [];
    var num = 1;
    for (var i in accountResourceList) {
        var id = accountResourceList[i]['resourceId'];
        var quantity = accountResourceList[i]['resourceNumber']; //['quantity'];
        var resourcePerMIn = accountResourceList[i]['resourcePerMIn'];
        resourceEnemyPerMin.push({id: id, quantity: quantity, per_min: resourcePerMIn});
        for (var j = num; j < id; j++) {
            document.getElementById("p2res" + j).style.visibility = 'hidden';
        }
        if (resourceFullList[id]['id'] == POWER) {
            enemyPower = quantity;
            createKings();
        }
        num = id + 1;
    }
    lastEnemyDate = new Date();
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