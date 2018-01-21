
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