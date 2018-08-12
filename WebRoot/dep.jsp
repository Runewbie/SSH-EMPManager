<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<s:if test="#session.lsdep==null">
	<c:redirect url="findAll_Dep.action"></c:redirect>
</s:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>部门列表</title>
</head>

<body>
<p align="center">部门列表</p>
<table width="500" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr>
    <td width="231" align="center" bgcolor="#00FF00">编号</td>
    <td width="259" align="center" bgcolor="#00FF00">名称</td>
    <td width="259" align="center" bgcolor="#00FF00">员工数量</td>
  </tr>
  <s:iterator value="#session.lsdep" var="dep">
  <tr>
    <td align="center">${dep.depid }</td>
    <td align="center">${dep.depname}</td>
<%--     <td align="center"><s:property value="#dep.emps.size" /> </td> --%>
    <td align="center"><s:property value="#dep.enums" /> </td>
  </tr>
  </s:iterator>
</table>
<hr />
<form id="form1" name="form1" method="post" action="save_Dep.action">
  <table width="400" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
      <td colspan="2" align="center" bgcolor="#00FF00">部门添加</td>
    </tr>
    <tr>
      <td align="center">部门名称</td>
      <td align="center">
      <s:textfield name="dep.depname"/>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#00FF00"><input type="submit" name="button" id="button" value="确定" /></td>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
</body>
</html>