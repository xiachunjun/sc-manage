package com.sc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	
	/**
	 * 校验时的错误信息: 没有错误时返回null
	 * @param br
	 * @return
	 */
	public String hasErrors(BindingResult br){
		if(!br.hasErrors()){
			return null;
		}
        List<FieldError> allErrors = br.getFieldErrors();
        if(CollectionUtils.isEmpty(allErrors)){
        	return null;
        }
        List<String> msgs = new ArrayList<String>();
        for (FieldError err : allErrors) {
        	msgs.add("{"+err.getField()+"}"+err.getDefaultMessage());
		}
        String errorMsg = StringUtils.join(msgs, '|');
        logger.error("校验输入参数时，出现错误信息： "+errorMsg);
        return errorMsg;
	}
	

}

