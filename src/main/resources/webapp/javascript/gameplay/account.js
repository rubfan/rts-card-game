var accountInfo = {};

function prepareAccountInfo(dataObject) {
    accountInfo = JSON.parse(dataObject);
    console.log(accountInfo);
    createAccountInfo();
}

function createAccountInfo() {
    var content = accountInfo['user'] != undefined ? "User: " + accountInfo['user']['name'] : "";
    content += " / " + (accountInfo['room'] != undefined ? "Current Room: "
            + accountInfo['room']['name'] + " (" + accountInfo['room']['description'] + ")" : "");
    document.getElementById("accountInfo").innerHTML = content;
}

function getAccountId() {
    return accountInfo['id'];
}

function getEnemyAccountId() {
    return accountInfo['id'];//TODO: we need to receive enemy account id from BE
}