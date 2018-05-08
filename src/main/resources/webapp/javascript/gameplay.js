/**
 * Created by ruslangramatic on 4/24/18.
 */
var hours = 1;
var countDownDate = (new Date().getTime()) + (hours * 60 * 60 * 1000);

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
    style.opacity = 1;
}
function hideTooltip() {
    document.getElementById("tooltip_component").style.visibility = 'hidden';
    document.getElementById("tooltip_component").style.opacity = 0;
    document.getElementById("tooltip_component").innerHTML = '';
}

function logout() {
    window.location.replace(RESOURCE_URL + '/login.html');
}

function startGameCycle() {
    restRequest('GET', REST_API_URL + '/account/info', prepareAccountInfo);

    restRequest("GET", REST_API_URL + "/building/product/list", prepareBuildingFullList);
    restRequest("GET", REST_API_URL + "/upgrade/product/list", prepareUpgradeFullList);
    restRequest("GET", REST_API_URL + "/resource/list", prepareResourceFullList);

    setInterval(function() {
        restRequest("GET", REST_API_URL + "/account/" + getAccountId() + "/building/list", createBuildingList);
        restRequest("GET", REST_API_URL + "/account/" + getAccountId() + "/upgrade/list", createUpgradeList);
        restRequest("GET", REST_API_URL + "/account/" + getAccountId() + "/resource/list", createResourceList);

        restRequest("GET", REST_API_URL + "/account/" + getEnemyAccountId() + "/building/list", createEnemyBuildingList);
        restRequest("GET", REST_API_URL + "/account/" + getEnemyAccountId() + "/upgrade/list", createEnemyUpgradeList);
        restRequest("GET", REST_API_URL + "/account/" + getEnemyAccountId() + "/resource/list", createEnemyResourceList);

        resourceQuantityList[POWER]['quantity'] = Math.floor(Math.random()*99);
        resourceEnemyQuantityList[POWER]['quantity'] = Math.floor(Math.random()*99);
        prepareKingImages();
        createKing();
        createEnemyKing();
    }, 2000);

    setInterval(function() {
        restRequest('GET', REST_API_URL + '/message/list', createChatMessageList);
    }, 5000);

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

    createCardList();//TODO:
}

