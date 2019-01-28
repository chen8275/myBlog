$(document).ready(function () {


    
    //发布悄悄话
    $('#userSayBtn').click(function () {
        
        var userSay = $('#userSay');
        if(userSay.val().length == 0){
            alert("你还没说两句呢");
            
    }else{
            $.ajax({
                type:'post',
                url:'../user/sendPrivateWord',
                dataType:'json',
                data:{
                    privateWord:userSay.val()
                },
                success:function (data) {
                    if(data['errcode'] == 404){
                        $.get("/login",function(data,status,xhr){
                            window.location.replace("/login");
                        });
                    } else {
                        if(data['errcode'] == 200){
                            alert("发布悄悄话成功");
                        }
                        userSay.val("");
                        /*getPrivateWordByPublisher(1);*/
                    }
                },
                error:function () {
                    alert("发布悄悄话失败");
                }
            });
        }
    });

    //生日选择器
    $('#birthday').datetimepicker({
        format: 'yyyy-mm-dd',
        weekStart: 1,
        autoclose: true,
        startView: 3,
        minView: "month",
        forceParse: false,
        language: 'zh-CN'

    });
    //左侧选项卡切换
    $('#basicSetting,#leaveMessage,#privateWord').css("display","none");
    $('.clickLi').click(function () {
        var flag = $(this).attr('class').substring(8);
        $('#personalDate,#basicSetting,#leaveMessage,#privateWord').css("display","none");
        $("#" + flag).css("display","block");
    });
    
    //安全设置更改密码
    $('#updateUsernameAndPassword').click(function () {
     
        var username = $('#username2');
        var password = $('#password');
        var password2 = $('#password2');
        if (password.val() != password2.val()){
            alert("密码不一致！！");
        } else{
            $.ajax({
                type:'post',
                url:'../user/updateUsernameAndPassword',
                dataType:'json',
                data:{
                    username:username.val(),
                    password:password.val()
                },
                success:function (data) {
                    alert("hello");
                    if(data['errcode'] == 404){
                        $.get("/login",function(data,status,xhr){
                            window.location.replace("/login");
                        });
                    } else {
                        if(data['errcode'] == 200){
                            alert("密码修改成功");
                        }
                        
                    }
                },
                error:function () {
                    alert("修改密码失败");
                }
            });
        }
    });



    //保存个人资料
    $('#savePersonalDateBtn').click(function () {
        alert("hello");
    })
  
    
    /*var username = $('#username');
    var phone = $('#phone');
    var trueName = $('#trueName');
    var birthday = $('#birthday');
    var gender = $('#genderTable input');
    var email = $('#email');
    var personalBrief = $('#personalBrief');
    savePersonalDateBtn.click(function () {
        alert("hello");
        var usernameValue = username.val();
        var genderValue = "male";
        if(usernameValue.length === 0){
            alert("昵称不能为空");
        } else if(!gender[0].checked && !gender[1].checked){
            alert("性别不能为空");
        } else {
            if(gender[0].checked){
                genderValue = "male";
            } else {
                genderValue = "female";
            }
            $.ajax({
                type:'post',
                url:'/savePersonalDate',
                dataType:'json',
                data:{
                    username:username.val(),
                    phone:phone.val(),
                    trueName:trueName.val(),
                    birthday:birthday.val(),
                    gender:genderValue,
                    email:email.val(),
                    personalBrief:personalBrief.val()
                    
                },
                success:function (data) {
                    alert("hello");
                    if(data['errcode'] == 404){
                        $.get("/login",function(data,status,xhr){
                            window.location.replace("/login");
                        });
                    } else {
                        if(data['errcode'] == 200){
                            alert("更改个人信息成功,重新登录后生效");
                            $.get("/login",function(data,status,xhr){
                                window.location.replace("/login");
                            });
                        } else if (data['errcode'] == 1003){
                            dangerNotice("该昵称已被占用");
                        }  else {
                            dangerNotice("更改个人信息失败");
                        }
                    }
                },
                error:function () {
                }
            });
        }
    });
*/





});