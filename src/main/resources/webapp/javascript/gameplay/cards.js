var cardFullList = {};

function prepareCardFullList(dataObject) {
    var jsonCardFullList = JSON.parse(dataObject);
    cardFullList = {};
    for (var num in jsonCardFullList) {
        cardFullList[jsonCardFullList[num]['card']['id']] = jsonCardFullList[num];
    }
}

function createCardList() {
    var content = "";
    for (var x = 0; x < 50; x++) {
        content += '<button style="height: 150px; width: 130px" class="glow-effect" '
            +'onclick="restRequest("GET", REST_API_URL + "/cards/use", jsonToTable)">Card: ' + x + '</button>';
    }
    document.getElementById("cards").innerHTML = content;
}
