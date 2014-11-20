/**
 * Created by Dannis on 2014/11/20.
 */
var selectedItems1 = [];
var selectedItems2 = [];
var selectableItems1 = [];
var selectableItems2 = [];

function initMultiSelect(obj, dataOptions) {
    $(obj).css({
        "width": "400px",
        "text-align": "center"
    });
    var row1 = "<tr style='text-align:left'>"
        + "<td><input id='search-input-1' type='text' style='width:124px'></td>"
        + "<td></td>"
        + "<td><input id='search-input-2' type='text' style='width:124px'></td>"
        + "<td></td>"
        + "<td></td>"
        + "</tr>";
    var row2 = "<tr style='vertical-align:top'>"
        + "<td><select id='selectable-items-1' multiple='multiple' style='width:130px;height:250px'></select></td>"
        + "<td style='vertical-align:middle'>"
        + "<button id='select-button-1' style='width:30px;height:22px;font-size:14px;line-height:12px;display:block'>--</button>"
        + "</td>"
        + "<td><select id='selectable-items-2' multiple='multiple' style='width:130px;height:250px'></select></td>"
        + "<td style='vertical-align:middle'>"
        + "<button id='select-button-2' style='width:30px;height:22px;font-size:14px;line-height:12px;display:block'>>></button>"
        + "<button id='deselect-button' style='width:30px;height:22px;font-size:14px;line-height:12px;display:block'><<</button>"
        + "</td>"
        + "<td><select id='selected-items' multiple='multiple' style='width:130px;height:250px'></select></td>"
        + "</tr>";

    $(obj).append(row1 + row2);
    initSelect();
    if (dataOptions) {
        if (dataOptions.singleClickSelect) {
            $("select").find("option").click(function () {
                selectItem(this);
            });
        }
    }
    bindEventHandler();

}

function initSelect() {
    var data1 = [{id: 1, name: '北京'}, {id: 2, name: '上海'}, {id: 3, name: '广州'}, {id: 4, name: '深圳'},
        {id: 5, name: '贵州'}, {id: 6, name: '四川'}, {id: 7, name: '云南'}, {id: 8, name: '广东'},
        {id: 9, name: '广西'}, {id: 10, name: '河南'}, {id: 11, name: '河北'}, {id: 12, name: '江苏'},
        {id: 13, name: '江西'}, {id: 14, name: '湖北'}, {id: 15, name: '湖南'}];

    var data2 = [{id: 1, name: '北京'}, {id: 2, name: '上海'}, {id: 3, name: '广州'}, {id: 4, name: '深圳'},
        {id: 5, name: '贵州'}, {id: 6, name: '四川'}, {id: 7, name: '云南'}, {id: 8, name: '广东'},
        {id: 9, name: '广西'}, {id: 10, name: '河南'}, {id: 11, name: '河北'}, {id: 12, name: '江苏'},
        {id: 13, name: '江西'}, {id: 14, name: '湖北'}, {id: 15, name: '湖南'}, {id: 16, name: '山西'},
        {id: 17, name: '陕西'}, {id: 18, name: '浙江'}];

    var select1 = $("select[id='selectable-items-1']");
    select1.empty();
    for (var i = 0; i < data1.length; i++) {
        selectableItems1.push(data1[i].id);
        select1.append("<option value='" + data1[i].id + "'>" + data1[i].name + "</option>");
    }

    var select2 = $("select[id='selectable-items-2']");
    select2.empty();
    for (var j = 0; j < data2.length; j++) {
        selectableItems2.push(data2[j].id);
        select2.append("<option value='" + data2[j].id + "'>" + data2[j].name + "</option>");
    }
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
                if (options[i].text.indexOf(inputText) != -1) {
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
                if (options[i].text.indexOf(inputText) != -1) {
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
