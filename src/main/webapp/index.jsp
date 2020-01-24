<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生信息Insert title here</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
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
			<a href="#">欢迎管理员：</a></span>
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
		      <li class="nav-item active">
		        <a class="nav-link" href="${APP_PATH }/main.jsp " >
		        	<span class="glyphicon glyphicon-education" aria-hidden="true"></span>
		          <span>学生管理</span>
		        </a>
		      </li>
		
		      <li class="nav-item">
		        <a class="nav-link" href="#">
		        	<span class="glyphicon glyphicon-scale" aria-hidden="true"></span>
		          <span>水电费管理</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">
		          <span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
		          <span>维修管理</span></a>
		      </li>
		    </ul>
		</div>
		</div>
<div class="content-contain">
	<!-- 学生信息修改模态框 -->
<div class="modal fade" id="stuUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">学生信息修改</h4>
      </div>
      <div class="modal-body ">
		        <form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">学号：</label>
		    <div class="col-sm-4">
		      <p class="form-control-static" id="stuNum_update_static"></p>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">姓名：</label>
		    <div class="col-sm-4">
		      <input type="text" name="name" class="form-control" id="stuName_update" placeholder="赵琦">
		    	<span class="help-block"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">性别：</label>
		    <div class="col-sm-6">
		    <label class="radio-inline">
				  <input type="radio" name="sex" id="gender1_update" value="男" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="sex" id="gender2_update" value="女"> 女
				</label>
				</div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">班级：</label>
		    <div class="col-sm-6">
		      <input type="text" name="zclass" class="form-control" id="classname_update" placeholder="数字媒体技术">
		    	<span class="help-block"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">学院：</label>
		    <div class="col-sm-6">
		      <input type="text" name="tie" class="form-control" id="college_update" placeholder="医药信息工程学院">
		    	<span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">宿舍号：</label>
		    <div class="col-sm-4">
		      <select class="form-control" name="dormitoryId">
				</select>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="stu_update_btn">更新</button>
      </div>
    </div>
  </div>
</div>

<!-- 学生信息增加模态框 -->
<div class="modal fade" id="stuAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">学生信息添加</h4>
      </div>
      <div class="modal-body ">
		        <form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">学号：</label>
		    <div class="col-sm-4">
		      <input type="text" name="studentNumber" class="form-control" id="stuNum_add" placeholder="1420302302">
		    	<span class="help-block"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">姓名：</label>
		    <div class="col-sm-4">
		      <input type="text" name="name" class="form-control" id="stuName_add" placeholder="赵琦">
		    	<span class="help-block"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">性别：</label>
		    <div class="col-sm-6">
		    <label class="radio-inline">
				  <input type="radio" name="sex" id="gender1_add" value="男" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="sex" id="gender2_add" value="女"> 女
				</label>
				</div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">班级：</label>
		    <div class="col-sm-6">
		      <input type="text" name="zclass" class="form-control" id="classname_add" placeholder="数字媒体技术">
		    	<span class="help-block"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">学院：</label>
		    <div class="col-sm-6">
		      <input type="text" name="tie" class="form-control" id="college_add" placeholder="医药信息工程学院">
		    	<span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 col-md-offset-1 control-label">宿舍号：</label>
		    <div class="col-sm-4">
		      <select class="form-control" name="dormitoryId" >
				</select>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="stu_save_btn">保存</button>
      </div>
    </div>
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
			    <h1>学生信息</h1>
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
							<th>学号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>班级</th>
							<th>学院</th>
							<th>宿舍号</th>
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

	<script type="text/javascript">
		var totalRecord,currentPage;
		$(function(){
			//去首页
			to_page(1);
		});
	
		function to_page(pn){
			$.ajax({
				url:"${APP_PATH}/stu",
				data:"pn="+pn,
				type:"get",
				success:function(result){
					build_stu_table(result);
					build_page_info(result);
					build_page_nav(result);
				}
			});
		}
		
		function build_stu_table(result){
			$("#stu_tables tbody").empty();
			var stu=result.extend.pageInfo.list;
			$.each(stu,function(index,item){
				var checkBoxId=$("<td><input type='checkbox' class='check_item'/></td>");
				var stuIdTd=$("<td></td>").append(item.userId);
				var stuNumTd=$("<td></td>").append(item.studentNumber);
				var stuNameTd=$("<td></td>").append(item.name);
				var genderTd=$("<td></td>").append(item.sex);
				var classnameTd=$("<td></td>").append(item.zclass);
				var collegeTd=$("<td></td>").append(item.tie);
				var dormNumTd=$("<td></td>").append(item.dormitoryName);
				var editBtn=$("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
				            .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				//添加自定义属性，表示当前学生ID
				editBtn.attr("edit_id",item.userId);
				var delBtn=$("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
	            			.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				delBtn.attr("del_id",item.userId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
				$("<tr></tr>").append(checkBoxId)
					.append(stuIdTd)
					.append(stuNumTd).append(stuNameTd)
					.append(genderTd).append(classnameTd)
					.append(collegeTd).append(dormNumTd)
					.append(btnTd)
					.appendTo("#stu_tables tbody")
			});
		}
		function build_page_info(result){
			$("#page_info_area").empty();
			$("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页，总"+
					result.extend.pageInfo.pages+"页，总"+
					result.extend.pageInfo.total+"条记录 ");
			totalRecord=result.extend.pageInfo.total;
			currentPage=result.extend.pageInfo.pageNum;
		}
		function build_page_nav(result){
			$("#page_nav_area").empty();
			var ul=$("<ul></ul>").addClass("pagination");
			//首页和前一页
			var firstPageLi=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
			//判断是否有前一页，否则不能按	
			if(result.extend.pageInfo.hasPreviousPage==false){
					firstPageLi.addClass("disabled");
					prePageLi.addClass("disabled");
				}else{
					//为首页、前一页注册点击事件
					firstPageLi.click(function(){
						to_page(1);
					});
					prePageLi.click(function(){
						to_page(result.extend.pageInfo.pageNum-1);
					});
				}
			
			//末页和后一页
			var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			//判断是否有后前一页，否则不能按	
			if(result.extend.pageInfo.hasNextPage==false){
					nextPageLi.addClass("disabled");
					lastPageLi.addClass("disabled");
				}else{
					//为末页、后一页注册点击事件
					lastPageLi.click(function(){
						to_page(result.extend.pageInfo.pages);
					});
					nextPageLi.click(function(){
						to_page(result.extend.pageInfo.pageNum+1);
					});
				}
			
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi=$("<li></li>").append($("<a></a>").append(item));
					if(result.extend.pageInfo.pageNum==item){
						numLi.addClass("active");
					}
					numLi.click(function(){
						to_page(item);
					});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var navEle=$("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}
		
		//清除表单数据及样式
		function reset_form(ele){
			$(ele)[0].reset();
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");
			
		}
		/* 点击 学生增加事件弹出模态框 */
		$("#stu_add_modal_btn").click(function(){
			//清除表单数据
			reset_form("#stuAddModal form")
			//$("#stuAddModal form")[0].reset();
			//请求宿舍列表
			getDorm("#stuAddModal select");
			//弹出模态框
			$('#stuAddModal').modal({
				backdrop:"static"
			})
		})
		
		//获取全部的宿舍列表并显示在下拉框
		function getDorm(ele){
			$(ele).empty();
			$.ajax({
				url:"${APP_PATH}/dorm",
				type:"get",
				success:function(result){
					$("#stuAddModal select").append("")
					$.each(result.extend.dorm,function(){
						var optionEle=$("<option></option>").append(this.dormitoryName).attr("value",this.dormitoryId);
						optionEle.appendTo(ele);
					})
				}
			})
		}
		//校验表单数据方法
		function validate_add_form(){
			//校验学号
			var stuNum=$("#stuNum_add").val();
			var regNum=/^[1-9]\d{9}$/;
			if(!regNum.test(stuNum)){
				show_validate_msg("#stuNum_add","error","学号请输入10位有效数字");
				return false;
			}else{
				show_validate_msg("#stuNum_add","success","");
			};
			
			//校验姓名
			var stuName=$("#stuName_add").val();
			var regName=/^[\u2E80-\u9FFF]{2,5}$/;
			if(!regName.test(stuName)){
				show_validate_msg("#stuName_add","error","请输入正确姓名");
				return false;
			}else{
				show_validate_msg("#stuName_add","success","");
			};
			//校验班级
			var className=$("#classname_add").val();
			var regClassName=/^[\u2E80-\u9FFF]{3,10}\d{0,2}$/;
			if(!regClassName.test(className)){
				show_validate_msg("#classname_add","error","请输入正确班级");
				return false;
			}else{
				show_validate_msg("#classname_add","success","");
			};
			//校验学院
			var college=$("#college_add").val();
			var regCollege=/^[\u2E80-\u9FFF]{3,10}$/;
			if(!regCollege.test(college)){
				show_validate_msg("#college_add","error","请输入正确学院");
				return false;
			}else{
				show_validate_msg("#college_add","success","");
			};
			return true;
		}
		
		//设置校验错误、正确信息方法
		function show_validate_msg(ele,status,msg){
			//清除当前元素的校验状态 再进行下次校验
			$(ele).parent().removeClass("has-error has-success");
			$(ele).next("span").text("");
			if("success"==status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if("error"==status){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		//检验学号是否重复
		$("#stuNum_add").change(function(){
			var stuNum=this.value;
			$.ajax({
				url:"${APP_PATH}/checkstunum",
				data:"stuNum="+stuNum,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#stuNum_add","success","");
						$("#stu_save_btn").attr("ajax-va","success");
					}else{
						show_validate_msg("#stuNum_add","error",result.extend.va_msg);
						$("#stu_save_btn").attr("ajax-va","error");
					}
				}
			})
		})
		
		
		//为保存提供点击事件
		$("#stu_save_btn").click(function(){
			//校验数据
			 if(!validate_add_form()){
				return false;
			} 
			//检验学号是否重复
			if($(this).attr("ajax-va")=="error"){
				return false;
			}
			//发送ajax请求保存
			$.ajax({
				url:"${APP_PATH}/stus",
				type:"POST",
				data:$("#stuAddModal form").serialize(),//将表单中数据转化为字符串a=1&b=zhangsan这种形式
				success:function(result){
					$("#stuAddModal").modal('hide');
					//到最后一页显示插入数据
					to_page(totalRecord);
					
					//后台校验
					/* if(result.code==100){
						//保存后关闭模态框
						$("#stuAddModal").modal('hide');
						//到最后一页显示插入数据
						to_page(totalRecord);
					}else{
					/* 	if(undefined!=result.extend.errorFields.stuNum){
							show_validate_msg("#stuNum_add","error",result.extend.errorFields.stuNum);
						}
						if(undefined!=result.extend.errorFields.stuName){
							show_validate_msg("#stuName_add","error",result.extend.errorFields.stuName);
						}
						if(undefined!=result.extend.errorFields.classname){
							show_validate_msg("#classname_add","error",result.extend.errorFields.classname);
						}
						if(undefined!=result.extend.errorFields.college){
							show_validate_msg("#college_add","error",result.extend.errorFields.college);
						}
					} */
					
				}
			}) 
		})
		
		//编辑按钮绑定点击事件
		$(document).on("click",".edit_btn",function(){
			reset_form("#stuUpdateModal form")
			//查出宿舍列表
			getDorm("#stuUpdateModal select");
			//查出学生信息
			getStu($(this).attr("edit_id"));
			//把id传给更新按钮
			$("#stu_update_btn").attr("edit_id",$(this).attr("edit_id"))
			//打开模态框
			$('#stuUpdateModal').modal({
				backdrop:"static"
			})
		});
		
		function getStu(id){
			$.ajax({
				url:"${APP_PATH}/stus/"+id,
				type:"GET",
				success:function(result){
					
					 var stuData=result.extend.stu;
					$("#stuNum_update_static").text(stuData.stuNum);
					$("#stuName_update").val(stuData.stuName);
					
					$("#stuUpdateModal input[name=gender]").val([stuData.gender]);
					$("#classname_update").val(stuData.classname);
					$("#college_update").val(stuData.college);
					$("#stuUpdateModal select").val([stuData.dId]); 
				}
			})
		}
		
		//更新按钮 修改更新信息
		$("#stu_update_btn").click(function(){			
			//校验更新的信息
			//校验姓名
			var stuName=$("#stuName_update").val();
			var regName=/^[\u2E80-\u9FFF]{2,5}$/;
			if(!regName.test(stuName)){
				show_validate_msg("#stuName_update","error","请输入正确姓名");
				return false;
			}else{
				show_validate_msg("#stuName_update","success","");
			};
			//校验班级
			var className=$("#classname_update").val();
			var regClassName=/^[\u2E80-\u9FFF]{3,10}\d{0,2}$/;
			if(!regClassName.test(className)){
				show_validate_msg("#classname_update","error","请输入正确班级");
				return false;
			}else{
				show_validate_msg("#classname_update","success","");
			};
			//校验学院
			var college=$("#college_update").val();
			var regCollege=/^[\u2E80-\u9FFF]{3,10}$/;
			if(!regCollege.test(college)){
				show_validate_msg("#college_update","error","请输入正确学院");
				return false;
			}else{
				show_validate_msg("#college_update","success","");
			};
			//发送ajax请求保存更新数据
			$.ajax({
				url:"${APP_PATH}/stus/"+$(this).attr("edit_id"),
				type:"PUT",
				data:$("#stuUpdateModal form").serialize(),
				success:function(result){
					
					 $("#stuUpdateModal").modal('hide');
					//到最后一页显示插入数据
					to_page(currentPage); 
				}
			})
		})
		
		//删除按钮绑定点击事件
		$(document).on("click",".delete_btn",function(){
			var stuName=$(this).parents("tr").find("td:eq(3)").text();
			var stuId=$(this).attr("del_id");
			if(confirm("确认删除学生："+stuName+"吗?")){
				$.ajax({
					url:"${APP_PATH}/stus/"+stuId,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						to_page(currentPage);
					}
				})
			}
		})
		
		//全选 全不选功能
		$("#check_all").click(function(){
			$(".check_item").prop("checked",$(this).prop("checked"));
		})
		//check_item全选也显示按钮
		$(document).on("click",".check_item",function(){
			var flag= $(".check_item:checked").length==$(".check_item").length;
			$("#check_all").prop("checked",flag);
		})
		
		//点击全部删除/批量删除
		$("#stu_delete_all_btn").click(function(){
			var stuNames="";
			var stuIds="";
			$.each($(".check_item:checked"),function(){
				stuNames+=$(this).parents("tr").find("td:eq(3)").text()+",";
				stuIds+=$(this).parents("tr").find("td:eq(1)").text()+"-";
			})
			stuNames=stuNames.substring(0,stuNames.length-1);
			stuIds=stuIds.substring(0,stuIds.length-1);
			if(confirm("确认删除学生："+stuNames+" 吗?")){
				$.ajax({
					url:"${APP_PATH}/stus/"+stuIds,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						to_page(currentPage);
					}
				})
			}
		});
	</script>
</body>
</html>