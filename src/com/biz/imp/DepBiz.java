package com.biz.imp;

import java.util.List;

import com.biz.IDepBiz;
import com.dao.*;

import com.po.*;
import com.service.DaoService;

public class DepBiz implements IDepBiz {
	private DaoService daos;

	public DaoService getDaos() {
		return daos;
	}

	public void setDaos(DaoService daos) {
		this.daos = daos;
	}

	public List<Dep> findAll() {
		List<Dep> lsdep=daos.getDepdao().findAll();
		for (Dep dep : lsdep) {
			dep.setEnums(dep.getEmps().size());
		}
		return daos.getDepdao().findAll();
	}

	public boolean save(Dep dep) {
		try {
			daos.getDepdao().save(dep);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
