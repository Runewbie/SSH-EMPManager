package com.po;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Integer eid;
	private Dep dep;
	private String ename;
	private String sex;
	private String address;
	private Date birthday;
	private String photo;
	private Set salaries = new HashSet(0);
	private Set empwelfares = new HashSet(0);

	
	/*** 与界面关联属性 ************/
	private String sdate;
	

	// 与界面关联属性
	// 1与薪资关联属性
	private float emoney;

	// 2于福利关联属性
	private Integer[] wid;// 接受复选框的数据

	// 3与照片上传关联的属性
	private File pic;
	private String picContentType;
	private String picFileName;
	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** minimal constructor */
	public Emp(Dep dep, String ename) {
		this.dep = dep;
		this.ename = ename;
	}

	/** full constructor */
	public Emp(Dep dep, String ename, String sex, String address,
			Date birthday, String photo, Set salaries, Set empwelfares) {
		this.dep = dep;
		this.ename = ename;
		this.sex = sex;
		this.address = address;
		this.birthday = birthday;
		this.photo = photo;
		this.salaries = salaries;
		this.empwelfares = empwelfares;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Dep getDep() {
		return this.dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set getSalaries() {
		return this.salaries;
	}

	public void setSalaries(Set salaries) {
		this.salaries = salaries;
	}

	public Set getEmpwelfares() {
		return this.empwelfares;
	}

	public void setEmpwelfares(Set empwelfares) {
		this.empwelfares = empwelfares;
	}
	
	public String getSdate() {
		if (birthday!=null) {
			sdate=new SimpleDateFormat("yyyy-MM-dd").format(birthday);
		}
		return sdate;
	}
	public void setSdate(String sdate) {
		if (sdate!=null&&!sdate.isEmpty()) {
			try {
				birthday=new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		this.sdate = sdate;
	}

	public float getEmoney() {
		return emoney;
	}

	public void setEmoney(float emoney) {
		this.emoney = emoney;
	}

	public Integer[] getWid() {
		return wid;
	}

	public void setWid(Integer[] wid) {
		this.wid = wid;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
}