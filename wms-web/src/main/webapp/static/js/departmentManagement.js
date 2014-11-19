/**
 * Created by deng.zhang on 2014/11/19.
 */
$(function () {
    initDatagrid();
});

function initDatagrid() {
    var columns = [
        [
            {field: 'ck', checkbox: true},
            {field: "code", title: "编号", align: "center", width: 100},
            {field: "name", title: "名称", align: "center", width: 120},
            {field: "createdOn", title: "创建日期", align: "center", width: 120},
            {field: "createdBy", title: "创建者", align: "center", width: 120},
            {field: "remark", title: "备注", align: "center", width: 180},
            {
                field: "id", title: "操作", align: "center", width: 150,
                formatter: function (value, row, index) {
                    var edit = '<a class="datagrid-edit-button" style="height:20px;width:34px;text-align: center" href="#">修改</a>';
                    var del = '<a class="datagrid-delete-button" style="height:20px;width:34px;text-align: center;margin-left:5px;" href="#">删除</a>';
                    return edit + del;
                }
            }
        ]
    ];
    $("#department_datagrid").datagrid({
        url: "../department/queryByPage.do",
        pagination: true,
        loadMsg: '数据加载中...',
        columns: columns,
        toolbar: "#table_toolbar",
        onLoadSuccess: function (data) {
            var $editButton = $('.datagrid-edit-button');
            $editButton.linkbutton({plain: false});
            $editButton.addClass("c8");
            var $deleteButton = $('.datagrid-delete-button');
            $deleteButton.linkbutton({plain: false});
            $deleteButton.addClass("c5");
        }
    });
}
