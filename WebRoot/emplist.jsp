<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:if test="#session.pb==null">
	<c:redirect url="findAll_Emp.action"></c:redirect>
</s:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工列表</title>
<script type="text/javascript">
	/**
	更改每页记录数
	*/
	function doChangeRows(){
		var rows=document.form1.rows.value;
		if(isNaN(rows)){
			alert('请输入正确的数字！');
			document.form1.rows.value=${pb.rows};
			return;
		}
		window.location="findAll_Emp.action?rows="+rows;
	}
	/**
	更改当前页数
	*/
	function doChangePage(){
		var page=document.form1.page.value;
		if(isNaN(page)){
			alert('请输入正确的数字！');
			document.form1.page.value=${pb.page};
			return;
		}
		window.location="findAll_Emp.action?page="+page;
	}
	
	//删除提示
	function dodel(){
		return window.confirm('是否真的删除!');
	}
</script>

</head>

<body>
<p align="center">员工列表</p>
<hr />
<table width="770" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr>
    <td width="79" align="center" bgcolor="#00FF00">编号</td>
    <td width="94" align="center" bgcolor="#00FF00">姓名</td>
    <td width="85" align="center" bgcolor="#00FF00">性别</td>
    <td width="100" align="center" bgcolor="#00FF00">地址</td>
    <td width="102" align="center" bgcolor="#00FF00">生日</td>
    <td width="108" align="center" bgcolor="#00FF00">部门</td>
    <td width="172" align="center" bgcolor="#00FF00">操作</td>
  </tr>
  <s:iterator value="#session.pb.pagelist" var="emp">
  <tr>
    <td align="center">${emp.eid}</td>
    <td align="center"><a href="findDetail_Emp.action?eid=${emp.eid}">${emp.ename}</a></td>
    <td align="center">${emp.sex}</td>
    <td align="center">${emp.address}</td>
    <td align="center"><s:date name="#emp.birthday" format="yyyy-MM-dd"/></td>
    <td align="center">${emp.dep.depname}</td>
    <td align="center"><a href="delById_Emp.action?eid=${emp.eid}" onclick="return dodel()">删除</a> <a href="findById_Emp.action?eid=${emp.eid}">修改</a></td>
  </tr>
  </s:iterator>
</table>
<form id="form1" name="form1" method="post" action="">
  <table width="770" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
      <td width="63" align="center" bgcolor="#00FF00">
      	<s:if test="#session.pb.page>1">
      		<a href="findAll_Emp.action?page=1">首页</a>
      	</s:if>
      	<s:else>
      		首页
      	</s:else>
      </td>
      <td width="58" align="center" bgcolor="#00FF00">
      	<s:if test="#session.pb.page>1">
      		<a href="findAll_Emp.action?page=${pb.page-1}">上页</a>
      	</s:if>
      	<s:else>
      		上页
      	</s:else>
      </td>
      <td width="92" align="center" bgcolor="#00FF00">
      	<s:if test="#session.pb.page<#session.pb.maxpage">
      		<a href="findAll_Emp.action?page=${pb.page+1}">下页</a>
      	</s:if>
      	<s:else>
      		下页
      	</s:else>
      </td>
      <td width="84" align="center" bgcolor="#00FF00">
      	<s:if test="#session.pb.page<#session.pb.maxpage">
      		<a href="findAll_Emp.action?page=${pb.maxpage}">末页</a></td>
      	</s:if>
      	<s:else>
      		末页
      	</s:else>
      <td width="205" align="center" bgcolor="#00FF00">每页
        <label for="rows"></label>
      <input name="rows" value="${pb.rows }" type="text" id="rows" size="2" />
      条记录
      <input type="button" onclick="doChangeRows()" name="button" id="button" value="确定" /></td>
      <td width="178" align="center" bgcolor="#00FF00">跳转到
        <label for="page"></label>
      <input name="page" value="${pb.page }" type="text" id="page" size="2" />
      <label>页
        <input type="button" onclick="doChangePage()" name="button2" id="button2" value="确定" />
      </label></td>
      <td width="60" align="center" bgcolor="#00FF00">${pb.page}/${pb.maxpage}页</td>
    </tr>
  </table>
</form>
<p align="center"><a href="empadd.jsp">返回添加</a></p>
</body>
</html>