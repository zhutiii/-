<%@ page import="com.ssm.stu.bean.newBean.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>宿舍管理系统 - 学生用户</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
    User userInfo = (User) request.getSession().getAttribute("userInfo");
%>
<script type="text/javascript"
	src="${APP_PATH }/static/jquery/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet">
	<link
	href="${APP_PATH }/static/css/stu1.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
      </button>
      <a class="navbar-brand" href="#">宿舍管理系统</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
     
      <ul class="nav navbar-nav navbar-right">
      	 
        <li>
			<a href="#">欢迎学生：${userInfo.getName()}</a></span>
        	</li>
        	<li>
			<a><span class="glyphicon glyphicon-user" aria-hidden="true" style="color: #fff;"></span></a>
        	</li>
        <li class="logout">
          <a href="#" class="loggout-toggle" data-toggle="modal" data-target="#logoutModal" role="button" aria-haspopup="true" aria-expanded="false">退出</a>
          
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<div class="sidebar" >
	<div id="wrapper">
    <ul class="sidebar navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${APP_PATH }/stu.jsp" >
        	<span class="glyphicon glyphicon-education" aria-hidden="true"></span>
          <span>个人信息查看</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link" href="${APP_PATH }/stu2.jsp">
        	<span class="glyphicon glyphicon-scale" aria-hidden="true"></span>
          <span>水电费查看</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${APP_PATH }/stu3.jsp">
          <span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
          <span>设备报修维护</span></a>
      </li>
    </ul>

</div>
<img src="static/images/stu.jpg" alt="">
     <div class="container">
		<p><h3 style="text-align: right;padding-right: 20px;">个人信息</h3></p>
		<hr>
		<ul class="xinxi">
			<li>姓名：${userInfo.getName()}</li>
			<li>性别：${userInfo.getSex()}</li>
			<li>学号：${userInfo.getStudentNumber()}</li>
			<li>班级：${userInfo.getZclass()}</li>
			<li>学院：${userInfo.getTie()}</li>
			<li>宿舍号：${userInfo.getDormitoryId()}</li>
			<li>宿舍管理员：${userInfo.getAdminName()}</li>
			<li>宿管联系方式：${userInfo.getAdminPhone()}</li>
	</ul>

</div>
</div>

<!-- 退出模态框 -->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">退出系统</h4>
      </div>
      <div class="modal-body">
        <p>你确定要退出吗？</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary"><a href="${APP_PATH }/logout" style="color:#fff;">退出</a></button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


</body>
</html>