

    //填充文章
    function putInArticle(data) {
        $('.articles').empty();
        var articles = $('.articles');
        
        $.each(data, function (index, obj) {
            if(index != (data.length) - 1){
                var center2 = $('<div class="center2>">' +
                    '<h3>'+
                    obj['articleTitle']+
                    '</h3>' +
                    '<h5><strong> by <span>'+obj['author']+'</span> posted on <span>'+obj['publishDate']+
                    '</span> under <a>'+obj['articleType']+'</a></strong></h5>'+
                    '<br>'+obj['articleTabloid']+'</p>'+
                    '<h5><a href="/front/detail/'+obj['id']+'">阅读全文<span class="glyphicon glyphicon-chevron-right"></span></a></h5>' +
                    '<br><br>'+
                    '</div>');
                
                /*var center = $('<div class="center">' +
                    '<header class="article-header">' +
                    '<h1 itemprop="name">' +
                    '<a class="article-title" href="' + obj['thisArticleUrl'] + '" target="_blank">' + obj['articleTitle'] + '</a>' +
                    '</h1>' +
                    '<div class="article-meta row">' +
                    '<span class="articleType am-badge am-badge-success">' + obj['articleType'] + '</span>' +
                    '<div class="articlePublishDate">' +
                    '<i class="am-icon-calendar"><a class="linkColor" href="/archives?archive=' + obj['publishDate'] + '"> ' + obj['publishDate'] + '</a></i>' +
                    '</div>' +
                    '<div class="originalAuthor">' +
                    '<i class="am-icon-user"> ' + obj['originalAuthor'] + '</i>' +
                    '</div>' +
                    '<div class="categories">' +
                    '<i class="am-icon-folder"><a class="linkColor" href="/categories?category=' + obj['articleCategories'] + '"> ' + obj['articleCategories'] + '</a></i>' +
                    '</div>' +
                    '</div>' +
                    '</header>' +
                    '<div class="article-entry">' +
                    obj['articleTabloid'] +
                    '</div>' +
                    '<div class="read-all">' +
                    '<a href="' + obj['thisArticleUrl'] + '" target="_blank">阅读全文 <i class="am-icon-angle-double-right"></i></a>' +
                    '</div>' +
                    '<hr>' +
                    '<div class="article-tags">' +

                    '</div>' +
                    '</div>');*/
                
                articles.append(center2);
                
            }
        })

    }
    
    
    //首页文章分页请求
    function ajaxFirst(currentPage) {
        //加载时请求
        $.ajax({
            type: 'POST',
            url: '../article/myArticles',
            dataType: 'json',
            data: {
                rows:"5",
                pageNum:currentPage
            },
            success: function (data) {
                //放入数据
                putInArticle(data);
                scrollTo(0,0);//回到顶部
                //分页
                $("#pagination").paging({
                    rows:data[data.length-1]['pageSize'],//每页显示条数
                    pageNum:data[data.length-1]['pageNum'],//当前所在页码
                    pages:data[data.length-1]['pages'],//总页数
                    total:data[data.length-1]['total'],//总记录数
                    callback:function(currentPage){
                        ajaxFirst(currentPage);
                    }
                });
            },
            error: function () {
                alert("获得文章信息失败！");
            }
        });
    }

    ajaxFirst(1);
    
