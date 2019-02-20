
    $('.superAdminList .superAdminClick').click(function () {
        var flag = $(this).attr('class').substring(16);
        $('#statistics,#articleManagement,#articleComment,#articleCategories,#friendLink,#userFeedback,#privateWord').css("display","none");
        $("#" + flag).css("display","block");
    });

    // 失败消息盒
    function dangerNotice(notice) {
        $('.dangerNotice').html(notice);
        $('.dangerNoticeAlert').css("display","block");
        var closeNoticeBox = setTimeout(function () {
            $('.dangerNoticeAlert').css("display","none");
        },3000);
    }
    // 成功消息盒
    function successNotice(notice) {
        $('.successNotice').html(notice);
        $('.successNoticeAlert').css("display","block");
        var closeNoticeBox = setTimeout(function () {
            $('.successNoticeAlert').css("display","none");
        },3000);
    }


    //获取统计信息
    function getStatisticsInfo() {
        $.ajax({
            type:'get',
            url:'../superAdmin/getStatisticsInfo',
            dataType:'json',
            data:{
            },
            success:function (data) {
                $('.allVisitor').html(data['allVisitor']);
                $('.yesterdayVisitor').html(data['yesterdayVisitor']);
                $('.allUser').html(data['allUser']);
                $('.articleNum').html(data['articleNum']);
            },
            error:function () {
                alert("获取统计信息失败");
            }
        });
    }
    
    getStatisticsInfo();
    
    //填充文章管理
    function putInArticleManagement(data) {
        var articleManagementTable = $('.articleManagementTable');
        articleManagementTable.empty();
        $.each(data['result'], function (index, obj) {
            articleManagementTable.append($('<tr id="a' + obj['id'] + '"><td><a href="findArticle?articleId=' + obj['articleId'] + '&originalAuthor=' + obj['originalAuthor'] + '">' + obj['articleTitle'] + '</a></td><td>' + obj['publishDate'] + '</td><td>' + obj['articleCategories'] + '</td> <td><span class="am-badge am-badge-success">' + obj['visitorNum'] + '</span></td>' +
                '<td>' +
                '<div class="am-dropdown" data-am-dropdown>' +
                '<button class="articleManagementBtn articleEditor am-btn am-btn-secondary">编辑</button>' +
                '<button class="articleDeleteBtn articleDelete am-btn am-btn-danger">删除</button>' +
                '</div>' +
                '</td>' +
                '</tr>'));
        });
        articleManagementTable.append($('<div class="my-row" id="page-father">' +
            '<div id="articleManagementPagination">' +
            '<ul class="am-pagination  am-pagination-centered">' +
            '</ul>' +
            '</div>' +
            '</div>'));

        $('.articleManagementBtn').click(function () {
            var $this = $(this);
            var id = $this.parent().parent().parent().attr("id").substring(1);
            alert(id);
            window.location.replace("/front/editor?id=" + id);
        });
        
        $('.articleDeleteBtn').click(function () {
            var $this = $(this);
            deleteId = $this.parent().parent().parent().attr("id").substring(1);
            $('#deleteAlter').modal('open');
        })
    }
    
    //获得文章管理文章
    function getArticleManagement(currentPage) {
        $.ajax({
            type:'get',
            url:'../superAdmin/getArticleManagement',
            dataType:'json',
            data:{
                rows:10,
                pageNum:currentPage
            },
            success:function (data) {
                putInArticleManagement(data);
                scrollTo(0,0);//回到顶部

                //分页
                $("#articleManagementPagination").paging({
                    rows:data['pageInfo']['pageSize'],//每页显示条数
                    pageNum:data['pageInfo']['pageNum'],//当前所在页码
                    pages:data['pageInfo']['pages'],//总页数
                    total:data['pageInfo']['total'],//总记录数
                    callback:function(currentPage){
                        getArticleManagement(currentPage);
                    }
                });
            },
            error:function () {
                alert("获取文章信息失败");
            }
        });
    }

    //点击文章管理
    $('.superAdminList .articleManagement').click(function () {
        getArticleManagement(1);
    });

    //文章管理删除文章
    $('.sureArticleDeleteBtn').click(function () {
        $.ajax({
            type:'get',
            url:'../superAdmin/deleteArticle',
            dataType:'json',
            data:{
                id:deleteId
            },
            success:function (data) {
                if(data == 1){
                    successNotice("删除文章成功");
                    getArticleManagement(1);
                } else {
                    dangerNotice("删除文章失败")
                }
            },
            error:function () {
                alert("删除失败");
            }
        });
    })

    
    
    
    //填充反馈信息
    function putInAllFeedback(data) {
        var feedbackInfos = $('.feedbackInfos');
        feedbackInfos.empty();
        if(data['result'].length == 0){
            feedbackInfos.append('<div class="noFeedback">无反馈信息</div>');
        } else {
            $.each(data['result'], function (index, obj) {
                var feedbackInfo = $('<div class="feedbackInfo"></div>');
                feedbackInfo.append('<div class="feedbackInfoTitle">' +
                    '<span class="feedbackName">' + obj['person'] + '</span>' +
                    '<span class="feedbackTime">' + obj['feedbackDate'] + '</span>' +
                    '</div>');
                feedbackInfo.append('<div class="feedbackInfoContent">' +
                    '<span class="feedbackInfoContentWord">反馈内容：</span>' +
                    obj['feedbackContent'] +
                    '</div>');
                var feedbackInfoContact = $('<div class="feedbackInfoContact"></div>');
                if(obj['contactInfo'] !== ""){
                    feedbackInfoContact.append('<span class="contactInfo">联系方式：</span>' +
                        obj['contactInfo']);
                } else {
                    feedbackInfoContact.append('<span class="contactInfo">联系方式：</span>' + '无'
                    );
                }
                feedbackInfo.append(feedbackInfoContact);
                feedbackInfos.append(feedbackInfo);
            });
            feedbackInfos.append($('<div class="my-row" id="page-father">' +
                '<div id="feedbackPagination">' +
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
        }

    }

    //获得反馈信息
    function getAllFeedback(currentPage) {
        $.ajax({
            type:'get',
            url:'/getAllFeedback',
            dataType:'json',
            data:{
                rows:10,
                pageNum:currentPage
            },
            success:function (data) {
                putInAllFeedback(data);
                scrollTo(0,0);//回到顶部

                //分页
                $("#feedbackPagination").paging({
                    rows:data['pageInfo']['pageSize'],//每页显示条数
                    pageNum:data['pageInfo']['pageNum'],//当前所在页码
                    pages:data['pageInfo']['pages'],//总页数
                    total:data['pageInfo']['total'],//总记录数
                    callback:function(currentPage){
                        getAllFeedback(currentPage);
                    }
                });
            },
            error:function () {
                alert("获取反馈信息失败");
            }
        });
    }

    //点击反馈
    $('.superAdminList .userFeedback').click(function () {
        getAllFeedback(1);
    });