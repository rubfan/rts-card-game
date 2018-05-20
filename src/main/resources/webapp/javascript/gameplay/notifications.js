var notificationList = {};

function createNotificationList(dataObject) {
    notificationList = JSON.parse(dataObject);
    console.log(notificationList);
    var content = "";
    var index = 0.5;
    for (var i in notificationList) {
        const id = "notification" + i;
        content += '<div id="' + id + '" class="notification" style="animation: fade 8s ' + index + 's ease">';
        content +=      '<div style="font-size: 25px; color: #0055ff">' + notificationList[i]['name'] + '</div><br>';
        content +=      '<b>' + notificationList[i]['description'] + '</b>';
        content += '</div>';
        index += 0.5;
    }
    document.getElementById("notification_container").innerHTML = content;
    setTimeout(function () {
        document.getElementById("notification_container").innerHTML = '';
    }, index * 1000 + 8000);
}

