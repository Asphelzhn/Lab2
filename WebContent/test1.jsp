<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="http://bootswatch.com/bower_components/bootstrap/dist/css/bootstrap.min.css">
	<link href="//cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
<title>book information search</title>

<style type="text/css">
div.pos_top
{
position:absolute;
top:40%;
}
div.pos_down
{
position:absolute;
bottom:20px
}
</style>
<style>
body 
{
	background-image:url('library.jpg ');
}
</style>

</head>
<body>


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">search</a></li>
        <li><a href="#">add</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container pos_top">

	<div class="row clearfix">
		<div class="col-md-12 column">
		<h1 class="text-center"><i class="fa fa-camera-retro fa-1x"></i>zhe li shi biao ti</h1>
		</div>
	</div>
<div>
	<form action="search" class="bs-example bs-example-form" role="form">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-5">
				<div class="input-group">
					<div class="input-group-btn">
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							123 
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li class="divider"></li>
							<li><a href="#">4</a></li>
						</ul>
					</div><!-- /btn-group -->
					<input type="text" name="aAuthor.name" class="form-control">
				</div><!-- /input-group -->
			</div><!-- /.col-lg-6 -->
			<div class="col-md-3">
	<button type="submit" class="btn btn-default">
		<i class="fa fa-search" aria-hidden="true"></i>
	</button>
			</div>
		</div><!-- /.row -->
	</form>

	
	
</div>




</div>



<div class="container">
    <div class="col-sm-7 pull-right well">
      <form class="form-inline" action="#" method="get">
        <div class="form-group col-sm-5">
          <input class="form-control" type="text" value="" placeholder="Search" name="q">
        </div>
        <div class="form-group col-sm-3">
          <select class="form-control" name="category">
              <option>select</option>
              <option>1</option>
              <option>2</option>
              <option>3</option>
          </select>
        </div>
        <button class="btn btn-primary col-sm-3 pull-right" type="submit">Search</button>
      </form>
    </div>
</div>





	
	
      <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="https://code.jquery.com/jquery.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>