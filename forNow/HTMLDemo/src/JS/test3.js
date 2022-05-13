function lampOn() {
    document.getElementById("lamp").src='../Image/lamp.jpg'
}

function  lampOff() {
    document.getElementById("lamp").src='../Image/lamp1.jpg'
}

var x = 1;
function change(){
    if (x%2 == 1){
        lampOn();
    }else{
        lampOff();
    }
    x++;
}

setInterval(change, 500);
