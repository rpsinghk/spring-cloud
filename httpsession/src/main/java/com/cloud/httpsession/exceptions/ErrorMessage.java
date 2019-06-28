package com.cloud.httpsession.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;


public @Data @AllArgsConstructor class  ErrorMessage {

	String code;
	String error;
	
}
