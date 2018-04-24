/**
 * Created by ruslangramatic on 4/24/18.
 */
function refreshButtonsStatus() {
    console.log("token: " + getCookie("token"));
    if(getCookie("token")){
        document.getElementById('logout').style.display = "inline-block";
        document.getElementById('login').style.display = "none";
        document.getElementById('new_user').style.display = "none";
        document.getElementById('lets_play').style.display = "inline-block";
        document.getElementById('name').style.display = "none";
        document.getElementById('password').style.display = "none";
    } else {
        document.getElementById('logout').style.display = "none";
        document.getElementById('login').style.display = "inline-block";
        document.getElementById('new_user').style.display = "inline-block";
        document.getElementById('lets_play').style.display = "none";
        document.getElementById('name').style.display = "inline-block";
        document.getElementById('password').style.display = "inline-block";
    }
}