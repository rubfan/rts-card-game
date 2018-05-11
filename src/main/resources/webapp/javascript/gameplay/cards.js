var cardFullList = {};

function prepareCardFullList(dataObject) {
    var jsonCardFullList = JSON.parse(dataObject);
    cardFullList = {};
    for (var num in jsonCardFullList) {
        cardFullList[jsonCardFullList[num]['cardDto']['id']] = jsonCardFullList[num];
    }
}

function createCardList(dataObject) {
    var accountCardList = JSON.parse(dataObject);
    var content = "";
    for (var i in accountCardList) {
        var id = accountCardList[i];
        content +=  '<button class="glow-effect card-button"'+
            ' onmousemove="prepareCardTooltip(' + id + '); showTooltip(event)"' +
            ' onmouseout="hideTooltip()"' +
            ' onclick="applyCard(' + id + ')">' +
            //'<img class="card-img" src="' + IMG_CARDS_URL[cardFullList[id]['cardDto']['id']] + '">' +
            '<span>' + cardFullList[id]['cardDto']['name'].split('_').join(' ') + '</span>' +
            '</button>';
    }
    document.getElementById("cards").innerHTML = content;
}

function applyCard(cardId) {
    restRequest("GET", REST_API_URL + "/account/" + getAccountId() + "/card/" + cardId + "/apply", function (dataObject) {
        playSoundFx('sounds/chicken_cluck_single.mp3');
    });
}

function prepareCardTooltip(num) {
    var content = 'Card: ' + cardFullList[num]['cardDto']['name'].split('_').join(' ');
    content += ' (' + cardFullList[num]['cardDto']['description'] + ')<br><br>';

    content += prepareP1BuildingQuantityDtoList(num);
    content += prepareP2BuildingQuantityDtoList(num);
    content += prepareP1ResourceQuantityDtoList(num);
    content += prepareP2ResourceQuantityDtoList(num);
    content += prepareP1UpgradeQuantityDtoList(num);
    content += prepareP2UpgradeQuantityDtoList(num);
    content += prepareNecessaryBuildingQuantityDtoList(num);
    content += prepareNecessaryUpgradeQuantityDtoList(num);

    document.getElementById("tooltip_component").innerHTML = content;
}

function prepareP1BuildingQuantityDtoList(num) {
    var content = '';
    if(cardFullList[num]['p1BuildingQuantityDtoList'] != undefined) {
        content += '<br>This card subtracts or adds you the following Buildings:' + '<br>';
        for (var numBld in cardFullList[num]['p1BuildingQuantityDtoList']) {
            content += '<img class="small-icon" src="' +
                IMG_BUILDINGS_URL[cardFullList[num]['p1BuildingQuantityDtoList'][numBld]['id']] + '">';
            content += ' ' + cardFullList[num]['p1BuildingQuantityDtoList'][numBld]['name'];
            content += ' (' + cardFullList[num]['p1BuildingQuantityDtoList'][numBld]['description'] + ') ';
            content += ' <b style="color: #7cff03">' +
                cardFullList[num]['p1BuildingQuantityDtoList'][numBld]['quantity'] + '</b><br>';
        }
    }
    return '';
}

function prepareP2BuildingQuantityDtoList(num) {
    var content = '';
    if(cardFullList[num]['p2BuildingQuantityDtoList'] != undefined) {
        content += '<br>This card takes the following Buildings from your opponent:' + '<br>';
        for (var numBld in cardFullList[num]['p2BuildingQuantityDtoList']) {
            content += '<img class="small-icon" src="' +
                IMG_BUILDINGS_URL[cardFullList[num]['p2BuildingQuantityDtoList'][numBld]['id']] + '">';
            content += ' ' + cardFullList[num]['p2BuildingQuantityDtoList'][numBld]['name'];
            content += ' (' + cardFullList[num]['p2BuildingQuantityDtoList'][numBld]['description'] + ') ';
            content += ' <b style="color: #ff0600">' +
                cardFullList[num]['p2BuildingQuantityDtoList'][numBld]['quantity'] + '</b><br>';
        }
    }
    return content;
}

function prepareP1ResourceQuantityDtoList(num) {
    var content = '';
    if(cardFullList[num]['p1ResourceQuantityDtoList'] != undefined) {
        content += '<br>This card subtracts or adds you the following Resources:' + '<br>';
        for (var numRes in cardFullList[num]['p1ResourceQuantityDtoList']) {
            content += '<img class="small-icon" src="' +
                IMG_RESOURCES_URL[cardFullList[num]['p1ResourceQuantityDtoList'][numRes]['id']] + '">';
            content += ' ' + cardFullList[num]['p1ResourceQuantityDtoList'][numRes]['name'];
            content += ' (' + cardFullList[num]['p1ResourceQuantityDtoList'][numRes]['description'] + ')';
            content += ' <b style="color: #7cff03">' +
                cardFullList[num]['p1ResourceQuantityDtoList'][numRes]['quantity'] + '</b><br>';
        }
    }
    return content;
}

function prepareP2ResourceQuantityDtoList(num) {
    var content = '';
    if(cardFullList[num]['p2ResourceQuantityDtoList'] != undefined) {
        content += '<br>This card takes the following Resources from your opponent:' + '<br>';
        for (var numRes in cardFullList[num]['p2ResourceQuantityDtoList']) {
            content += '<img class="small-icon" src="' +
                IMG_RESOURCES_URL[cardFullList[num]['p2ResourceQuantityDtoList'][numRes]['id']] + '">';
            content += ' ' + cardFullList[num]['p2ResourceQuantityDtoList'][numRes]['name'];
            content += ' (' + cardFullList[num]['p2ResourceQuantityDtoList'][numRes]['description'] + ')';
            content += ' <b style="color: #ff0600">' +
                cardFullList[num]['p2ResourceQuantityDtoList'][numRes]['quantity'] + '</b><br>';
        }
    }
    return content;
}

function prepareP1UpgradeQuantityDtoList(num) {
    var content = '';
    if(cardFullList[num]['p1UpgradeQuantityDtoList'] != undefined) {
        content += '<br>This card subtracts or adds you the following Upgrades:' + '<br>';
        for (var numBld in cardFullList[num]['p1UpgradeQuantityDtoList']) {
            content += ' ' + cardFullList[num]['p1UpgradeQuantityDtoList'][numBld]['name'];
            content += ' (' + cardFullList[num]['p1UpgradeQuantityDtoList'][numBld]['description'] + ')';
            content += ' <b style="color: #7cff03">' +
                cardFullList[num]['p1UpgradeQuantityDtoList'][numBld]['quantity'] + '</b><br>';
        }
    }
    return content;
}

function prepareP2UpgradeQuantityDtoList(num) {
    var content = '';
    if(cardFullList[num]['p2UpgradeQuantityDtoList'] != undefined) {
        content += '<br>This card takes the following Upgrades from your opponent:' + '<br>';
        for (var numBld in cardFullList[num]['p2UpgradeQuantityDtoList']) {
            content += ' ' + cardFullList[num]['p2UpgradeQuantityDtoList'][numBld]['name'];
            content += ' (' + cardFullList[num]['p2UpgradeQuantityDtoList'][numBld]['description'] + ')';
            content += ' <b style="color: #ff0600">' +
                cardFullList[num]['p2UpgradeQuantityDtoList'][numBld]['quantity'] + '</b><br>';
        }
    }
    return content;
}

function prepareNecessaryBuildingQuantityDtoList(num) {
    var content = '';
    if(cardFullList[num]['necessaryBuildingQuantityDtoList'] != undefined) {
        content += '<br>This card requires the following Buildings:' + '<br>';
        for (var numBld in cardFullList[num]['necessaryBuildingQuantityDtoList']) {
            content += '<img class="small-icon" src="' +
                IMG_BUILDINGS_URL[cardFullList[num]['necessaryBuildingQuantityDtoList'][numBld]['id']] + '">';
            content += ' ' + cardFullList[num]['necessaryBuildingQuantityDtoList'][numBld]['name'];
            content += ' (' + cardFullList[num]['necessaryBuildingQuantityDtoList'][numBld]['description'] + ')';
            content += ' <b style="color: #ff8000">' +
                cardFullList[num]['necessaryBuildingQuantityDtoList'][numBld]['quantity'] + '</b><br>';
        }
    }
    return content;
}

function prepareNecessaryUpgradeQuantityDtoList(num) {
    var content = '';
    if(cardFullList[num]['necessaryUpgradeQuantityDtoList'] != undefined) {
        content += '<br>This card requires the following Upgrades:' + '<br>';
        for (var numBld in cardFullList[num]['necessaryUpgradeQuantityDtoList']) {
            content += ' ' + cardFullList[num]['necessaryUpgradeQuantityDtoList'][numBld]['name'];
            content += ' (' + cardFullList[num]['necessaryUpgradeQuantityDtoList'][numBld]['description'] + ')';
            content += ' <b style="color: #ff8000">' +
                cardFullList[num]['necessaryUpgradeQuantityDtoList'][numBld]['quantity'] + '</b><br>';
        }
    }
    return content;
}
