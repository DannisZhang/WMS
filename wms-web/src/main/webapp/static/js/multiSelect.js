/**
 * Created by Dannis on 2014/11/20.
 */
var selectedItems1 = [];
var selectedItems2 = [];

function initMultiSelect(obj, dataOptions) {
    $(obj).css({
        "width": "400px",
        "font-size":"14px",
        "text-align": "center"
    });
    var label1 = "选择列一";
    var label2 = "选择列二";
    var label3 = "已选择列";
    if (dataOptions) {
        if (dataOptions.param1.label) {
            label1 = dataOptions.param1.label;
        }
        if (dataOptions.param2.label) {
            label2 = dataOptions.param2.label;
            label3 = "已选择" + label2;
        }
    }

    var labelRow = "<tr style='text-align:left'>"
        + "<td><label id='label1' for='search-input-1'>" + label1 + "</label></td>"
        + "<td></td>"
        + "<td><label id='label2' for='search-input-2'>" + label2 + "</label></td>"
        + "<td></td>"
        + "<td><label id='label3' for='selected-items'>" + label3 + "</label></td>"
        + "</tr>";

    var searchRow = "<tr style='text-align:left'>"
        + "<td><input id='search-input-1' type='text' class='form-control' style='width:124px;padding: 0 3px;'></td>"
        + "<td></td>"
        + "<td><input id='search-input-2' type='text' class='form-control' style='width:124px;padding: 0 3px;'></td>"
        + "<td></td>"
        + "<td></td>"
        + "</tr>";
    var selectRow = "<tr style='vertical-align:top'>"
        + "<td><select id='selectable-items-1' multiple='multiple' class='form-control' style='width:130px;height:220px;padding:0'></select></td>"
        + "<td style='vertical-align:middle'>"
        + "<button id='select-button-1' style='width:30px;height:22px;font-size:14px;line-height:12px;display:block'>--</button>"
        + "</td>"
        + "<td><select id='selectable-items-2' multiple='multiple' class='form-control' style='width:130px;height:220px;padding:0'></select></td>"
        + "<td style='vertical-align:middle'>"
        + "<button id='select-button-2' style='width:30px;height:22px;font-size:14px;line-height:12px;display:block'>>></button><br>"
        + "<button id='deselect-button' style='width:30px;height:22px;font-size:14px;line-height:12px;display:block'><<</button>"
        + "</td>"
        + "<td><select id='selected-items' multiple='multiple' class='form-control' style='width:130px;height:220px;padding:0'></select></td>"
        + "</tr>";

    $(obj).append(labelRow + searchRow + selectRow);
    if (dataOptions) {
        if (dataOptions.singleClickSelect) {
            $("select").find("option").click(function () {
                selectItem(this);
            });
        }
        if (dataOptions.linkage) {
            $("select[id='selectable-items-1']").on('change',function () {
                console.info($(this).find("option:selected"));
                //TODO:更新第二列数据
            });
        }
    }
    bindEventHandler();

}

function resetMultiSelect(obj, dataOptions) {
    var select1 = $("select[id='selectable-items-1']");
    var select2 = $("select[id='selectable-items-2']");
    select1.empty();
    select2.empty();

    var label1 = "选择列一";
    var label2 = "选择列二";
    var label3 = "已选择列";
    if (dataOptions) {
        if ('emptyData' == dataOptions.command) {
            return;
        }
        if (dataOptions.param1.label) {
            label1 = dataOptions.param1.label;
        }
        if (dataOptions.param2.label) {
            label2 = dataOptions.param2.label;
            label3 = "已选择" + label2;
        }
    }
    $(obj).find("label[id='label1']").text(label1);
    $(obj).find("label[id='label2']").text(label2);
    $(obj).find("label[id='label3']").text(label3);
    fillData(select1,dataOptions.param1.url,dataOptions.param1.method);
    fillData(select2,dataOptions.param2.url,dataOptions.param2.method);
}

function fillData(selectObj,url,method) {
    var data = [];
    $.ajax({
        url:url,
        type:method,
        async:false,
        success:function (result) {
            data = result;
        }
    });

    var select = $(selectObj);
    var options = "";
    for (var i = 0; i < data.length; i++) {
        options += "<option value='" + data[i].id + "'>" + data[i].name + "</option>"
    }
    select.append(options);
}

function selectItem(obj) {
    var select = $(obj).parent();
    if ("selectable-items-1" == select.attr('id')) {
        var existsIndex1 = $.inArray($(obj).val(), selectedItems1);
        if (existsIndex1 == -1) {//-1表示不存在
            selectedItems1.push($(obj).val());
        } else {
            selectedItems1.splice(existsIndex1, 1);
            $(obj).prop("selected", false);
        }
        for (var i = 0; i < selectedItems1.length; i++) {
            select.find("option[value='" + selectedItems1[i] + "']").prop("selected", true);
        }
    } else if ("selectable-items-2" == select.attr('id')) {
        var existsIndex2 = $.inArray($(obj).val(), selectedItems2);
        if (existsIndex2 == -1) {//-1表示不存在
            selectedItems2.push($(obj).val());
        } else {
            selectedItems2.splice(existsIndex2, 1);
            $(obj).prop("selected", false);
        }
        for (var j = 0; j < selectedItems2.length; j++) {
            select.find("option[value='" + selectedItems2[j] + "']").prop("selected", true);
        }
    }
}

/**
 * 绑定事件处理器
 */
function bindEventHandler() {
    //选择按钮绑定事件
    $("button[id='select-button-2']").click(function () {
        var select = $("select[id='selectable-items-2']");
        var selectedOptions = select.find("option:selected");
        for (var i = 0;i < selectedOptions.length;i++) {
            selectedOptions[i].style.display = 'none';
            $(selectedOptions[i]).prop("selected",false);
            $("select[id='selected-items']").append("<option value='" + $(selectedOptions[i]).val() + "'>" + $(selectedOptions[i]).text() + "</option>");
        }
    });

    //取消选择按钮绑定事件
    $("button[id='deselect-button']").click(function () {
        var select = $("select[id='selected-items']");
        var selectedOptions = select.find("option:selected");
        for (var i = 0;i < selectedOptions.length;i++) {
            $("select[id='selectable-items-2']").find("option[value='" + $(selectedOptions[i]).val() + "']").css("display","");
            $(selectedOptions[i]).remove();
        }
    });

    //第一列搜索框绑定事件
    $("input[id='search-input-1']").on("input", function () {
        var inputText = $("input[id='search-input-1']").val().trim();
        var options = $("select[id='selectable-items-1']").find("option");
        if (inputText) {
            for (var i = 0; i < options.length; i++) {
                if (options[i].text.toLowerCase().indexOf(inputText.toLowerCase()) != -1) {
                    options[i].style.display = "";
                } else {
                    options[i].style.display = "none";
                }
            }
        } else {
            for (var j = 0; j < options.length; j++) {
                options[j].style.display = "";
            }
        }
    });

    //第二列搜索框绑定事件
    $("input[id='search-input-2']").on("input", function () {
        var inputText = $("input[id='search-input-2']").val().trim();
        var options = $("select[id='selectable-items-2']").find("option");
        if (inputText) {
            for (var i = 0; i < options.length; i++) {
                if (options[i].text.toLowerCase().indexOf(inputText.toLowerCase()) != -1) {
                    options[i].style.display = "";
                } else {
                    options[i].style.display = "none";
                }
            }
        } else {
            for (var j = 0; j < options.length; j++) {
                options[j].style.display = "";
            }
        }
    });
}


function spliceArray(srcArray, removedArray) {
    for (var i = 0; i < removedArray.length; i++) {
        var existsIndex = $.inArray(removedArray[i], srcArray);
        srcArray.splice(existsIndex, 1);
    }
}
