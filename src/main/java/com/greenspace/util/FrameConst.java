package com.greenspace.util;

public class FrameConst {
	
//---------------交互状态码-------------------------
	public static final class SC{
		public static final int SC_200 = 200;// Success
		public static final int SC_300 = 300;// Service_Error
		public static final int SC_301 = 301;// time_out--->dologin
		public static final int SC_303 = 303;// 重复提交
		public static final int SC_401 = 401;// Auth_Error
		public static final int SC_500 = 500;// Server_Error
		public static final int SC_402 = 402;// csrf token is invalid
		public static final int SC_4010 = 4010;//
		public static final int SC_4011 = 4011;//
	}
	public static final class WEB_MSG{
		public static final String AJAX_SUCCESS="数据处理成功 ";
		public static final String AJAX_ERROR="数据处理失败  ";
		public static final String VALIDATE_ERROR="数据校验失败 ";
		public static final String AUTH_ERROR= "权限授权认证失败 ";
		public static final String AUTH_UNREGISTER_ERROR= "未注册用户";
		public static final String AUTH_NONCHECKED_ERROR= "未审核用户";
		public static final String SERVER_ERROR= "服务器错误 ";
		public static final String QUERY_FAILURE= "未查询到数据";
		public static final String INVALID_SESSIONUSER= "用户未登录或超时";
	}

	public static final class ERROR_PAGE{
		public static final String ERROR_PAGE_301="/static/pages/301.html";
		public static final String ERROR_PAGE_401="/static/pages/401.html";
		public static final String ERROR_PAGE_300="/static/pages/300.html";
		public static final String ERROR_PAGE_500="/static/pages/500.html";
		public static final String ERROR_PAGE_402="/static/pages/402.html";
	}
	

}
