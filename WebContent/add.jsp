<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
					<li><a href="index.jsp">搜索</a></li>
					<li class="active"><a href="turn2add?">添加</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="row clearfix">
			<div class="col-md-6 col-md-offset-3 ">
			<ul class="nav nav-tabs">
  				<li class="active" aria-expanded="true"><a  href="#home" data-toggle="tab">添加书籍</a></li>
  				<li aria-expanded="false"><a href="#profile" data-toggle="tab">添加作者</a></li>
			</ul>

				<div id="myTabContent" class="tab-content">
  				<div class="tab-pane fade active in" id="home">
				<form class="form-horizontal" action="add" method="execute">
					<fieldset>
						<legend>书籍信息</legend>
						<div class="form-group">
							<label for="inputTitle" class="col-lg-2 control-label">标题</label>
							<div class="col-lg-10">
								<input type="text" maxlength="128" required="required" class="form-control" id="inputTitle"
									name="newBook.title" placeholder="请输入标题">
							</div>
						</div>
						<div class="form-group">
							<label for="inputAuthor" class="col-lg-2 control-label">作者</label>
							<div class="col-lg-10">
        						<s:select  Class="form-control" list="authors" listKey="authorId" listValue="name" name="newBook.authorId"  headerKey="" headerValue="-请选择-" >
   								</s:select>
								<s:if test="warring==0">
        						<span class="help-block">找不到作者请点击上方添加新的作者</span>
        						</s:if>
								<s:if test="warring==2">
        						<div class="alert alert-dismissible alert-success">
  								<button type="button" class="close" data-dismiss="alert">&times;</button>
  								<strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
								</div>
								</s:if>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPublisher" class="col-lg-2 control-label">出版社</label>
							<div class="col-lg-10">
								<input type="text" maxlength="128" class="form-control" id="inputPublisher"
									name="newBook.publisher" placeholder="请输入出版社">
							</div>
						</div>
						<div class="form-group">
							<label for="inputDate" class="col-lg-2 control-label">出版日期</label>
							<div class="col-lg-10">
								<input type="date" class="form-control" id="inputDate"
									name="newBook.publishDate" placeholder="日期">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPrice" class="col-lg-2 control-label">价格</label>
							<div class="col-lg-10">
								<input type="text" maxlength="128" pattern="[0-9]*" class="form-control" id="inputPrice"
									name="newBook.price" placeholder="请输入价格">
							</div>
						</div>
						<div class="form-group">
							<label for="inputIsbn"  class="col-lg-2 control-label">ISBN</label>
							<div class="col-lg-10">
								<input type="text" maxlength="13" required="required" pattern="[0-9]*" class="form-control" id="inputIsbn"
									name="newBook.isbn" placeholder="请输入书籍的ISBN">
									<s:if test="warring==1">
								<div class="alert alert-dismissible alert-danger">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<strong>ISBN冲突!</strong><br>数据库中已有此条目。 
								</div>
									</s:if>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2">
								<button type="reset" class="btn btn-default">取消</button>
								<input type="submit" value="提交" class="btn btn-primary" />
							</div>
						</div>
					</fieldset>
				</form>
				</div>
				<div class="tab-pane fade" id="profile">
				<form class="form-horizontal" action="addAuthor" >
					<fieldset>
						<legend>作者</legend>
						<div class="form-group">
							<label for="inputName" class="col-lg-2 control-label">姓名</label>
							<div class="col-lg-10">
								<input type="text" required="required" class="form-control" id="inputName"
									name="newAuthor.name" placeholder="请输入作者姓名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputAge"  class="col-lg-2 control-label">年龄</label>
							<div class="col-lg-10">
								<input type="text" maxlength="128" pattern="[0-9]*" class="form-control" id="inputAge"
									name="newAuthor.age" placeholder="请输入作者年龄">
							</div>
						</div>
						<div class="form-group">
							<label for="inputCountry" class="col-lg-2 control-label">国籍</label>
							<div class="col-lg-10">
								<input type="text" maxlength="128" class="form-control" id="inputCountry"
									name="newAuthor.country" placeholder="请输入作者国籍">
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2">
								<button type="reset" class="btn btn-default">取消</button>
								<input type="submit" value="提交" class="btn btn-primary" />
							</div>
						</div>
					</fieldset>
				</form>
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