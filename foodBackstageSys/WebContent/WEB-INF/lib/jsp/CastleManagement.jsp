<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>管理员页面</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/buttons.css" rel="stylesheet">

<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
<script src="js/jquery-3.3.1.js"></script>
<style type="text/css">
th {
	text-align: center;
}
</style>
<script src="js/castlejs.js"></script>
</head>
<body>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="js/jquery-3.3.1.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="js/bootstrap.min.js"></script>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">后台管理界面</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li id="usertag" class="active"><a href="#"
						onclick="writeuserview(1);repage()">用户管理 <span class="sr-only">(current)</span>
					</a></li>
					<li id="cheftag"><a href="#"
						onclick="writechefview(1);repage()">厨师管理</a></li>
					<li id="foodtag" class="active"><a href="#"
						onclick="writefoodview(1);repage()">菜品管理</a></li>
				</ul>
				<form class="navbar-form navbar-left" hidden="true">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<!-- <li><a href="#">Link</a></li> -->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><c:out value="${me.name}" /> <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class="disabled"><a href="#">开发功能</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="index.jsp">退出</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改页面</h4>
				</div>
				<div id="updata_body" class="modal-body">
					<!-- 中心 -->
				</div>
				<div class="modal-footer">
					<button id="bt_close" type="button" class="btn btn-default"
						data-dismiss="modal">关闭</button>
					<button id="bt_submit_updata" class="btn btn-primary">保存修改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 修改用户的修改框结束 -->
	<input id="urlflag" type="hidden" value="user_updataonejson" />
	<input id="simpleurlflag" type="hidden" value="user" />
	<input value="+" data-toggle='modal' data-target='#addModal'
		id="bt_showaddview"
		class="button button-caution button-circle button-jumbo" type="button"
		style="position: absolute; left: 10px; top: 90%;" />
	<!-- Modal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 id="addviewtitle" class="modal-title" id="myModalLabel">[添加一个新用户]</h4>
				</div>
				<div id="addview_body" class="modal-body">
					<!-- 中心 -->
				</div>
				<div class="modal-footer">
					<button id="bt_close" type="button" class="btn btn-default"
						data-dismiss="modal">关闭</button>
					<button id="bt_submit_add" class="btn btn-primary">添加</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加信息的表格结束 -->
	<div aria-label="...">
		<ul id="pagenum" class="pagination pagination-lg"
			style="position: absolute; margin-left: -230px; left: 50%; top: 83%;">
			<li ><a id="bt_pagenext" aria-hidden="true" onclick="jumppage(this)">首页</a>
			</li>
			<li class="active"><a id="bt_page1" onclick="jumppage(this)">1
			</a></li>
			<li><a id="bt_page2" href="#" onclick="jumppage(this)">2</a></li>
			<li id="midli"><a id="bt_page3" href="#"
				onclick="jumppage(this)">3</a></li>
			<li><a id="bt_page4" href="#" onclick="jumppage(this)">4</a></li>
			<li><a id="bt_page5" href="#" onclick="jumppage(this)">5</a></li>
			<li class="disabled"><a id="bt_pagenext" href="#" aria-label="Next"> <span
					aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</div>
	<!-- 当前页码 会根据各种操作变动 隐藏 -->
	<input id="thispage" value="1" type="hidden" />
</body>
</html>