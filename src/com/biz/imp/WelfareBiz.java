package com.biz.imp;

import java.util.List;

import com.po.*;
import com.service.DaoService;
import com.biz.IWelfareBiz;
import com.dao.*;
public class WelfareBiz implements IWelfareBiz{
	private DaoService daos;

	public DaoService getDaos() {
		return daos;
	}

	public void setDaos(DaoService daos) {
		this.daos = daos;
	}
	public List<Welfare> findAll() {
		return daos.getWdao().findAll();
	}
	public boolean save(Welfare wf) {
		try {
			daos.getWdao().save(wf);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
