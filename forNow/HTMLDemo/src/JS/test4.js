//小灯泡的变换
var temp = document.getElementById("lamp");
temp.onmouseover = function(){
    document.getElementById("lamp").src='../Image/lamp1.jpg';
}

temp.onmouseout = function () {
    document.getElementById("lamp").src='../Image/lamp.jpg';
}


//检查用户名
function checkUsername() {
    var username = usrname.value.trim();
    var usernameRule = /^\w{6,12}$/;

    if (!usernameRule.test(username)){
        document.getElementById("username_err").style.display = '';
        return false;
    }else{
        document.getElementById("username_err").style.display = 'none';
        return true;
    }
}

//检查密码
function checkPassword() {
    var password = passwordInput.value.trim();
    var passwordRule = /^\w{6,12}$/;

    if (!passwordRule.test(password)){
        document.getElementById("password_err").style.display = '';
        return false;
    }else{
        document.getElementById("password_err").style.display = 'none';
        return true;
    }
}

//检查手机号
function checkPhone() {
    var phoneNum = phoneNumInput.value.trim();
    var phoneNumRule = /^[1]\d{10}$/

    if (!phoneNumRule.test(phoneNum)){
        document.getElementById("phoneNum_err").style.display = '';
        return false;
    }else{
        document.getElementById("phoneNum_err").style.display = 'none';
        return true;
    }
}

var usrname = document.getElementById("username");
usrname.onblur = checkUsername;

var passwordInput = document.getElementById("password");
passwordInput.onblur = checkPassword;

var phoneNumInput = document.getElementById("phoneNum");
phoneNumInput.onblur = checkPhone;

//提交表单
var regForm = document.getElementById("reg-form");
regForm.onsubmit = function () {
    var flag = checkUsername() && checkPhone() && checkPassword();
    if (flag){
        document.getElementById("submit_err").style.display = 'none';
    }else{
        document.getElementById("submit_err").style.display = '';
    }
    return flag;
}



