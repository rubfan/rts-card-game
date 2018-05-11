var accountInfo = {};
var userName = '';
var enemyName = '';
var accountId = '';
var enemyAccountId = '';

function prepareAccountInfo(dataObject) {
    accountInfo = JSON.parse(dataObject);
    userName = null;
    enemyName = null;
    accountId = null;
    enemyAccountId = null;
    if(accountInfo['id'] != undefined) {
        accountId = accountInfo['id'];
        if(accountInfo['room'] != undefined) {
            if(accountInfo['room']['account2'] != undefined && accountInfo['room']['account2'] != undefined ) {
                if(accountInfo['room']['account1']['id'] == accountId) {
                    enemyAccountId = accountInfo['room']['account2']['id'];
                    userName = accountInfo['room']['account1']['user']['name'];
                    enemyName = accountInfo['room']['account2']['user']['name'];
                } else if(accountInfo['room']['account2']['id'] == accountId) {
                    enemyAccountId = accountInfo['room']['account1']['id'];
                    userName = accountInfo['room']['account2']['user']['name'];
                    enemyName = accountInfo['room']['account1']['user']['name'];
                }
                createAccountInfo();
            }
        }
    }
}

function createAccountInfo() {
    var content = (accountInfo['room'] != undefined ? "Current Room: "
            + accountInfo['room']['name'] + " (" + accountInfo['room']['description'] + ")" : "");
    content += ' <b style="color: #7cff03">' + getUserName() + '</b> VS <b style="color: red">' + getEnemyUserName() + '</b>';
    document.getElementById("accountInfo").innerHTML = content;
}

function getAccountId() {
    return accountId;
}

function getEnemyAccountId() {
    return enemyAccountId;
}

function getUserName() {
    return userName;
}

function getEnemyUserName() {
    return enemyName;
}