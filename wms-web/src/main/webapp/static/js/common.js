var themeName = 'gray';
var customThemeHref = "static/easyui/themes/gray/easyui.css";
$(function () {
    init();
});

function init() {
    initTopMenu();
    initLeftMenu();
    initWorkspaceTabs();
    $('body').layout();
    showCurrentTime();
    initCalendar();
    if ($.cookie('easyuiThemeName')) {
        changeTheme($.cookie('easyuiThemeName'));
    }
}

function initTopMenu() {
    var $changeThemeMenuButton = $("#change-theme-menubutton").menubutton({
        menu:'#theme-menu',
        iconCls:'icon-custom-theme'
    });
    var $exitMenuButton = $("#exit-menubutton").menubutton({
        menu:'#system-menu',
        iconCls:'icon-custom-lock'
    });
    $($changeThemeMenuButton.menubutton('options').menu).menu({
        onClick:function (item) {
            themeName = item.text.toLowerCase();
            changeTheme(themeName);
        }
    });
    $($exitMenuButton.menubutton('options').menu).menu({
        onClick:function (item) {
            if ("logout-button" == item.name) {
                $('#logout-dialog').dialog('open');
            } else if ("exit-button" == item.name) {
                $("#exit-dialog").dialog('open');
            }
        }
    });
}

/* 左边菜单栏绑定单击事件 */
function initLeftMenu() {
    $('#menu').find('ul li a').click(function () {
        var tabTitle = $(this).text();
        var url = $(this).attr("href");
        addTab(tabTitle, url);
        $('#menu').find('ul li a').removeClass("selected");
        $(this).addClass("selected");
    });
}

/**
 * 初始化Tab
 */
function initWorkspaceTabs() {
    $("div[id='workspaceTabs']").tabs({
        border:false,
        fit:true
    });
}

/* Initialize calendar */
function initCalendar() {
    $('#cc').calendar({
        border: true,
        weeks: ['六', '一', '二', '三', '四', '五', '日'],
        months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        current: new Date()
    });
}

/* 添加Tab */
function addTab(subTitle, url) {
    var $tabs = $('#workspaceTabs');
    if (!$tabs.tabs('exists', subTitle)) {
        var $mainPanel = $('#mainPanel');
        var id = "iframe" + subTitle;
        var content = '<iframe scrolling="auto" frameborder="0" src="' + url + '" id="' + id + '" style="width:100%;height:100%;"></iframe>';
        $tabs.tabs('add', {
            title: subTitle,
            content: content,
            fit:true,
            closable: true,
            height: $mainPanel.height() - 26
        });
        refreshTheme();
    } else {
        $tabs.tabs('select', subTitle);
    }
}

/* 显示当前时间 */
function showCurrentTime() {
    $("#current-time").text(getCurrentTime());
    setTimeout("showCurrentTime()", 1000);
}

/* 获取当前时间字符串 */
function getCurrentTime() {
    var today = new Date();
    var day;
    var date;
    var time;

    if (today.getDay() == 0) {
        day = "星期日";
    } else if (today.getDay() == 1) {
        day = "星期一";
    } else if (today.getDay() == 2) {
        day = "星期二";
    } else if (today.getDay() == 3) {
        day = "星期三";
    } else if (today.getDay() == 4) {
        day = "星期四";
    } else if (today.getDay() == 5) {
        day = "星期五";
    } else if (today.getDay() == 6) {
        day = "星期六";
    }

    var month = today.getMonth();
    month++;
    if (month < '10') {
        month = "0" + month;
    }

    var d = today.getDate();
    if (d < '10') {
        d = "0" + d;
    }

    date = today.getFullYear() + "年" + month + "月" + d + "日";
    var hours = today.getHours();
    var minutes = today.getMinutes();
    var seconds = today.getSeconds();
    if (hours < '10') {
        hours = "0" + hours;
    }
    if (minutes < '10') {
        minutes = "0" + minutes;
    }
    if (seconds < '10') {
        seconds = "0" + seconds;
    }

    time = hours + "时" + minutes + "分" + seconds + "秒";

    return date + " " + day + " " + time;
}

/* 修改主题 */
function changeTheme(themeName) {
    var $easyuiTheme = $("link[id='easyuiTheme']");
    var oldHref = $easyuiTheme.attr("href");
    var newHref = oldHref.substring(0, oldHref.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
    $easyuiTheme.attr("href", newHref);
    customThemeHref = newHref;

    //子页面iframe
    var $iframes = $('iframe');
    if ($iframes.length > 0) {
        var iframeHref = '../' + newHref;
        for (var i = 0; i < $iframes.length; i++) {
            $($iframes[i]).contents().find('link[id="easyuiTheme"]').attr('href', iframeHref);
        }
    }
    $.cookie('easyuiThemeName', themeName, {
        expires: 7
    });
}
function refreshTheme() {
    //子页面iframe
    var $iframes = $('iframe');
    if ($iframes.length > 0) {
        var iframeHref = '../' + customThemeHref;
        for (var i = 0; i < $iframes.length; i++) {
            $($iframes[i]).contents().find('link[id="easyuiTheme"]').attr('href', iframeHref);
        }
    }
}
/**
 * 检查新添加的Tab的主题是否跟系统一致，若不一致则切换至跟系统一样
 * @param title
 */
function checkTheme(title) {
    var $iframes = $('iframe');
    if ($iframes.length > 0) {
        var iframeId = 'iframe' + title;
        for (var i = 0;i < $iframes.length;i++) {
            if (iframeId == $($iframes[i]).attr('id')) {
                $($iframes[i]).contents().find('link[id="easyuiTheme"]').attr('href', '../' + customThemeHref);
            }
        }
    }
}