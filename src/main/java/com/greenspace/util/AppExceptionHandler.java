package com.greenspace.util;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;



@ControllerAdvice  
public class AppExceptionHandler extends BaseController{
	
	@Autowired  
	private  ApplicationEventPublisher publisher;
	
	@ExceptionHandler
	@ResponseBody
	public Object processGlobalExceptions(HttpServletRequest request,HttpServletResponse httpResponse, HandlerMethod handlerMethod, Exception e ) throws Exception {
		if (e instanceof ServiceLogicalException) {
			 if(isAjax(request)){
				 respJSON(httpResponse, ajaxDoneError(e.getMessage()));
				 return null;
			 }else{
				 redirect(request, httpResponse, FrameConst.ERROR_PAGE.ERROR_PAGE_300);
				 return null;
			 }
		}else if(e instanceof Exception){
			e.printStackTrace();
			 if(isAjax(request)){
				 respJSON(httpResponse, ajaxDoneError(FrameConst.WEB_MSG.SERVER_ERROR+"||"+e.getMessage() ));
				  return null;
			 }else{
				  redirect(request, httpResponse, FrameConst.ERROR_PAGE.ERROR_PAGE_500);
				  return null;
			 }
		}
		return null;
	}
	
	
	public static void redirect(HttpServletRequest httpRequest,HttpServletResponse httpResponse,String url) throws IOException, ServletException{
		if(url==null){return;}
		url=url.startsWith("/")?url:"/"+url;
		if (url!=null &&!url.contains(httpRequest.getContextPath())) {
			 url=httpRequest.getContextPath()+url;
	     }
		httpResponse.sendRedirect(url);
	}
	
	public static void forward(HttpServletRequest httpRequest,HttpServletResponse httpResponse,String url) throws ServletException, IOException{
		if(url==null){return;}
		url=url.startsWith("/")?url:"/"+url;
		httpRequest.getRequestDispatcher(url).forward(httpRequest,httpResponse);
	}
	
	public static void respJSON(HttpServletResponse httpResponse,JSONMSG jsonmsg) throws IOException{
		httpResponse.setCharacterEncoding("UTF-8");  
		httpResponse.setContentType("application/json;charset=utf-8");
		httpResponse.getWriter().write(JSON.toJSONString(jsonmsg));
	}
    public static boolean isAjax(HttpServletRequest request){
//    	String h=request.getHeader("X-Requested-With");
    	if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))){
    		return true;
    	}
    	if("XMLHttpRequest".equalsIgnoreCase(request.getParameter("X-Requested-With"))){
    		return true;
    	}
    	if((""+request.getHeader("accept")).toLowerCase().contains("application/json")) {
    		return true;
    	}
    	if((""+request.getHeader("Accept")).toLowerCase().contains("application/json")) {
    		return true;
    	}
    	return "XMLHttpRequest".equalsIgnoreCase(request.getParameter("ajaxRequest"));
    }
    
	public ApplicationEventPublisher getPublisher() {
		return publisher;
	}

	public void setPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	} 
}
