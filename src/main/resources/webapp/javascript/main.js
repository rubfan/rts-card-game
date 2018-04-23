const RESOURCE_URL = window.location.protocol + "//" + window.location.host;
const REST_API_URL = RESOURCE_URL + "/rest";

function restRequest(method, url, callback, requestBody) {
    var httpRequest = new XMLHttpRequest();
    httpRequest.open(method, url, false);
    httpRequest.setRequestHeader("Content-type", "application/json");
    httpRequest.setRequestHeader('Accept', 'application/json');
    httpRequest.onreadystatechange = function() {
        if (this.readyState == 4 && (this.status == 200 || this.status == 201)) {
            if(callback && this.responseText) {
                callback(this.responseText);
            } else if (callback) {
                callback();
            }
        } else {
            console.log("status: " + this.status);
            console.log(this.responseText);
        }
    };
    switch(method) {
        case "GET": httpRequest.send(null); break;
        case "POST":
            console.log(requestBody);
            var json = JSON.stringify(requestBody);
            httpRequest.send(json);
            break;
    }
}

function jsonToTable(dataObject) {
    dataObject = JSON.parse(dataObject);
    console.log(dataObject);
    var table = "<table class='info-table'>";
    var tbody = "";
    var theader = "";
    for (var x in dataObject) {
        if(!theader) {
            theader += "<tr>";
            for (var prop in dataObject[x]) {
                theader += "<th>" + prop + "</th>";
            }
            theader += "</tr>"
        }
        tbody += "<tr>";
        for (var prop in dataObject[x]) {
            tbody += "<td>" + dataObject[x][prop] + "</td>";
        }
        tbody += "</tr>"
    }
    table += theader + tbody + "</table>";
    document.getElementById("responseText").innerHTML = table;
}

function jsonToString(dataObject) {
    console.log("==========");
    console.log(dataObject);
    document.getElementById("responseText").innerHTML = JSON.stringify(dataObject);
}

function getCookie(key) {
    var match = document.cookie.match(new RegExp(key + '=([^;]+)'));
    if (match) return match[1];
    return null;
}
function removeCookie(key) {
    document.cookie = key + "=";
}
function setCookie(key, value) {
    document.cookie = key + "=" + value;
}