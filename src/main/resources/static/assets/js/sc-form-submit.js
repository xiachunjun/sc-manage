/**
 * option:
 * {
 * formId:要提交的表单的id
 * url:请求地址，
 * type:默认post，不建议修改
 * callBack:回调函数，将整个response作为参数
 * catchError:true/false   当后台返回inputError是否做通用处理（alert出具体错误）
 * 
 * }
 * 
 */

var submitForm = function queryData(option) {
	if (!!!option.url) {
		alert("提交异常-表单url为空！");
	}
	var localCallBack;
	if (!!!option.callBack) {
		localCallBack = function(data) {
			var resultCode = data.resultCode;
			if (resultCode == '000000') {
				alert("操作成功!");
			} else if (resultCode == '100002') {
				showInputError(data);
			} else {
				alert("操作失败!");
			}
		}
	} else {
		if (option.catchError) {
			localCallBack = function(data) {
				var resultCode = data.resultCode;
				if (resultCode == '000000') {
					option.callBack(data);
				} else if (resultCode == '100002') {
					showInputError(data);
				} else {
					alert("操作失败!");
				}

			}
		}else{
			localCallBack=option.callBack;
		}
	}

	if (!!!option.type) {
		option.type = 'POST';
	}
	var paramJson = {};
	if (!!option.formId) {
		paramJson = $("#" + option.formId).serializeJSON();
	}
	$.ajax({
		type : option.type,
		url : option.url,
		data : JSON.stringify(paramJson),
		dataType : 'json',
		headers : {
			'Content-Type' : 'application/json'
		},
		success : localCallBack,
		error : function(data) {
			alert("服务器异常-" + JSON.stringify(data));
		}
	});
}

var showInputError = function(data) {
	var dataMap = data.dataMap;
	var inputError = dataMap.inputError;
	var ht = data.resultMessage + "[";
	for (var name in inputError) {
		ht = ht + inputError[name] + ";";
	}
	ht = ht + "]";
	alert(ht);
}

var del = function(option) {
	if (!!!option.url) {
		alert("删除异常-url为空！");
		return;
	}
	if (!!!option.id) {
		alert("删除异常-id为空！");
		return;
	}
	if (!window.confirm('确认删除？')) {
		return;
	}
	$.ajax({
		type : 'POST',
		url : option.url,
		data : JSON.stringify({
			'id' : option.id
		}),
		dataType : 'json',
		headers : {
			'Content-Type' : 'application/json'
		},
		success : function(data) {
			var resultCode = data.resultCode;
			if (resultCode == '000000') {
				alert("删除成功!");
				if (!!option.callBack) {
					option.callBack();
				}
			} else {
				alert("删除失败!");
			}
		},
		error : function(data) {
			alert("删除异常-" + JSON.stringify(data));
		}
	});

}