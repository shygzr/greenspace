package com.greenspace.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.util.StringUtils;

public class JSONMSG implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int statusCode ;
	private String message;
	private String forwardUrl;
	private String confirmMsg;
	private String token;
	private Map<String,Object> data=new HashMap<String,Object>();;
	//private String StrData;
	public JSONMSG() {
		super();
	}
	public JSONMSG(int statusCode) {
		super();
		this.statusCode = statusCode;
	}
	public static JSONMSG newMSG(int statusCode) {
		return new JSONMSG( statusCode,  null);
	}
	public static JSONMSG newMSG(int statusCode, String message) {
		return new JSONMSG( statusCode,  message);
	}
	
	public JSONMSG(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	public JSONMSG(int statusCode, String message, String forwardUrl,String confirmMsg) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.forwardUrl = forwardUrl;
		this.confirmMsg = confirmMsg;
	}
	
//--------------------------------------------------------	
	public JSONMSG put(String key,Object value) {
		if(key==null||key.isEmpty()){
			throw new AppRuntimeException("key can not be null");
		}
		this.getData().put(key, value);
		return this;
	}
	
	public Optional<Object> getObj(String key) {
		if(this.getData().isEmpty()||!StringUtils.hasText(key)){
			return Optional.empty();
		}
		return Optional.ofNullable(this.getData().get(key));
	}
	
	
	
//--------------------------------------------------------	
	public int getStatusCode() {
		return statusCode;
	}
	public JSONMSG setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public JSONMSG setMessage(String message) {
		this.message = message;
		return this;
	}
	public String getForwardUrl() {
		return forwardUrl;
	}
	public JSONMSG setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
		return this;
	}
	public String getConfirmMsg() {
		return confirmMsg;
	}
	public JSONMSG setConfirmMsg(String confirmMsg) {
		this.confirmMsg = confirmMsg;
		return this;
	}
	public String getToken() {
		return token;
	}
	public JSONMSG setToken(String token) {
		this.token = token;
		return this;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public JSONMSG setData(Map<String, Object> data) {
		this.data = data;
		return this;
	}
//	public String getStrData() {
//		return StrData;
//	}
//	public JSONMSG setStrData(String strData) {
//		StrData = strData;
//		return this;
//	}
	@Override
	public String toString() {
		return "JSONMSG [statusCode=" + statusCode + ", message=" + message + ", forwardUrl=" + forwardUrl
				+ ", confirmMsg=" + confirmMsg + ", token=" + token + ", data=" + data + "]";
	}

}
