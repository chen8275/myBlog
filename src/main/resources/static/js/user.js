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
    var username = $('#username');
    var phone = $('#phone');
    var trueName = $('#trueName');
    var birthday = $('#birthday');
    var gender = $('#genderTable input');
    var email = $('#email');
    var personalBrief = $('#personalBrief');
    $('#savePersonalDateBtn').click(function () {
        
        var usernameValue = username.val();
        var genderValue = "male";
        console.log(usernameValue);
        console.log(genderValue);
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
                url:'../user/savePersonalDate',
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
                    alert("yes");
                    if(data['errcode'] == 404){
                        $.get("/login",function(data,status,xhr){
                            window.location.replace("/front/login");
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



//填充用户评论
    function putInCommentInfo(date) {
        var comment = $('.comment');
        comment.empty();
        if(date['result'].length == 0){
            comment.append($('<div class="noComment">' +
                '你还没有任何评论哦' +
                '</div>'));
        } else {
            var amList = $('<ul class="am-list"></ul>');
            $.each(date['result'], function (index, obj) {
                amList.append($('<li class="am-g am-list-item-dated">' +
                    '<a target="_blank" href="/findArticle?articleId=' + obj['articleId'] + '&originalAuthor=' + obj['originalAuthor'] + '" style="padding: 5px 0 2px 0" class="leaveMessageTitle am-list-item-hd">' + obj['articleTitle'] + '</a>' +
                    '<span class="am-list-date" style="color: #a7baaa">' + obj['commentDate'] + '</span>' +
                    '<div class="leaveMessageContent">' +
                    obj['answerer'] + '：' +obj['commentContent'] +
                    '</div>' +
                    '<span class="reply"><span class="replyNum">' + obj['replyNum'] + '</span>个回复</span>' +
                    '</li>'))
            });
            var amListNewsBd = $('<div class="am-list-news-bd"></div>');
            amListNewsBd.append(amList);
            amListNewsBd.append($('<div class="my-row" id="page-father">' +
                '<div id="commentPagination">' +
                '<ul class="am-pagination  am-pagination-centered">' +
                '<li class="am-disabled"><a href="#">&laquo; 上一页</a></li>' +
                '<li class="am-active"><a href="#">1</a></li>' +
                '<li><a href="#">2</a></li>' +
                '<li><a href="#">3</a></li>' +
                '<li><a href="#">4</a></li>' +
                '<li><a href="#">5</a></li>' +
                '<li><a href="#">下一页 &raquo;</a></li>' +
                '</ul>' +
                '</div>' +
                '</div>'));
            comment.append(amListNewsBd);
        }
    }
//填充用户留言
    function putInLeaveMessageInfo(data) {
        var userLeaveMessage = $('.userLeaveMessage');
        userLeaveMessage.empty();
        if(data['result'].length == 0){
            userLeaveMessage.append($('<div class="noLeaveMessage">' +
                '你还没有任何留言哦' +
                '</div>'))
        } else {
            var amList = $('<ul class="am-list"></ul>');
            $.each(data['result'], function (index, obj) {
                amList.append($('<li class="am-g am-list-item-dated">' +
                    '<a target="_blank" href="/' + obj['pageName'] + '" class="leaveMessageTitle am-list-item-hd ">' + obj['answerer'] + "：" + obj['leaveMessageContent'] + '</a>' +
                    '<span class="am-list-date">' + obj['leaveMessageDate'] + '</span>' +
                    '</li>'));
            })
            var amListNewsBd = $('<div class="am-list-news-bd"></div>');
            amListNewsBd.append(amList);
            amListNewsBd.append($('<div class="my-row" id="page-father">' +
                '<div id="leaveMessagePagination">' +
                '<ul class="am-pagination  am-pagination-centered">' +
                '<li class="am-disabled"><a href="">&laquo; 上一页</a></li>' +
                '<li class="am-active"><a href="">1</a></li>' +
                '<li><a href="">2</a></li>' +
                '<li><a href="">3</a></li>' +
                '<li><a href="">4</a></li>' +
                '<li><a href="">5</a></li>' +
                '<li><a href="">下一页 &raquo;</a></li>' +
                '</ul>' +
                '</div>' +
                '</div>'));
            userLeaveMessage.append(amListNewsBd);
        }
    }



});