function createChatMessageList(dataObject) {
    var messagesList = JSON.parse(dataObject);
    console.log(messagesList);
    var content = "";
    for (var msgIndex in messagesList) {
        content += '<tr>';
        content += '<td style="text-align: right; color: darkblue">' + messagesList[msgIndex]['from_account_id'] + ':</td>';
        content += '<td style="font-size: 12px">' + messagesList[msgIndex]['text'] + '</td>';
        content += '</tr>';
    }
    document.getElementById("chat_items").innerHTML = "<table class='chat-table'>" + content + "</table>";
}
