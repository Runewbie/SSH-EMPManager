package com.action;
import com.biz.IDepBiz;
import com.biz.imp.DepBiz;
import com.po.*;
import com.service.BizService;
import java.util.*;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 * 部门Action类
 * @author Runewbie
 *
 */
public class DepAction implements IDepAction {
	private Dep dep;
	private String path;
	
	private BizService bizs;
	
	
	public BizService getBizs() {
		return bizs;
	}

	public void setBizs(BizService bizs) {
		this.bizs = bizs;
	}

	
	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	public String save() {
		boolean flag=bizs.getDepbiz().save(dep);
		if(flag){
			path="findAll_Dep";
			return "ok";
		}
		return null;
	}

	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		List<Dep> lsdep=bizs.getDepbiz().findAll();
//		for (Dep dep : lsdep) {
//			dep.setEnums(dep.getEmps().size());
//		}
		session.setAttribute("lsdep", lsdep);
		path="dep.jsp";
		return "ok";
	}

}
