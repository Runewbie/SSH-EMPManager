<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人力资源管理系统</title>
</head>

<body>
<table width="150" border="2" cellspacing="0" cellpadding="1" bordercolor="#00CC00">
<s:if test="#session.ad.levels==1">
  <tr>
    <td align="center" bgcolor="#FFCC33"><a href="dep.jsp" target="mainFrame">部门管理</a></td>
  </tr>
</s:if>

  <tr>
    <td align="center" bgcolor="#FFCC33"><a href="emplist.jsp" target="mainFrame">员工管理</a></td>
  </tr>

<s:if test="#session.ad.levels==1">
  <tr>
    <td align="center" bgcolor="#FFCC33"><a href="welfare.jsp" target="mainFrame">福利管理</a></td>
  </tr>
</s:if>

<s:if test="#session.ad.levels==1">
  <tr>
    <td align="center" bgcolor="#FFCC33"><a href="admin.jsp" target="mainFrame">用户管理</a></td>
  </tr>
</s:if>
  <tr>
    <td align="center" bgcolor="#FFCC33"><a href="login.jsp" target="_parent">退出登录</a></td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>