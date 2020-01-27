<%@ page import="com.ssm.stu.bean.newBean.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>宿舍管理系统 - 维修员用户</title>
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
	href="${APP_PATH }/static/css/index.css"
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
			<a href="#">欢迎维修员：${userInfo.getName()}</a></span>
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


<div class="main-container">
		<div class="sidebar" >
			<div id="wrapper">
		    <ul class="sidebar navbar-nav">
		      <li class="nav-item">
		        <a class="nav-link" href="#">
		          <span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
		          <span>设备维修情况</span></a>
		      </li>
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
<!-- 页面搭建 -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			    <h1>设备维修信息</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="stu_add_modal_btn">新增</button>
				<button class="btn btn-danger" id="stu_delete_all_btn">删除</button>
			</div>
		</div>
		<div class="table-container" style="height:300px;">
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="stu_tables">
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="check_all"/>
							</th>
							<th>#</th>
							<th>宿舍号</th>
							<th>报修事由</th>
							<th>报修时间</th>
							<th>维修状态</th>
							<th>更新时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
		</div>
		</div>
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area">
				
			</div>
		</div>
	</div>
</div>
</div>

</body>
</html>