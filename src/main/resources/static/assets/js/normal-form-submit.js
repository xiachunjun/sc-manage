var submitForm = function queryData(option) {
	if (!!!option.formId) {
		alert("提交异常-表单ID为空！");
	}
	if (!!!option.url) {
		alert("提交异常-表单url为空！");
	}
	if (!!!option.type) {
		option.type = 'POST';
	}
	var paramJson = $("#" +option.formId).serializeJSON();
	$.ajax({
		type : option.type,
		url : option.url,
		data : JSON.stringify(paramJson),
		headers : {
			'Content-Type' : 'application/json'
		},
		success : function(data) {
			var resultCode = data.resultCode;
			var dataMap = data.dataMap;
			if (resultCode == '000000' & dataMap != null) {
				alert("操作成功!")
			} else {
				alert("操作异常!");
			}
		},
		dataType : 'json',
		error : function(data) {
			alert("服务器异常-" + JSON.stringify(data));
		}
	});
}