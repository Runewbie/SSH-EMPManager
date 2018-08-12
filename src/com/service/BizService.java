package com.service;

import com.biz.*;

public class BizService {
	private IDepBiz depbiz;
	public IDepBiz getDepbiz() {
		return depbiz;
	}
	public void setDepbiz(IDepBiz depbiz) {
		this.depbiz = depbiz;
	}
	public IAdminBiz getAbiz() {
		return abiz;
	}
	public void setAbiz(IAdminBiz abiz) {
		this.abiz = abiz;
	}
	public IWelfareBiz getWbiz() {
		return wbiz;
	}
	public void setWbiz(IWelfareBiz wbiz) {
		this.wbiz = wbiz;
	}
	public IEmpBiz getEbiz() {
		return ebiz;
	}
	public void setEbiz(IEmpBiz ebiz) {
		this.ebiz = ebiz;
	}
	private IAdminBiz abiz;
	private IWelfareBiz wbiz;
	private IEmpBiz ebiz;
}
