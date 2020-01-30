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
				<input id="tab-3" type="radio" name="tab" class="sign-out">
				<label for="tab-3" class="tab">维修员登录</label>
				
				
				 <div class="login-form"> 
				 <form  id="stuForm">

					<div class="sign-in-htm">
						<div class="group">
							<input id="stuName" name="stuName" type="text" class="inputClass" placeholder="学生用户名" " autocomplete="off">
						</div> 
						<div class="group">
							<input id="stuPwd" name="stuPwd" type="password" class="inputClass" data-type="password"  placeholder="密码" autocomplete="off">
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
<form  id="maintainForm">

					<div class="sign-out-htm">
						<div class="group">
							<input id="maintainName" name="maintainName" type="text" class="inputClass" placeholder="维修员用户名" " autocomplete="off">
						</div> 
						<div class="group">
							<input id="maintainPwd" name="maintainPwd" type="password" class="inputClass" data-type="password"  placeholder="密码" autocomplete="off">
							<label class="label errorClass" id="maintainError"></label>
						</div>
						
							<div class="hr"></div>
						<div class="group">
							<input type="button" id="maintainbtn"  value="登 录">
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
						if(${userInfo.getIsAdmin()==3}){
							window.location.href="${APP_PATH}/bigadmin.jsp"
						}
						window.location.href="${APP_PATH}/index.jsp"
					}
					else{
						$("#adminError").text(result.extend.error)
					}
				}
			})
		})
		
		
		$("#tab-1").click(function(){
		$("#stuForm")[0].reset();
		$("#stuForm").find("#stuError").text("");
	});
		$("#stubtn").click(function(){
			$.ajax({
				url:"${APP_PATH}/studentLogin",
				type:"POST",
				data:$("#stuForm").serialize(),
				success:function(result){
					if(result.code==100){
						window.location.href="${APP_PATH}/stu.jsp"
					}else{
						$("#stuError").text(result.extend.error)
					}
				}
			})
		})
	
		
		$("#tab-3").click(function(){
		$("#maintainForm")[0].reset();
		$("#maintainForm").find("#maintainError").text("");
	});
		$("#maintainbtn").click(function(){
			$.ajax({
				url:"${APP_PATH}/maintainerLogin",
				type:"POST",
				data:$("#maintainForm").serialize(),
				success:function(result){
					if(result.code==100){
						window.location.href="${APP_PATH}/mend.jsp"
					}else{
						$("#maintainError").text(result.extend.error)
					}
				}
			})
		})
		
	</script>
  </body>
</html>
