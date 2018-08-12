<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<s:if test="#session.lsad==null">
	<c:redirect url="findAll_Admin.action"></c:redirect>
</s:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工列表</title>
</head>

<body>
<p align="center">员工列表</p>
<table width="500" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr>
    <td width="89" align="center" bgcolor="#00FF00">编号</td>
    <td width="126" align="center" bgcolor="#00FF00">姓名</td>
    <td width="108" align="center" bgcolor="#00FF00">密码</td>
    <td width="54" align="center" bgcolor="#00FF00">级别</td>
    <td width="101" align="center" bgcolor="#00FF00">操作</td>
  </tr>
  <s:iterator value="#session.lsad" var="ad">
    <tr>
      <td align="center">${ad.aid}</td>
      <td align="center">${ad.aname}</td>
      <td align="center">${ad.passwd}</td>
      <td align="center">
      	<s:if test="#ad.levels==0">
      		员工
      	</s:if>
      	<s:else>
      		经理
      	</s:else>
      </td>
      <td align="center"><a href="delById_Admin.action?aid=${ad.aid}">删除</a> <a href="findById_Admin.action?aid=${ad.aid}">修改</a></td>
    </tr>
  </s:iterator>
</table>
<hr />
<form id="form1" name="form1" method="post" action="save_Admin.action">
  <table width="400" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
      <td colspan="2" align="center" bgcolor="#00FF00">员工添加</td>
    </tr>
    <tr>
      <td width="79" align="center">账号</td>
      <td width="311" align="left"><s:textfield name="admin.aname"/></td>
    </tr>
    <tr>
      <td align="center" bgcolor="#CCE8CF">密码</td>
      <td align="left" bgcolor="#CCE8CF"><s:password name="admin.passwd"/></td>
    </tr>
    <tr>
      <td align="center" bgcolor="#CCE8CF">级别</td>
      <td align="center" bgcolor="#CCE8CF"><s:radio name="admin.levels" list="#{0:'员工',1:'经理'}" listKey="key" listValue="value" value="0"/></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#00FF00"><input type="submit" name="button" id="button" value="保存" /></td>
    </tr>
  </table>
</form>
<p></p>
</body>
</html>