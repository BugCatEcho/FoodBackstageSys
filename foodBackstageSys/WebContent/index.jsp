<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理登陆页面</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="css/buttons.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<script src="js/bootstrap.js"></script>
</head>
<body>
	<div class="tabbable col-md-12">
		<!-- Only required for left/right tabs -->
		<ul class="nav nav-tabs">
			<li class="active"><a href="#tab1" data-toggle="tab">厨师登陆</a></li>
			<li><a href="#tab2" data-toggle="tab">管理员登陆</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="tab1">
				<div class="container col-md-4 col-md-offset-4">
					<form id="form1" action="chef_login" method="post"
						class="form-signin">
						<h2 class="form-signin-heading">厨师登陆入口</h2>
						<label for="inputAccount" class="sr-only">账号</label> <input
							name="chef.acc" id="inputAccount" class="form-control"
							placeholder="账号" required autofocus> <label
							for="inputPassword" class="sr-only">密码</label> <input
							name="chef.pwd" type="password" id="inputPassword"
							class="form-control" placeholder="密码" required>
						<button class="button button-3d button-primary button-rounded col-md-4 col-md-offset-4" type="submit">登陆</button>
					</form>
				</div>  
				<!-- /over -->  
			</div>
			<div class="tab-pane" id="tab2">
				<div class="container col-md-4 col-md-offset-4"> 
					<form id="form1" action="castle_login" method="post"
						class="form-signin">
						<h2 class="form-signin-heading">管理登陆入口</h2>
						<label for="inputAccount" class="sr-only">账号</label> <input
							name="castle.acc" id="inputAccount" class="form-control"
							placeholder="账号" required autofocus> <label
							for="inputPassword" class="sr-only">密码</label> <input
							name="castle.pwd" type="password" id="inputPassword"
							class="form-control" placeholder="密码" required>
						<button class="button button-3d button-primary button-rounded col-md-4 col-md-offset-4" type="submit">登陆</button>
					</form>
				</div>
				<!-- /over -->
			</div>
		</div>
	</div>
</body>
</html>