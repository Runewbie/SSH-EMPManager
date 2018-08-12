package com.action;
import com.po.*;
import com.service.BizService;
import java.util.*;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.biz.*;
import com.biz.imp.*;

/**
 * 员工福利Action类
 * @author Runewbie
 *
 */
public class WelfareAction implements IWelfareAction {
	private Welfare wf;
	private String path;
	private BizService bizs;
	
	
	public BizService getBizs() {
		return bizs;
	}

	public void setBizs(BizService bizs) {
		this.bizs = bizs;
	}
	public Welfare getWf() {
		return wf;
	}

	public void setWf(Welfare wf) {
		this.wf = wf;
	}

	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	public String save() {
		boolean flag=bizs.getWbiz().save(wf);
		if(flag){
			path="findAll_Welfare";
			return "ok";
		}
		return null;
	}

	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		List<Welfare> lswf=bizs.getWbiz().findAll();
		session.setAttribute("lswf", lswf);
		path="welfare.jsp";
		return "ok";
	}

}
