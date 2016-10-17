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
	top: 40%;
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
					<li class="active"><a href="index.jsp">搜索</a></li>
					<li><a href="turn2add?">添加</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="row clearfix">
			<div class="col-md-8 col-md-offset-2 ">
				<h1>搜索结果</h1>
				<s:if test="putoutAuthor==1">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">作者信息</h3>
						<s:if test="tooMuchAuthor==1">
						<br>
						<span class="label label-info">Info</span>
						<span>存在重复的作者姓名</span>
						</s:if>
					</div>
					<div class=panel-body>
						<table class="table table-striped table-hover">
							<tr>
								<th>编号</th>
								<th>姓名</th>
								<th>年龄</th>
								<th>国籍</th>
							</tr>
							<s:iterator value="authors" var="x">
							<tr class="info">
								<td><s:property value="#x.authorId" /></td>
								<td><s:property value="#x.name" /></td>
								<td><s:property value="#x.age" /></td>
								<td><s:property value="#x.country" /></td>
							</tr>
							</s:iterator>
						</table>
					</div>
				</div>
				</s:if>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">书籍信息</h3>
					</div>
					<div class=panel-body>
						<table class="table table-striped table-hover">
							<tr>
								<th>#</th>
								<th>ISBN</th>
								<th>标题</th>
								<th>作者序号</th>
								<th>出版社</th>
								<th>出版日期</th>
								<th>价格</th>
								<th>操作</th>
							</tr>
							<s:iterator value="books" var="x">
								<s:set var="i" value="1"></s:set>
								<tr>
									<td><s:property value="%{#i}" /></td>
									<td><s:property value="#x.isbn" /></td>
									<td><s:property value="#x.title" /></td>
									<td><s:property value="#x.authorId" /></td>
									<td><s:property value="#x.publisher" /></td>
									<td><s:property value="#x.publishDate" /></td>
									<td><s:property value="#x.price" /></td>
									<td><a class="btn btn-danger  btn-xs"
										href="delete?aBook.isbn=<s:property value="#x.isbn"/>&aAuthor.name=<s:property value="aAuthor.name"/>">删除</a>
										<a class="btn btn-warning  btn-xs"
										href="turn2edit?aBook.isbn=<s:property value="#x.isbn"/>&aAuthor.name=<s:property value="aAuthor.name"/>">修改</a>
										</td>
								</tr>
								<s:set var="i" value="#i + 1" />
							</s:iterator>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
	<script src="https://code.jquery.com/jquery.js"></script>
	<!-- 包括所有已编译的插件 -->
	<script src="dist/js/bootstrap.min.js"></script>
</body>
</html>