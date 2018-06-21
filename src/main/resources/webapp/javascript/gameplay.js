/**
 * Created by ruslangramatic on 4/24/18.
 */
var hours = 1;
var countDownDate = (new Date().getTime()) + (hours * 60 * 60 * 1000);
var countDownLatchCounter = 0;

function playSoundFx(file) {
    var audio = new Audio(file);
    audio.play();
}

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
    style.zIndex = 9999;
}
function hideTooltip() {
    document.getElementById("tooltip_component").style.visibility = 'hidden';
    document.getElementById("tooltip_component").style.opacity = 0;
    document.getElementById("tooltip_component").innerHTML = '';
}

function logout() {
    window.location.replace(RESOURCE_URL + '/login.html');
}

function redirectToRooms() {
    window.location.replace(RESOURCE_URL + '/rooms.html');
}

//************************************************
//******************GAME STARTER******************
//************************************************
function startGame() {
    countDownLatchCounter = 0;
    restRequest("GET", REST_API_URL + "/account/info", function (dataObject) {
        countDownLatchCounter++;
        prepareAccountInfo(dataObject);
        if(getAccountId() == null) {
            redirectToRooms();
        } else {
            runGameCycle();
        }
    });
}
function runGameCycle() {
    //====INIT STATIC DATA(always the same)====
    restRequest("GET", REST_API_URL + "/building/product/list",
        function(dataObject){ countDownLatchCounter++; prepareBuildingFullList(dataObject) });
    restRequest("GET", REST_API_URL + "/upgrade/product/list",
        function(dataObject){ countDownLatchCounter++; prepareUpgradeFullList(dataObject) });
    restRequest("GET", REST_API_URL + "/resource/list",
        function(dataObject){ countDownLatchCounter++; prepareResourceFullList(dataObject) });
    restRequest("GET", REST_API_URL + "/card/product/list",
        function(dataObject){ countDownLatchCounter++; prepareCardFullList(dataObject) });

    //====CYCLE OF DYNAMIC DATA(always changing during gameplay)====
    var si = setInterval(function() {
        if(getAccountId() == null) {
            clearInterval(si);
            redirectToRooms();
        }
        if(getEnemyAccountId() == null) {
            restRequest('GET', REST_API_URL + "/account/info", prepareAccountInfo);
            return;
        }
        if(countDownLatchCounter != 5) {
            return;
        }
        restRequest("GET", REST_API_URL + "/account/" + getAccountId() + "/building/list", createBuildingList);
        restRequest("GET", REST_API_URL + "/account/" + getAccountId() + "/upgrade/list", createUpgradeList);
        //restRequest("GET", REST_API_URL + "/account/" + getAccountId() + "/resource/list", createResourceList);
        restRequest("GET", REST_API_URL + "/account/" + getAccountId() + "/resourcePerMin/list", createResourceList);
        restRequest("GET", REST_API_URL + "/account/" + getAccountId() + "/card/list", createCardList);
        restRequest("GET", REST_API_URL + "/account/" + getEnemyAccountId() + "/building/list", createEnemyBuildingList);
        restRequest("GET", REST_API_URL + "/account/" + getEnemyAccountId() + "/upgrade/list", createEnemyUpgradeList);
        //restRequest("GET", REST_API_URL + "/account/" + getEnemyAccountId() + "/resource/list", createEnemyResourceList);
        restRequest("GET", REST_API_URL + "/account/" + getEnemyAccountId() + "/resourcePerMin/list", createEnemyResourceList);
        restRequest("GET", REST_API_URL + "/message/list", createChatMessageList);
    }, 4000);

    setInterval(function() {
        restRequest('GET', REST_API_URL + "/account/" + getAccountId() + "/notification/recent", createNotificationList);
    }, 20000);

    var x = setInterval(function() {
        var now = new Date().getTime();
        var distance = countDownDate - now;
        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((distance % (1000 * 60)) / 1000);
        document.getElementById("count_down_time").innerHTML =
            (minutes.toString().length > 1 ? minutes : "0" + minutes) + ":" +
            (seconds.toString().length > 1 ? seconds : "0" + seconds);
        if (distance < 0) {
            clearInterval(x);
            document.getElementById("count_down_time").innerHTML = "EXPIRED";
        }
    }, 1000);
}

//########ENTER POINT#########
startGame();
//############################

