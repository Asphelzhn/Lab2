<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://bootswatch.com/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link
	href="//cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">
<title>book information search</title>
<style type="text/css">
body, button, input, select, textarea, h1, h2, h3, h4, h5, h6 {
	font-family: Microsoft YaHei, '宋体', Tahoma, Helvetica, Arial,
		"\5b8b\4f53", sans-serif;
}
</style>
<style type="text/css">
div.pos_top {
	position: absolute;
	top: 35%;
}

div.pos_down {
	position: absolute;
	bottom: 20px
}
</style>
<style>
body {
	background-image: url('lalala.jpg ');
}
</style>
</head>
<body>


	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp"><i class="fa fa-home fx-2x" aria-hidden="true"></i></a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">搜索</a></li>
					<li><a href="turn2add?">添加</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container pos_top">

		<div class="row clearfix">
			<div class="col-md-6 col-md-offset-4 column">
				<h1 class="text-center">
					书籍信息检索
				</h1>
				<br>
			</div>
		</div>
		<div>
			<form action="searchByBookName" class="bs-example bs-example-form" role="form">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-6">
						<div class="input-group">
							<div class="input-group-btn">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown">
									按书名搜索<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="index.jsp">按作者搜索</a></li>
								</ul>
							</div>
							<!-- /btn-group -->
							<input type="text" name="aBook.title" class="form-control">
						
							<div class="input-group-btn">
								<button type="submit" class="btn btn-default">
								<i class="fa fa-search" aria-hidden="true"></i>
								</button>
							</div>
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->

				</div>
				<!-- /.row -->
			</form>
		</div>
		
		<s:if test="warring==1">
		<br>
		<br>
		<div  class="col-md-4 col-md-offset-5">
			<div class="alert alert-dismissible alert-info">
			  <button type="button" class="close" data-dismiss="alert">&times;</button>
			  未找到相关条目
			</div>
		</div>
		</s:if>
		
	</div>
	<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
	<script src="https://code.jquery.com/jquery.js"></script>
	<!-- 包括所有已编译的插件 -->
	<script src="dist/js/bootstrap.min.js"></script>
</body>
</html>