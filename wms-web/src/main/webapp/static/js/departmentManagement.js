/**
 * Created by deng.zhang on 2014/11/19.
 */
var deletingDeptId = -1;
$(function () {
    //initPanel();
    initDatagrid();
    initDialog();
    //initWindow();

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
            add();
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

function initDialog() {
    $("#edit-department-dialog").dialog({
        title:"新建部门",
        width:500,
        height:450,
        closed:true,
        cache:false,
        modal:true,
        buttons:"#dialog-buttons"
    });
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

function add() {
    clearEditDepartmentForm();
    $("#edit-department-dialog").dialog({title:"添加部门"}).dialog("open");
}

function detail(event, deptId) {
    event.stopPropagation();
    alert("详情");
}

function clearEditDepartmentForm() {
    var $editDepartmentDialog = $("#edit-department-dialog").dialog();
    $editDepartmentDialog.find("#cnName").textbox("setValue","");
    $editDepartmentDialog.find("#enName").textbox("setValue","");
    $editDepartmentDialog.find("#location").textbox("setValue","");
    $editDepartmentDialog.find("#remark").textbox("setValue","");
}

function deleteDeptById(event, deptId) {
    event.stopPropagation();
    deletingDeptId = deptId;
    $("#delete-Department-dialog").dialog("open");
}

function editDepartment() {
    var $editDepartmentDialog = $("#edit-department-dialog");
    var params = {};
    params.cnName = $editDepartmentDialog.find("#cnName").textbox("getValue");
    params.enName = $editDepartmentDialog.find("#enName").textbox("getValue");
    params.location = $editDepartmentDialog.find("#location").textbox("getValue");
    params.establishedDate = $editDepartmentDialog.find("#establishedDate").datebox('getValue');
    params.parentId = $editDepartmentDialog.find("#parent").combobox('getValue');
    params.managerId = $editDepartmentDialog.find("#manager").combobox('getValue');
    params.remark = $editDepartmentDialog.find("#remark").textbox('getValue');

    var departmentId = $editDepartmentDialog.find("input[type='hidden'][id='departmentId']").val();
    var url = "../department/add.json";
    if (departmentId != '-1') {
        url = "../department/update.json";
        params.id = departmentId;
    }
    $.ajax({
        url:url,
        method:'post',
        data:params,
        async:false,
        success: function (result) {
            alert(result.message);
            $editDepartmentDialog.dialog('close');
            $('#department-datagrid').datagrid('reload');
        }
    });
}

function edit(event, deptId) {
    event.stopPropagation();
    clearEditDepartmentForm();
    var $editDepartmentDialog = $("#edit-department-dialog").dialog({title:"修改部门"});
    $.ajax({
        url:"../department/queryById.json",
        method:"get",
        data:{deptId:deptId},
        dataType:"json",
        success: function (result) {
            if (result && result.data) {
                var department = result.data;
                $editDepartmentDialog.find("input[type='hidden'][id='departmentId']").val(department.id);
                $editDepartmentDialog.find("#cnName").textbox("setValue",department.cnName);
                $editDepartmentDialog.find("#enName").textbox("setValue",department.enName);
                if (department.parent) {
                    $editDepartmentDialog.find("#parent").combobox("setValue",department.parent.id);
                }
                if (department.manager) {
                    $editDepartmentDialog.find("#manager").combobox("select",department.manager.id);
                }
                $editDepartmentDialog.find("#location").textbox("setValue",department.location);
                $editDepartmentDialog.find("#establishedDate").datebox("setValue",department.establishedDate);
                $editDepartmentDialog.find("#remark").textbox("setValue",department.remark);
            }
        }
    });
    $editDepartmentDialog.dialog("open");
}