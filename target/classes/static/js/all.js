$(document).ready(function(){

    //反馈
    $('#feedbackFormBtn').click(function () {
        var feedbackFormContent = $('#feedbackFormContent');
        var feedbackFormQQ = $('#feedbackFormQQ');
        if (feedbackFormContent.val().length == 0){
            alert("反馈内容不能为空哦！");
        } else {
            $.ajax({
                type:'POST',
                url:'../feedback/insertFeedback',
                dataType:'json',
                data:{
                    feedbackContent:feedbackFormContent.val(),
                    contactInfo:feedbackFormQQ.val()
                },
                success:function (data) {
                        alert("反馈成功，我会尽快解决的！");
                       /* $('#modal-container-870181').css("display","none");*/
                },
                error:function () {
                }
            });
        }
    })
    
    
    
    
    
    
});

