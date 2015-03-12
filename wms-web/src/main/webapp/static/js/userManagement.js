/**
 * Created by deng.zhang on 2014/11/19.
 */
var deletingDeptId = -1;
$(function () {
    initDatagrid();
    initUserDialog();

    $("#delete-dept-btn").click(function () {
        var rows = $('#user-datagrid').datagrid('getChecked');
        if (rows.length == 0) {
            return;
        }
        var ids = [];
        $.each(rows, function (i, row) {
            ids.push(row.id);
        });
        $.post('../user/deleteUsersByIds.json', {ids: ids.join(",")}, function (result) {
            alert(result.message);
            $('#user-datagrid').datagrid('reload');
        });
    });
});

function initPanel() {
    $('#user-management-panel').panel({
        fit:true
    });
}

function initDatagrid() {
    var columns = [
        [
            {field: 'ck', checkbox: true},
            {field: "cnName", title: "中文名称", align: "center", width: 120, fixed: true},
            {field: "enName", title: "英文名称", align: "center", width: 120, fixed: true},
            {field: "code", title: "编号", align: "center", width: 100, fixed: true},
            {field: "location", title: "部门地址", align: "center", width: 130, fixed: true},
            {field: "establishedDate", title: "成立日期", align: "center", width: 120, fixed: true},
            {field: "remark", title: "备注", align: "center", width: 200},
            {
                field: "id", title: "操作", align: "center", width: 150, fixed: true,
                formatter: function (value, row, index) {
                    var detail = '<a class="datagrid-detail-button" onclick="detail(event,' + row.id + ')"'
                        + ' style="height:20px;width:34px;text-align: center" href="javascript:void(0);">详情</a>';
                    var edit = '<a class="datagrid-edit-button" onclick="edit(event,' + row.id + ')"'
                        + ' style="height:20px;width:34px;text-align: center;margin-left:5px" href="javascript:void(0);">修改</a>';
                    var del = '<a class="datagrid-delete-button" onclick="deleteDeptById(event,' + row.id + ')"'
                        + ' style="height:20px;width:34px;text-align: center;margin-left:5px;" href="javascript:void(0);">删除</a>';
                    return detail + edit + del;
                }
            }
        ]
    ];

    var toolbar = [{
        text:'添加部门',
        iconCls:'icon-add',
        handler:function() {
            addUser();
        }
    },'-',{
        text:'删除部门',
        iconCls:'icon-remove',
        handler:function(){
            alert("删除部门");
        }
    },'-',{
        text:'批量导入',
        handler:function(){
            alert("批量导入");
        }
    },'-',{
        text:'导出EXCEL',
        handler:function(){
            alert("导出EXCEL");
        }
    }];

    $("#user-datagrid").datagrid({
        url: "user/queryByPage.json",
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

function initWindow() {
    var $addUserWindow = $("#add-user-window");
    $addUserWindow.window({
        title:"创建部门",
        width:500,
        height:450,
        modal:true
    });
    $addUserWindow.window("close");
}

function initUserDialog() {
    $.parser.parse("#userManagement");
    $("#edit-user-dialog").dialog({
        title:"新建部门",
        width:500,
        height:450,
        closed:true,
        cache:false,
        modal:true,
        buttons:"#user-dialog-buttons"
    });

    $("#delete-User-dialog").dialog({
        title: "删除部门",
        width: 320,
        height: 150,
        modal: true,
        closed: true,
        resizable: false,
        buttons: [
            {
                text: '是的', iconCls: 'icon-ok', handler: function () {
                $.ajax({
                    url: "../user/deleteUserById.json",
                    data: {deptId: deletingDeptId},
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        $("#user-datagrid").datagrid("reload");
                    },
                    error: function (result) {
                        alert("删除失败");
                    }
                });
                $("#delete-User-dialog").dialog("close");
            }
            },
            {
                text: '不是', iconCls: 'icon-no', handler: function () {
                $("#delete-User-dialog").dialog("close");
            }
            }
        ]
    });
}

function addUser() {
    clearEditUserForm();
    $("#edit-user-dialog").dialog({title:"添加部门"}).dialog("open");
}

function detail(event, deptId) {
    event.stopPropagation();
    alert("详情");
}

function clearEditUserForm() {
    var $editUserDialog = $("#edit-user-dialog").dialog();
    $editUserDialog.find("#cnName").textbox("setValue","");
    $editUserDialog.find("#enName").textbox("setValue","");
    $editUserDialog.find("#location").textbox("setValue","");
    $editUserDialog.find("#remark").textbox("setValue","");
}

function deleteDeptById(event, deptId) {
    event.stopPropagation();
    deletingDeptId = deptId;
    $("#delete-User-dialog").dialog("open");
}

function editUser() {
    var $editUserDialog = $("#edit-user-dialog");
    var params = {};
    params.cnName = $editUserDialog.find("#cnName").textbox("getValue");
    params.enName = $editUserDialog.find("#enName").textbox("getValue");
    params.location = $editUserDialog.find("#location").textbox("getValue");
    params.establishedDate = $editUserDialog.find("#establishedDate").datebox('getValue');
    params.parentId = $editUserDialog.find("#parent").combobox('getValue');
    params.managerId = $editUserDialog.find("#manager").combobox('getValue');
    params.remark = $editUserDialog.find("#remark").textbox('getValue');

    var userId = $editUserDialog.find("input[type='hidden'][id='userId']").val();
    var url = "../user/add.json";
    if (userId != '-1') {
        url = "../user/update.json";
        params.id = userId;
    }
    $.ajax({
        url:url,
        method:'post',
        data:params,
        async:false,
        success: function (result) {
            alert(result.message);
            $editUserDialog.dialog('close');
            $('#user-datagrid').datagrid('reload');
        }
    });
}

function edit(event, deptId) {
    event.stopPropagation();
    clearEditUserForm();
    var $editUserDialog = $("#edit-user-dialog").dialog({title:"修改部门"});
    $.ajax({
        url:"../user/queryById.json",
        method:"get",
        data:{deptId:deptId},
        dataType:"json",
        success: function (result) {
            if (result && result.data) {
                var user = result.data;
                $editUserDialog.find("input[type='hidden'][id='userId']").val(user.id);
                $editUserDialog.find("#cnName").textbox("setValue",user.cnName);
                $editUserDialog.find("#enName").textbox("setValue",user.enName);
                if (user.parent) {
                    $editUserDialog.find("#parent").combobox("setValue",user.parent.id);
                }
                if (user.manager) {
                    $editUserDialog.find("#manager").combobox("select",user.manager.id);
                }
                $editUserDialog.find("#location").textbox("setValue",user.location);
                $editUserDialog.find("#establishedDate").datebox("setValue",user.establishedDate);
                $editUserDialog.find("#remark").textbox("setValue",user.remark);
            }
        }
    });
    $editUserDialog.dialog("open");
}