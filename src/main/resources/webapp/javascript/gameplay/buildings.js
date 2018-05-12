var buildingFullList = {};

const IMG_BUILDINGS_URL = {
    "1": {url:"images/buildings/granary_building.png", x: -10, y: 325}, // Амбар
    "2": {url:"images/buildings/chicken_house_building.png", x: 125, y: 335}, // Курятник
    "3": {url:"images/buildings/incubator_building.png", x: 250, y: 335}, // Инкубатор
    "4": {url:"images/buildings/cleaning_center_building.png", x: 57, y: 275}, // Клининг Центр
    "5": {url:"images/buildings/chicken_yard_building.png", x: 180, y: 275}, // Куринный Двор
    "6": {url:"images/buildings/cock_house_building.png", x: 300, y: 275}, // Петушатня
    "7": {url:"images/buildings/cock_barrack_building.png", x: -5, y: 230}, // Петушинные бараки
    "8": {url:"images/buildings/quarry_building.png", x: 170, y: 390}, // Каменоломня
    "9": {url:"images/buildings/hammer_stonecutter_building.png", x: 110, y: 210}, // Молото-Каменотес
    "10": {url:"images/buildings/throwing_school_building.png", x: 230, y: 210}, // Школа Метания
    "11": {url:"images/buildings/blast_furnace_building.png", x: 50, y: 190}, // Доменная печь
    "12": {url:"images/buildings/smithy_building.png", x: 300, y: 200}, // Кузница
    "13": {url:"images/buildings/axe_school_building.png", x: 165, y: 175}, // Школа Топора
    "14": {url:"images/buildings/wood_logger_building.png", x: 290, y: 410}, // Лесорубка
    "15": {url:"images/buildings/carpentry_building.png", x: 0, y: 150}, // Плотницкая
    "16": {url:"images/buildings/joinery-building.png", x: 100, y: 120}, // Столярка
    "17": {url:"images/buildings/alchemical_lab_building.png", x: 240, y: 130}, // Алхимическая лаба
    "18": {url:"images/buildings/armory_building.png", x: 0, y: 80}, // Оружейная
    "19": {url:"images/buildings/ballistic_base_building.png", x: 190, y: 70}, // Балистическая лаба
    "20": {url:"images/buildings/sanctuary_building.png", x: 80, y: 50}, // Алтарь
    "21": {url:"images/buildings/magic_school_building.png", x: 0, y: 0}, // Школа колдовства
    "22": {url:"images/buildings/ziggurat_building.png", x: 140, y: 0} // Зиккурат
};

function prepareBuildingFullList(dataObject) {
    var jsonBuildingFullList = JSON.parse(dataObject);
    buildingFullList = {};
    for (var num in jsonBuildingFullList) {
        buildingFullList[jsonBuildingFullList[num]['buildingDto']['id']] = jsonBuildingFullList[num];
    }
}

function createBuildingList(dataObject) {
    var accountBuildingList = JSON.parse(dataObject);
    var content = "";
    for (var i in accountBuildingList) {
        var id = accountBuildingList[i]['buildingId'];
        var building = IMG_BUILDINGS_URL[buildingFullList[id]['buildingDto']['id']];
        content += '<div class="building-selector" style="position: absolute;left: '
            + building['x'] + 'px; bottom: ' + building['y'] + 'px"'
            + ' onmousemove="prepareBuildingTooltip(' + id + '); showTooltip(event)"'
            + ' onmouseout="hideTooltip()">';
        content += '<img class="building-img" src="' + building['url'] + '">';
        //content += '<span class="building-text">' + buildingFullList[id]['buildingDto']['name'].split('_').join(' ') + '</span>'
        content += '<span class="big-text-number">' + accountBuildingList[i]['number'] + '</span>';
        content += '</div>';
    }
    document.getElementById("building_items").innerHTML = content;
}

function createEnemyBuildingList(dataObject) {
    var accountBuildingList = JSON.parse(dataObject);
    var content = "";
    for (var i in accountBuildingList) {
        var id = accountBuildingList[i]['buildingId'];
        var building = IMG_BUILDINGS_URL[buildingFullList[id]['buildingDto']['id']];
        content += '<div class="building-selector" style="position: absolute;right: '
            + building['x'] + 'px; bottom: ' + building['y'] + 'px"'
            + ' onmousemove="prepareBuildingTooltip(' + id + '); showTooltip(event)"'
            + ' onmouseout="hideTooltip()">';
        content += '<img class="building-img" src="' + building['url'] + '">';
        //content += '<span class="building-text">' + buildingFullList[id]['buildingDto']['name'].split('_').join(' ') + '</span>'
        content += '<span class="big-text-number">' + accountBuildingList[i]['number'] + '</span>';
        content += '</div>';
    }
    document.getElementById("enemy_building_items").innerHTML = content;
}

function prepareBuildingTooltip(num) {
    var content = '';
    content += '<b style="font-size: 20px; color: #ff8000">Building: '
        + buildingFullList[num]['buildingDto']['name'].split('_').join(' ') + '</b><br>';
    content += ' (' + buildingFullList[num]['buildingDto']['description'] + ')<br><br>';
    if(buildingFullList[num]['productDtoList'] != undefined) {
        content += '<br>This Building produces the following resources:' + '<br>';
        for (var numRes in buildingFullList[num]['productDtoList']) {
            var perSec = buildingFullList[num]['productDtoList'][numRes]['numPerSec'];
            content += '<img class="small-icon" src="' +
                IMG_RESOURCES_URL[buildingFullList[num]['productDtoList'][numRes]['id']] + '">';
            content += ' ' + buildingFullList[num]['productDtoList'][numRes]['name'];
            content += ' (' + buildingFullList[num]['productDtoList'][numRes]['description'] + ') ';
            content += perSec > 0 ? '<b style="color: #7cff03">+' : '<b style="color: #ff8000">';
            content += buildingFullList[num]['productDtoList'][numRes]['numPerSec'] + '</b> per minute <br>';
        }
    }
    document.getElementById("tooltip_component").innerHTML = content;
}