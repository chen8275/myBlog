var tag="";

//添加所有标签
function putInAllTags(data) {
    var allTags = $('.allTags');
    allTags.empty();
    allTags.append($('<div class="allTagsTitle">' +
        '<h2 style="font-size: 20px">Tags</h2>' +
        '</div>'));
    allTags.append($('<div class="allTagsNum">' +
        '目前共计 <span class="num" style="font-size: 20px">' + data['tagsNum'] + '</span> 个标签' +
        '</div>'));
    var allTagsCloud = $('<div class="allTagsCloud categories-comment am-animation-slide-top"></div>');
    $.each(data['result'], function (index, obj) {
        allTagsCloud.append($('<a href="/tags?tag=' + obj['tagName'] + '" style="font-size:' + obj['tagSize'] + 'px">' + obj['tagName'] + '</a>'));
    });
    allTags.append(allTagsCloud);
}

