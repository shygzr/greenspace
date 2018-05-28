package com.greenspace.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {
	// 构造带有4个参数的JSONMSG
	protected JSONMSG ajaxDone(int statusCode, String message, String forwardUrl, String confirmMsg) {
		JSONMSG msg = new JSONMSG();
		msg.setStatusCode(statusCode);
		msg.setMessage(message);
		msg.setForwardUrl(forwardUrl);
		msg.setConfirmMsg(confirmMsg);
		return msg;
	}

	// 构造带有前2个参数的JSONMSG
	protected JSONMSG ajaxDone(int statusCode, String message) {
		return ajaxDone(statusCode, message, "", "");
	}

	protected JSONMSG ajaxSuccess() {
		return ajaxDone(FrameConst.SC.SC_200, "");
	}

	protected JSONMSG ajaxDoneSuccess(String message) {
		return ajaxDone(FrameConst.SC.SC_200, message);
	}

	protected JSONMSG ajaxDoneError(String message) {
		return ajaxDone(FrameConst.SC.SC_300, message);
	}

	protected JSONMSG ajaxServerError(String message) {
		return ajaxDone(FrameConst.SC.SC_500, message);
	}

	protected JSONMSG ajaxAuthError(String message) {
		return ajaxDone(FrameConst.SC.SC_401, message);
	}

	protected JSONMSG ajaxAuthError(int statusCode, String message) {
		return ajaxDone(statusCode, message);
	}

	protected JSONMSG ajaxQuery(String key, Optional<?> value) {
		if (value.isPresent()) {
			return ajaxSuccess().put(key, value.get());
		} else {
			return ajaxSuccess().put(key, new Object());
			// return ajaxDoneError(FrameConst.WEB_MSG.QUERY_FAILURE);
		}
	}

	protected JSONMSG ajaxQuery(String key, Object value) {
		if (!Objects.isNull(value)) {
			return ajaxSuccess().put(key, value);
		} else {
			return ajaxSuccess().put(key, new Object());
			// return ajaxDoneError(FrameConst.WEB_MSG.QUERY_FAILURE);
		}
	}

	protected static final String viewPath = "view";

	protected Object forward(String viewPath, String viewName) {
		if (!viewPath.startsWith("/")) {
			viewPath = "/" + viewPath;
		}
		if(!viewPath.endsWith("/")){
			viewPath=viewPath+"/";
		}
		/*System.out.println("gzzr:forward:" + viewPath + viewName);*/
		return "forward:" + viewPath + viewName;
	}

	protected Object redirect(String viewPath,String viewName) {
		if(!viewPath.startsWith("/")){
			viewPath="/"+viewPath;
		}
		if(!viewPath.endsWith("/")){
			viewPath=viewPath+"/";
		}
		/*System.out.println("gzzr:redirect:"+viewPath+viewName);*/
		return "redirect:"+viewPath+viewName;
	}

	protected static Object convert(Object object) {
		if (object == null) {
			return new Object();
		}
		return object;
	}
	
	protected Boolean handlerString(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session==null){
           //没有登录成功
			return true;
        }
		String username = (String) session.getAttribute("username");
		if (username == null) {
			//没有登录成功
			return true;
		}
		return false;	
	}
	
	protected  Object redirectString() {
		return redirect("", "index.html");
	}
	
	protected Boolean handlerStringX(HttpServletRequest request, Long userid) {
		HttpSession session = request.getSession(false);
		if(session==null){
           //没有登录成功
			return true;
        }
		String username = (String) session.getAttribute("username");
		if (username == null) {
			//没有登录成功
			return true;
		}
		/*Long useridx = Long.parseLong(session.getAttribute("userid").toString());
		if (useridx != userid) {
			//没有登录成功
			return true;
		}*/
		String gzzrcode = (String) session.getAttribute("gzzr_code");
		if (gzzrcode != "gzzr_Xmxcnuumeo_gzzr") {
			//没有登录成功
			return true;
		}
		return false;	
	}
	
	protected Boolean handlerStringAdmin(HttpServletRequest request, Long userid) {
		HttpSession session = request.getSession(false);
		if(session==null){
           //没有登录成功
			return true;
        }
		String username = (String) session.getAttribute("username");
		if (username == null) {
			//没有登录成功
			return true;
		}
		/*Long useridx = Long.parseLong(session.getAttribute("userid").toString());
		if (useridx != userid) {
			//没有登录成功
			return true;
		}*/
		String gzzrcode = (String) session.getAttribute("gzzr_code");
		if (gzzrcode != "gzzr_Xmxcnuumeoadmin_gzzr") {
			//没有登录成功
			return true;
		}
		return false;	
	}
	
	protected Object handlernoAuth(String user_id) {
			ModelAndView modelAndView = new ModelAndView("/me");
	        modelAndView.addObject("user_id", user_id);
	        return modelAndView;	
	}
	
	protected void uploadFile(byte[] file, String filePath, String fileName, String suf) throws Exception {
		File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }    
        String[] files = targetFile.list();
        String[] fs = Arrays.stream(files)
        	.filter(y -> y.substring(0, y.lastIndexOf(".")).equals(fileName))
			.toArray(String[]::new);
        if(fs.length != 0) {
        	for(String s : fs) {
            	File e = new File(filePath + s);
            	e.delete();
            }
        }else {
        	
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName+suf);
        out.write(file);
        out.flush();
        out.close();	
	}
}
