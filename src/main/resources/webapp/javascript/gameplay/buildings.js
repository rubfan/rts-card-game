var buildingFullList = {};

const IMG_BUILDINGS_URL = {
    "1": "images/buildings/granary_building.png", // Амбар
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
    "22": "images/buildings/ziggurat_building.png", // Зиккурат
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
        content +=  '<button class="glow-effect building-button"'+
                        ' onmousemove="prepareBuildingTooltip(' + id + '); showTooltip(event)"' +
                        ' onmouseout="hideTooltip()">' +
                        '<img class="building-img" src="' + IMG_BUILDINGS_URL[buildingFullList[id]['buildingDto']['id']] + '">' +
                        '<span class="building-text">' + buildingFullList[id]['buildingDto']['name'].split('_').join(' ') + '</span>' +
                        '<span class="big-text-number">' + accountBuildingList[i]['number'] + '</span>' +
                    '</button>';
    }
    document.getElementById("building_items").innerHTML = content;
}

function createEnemyBuildingList(dataObject) {
    var accountBuildingList = JSON.parse(dataObject);
    var content = "";
    for (var i in accountBuildingList) {
        var id = accountBuildingList[i]['buildingId'];
        content +=  '<button class="glow-effect building-button"'+
                        ' onmousemove="prepareBuildingTooltip(' + id + '); showTooltip(event)"' +
                        ' onmouseout="hideTooltip()">' +
                        '<img class="building-img" src="' + IMG_BUILDINGS_URL[buildingFullList[id]['buildingDto']['id']] + '">' +
                        '<span class="building-text">' + buildingFullList[id]['buildingDto']['name'].split('_').join(' ') + '</span>' +
                        '<span class="big-text-number">' + accountBuildingList[i]['number'] + '</span>' +
                    '</button>';
    }
    document.getElementById("enemy_building_items").innerHTML = content;
}

function prepareBuildingTooltip(num) {
    var content = '';
    content += 'Building: ' + buildingFullList[num]['buildingDto']['name'].split('_').join(' ');
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