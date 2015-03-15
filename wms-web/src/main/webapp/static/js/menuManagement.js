/**
 * Created by deng.zhang on 2014/11/19.
 */
var deletingMenuId = -1;
$(function () {
    initMenuDatagrid();
    initMenuDialog();

    $("#deleteMenuBtn").click(function () {
        var rows = $('#menuDatagrid').datagrid('getChecked');
        if (rows.length == 0) {
            return;
        }
        var ids = [];
        $.each(rows, function (i, row) {
            ids.push(row.id);
        });
        $.post('../menu/deleteMenusByIds.json', {ids: ids.join(",")}, function (result) {
            alert(result.message);
            $('#menuDatagrid').datagrid('reload');
        });
    });
});

function initMenuDatagrid() {
    var columns = [
        [
            {field: 'ck', checkbox: true},
            {field: "code", title: "菜单编码", align: "center", width: 100, fixed: true},
            {field: "name", title: "菜单名称", align: "center", width: 120, fixed: true},
            {field: "createdBy", title: "创建者", align: "center", width: 100, fixed: true},
            {field: "createdOn", title: "创建时间", align: "center", width: 120, fixed: true},
            {field: "description", title: "菜单描述", align: "center", width: 200},
            {
                field: "id", title: "操作", align: "center", width: 150, fixed: true,
                formatter: function (value, row, index) {
                    var detail = '<a class="datagrid-detail-button" onclick="viewMenuDetail(event,' + row.id + ')"'
                        + ' style="height:20px;width:34px;text-align: center" href="javascript:void(0);">详情</a>';
                    var edit = '<a class="datagrid-edit-button" onclick="editMenu(event,' + row.id + ')"'
                        + ' style="height:20px;width:34px;text-align: center;margin-left:5px" href="javascript:void(0);">修改</a>';
                    var del = '<a class="datagrid-delete-button" onclick="deleteMenuById(event,' + row.id + ')"'
                        + ' style="height:20px;width:34px;text-align: center;margin-left:5px;" href="javascript:void(0);">删除</a>';
                    return detail + edit + del;
                }
            }
        ]
    ];

    var toolbar = [{
        text:'添加菜单',
        iconCls:'icon-add',
        handler:function() {
            addMenu();
        }
    },'-',{
        text:'删除菜单',
        iconCls:'icon-remove',
        handler:function(){
            alert("删除菜单");
        }
    }];

    $("#menuDatagrid").datagrid({
        url: "menu/queryByPage.json",
        pagination: true,
        pageSize: 15,
        pageList: [10, 15, 20],
        loadMsg: '数据加载中...',
        columns: columns,
        fitColumns: true,
        toolbar: toolbar,
        onLoadSuccess: function () {
            var $detailButton = $('.datagrid-detail-button');
            $detailButton.linkbutton({plain: false});
            $detailButton.addClass("c1");
            var $editButton = $('.datagrid-edit-button');
            $editButton.linkbutton({plain: false});
            $editButton.addClass("c8");
            var $deleteButton = $('.datagrid-delete-button');
            $deleteButton.linkbutton({plain: false});
            $deleteButton.addClass("c5");
        }
    });
}

function initMenuDialog() {
    $.parser.parse("#menuManagement");
    $("#editMenuDialog").dialog({
        title:"添加菜单",
        width:500,
        height:450,
        closed:true,
        cache:false,
        modal:true,
        buttons:"#menuDialogButtons"
    });

    $("#deleteMenuDialog").dialog({
        title: "删除菜单",
        width: 320,
        height: 150,
        modal: true,
        closed: true,
        resizable: false,
        buttons: [
            {
                text: '是的', iconCls: 'icon-ok', handler: function () {
                $.ajax({
                    url: "../menu/deleteMenuById.json",
                    data: {deptId: deletingMenuId},
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        $("#menuDatagrid").datagrid("reload");
                    },
                    error: function (result) {
                        alert("删除失败");
                    }
                });
                $("#deleteMenuDialog").dialog("close");
            }
            },
            {
                text: '不是', iconCls: 'icon-no', handler: function () {
                $("#deleteMenuDialog").dialog("close");
            }
            }
        ]
    });
}

function addMenu() {
    clearEditMenuForm();
    $("#editMenuDialog").dialog({title:"添加菜单"}).dialog("open");
}

function viewMenuDetail(event, deptId) {
    event.stopPropagation();
    alert("详情");
}

function clearEditMenuForm() {
    $("#editMenuDialog").find("#editMenuFrom").form("clear");
}

function deleteMenuById(event, deptId) {
    event.stopPropagation();
    deletingMenuId = deptId;
    $("#deleteMenuDialog").dialog("open");
}

function saveMenu() {
    var $editMenuDialog = $("#editMenuDialog");

    var menuId = $editMenuDialog.find("input[name='menuId']").val();
    var url = "menu/add.json";
    if (menuId != '') {
        url = "menu/update.json";
    }

    $editMenuDialog.find("#editMenuFrom").form("submit",{
        url:url,
        success: function (result) {
            try {
                var jsonResult = $.parseJSON(result);
                if (jsonResult.status = 0) {
                    $.messager.alert("提示信息",jsonResult.message);
                    $('#menuDatagrid').datagrid('reload');
                } else {
                    $.messager.alert("提示信息",jsonResult.message,"warning");
                }
                $.messager.alert("提示信息",jsonResult.message);
            } catch (e) {
                $.messager.alert("系统异常","系统发生异常","warning");
            }
            clearEditMenuForm();
            $editMenuDialog.dialog('close');
        }
    });
}

function editMenu(event, deptId) {
    event.stopPropagation();
    clearEditMenuForm();
    var $editMenuDialog = $("#editMenuDialog").dialog({title:"修改菜单"});
    $.ajax({
        url:"menu/queryById.json",
        method:"get",
        data:{deptId:deptId},
        dataType:"json",
        success: function (result) {
            if (result && result.data) {
                var menu = result.data;
                $editMenuDialog.find("#editMenuFrom").form('load',{
                    cnName:menu.cnName,
                    enName:menu.enName,
                    parent:menu.parent ? menu.parent.id : '',
                    menuManager:menu.manager ? menu.manager.id : '',
                    location:menu.location,
                    establishedDate:menu.establishedDate,
                    remark:menu.remark,
                    menuId:menu.id
                });
            }
        }
    });
    $editMenuDialog.dialog("open");
}