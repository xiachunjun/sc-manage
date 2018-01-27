var submitForm = function queryData(option) {
	if (!!!option.formId) {
		alert("提交异常-表单ID为空！");
	}
	if (!!!option.callBack) {
		option.callBack = function(data) {
			var resultCode = data.resultCode;
			if (resultCode == '000000') {
				alert("操作成功!");
			} else if (resultCode == '100002') {
				var dataMap = data.dataMap;
				var inputError = dataMap.inputError;
				var ht = data.resultMessage + "[";
				for (var name in inputError) {
					ht = ht + inputError[name] + ";";
				}
				ht = ht + "]";
				alert(ht);
			}
		}
	}
	if (!!!option.url) {
		alert("提交异常-表单url为空！");
	}
	if (!!!option.type) {
		option.type = 'POST';
	}
	var paramJson = $("#" + option.formId).serializeJSON();
	$.ajax({
		type : option.type,
		url : option.url,
		data : JSON.stringify(paramJson),
		dataType : 'json',
		headers : {
			'Content-Type' : 'application/json'
		},
		success : option.callBack,
		error : function(data) {
			alert("服务器异常-" + JSON.stringify(data));
		}
	});
}