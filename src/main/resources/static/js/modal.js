/**
 * 打开模态框的方法
 * @param url 视图路径
 * @param modalId 模态框id
 */
function openModal(url, modalId) {
    $("#"+modalId).empty();
    registerEvent(modalId);
    $.ajax({
        url: url,
        type: "GET",
        dataType: "html",
        success: function (data) {
            $("#"+modalId).append(data);
        }
    });
}

/**
 * 注册模态框关闭事件，关闭后刷新页面
 * @param modalId
 */
function registerEvent(modalId){
    $("#"+modalId).on("hidden.bs.modal",function(){
        parent.refreshTab();
    });
}
