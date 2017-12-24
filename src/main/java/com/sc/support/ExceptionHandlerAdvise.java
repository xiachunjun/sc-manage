package com.sc.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;

@ControllerAdvice(annotations = { RestController.class, Controller.class })
public class ExceptionHandlerAdvise {

	private static Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvise.class);

	@ExceptionHandler(ScException.class)
	@Order(100)
	@ResponseBody
	public DataResponse handleWandaException(ScException ex) {
		return new DataResponse(ex);
	}

	/**
	 * json格式请求 RequestBody valid报错
	 */
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@Order(400)
	@ResponseBody
	public DataResponse handleValidationException(MethodArgumentNotValidException e) {
		Map<String, String> errMap = new HashMap<>();
		List<FieldError> allErrors = e.getBindingResult().getFieldErrors();
		if (allErrors != null && allErrors.size() > 0) {
			for (FieldError fieldError : allErrors) {
				errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
		}
		DataResponse dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
		dr.put("input_error", errMap);
		return dr;
	}
	
	/**
	 * form-data提交表单时 valid报错
	 */
	@ExceptionHandler({BindException.class })
	@Order(401)
	@ResponseBody
	public DataResponse handleBindException(BindException e) {
		Map<String, String> errMap = new HashMap<>();
		List<FieldError> allErrors = e.getBindingResult().getFieldErrors();
		if (allErrors != null && allErrors.size() > 0) {
			for (FieldError fieldError : allErrors) {
				errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
		}
		DataResponse dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
		dr.put("input_error", errMap);
		return dr;
	}
	

	@ExceptionHandler(Exception.class)
	@Order(2000)
	@ResponseBody
	public DataResponse handleWandaException(Exception ex) {
		logger.error("运行时异常：" + ex.getMessage(), ex);
		return new DataResponse(ResponseEnum.RESPONSE_FAIL);
	}
}
