<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<html>
  <head>
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${APP_PATH }/static/jquery/jquery-1.12.4.min.js"></script>
	<link href="${APP_PATH }/static/css/login.css" rel="stylesheet">


	
  </head>
  
    <div class="jq22-container" style="padding-top:50px">
		<div class="login-wrap">
			<div class="login-html">
				<input id="tab-1" type="radio" name="tab" class="sign-in" checked>
				<label for="tab-1" class="tab">学生登录</label>
				<input id="tab-2" type="radio" name="tab" class="sign-up">
				<label for="tab-2" class="tab">管理员登录</label>
				
				 <div class="login-form"> 
				 <form  id="stuForm">

					<div class="sign-in-htm">
						<div class="group">
							<input id="username" name="loginname" type="text" class="inputClass" placeholder="学生用户名" " autocomplete="off">
						</div> 
						<div class="group">
							<input id="password" name="loginpass" type="password" class="inputClass" data-type="password"  placeholder="密码" autocomplete="off">
							<label class="label errorClass" id="stuError"></label>
						</div>
						
							<div class="hr"></div>
						<div class="group">
							<input type="button" id="stubtn"  value="登 录">
						</div>

					</div> 
				</form>
				
				<form  id="adminForm" >

					<div class="sign-up-htm">
						<div class="group">
							<input id="adminName" name="adminName" type="text" class="inputClass" placeholder="管理员用户名" autocomplete="off" >
						</div>
						<div class="group">
						<input id="adminPwd" name="adminPwd" type="password" class="inputClass" data-type="password" placeholder="密码" autocomplete="off" >
							<label class="label errorClass" id="adminError"></label>
						</div>
							<div class="hr"></div>
						<div class="group">
							<input type="button" id="adminbtn" value="登录">
						</div>
						

					</div>
				</form>	

				</div>
			</div>
		</div>
	</div>
	<script>
	$("#tab-2").click(function(){
		$("#adminForm")[0].reset();
		$("#adminForm").find("#adminError").text("");
	});
		$("#adminbtn").click(function(){
			$.ajax({
				url:"${APP_PATH}/adminlog",
				type:"POST",
				data:$("#adminForm").serialize(),
				success:function(result){
					if(result.code==100){
						window.location.href="../../index.jsp"
					}else{
						$("#adminError").text(result.extend.error)
					}
				}
			})
		})
	
		
	</script>
  </body>
</html>
