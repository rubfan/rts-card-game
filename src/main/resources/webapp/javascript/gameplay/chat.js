var lastTime = null;
function createChatMessageList(dataObject) {
    var messagesList = JSON.parse(dataObject);
    var content = "";
    var currentTime = null;
    for (var i in messagesList) {
        content += '<tr>';
        var fromAccId = messagesList[i]['fromAccountId'];
        if(fromAccId == getAccountId()){
            content += '<td width="100px" style="text-align: right; color: #138b00">' + getUserName() + ':</td>';
        } else if(fromAccId == getEnemyAccountId()){
            content += '<td width="100px" style="text-align: right; color: #c80c00">' + getEnemyUserName() + ':</td>';
        }
        content += '<td style="font-size: 12px">' + messagesList[i]['text'] + '</td>';
        content += '</tr>';
        currentTime = messagesList[i]['time'];
    }
    var chat = document.getElementById("chat_items");
    chat.innerHTML = "<table class='chat-table'>" + content + "</table>";
    if(currentTime != null && currentTime != lastTime) {
        document.getElementById("chat_container").scrollTop = document.getElementById("chat_container").scrollHeight;
    }
    lastTime = currentTime;
}

function clearMessageTextBox() {
    document.getElementById('message').value = "";
}

function onEnterMessageTextBox(event) {
    event.preventDefault();
    if (event.keyCode === 13) {
        document.getElementById("send_message").click();
    }
}
