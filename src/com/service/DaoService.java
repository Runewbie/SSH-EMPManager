package com.service;

import com.dao.*;
/**
 * 本类为dao的服务类，使用了面向对象设计中的迪米特原则，即“最少知识原则”，
 * 迪米特原则（LoD）：如果两个类不必彼此直接通信，那么这两个类就不应发生
 * 直接的相互作用。如果其中的一个类需要调用另一个类的某一个方法的话，可以通过第三者调用。
 * @author Runewbie
 *
 */
public class DaoService {
	private AdminDAO adao;
	public AdminDAO getAdao() {
		return adao;
	}
	public void setAdao(AdminDAO adao) {
		this.adao = adao;
	}
	public DepDAO getDepdao() {
		return depdao;
	}
	public void setDepdao(DepDAO depdao) {
		this.depdao = depdao;
	}
	public WelfareDAO getWdao() {
		return wdao;
	}
	public void setWdao(WelfareDAO wdao) {
		this.wdao = wdao;
	}
	public EmpDAO getEdao() {
		return edao;
	}
	public void setEdao(EmpDAO edao) {
		this.edao = edao;
	}
	public SalaryDAO getSdao() {
		return sdao;
	}
	public void setSdao(SalaryDAO sdao) {
		this.sdao = sdao;
	}
	public EmpwelfareDAO getEwdao() {
		return ewdao;
	}
	public void setEwdao(EmpwelfareDAO ewdao) {
		this.ewdao = ewdao;
	}
	private DepDAO depdao;
	private WelfareDAO wdao;
	private EmpDAO edao;
	private SalaryDAO sdao;
	private EmpwelfareDAO ewdao;
}
