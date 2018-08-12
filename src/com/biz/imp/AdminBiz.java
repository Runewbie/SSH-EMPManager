package com.biz.imp;

import java.util.List;

import com.biz.*;
import com.po.*;
import com.service.DaoService;
import com.dao.*;
public class AdminBiz implements IAdminBiz {
	private DaoService daos;
	
	public DaoService getDaos() {
		return daos;
	}

	public void setDaos(DaoService daos) {
		this.daos = daos;
	}

	public boolean save(Admin admin) {
		try {
			daos.getAdao().save(admin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Admin admin) {
		try {
			daos.getAdao().merge(admin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(Integer aid) {
		Admin admin=daos.getAdao().findById(aid);
		try {
			daos.getAdao().delete(admin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Admin findById(Integer aid) {
		return daos.getAdao().findById(aid);
	}

	public List<Admin> findAll() {
		return daos.getAdao().findAll();
	}

	public Admin check(Admin admin) {
		return daos.getAdao().check(admin);
	}
}
