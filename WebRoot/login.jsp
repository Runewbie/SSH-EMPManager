<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<style type="text/css">
#apDiv1 {
	position: absolute;
	left: 117px;
	top: 17px;
	width: 257px;
	height: 80px;
	z-index: 1;
}
#apDiv2 {
	position: absolute;
	left: 412px;
	top: 179px;
	width: 273px;
	height: 90px;
	z-index: 1;
}
#apDiv3 {
	position: absolute;
	left: 431px;
	top: 91px;
	width: 418px;
	height: 89px;
	z-index: 2;
}
</style>
</head>

<body>
<div id="apDiv2">
  <form id="form1" name="form1" method="post" action="check_Admin.action">
    <table width="300" border="1" align="center" cellpadding="1" cellspacing="0">
      <tr>
        <td height="24" colspan="2" align="center" bgcolor="#00CC00">用户登录</td>
      </tr>
      <tr>
        <td width="88" align="center">用户名</td>
        <td width="202" align="left"><label for="admin.aname"></label>
        <input type="text" name="admin.aname" id="admin.aname" /></td>
      </tr>
      <tr>
        <td align="center">密码</td>
        <td align="left"><label for="admin.passwd"></label>
        <input type="password" name="admin.passwd" id="admin.passwd" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center" bgcolor="#00CC00"><input type="submit" name="button" id="button" value="确定" />
        <input type="reset" name="button2" id="button2" value="重置" /></td>
      </tr>
    </table>
  </form>
   <p>
    	<%
    		String error=request.getParameter("error");
        	if(error!=null&&!error.equals("")){
    	%>
    		<font color="red">用户名或者密码错误</font>
    	<%
    	}
    	%>
    </p>
</div>
<div id="apDiv3">
  <h1> 人力资源管理系统</h1>
</div>
</body>
</html>