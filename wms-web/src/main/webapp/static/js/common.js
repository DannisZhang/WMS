$(function(){
	initLeftMenu();
	$('body').layout();
	showCurrentTime();
	initCalendar();
});

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

/* Initialize calendar */
function initCalendar() {
	$('#cc').calendar({
		border:true,
		weeks:['六','一','二','三','四','五','日'],
		months:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
		current:new Date()
    });
}

/* 添加Tab */
function addTab(subTitle, url) {
    if (!$('#tabs').tabs('exists', subTitle)) {
        $('#tabs').tabs('add', {
            title: subTitle,
            content: createFrame(url),
            closable: true,
            width: $('#mainPanel').width() - 10,
            height: $('#mainPanel').height() - 26
        });
    } else {
        $('#tabs').tabs('select', subTitle);
    }
}

/* 创建iframe */
function createFrame(url) {
    return '<iframe name="mainFrame" scrolling="yes" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
}

/* 显示当前时间 */
function showCurrentTime() {
	$("#current-time").text(getCurrentTime());
	setTimeout("showCurrentTime()",1000);
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