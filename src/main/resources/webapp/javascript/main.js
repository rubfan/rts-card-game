/**
 * Created by ruslangramatic on 3/24/18.
 */
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