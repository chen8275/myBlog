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
    
    
    
});