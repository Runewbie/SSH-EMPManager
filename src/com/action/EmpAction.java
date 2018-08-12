package com.action;
import com.po.*;
import com.service.BizService;
import com.bean.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.biz.*;
import com.biz.imp.*;
/**
 * 员工Action类
 * @author Runewbie
 *
 */
public class EmpAction implements IEmpAction {
	private Emp emp;
	private Integer eid;
	
	private int page;
	private int rows;
	
	private String path;
	
	private BizService bizs;
	
	
	public BizService getBizs() {
		return bizs;
	}

	public void setBizs(BizService bizs) {
		this.bizs = bizs;
	}

	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	
	public String save() {
		/************�����ļ��ϴ�*****************/
		//��ȡ������������·��
		String rpath=ServletActionContext.getRequest().getRealPath("/");
		
		//�ж��Ƿ�����ļ��ϴ�
		if(emp.getPic()!=null&&emp.getPic().length()>0){
			//��ȡ�ļ����
			String fname=emp.getPicFileName();
			
			//�ж��Ƿ���ں�׺
			if(fname.lastIndexOf(".")!=-1){
				//��ȡ��׺���
				String ext=fname.substring(fname.lastIndexOf("."));
				//�ж��ļ���׺�Ƿ�Ϊjpg����png
				if(ext.equalsIgnoreCase(".jpg")||ext.equalsIgnoreCase(".png")){
					//�����µ��ļ����
					String newfname=new Date().getTime()+ext;
					//�����ļ�����ָ���ϴ��ļ���ŵ�·��
					File destFile=new File(rpath+"/uppic/"+newfname);
					
					try {
						//��ʼ�ϴ�
						FileUtils.copyFile(emp.getPic(), destFile);
						emp.setPhoto(newfname);//�����µ��ļ���Ƶ���ݿ�
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
		
		/*********************************************************/
		boolean flag=bizs.getEbiz().save(emp);
		if(flag){
			path="findAll_Emp.action";
			return "ok";
		}
		return null;
	}

	public String update() {
		/************�����ļ��ϴ�*****************/
		//��ȡԭ����Ա����Ƭ(emp.getEid()�Ǹ��½���������򴫵������ı��)
		String oldfname=bizs.getEbiz().findById(emp.getEid()).getPhoto();
		//��ȡ������������·��
		String rpath=ServletActionContext.getRequest().getRealPath("/");
		
		//�ж��Ƿ�����ļ��ϴ�
		if(emp.getPic()!=null&&emp.getPic().length()>0){
			//��ȡ�ļ����
			String fname=emp.getPicFileName();
			
			//�ж��Ƿ���ں�׺
			if(fname.lastIndexOf(".")!=-1){
				//��ȡ��׺���
				String ext=fname.substring(fname.lastIndexOf("."));
				//�ж��ļ���׺�Ƿ�Ϊjpg����png
				if(ext.equalsIgnoreCase(".jpg")||ext.equalsIgnoreCase(".png")){
					//�����µ��ļ����
					String newfname=new Date().getTime()+ext;
					//�����ļ�����ָ���ϴ��ļ���ŵ�·��
					File destFile=new File(rpath+"/uppic/"+newfname);
					
					try {
						//��ʼ�ϴ�
						FileUtils.copyFile(emp.getPic(), destFile);
						emp.setPhoto(newfname);//�����µ��ļ���Ƶ���ݿ�
						
						//ɾ��ԭ����Ա����Ƭ
						File oldfile=new File(rpath+"/uppic/"+oldfname);
						if(oldfile.exists()&&!oldfname.equals("default.jpg")){
							oldfile.delete();//ɾ��
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}else{
			emp.setPhoto(oldfname);//���޸���Ƭʱ��������ԭ������Ƭ
		}
		
		/*********************************************************/
		
		boolean flag=bizs.getEbiz().update(emp);
		if(flag){
			path="findAll_Emp.action";
			return "ok";
		}
		return null;
	}

	public String delById() {
		//��ȡԭ����Ա����Ƭ(emp.getEid()�Ǹ��½���������򴫵������ı��)			
		String oldfname=bizs.getEbiz().findById(eid).getPhoto();
		//��ȡ������������·��
		String rpath=ServletActionContext.getRequest().getRealPath("/");
				
		
		boolean flag=bizs.getEbiz().delById(eid);
		if(flag){
			//ɾ��ԭ����Ա����Ƭ
			File oldfile=new File(rpath+"/uppic/"+oldfname);
			if(oldfile.exists()&&!oldfname.equals("default.jpg")){
				oldfile.delete();//ɾ��Ա����Ƭ
			}
			
			path="findAll_Emp.action";
			return "ok";
		}
		return null;
	}

	public String findById() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		Emp oldemp=bizs.getEbiz().findById(eid);
		session.setAttribute("oldemp",oldemp);
		path="empupdate.jsp";
	
		return "ok";
	}

	public String findDetail() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		Emp demp=bizs.getEbiz().findById(eid);
		session.setAttribute("demp",demp);
		path="empdetail.jsp";
	
		return "ok";
	}

	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		/*******************Ϊ�޸Ľ���׼�����****************************/
		List<Dep> lsdep=bizs.getDepbiz().findAll();//�����б��׼��
		List<Welfare> lswf=bizs.getWbiz().findAll();//��ѡ��׼�����
		session.setAttribute("lsdep", lsdep);
		session.setAttribute("lswf", lswf);
		/***********************************************************/
		
		//��ȡ��ҳ��ʵ�����
		PageBean pb=(PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		
		//�жϴ��ݵĵ�ǰҳ���ÿҳ��¼��
		page=page==0?pb.getPage():page;
		rows=rows==0?pb.getRows():rows;
		
		//��ȡ���ҳ��
		int maxpage=bizs.getEbiz().findMaxPage(rows);
		if(page>maxpage)page=maxpage;
		
		//��ȡ��ǰҳ��¼�ļ���
		List<Emp> lsemp=bizs.getEbiz().findAll(page, rows);
		
		//��װ����ҳʵ����
		pb.setMaxpage(maxpage);
		pb.setPage(page);
		pb.setRows(rows);
		pb.setPagelist(lsemp);
		
		session.setAttribute("pb",pb);
		
		path="emplist.jsp";
		
		return "ok";
	}

	public String doinit() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		List<Dep> lsdep=bizs.getDepbiz().findAll();//�����б��׼��
		List<Welfare> lswf=bizs.getWbiz().findAll();//��ѡ��׼�����
		session.setAttribute("lsdep", lsdep);
		session.setAttribute("lswf", lswf);
		path="empadd.jsp";
		return "ok";
	}

}
