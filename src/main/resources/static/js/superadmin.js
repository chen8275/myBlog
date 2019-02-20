
    $('.superAdminList .superAdminClick').click(function () {
        var flag = $(this).attr('class').substring(16);
        $('#statistics,#articleManagement,#articleComment,#articleCategories,#friendLink,#userFeedback,#privateWord').css("display","none");
        $("#" + flag).css("display","block");
    });

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
                    alert("删除文章成功");
                    getArticleManagement(1);
                } else {
                    alert("删除文章失败");
                }
            },
            error:function () {
                alert("删除失败");
            }
        });
    })