<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"><font color="red"><a href="${pageContext.request.contextPath}/customer/list.do">点我直接进入后台管理系统</a></font></h1>

<h1 align="center"><font color="red">用户登陆</font></h1>
		<form action="/testweb_fr/servlet01" method="post">
			<table align="center">
				<tr>
					<TD>用户名:</TD>
					<TD>
						<input id="username" type="text" name="username">
					</TD>
				</tr>
				<tr>
					<TD>密码:</TD>
					<TD>
						<input id="password" type="password" name="password" />
					</TD>
				</tr>
				<tr>
					<TD>验证码:</TD>
					<TD>
						<input id="check" type="text" name="check" size="4"/>
						<img id="checkimg" src="/testweb_fr/CheckImgServlet">
						<a onclick="changeImg()" href="javascript:void(0);">看不清换一张</a>
					</TD>
					
				</tr>
			
				<tr>
					<TD>
						<a href="register.html"><input id="register" type="button" name="register" value="注册" /></a>
					</TD>
					<TD>
						<input id="login" type="submit" name="login" value="登陆" />
					</TD>
				</tr>

			</table>
		</form>
</body>
<script>
	function changeImg(){
			document.getElementById("checkimg").src="/testweb_fr/CheckImgServlet?time="+new Date().getTime();
		}
</script>
</html>