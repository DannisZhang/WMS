/**
 * Created by deng.zhang on 2014/11/19.
 */
var deletingDeptId = -1;
$(function () {
    //initPanel();
    initDatagrid();
    initDialog();
    initWindow();
    initEditDepartmentDialog();

    $("#delete-dept-btn").click(function () {
        var rows = $('#department-datagrid').datagrid('getChecked');
        if (rows.length == 0) {
            return;
        }
        var ids = [];
        $.each(rows, function (i, row) {
            ids.push(row.id);
        });
        $.post('../department/deleteDepartmentsByIds.json', {ids: ids.join(",")}, function (result) {
            alert(result.message);
            $('#department-datagrid').datagrid('reload');
        });
    });
});

function initPanel() {
    $('#department-management-panel').panel({
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
            {field: "establishedDate", title: "成立日期", align: "center", width: 120, fixed: true},
            {field: "createdOn", title: "创建时间", align: "center", width: 130, fixed: true},
            {field: "createdBy", title: "创建者", align: "center", width: 100, fixed: true},
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
        handler:function(){
            $("#add-department-window").window("open");
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

    $("#department-datagrid").datagrid({
        url: "../department/queryByPage.json",
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

function initDialog() {
    $("#delete-Department-dialog").dialog({
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
                    url: "../department/deleteDepartmentById.json",
                    data: {deptId: deletingDeptId},
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        $("#department-datagrid").datagrid("reload");
                    },
                    error: function (result) {
                        alert("删除失败");
                    }
                });
                $("#delete-Department-dialog").dialog("close");
            }
            },
            {
                text: '不是', iconCls: 'icon-no', handler: function () {
                $("#delete-Department-dialog").dialog("close");
            }
            }
        ]
    });
}

function initWindow() {
    var $addDepartmentWindow = $("#add-department-window");
    $addDepartmentWindow.window({
        title:"创建部门",
        width:500,
        height:450,
        modal:true
    });
    $addDepartmentWindow.window("close");
}

function initEditDepartmentDialog() {
    $("#edit-department-dialog").dialog({
        title:"修改部门",
        width:500,
        height:450,
        closed:true,
        cache:false,
        modal:true,
        buttons:"#dialog-buttons"
    });
}

function detail(event, deptId) {
    event.stopPropagation();
    alert("详情");
}

function edit(event, deptId) {
    event.stopPropagation();
    $("#edit-department-dialog").dialog("open");
}

function deleteDeptById(event, deptId) {
    event.stopPropagation();
    deletingDeptId = deptId;
    $("#delete-Department-dialog").dialog("open");
}

function saveDepartment() {
    var $addDepartmentWindow = $('#add-department-window');
    var params = {};
    params.cnName = $addDepartmentWindow.find('input[id="cnName"]').val();
    params.enName = $addDepartmentWindow.find('input[id="enName"]').val();
    params.location = $addDepartmentWindow.find('input[id="location"]').val();
    params.establishedDate = $addDepartmentWindow.find('#establishedDate').datebox('getValue');
    params.parentId = $addDepartmentWindow.find('#parent').combobox('getValue');
    params.managerId = $addDepartmentWindow.find('#manager').combobox('getValue');
    params.remark = $addDepartmentWindow.find('#remark').textbox('getValue');

    console.log(params)
    $.ajax({
        url:'../department/add.json',
        method:'post',
        data:params,
        async:false,
        success: function (result) {
            alert(result.message);
            $('#add-department-window').dialog('close');
            $('#department-datagrid').datagrid('reload');
        }
    });
}
