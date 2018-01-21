
/**
 * timestampStr时间戳
 * complement是否补全，true需要补全，如1月补全为：01月
 * return 示例:2018年1月1日
 */
function formatDate(timestampStr, complement) {
	var now;
	if (!!timestampStr) {
		now = new Date(timestampStr);
	} else {
		now = new Date();
	}
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var date = now.getDate();
	if (complement) {
		month = dateComplement(month);
		date = dateComplement(date);
	}
	/* var   hour=now.getHours();     
	var   minute=now.getMinutes();     
	var   second=now.getSeconds();  */
	return year + "年" + month + "月" + date + "日";
}
/**
 * timestampStr时间戳
 * complement是否补全，true需要补全，如1月补全为：01月
 * return 示例:2018-1-1
 */
function formatDate1(timestampStr, complement) {
	var now;
	if (!!timestampStr) {
		now = new Date(timestampStr);
	} else {
		now = new Date();
	}
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var date = now.getDate();
	if (complement) {
		month = dateComplement(month);
		date = dateComplement(date);
	}
	return year + "-" + month + "-" + date;
}

/**
 * 小于10左补0
 */
function dateComplement(target) {
	if (target < 10) {
		return "0" + target;
	} else {
		return target;
	}
}

var dateList =function getDateList(initOption) {
	var format1 = 'yyyy-MM-dd';
	var format2 = 'yyyy-MM';
	var format3 = 'yyyy年MM月dd日';
	var format4 = 'yyyy年MM月';
	var	option={
				'format':format1,
				'size':12
		};
	if (!!initOption.format) {
		option.format = initOption.format;
	}
	if (!!initOption.size) {
		option.size = initOption.size;
	}
	var now = new Date();
	var result = [];
	for (var i = 0; i < option.size; i++) {
		var obj=new Object();
		var m = now.getMonth() + 1;
		var date = now.getDate();
		if (format1 == option.format) {
			obj.key=now.getFullYear() + "-" + dateComplement(m) + "-" + dateComplement(date);
			obj.value=now.getFullYear() + "-" + dateComplement(m) + "-" + dateComplement(date);
			result.push(obj);
		} else if (format2 == option.format) {
			obj.key=now.getFullYear() + "-" + dateComplement(m);
			obj.value=now.getFullYear() + "-" + dateComplement(m);
			result.push(obj);
		} else if (format3 == option.format) {
			obj.key=now.getFullYear() + "-" + dateComplement(m) + "-" + dateComplement(date);
			obj.value=now.getFullYear() + "年" + dateComplement(m) + "月" + dateComplement(date) + "日";
			result.push(obj);
		} else if (format4 == option.format) {
			obj.key=now.getFullYear() + "-" + dateComplement(m);
			obj.value=now.getFullYear() + "年" + dateComplement(m) + "月";
			result.push(obj);
		}
		now.setMonth(now.getMonth() - 1);
	}
	return result;
}