/*临时代码块 记得变为外部js文件  */
	$(document)
			.ready(
					function() {
						//当页面载入时要执行的操作有:
						//显示user表格
						writeuserview(1)
						//还有监听bt_submit_updata按钮 当提交时 获取需要获取的数据
						$("#bt_submit_updata").click(function() {//修改按钮监听开始
											console.log("点击了一次提交修改按钮")
											//当这个按钮按下时应该ajax提交要提交的数据
											var urlflag = $("#urlflag").val()
											console.log(urlflag)
											switch (urlflag) {
											case "user_updataonejson":
												console.log("执行异步修改方法")
												//如果地址是更新用户
												$.ajax({
															url : urlflag,
															data : {
																"user.uid" : $(
																		"#updata_body input[name='user.uid']")
																		.val(),
																"user.name" : $(
																		"#updata_body input[name='user.name']")
																		.val(),
																"user.acc" : $(
																		"#updata_body input[name='user.acc']")
																		.val(),
																"user.pwd" : $(
																		"#updata_body input[name='user.pwd']")
																		.val(),
																"user.money" : $(
																		"#updata_body input[name='user.money']")
																		.val(),
																"user.other" : $(
																		"#updata_body input[name='user.other']")
																		.val()
															},
															type : "POST",
															dataType : "JSON",
															success : function(jsondata) {
																$('#myModal').modal('hide')//关闭弹窗
																alert("修改成功");//提示
																//修改页面数据
																//刷新页面数据方法
																writeuserview($(thispage).val());
															}
														})
												break;
											case "food_updataonejson":
												console.log("执行异步修改方法")
												//如果地址是更新用户
												$.ajax({
															url : urlflag,
															data : {
																"food.fid" : $("#updata_body input[name='food.fid']").val(),
																"food.name" : $("#updata_body input[name='food.name']").val(),
																"food.chef.cid" : $("#updata_body input[name='food.chef.cid']").val(),
																"food.type.tid" : $("#updata_body input[name='food.type.tid']").val(),
																"food.money" : $("#updata_body input[name='food.money']").val(),
																"food.other" : $("#updata_body input[name='food.other']").val()
															},
															type : "POST",
															dataType : "JSON",
															success : function(jsondata) {
																$('#myModal').modal('hide')//关闭弹窗
																alert("修改成功");//提示
																//修改页面数据
																//刷新页面数据方法
																writefoodview($(thispage).val());
															}
														})

												break;
											case "chef_updataonejson":
												console.log("执行异步修改chef方法")
												//如果地址是更新用户
												$.ajax({
															url : urlflag,
															data : {
																"chef.cid" : $("#updata_body input[name='chef.cid']").val(),
																"chef.name" : $("#updata_body input[name='chef.name']").val(),
																"chef.acc" : $("input[name='chef.acc']").val(),
																"chef.pwd" : $("#updata_body input[name='chef.pwd']").val(),
																"chef.phone" : $("#updata_body input[name='chef.phone']").val(),
																"chef.other" : $("#updata_body input[name='chef.other']").val()
															},
															type : "POST",
															dataType : "JSON",
															success : function(jsondata) {
																$('#myModal').modal('hide')//关闭弹窗
																alert("修改成功");//提示
																//修改页面数据
																//刷新页面数据方法
																writechefview($(thispage).val());
															}
														})

												break;
											default:
												break;
											}
											//提交数据后记得清空updata表单
											//$("#updata_body").empty()//由于提供了更完善的选择器 不再会有取错值问题 所以为了美观可以暂时不清除
										})//修改按钮监听结束
						$("#bt_showaddview").click(function() {//显示添加窗口按钮监听开始
											//当显示添加按钮被按下时应当清空添加窗口的信息并重新赋值
											$("#addview_body").empty()//提交前记得清空添加表单的所有输入框 防止被找错										
											//获得当前操作主题是userh还是food...
											var simpleurlflag = $("#simpleurlflag").val()
											console.log("正在操作的视图是"+ simpleurlflag)
											switch (simpleurlflag) {
											case "user":
												$("#addviewtitle").html("添加一个新用户")//修改标题
												$("#addview_body").append(
													"姓名:<input name='user.name' class='form-control' type='text'  placeholder='请输入姓名'/><br/>"
													+ "账号:<input name='user.acc' class='form-control'  type='text'  placeholder='请输入账号'/><br/>"
													+ "密码:<input name='user.pwd' class='form-control'  type='text' placeholder='请输入密码'/><br/>"
													+ "余额:<input name='user.money' class='form-control'  value='0.00' type='number'/><br/>"
													+ "备注:<input name='user.other' class='form-control'  type='text' placeholder='请输入备注'/><br/>")
												break;
											case "food":
												$("#addviewtitle").html("添加一道新菜品")//修改标题
												//理应现ajax获得所有类型和所有厨师
												/* 暂时先直接写厨师id和类型id */
												/* 18/12/20 异步获取单选类型按钮组与厨师select实现 */
												$("#addview_body").append(//现写入表格大致
													"菜名:<input name='food.name' class='form-control'  type='text' placeholder='请输入菜名'/><br/>"
													+ "厨师:<input name='food.chef.cid' class='form-control'  type='text' placeholder='请输入厨师id'/><br/>"
													+ "类型:<select onChange='selectchange()' id='typeselect' name='food.type.tid' class='form-control'></select><br/>"//只有按钮组div 之后会插入按钮数据
													+ "价钱:<input name='food.money' class='form-control'  type='number'  placeholder='0.00'/><br/>"
													+ "备注:<input name='food.other' class='form-control'  type='text' placeholder='请输入备注'/><br/>")
												$.ajax({
															url : "type_queryalljson",
															type : "POST",
															dataType : "JSON",
															success : function(jsondata) {
																console.log("querytypeall"+ jsondata)
																var typejson = jsondata.data //获得typelist
																//<label class="btn btn-primary"> <input type="radio" name="type.name" id="option2" autocomplete="off">名字</label>
																for (var tpsi = 0; tpsi < typejson.length; tpsi++) {
																	$("#typeselect	").append(//向单选按钮组div写入按钮
																		"<option name='food.type.tid' value='"
																		+ typejson[tpsi].tid
																		+ "'>"
																		+ typejson[tpsi].name
																		+ "</option>")
																}
															}
														})
												break;
											case "chef":
												$("#addviewtitle").html("添加一个新厨师")
												//理应现ajax获得所有类型和所有厨师
												/* 暂时先直接写厨师id和类型id */
												$("#addview_body").append(
													"姓名:<input name='chef.name' class='form-control'  type='text' placeholder='请输入姓名'/><br/>"
													+ "账号:<input name='chef.acc' class='form-control'  type='text' placeholder='请输入账号'/><br/>"
													+ "密码:<input name='chef.pwd' class='form-control'  type='text' placeholder='请输入密码'/><br/>"
													+ "电话:<input name='chef.phone' class='form-control'  type='number' placeholder='请输入电话'/><br/>"
													+ "备注:<input name='chef.other' class='form-control'  type='text' placeholder='请输入备注'/><br/>")
												break;
											default:
												break;
											}
										})//显示添加窗口按钮监听结束
						$("#bt_submit_add").click(function() {//提交添加按钮的监听开始 
											var simpleurlflag = $("#simpleurlflag").val()
											console.log("正在执行异步添加一个"+ simpleurlflag)
											switch (simpleurlflag) {
											case "user":
												$.ajax({
															url : simpleurlflag + "_addonejson",
															data : {
																"user.name" : $(
																		"#addview_body input[name='user.name']")
																		.val(),
																"user.acc" : $(
																		"#addview_body input[name='user.acc']")
																		.val(),
																"user.pwd" : $(
																		"#addview_body input[name='user.pwd']")
																		.val(),
																"user.money" : $(
																		"#addview_body input[name='user.money']")
																		.val(),
																"user.other" : $(
																		"#addview_body input[name='user.other']")
																		.val()
															},
															type : "POST",
															dataType : "JSON",
															success : function(jsondata) {
																$('#addModal').modal('hide')//关闭模态框
																alert("添加成功");//提示
																//刷新页面数据方法
																writeuserview($(thispage).val());
															}
														})
												break;
											case "food":
												$.ajax({
															url : simpleurlflag + "_addonejson",
															data : {
																"food.name" : $(
																		"#addview_body input[name='food.name']")
																		.val(),
																"food.money" : $(
																		"#addview_body input[name='food.money']")
																		.val(),
																"food.chef.cid" : $(
																		"#addview_body input[name='food.chef.cid']")
																		.val(),
																"food.type.tid" : $(
																		"#addview_body select[name='food.type.tid']")
																		.val(),
																"food.other" : $(
																		"#addview_body input[name='food.other']")
																		.val()
															},
															type : "POST",
															dataType : "JSON",
															success : function(jsondata) {
																$('#addModal').modal('hide')//关闭模态框
																alert("添加成功");//提示
																//刷新页面数据方法
																writefoodview($(thispage).val());
															}
														})
												break;
											case "chef":
												$.ajax({
															url : simpleurlflag + "_addonejson",
															data : {
																"chef.name" : $("#addview_body input[name='chef.name']").val(),
																"chef.acc" : $("#addview_body input[name='chef.acc']").val(),
																"chef.pwd" : $("#addview_body input[name='chef.pwd']").val(),
																"chef.phone" : $("#addview_body input[name='chef.phone']").val(),
																"chef.other" : $("#addview_body input[name='chef.other']").val()
															},
															type : "POST",
															dataType : "JSON",
															success : function(jsondata) {
																$('#addModal').modal('hide')//关闭模态框
																alert("添加成功");//提示
																//刷新页面数据方法
																writechefview($(thispage).val());
															}
														})
												break;
											default:
												break;
											}
										})//提交添加按钮的监听结束
					})
	function selectchange(selectobj) {
		//
		/* $("#typeselect option").removeAttr("selected") 
		$("#typeselect option:selected").attr("selected","selected")  */
	}
	function repage() {
		//这个方法用来初始化页码
		$("#pagenum li").removeClass("active")
		$("#thispage").val(1)
		$("#bt_page1").html(1);
		$("#bt_page2").html(2);
		$("#bt_page3").html(3);
		$("#bt_page4").html(4);
		$("#bt_page5").html(5);
		$("#bt_page1").addClass("active")
	}
	function jumppage(btobj) {
		var numflag = $(btobj).text(); //记得要先转为jquery对象才能使用
		if(numflag=="首页"){ 
			console.log(numflag)
			numflag=Number(1)
		}
		//获得想要跳转的页码后
		//判断页码的正确性 不能小于1 
		if (numflag > 0) {
			//更改5个页码的文字bt_page1。。。bt_page5
			$("#thispage").val(numflag)//让全局知道当前页数
			if (numflag < 4) {//页码小于3则为12345
				var flag = (Number(numflag) + 1)
				$("#pagenum li").removeClass("active")
				$("#bt_page1").html(1);
				$("#bt_page2").html(2);
				$("#bt_page3").html(3);
				$("#bt_page4").html(4);
				$("#bt_page5").html(5);
				$("#pagenum li:nth-child(" + flag + ")").addClass("active")
			} else {
				$("#thispage").val(numflag)//让全局知道当前页数
				$("#pagenum li").removeClass("active")
				$("#bt_page1").html(Number(numflag) - 2);
				$("#bt_page2").html(Number(numflag) - 1);
				$("#bt_page3").html(Number(numflag));
				$("#bt_page4").html(Number(numflag) + 1);
				$("#bt_page5").html(Number(numflag) + 2);
				$("#midli").addClass("active")

			}
			//页码大于maxpage-(页码一半长度)则为 maxpage-5 + + + +

			//点击页码后更改页码样式class="active"给li

			var actionname = $("#simpleurlflag").val()
			console.log("正在获取第" + numflag + "页的" + actionname)
			switch (actionname) {
			case "user":
				writeuserview(numflag)
				break;
			case "food":
				writefoodview(numflag)
				break;
			case "chef":
				writechefview(numflag)
				break; 
			default:
				break;
			}

		} else {
			alert("违规的页码"); 
		}

	}
	function updatauserajax(uid) {
		//异步修改用户信息的方法
		//实现一个表单弹窗 已经用bootstrap 实现
		//为表单弹窗修改重要书数据 idkey (要修改的用户id 就是方法传进来的uid)
		$("#idkey").val(uid);//将修改页面中的要修改的id改为传进来的uid
		$("#updata_body").empty() //写入前要先清除updata_body中的老内容
		//为该表单生成要填写的参数框
		//先异步获得那个用户的老参数
		$.ajax({
					url : "user_queryonejson",
					data : {
						"user.uid" : uid
					},
					type : "POST",
					dataType : "JSON",
					success : function(jsondata) {
						console.log(jsondata);
						var olduser = jsondata.data//取出获得的老数据
						$("#updata_body").append(
										"正在修改的用户ID为:"+ uid
										+ "<input name='user.uid' value='"+uid+"' type='hidden'><br/>"
										+ "姓名:<input value='"+olduser.name+"' name='user.name' type='text' /><br/>"
										+ "账号:<input value='"+olduser.acc+"'  name='user.acc' type='text' /><br/>"
										+ "密码:<input value='"+olduser.pwd+"'  name='user.pwd' type='text' /><br/>"
										+ "余额:<input value='"+olduser.money+"'  name='user.money' type='Number' /><br/>"
										+ "其他:<input value='"+olduser.other+"'  name='user.other' type='text' /><br/>")

					}
				})
	}
	function updatachefajax(cid) {
		//异步更新菜品方法
		//首先清空更改窗口的数据
		$("#updata_body").empty() //写入前要先清除updata_body中的老内容
		//异步获取该厨师的老数据并生成input
		$.ajax({
					url : "chef_queryonejson",
					data : {
						"chef.cid" : cid
					},
					type : "POST",
					dataType : "JSON",
					success : function(jsondata) {
						console.log(jsondata);
						var oldchef = jsondata.data//取出获得的老数据
						/* <div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
						  <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
						</div>
						</div> */
						$("#updata_body").append(
										"正在修改的厨师ID为:"
												+ cid
												+ "<input name='chef.cid' value='"+cid+"' type='hidden'><br/>"
												+ "<div class='form-group'>"
												+ " <label for='inputEmail3' class='col-sm-2 control-label'>姓名</label>"
												+ " <div class='col-sm-10'>"
												+ " <input name='chef.name' value='"+oldchef.name+"' type='text' class='form-control' placeholder='厨师姓名'>"
												+ " </div> </div>"
												+ "<div class='form-group'>"
												+ " <label for='inputEmail3' class='col-sm-2 control-label'>账号</label>"
												+ " <div class='col-sm-10'>"
												+ " <input name='chef.acc'  value='"+oldchef.acc+"' type='text' id='disabledInput' class='disabled form-control' placeholder='账号' disabled>"
												+ " </div> </div>"
												+ "<div class='form-group'>"
												+ " <label for='inputEmail3' class='col-sm-2 control-label'>密码</label>"
												+ " <div class='col-sm-10'>"
												+ " <input name='chef.pwd'  value='"+oldchef.pwd+"' type='text' class='form-control' placeholder='密码' >"
												+ " </div> </div>"
												+ "<div class='form-group'>"
												+ " <label for='inputEmail3' class='col-sm-2 control-label'>电话</label>"
												+ " <div class='col-sm-10'>"
												+ " <input name='chef.phone'  value='"+oldchef.phone+"' type='text' class='form-control disabled' placeholder='手机号'>"
												+ " </div> </div>"
												+ "<div class='form-group'>"
												+ " <label for='inputEmail3' class='col-sm-2 control-label'>简介</label>"
												+ " <div class='col-sm-10'>"
												+ " <input name='chef.other'  value='"+oldchef.other+"' type='text' class='form-control disabled' placeholder='简介'>"
												+ " </div> </div>")
					}
				})
	}
	function updatafoodajax(fid) {
		console.log("正在操作的id为：" + fid)
		//异步更新菜品方法
		//首先清空更改窗口的数据
		$("#updata_body").empty() //写入前要先清除updata_body中的老内容
		//异步获取该菜品的老数据并生成input
		$.ajax({
					url : "food_queryonejson",
					data : {
						"food.fid" : fid
					},
					type : "POST",
					dataType : "JSON",
					success : function(jsondata) {
						console.log(jsondata);
						var oldfood = jsondata.data//取出获得的老数据
						$("#updata_body").append(
										"正在修改的菜品ID为:"
												+ fid
												+ "<input name='food.fid' value='"+fid+"' type='hidden'><br/>"
												+ "菜名:<input value='"+oldfood.name+"' name='food.name' type='text' />"
												+ "<input value='"+oldfood.chef.cid+"'  name='food.chef.cid' type='hidden' />"
												+ "<input value='"+oldfood.type.tid+"'  name='food.type.tid' type='hidden' /><br/>"
												+ "单价:<input value='"+oldfood.money+"'  name='food.money' type='number' /><br/>"
												+ "简介:<input value='"+oldfood.other+"'  name='food.other' type='text' /><br/>")

					}
				})

	}
	function deluserajax(uid) {
		//异步删除user的代码块
		$.ajax({
			url : "user_delonejson",
			data : {
				"user.uid" : uid
			},
			type : "POST",
			dataType : "JSON",
			success : function(jsondata) {
				console.log(jsondata);
				//调用更新界面方法
				writeuserview($("#thispage").val());
			}
		})

	}
	function delfoodajax(fid) {
		//异步删除菜品方法
		//ajax请求通过id删除该菜品
		$.ajax({
			url : "food_delonejson",
			data : {
				"food.fid" : fid
			},
			type : "POST",
			dataType : "JSON",
			success : function(jsondata) {
				console.log(jsondata);
				//刷新页面数据
				writefoodview($("#thispage").val())
			}
		})//异步删除菜品完成

	}
	function delchefajax(cid) {
		//异步删除厨师方法
		//ajax请求通过id删除该菜品
		$.ajax({
			url : "chef_delonejson",
			data : {
				"chef.cid" : cid
			},
			type : "POST",
			dataType : "JSON",
			success : function(jsondata) {
				console.log(jsondata);
				//刷新页面数据
				writechefview($("#thispage").val())
			}
		})//异步删除菜品完成

	}
	function writefoodview(pagenum) {
		//页面刷新时记得将上方类型的阴影改为相应的还要修改下方updatade url
		//移除其他的tag阴影
		$("[id$=tag]").removeClass("active");//移除id以tag结尾的类属性
		//添加food的阴影
		$("#foodtag").addClass("active");
		//更改下方updataurl的属性
		$("#urlflag").attr("value", "food_updataonejson")
		$("#simpleurlflag").attr("value", "food")
		//重新生成食品页面的方法
		if (pagenum<999|pagenum>0) {
		} else {
			pagenum = 1
		}//该方法防止传入的页码为错误值
		$("#top").remove()//清除原始的信息表格
		$.ajax({//获得新的数据 food_querypagejson
					url : "food_querypagejson",
					data : {
						"page" : pagenum
					//获取第一页的数据
					},
					type : "POST",
					dataType : "JSON",
					success : function(jsondata) {
						console.log(jsondata); //test
						var json = jsondata.data;
						$("nav").after(
								//书写标题行以及表格骨骼
								"<table id='top' class='table table-striped'>"
										+ "<thead><tr>" + "<th>ID</th>"
										+ "<th>菜名</th>" + "<th>厨师</th>"
										+ "<th>类型</th>" + "<th>类型</th>"
										+ "<th>Other</th>" + "<th>修改</th>"
										+ "<th>删除</th>" + "</tr></thead>"
										+ "</table>");
						//向表格写入数据
						for (var i = json.length - 1; i > -1; i--) {
							$("thead").after(
											"<tr id='"+json[i].uid+"'  align='center'>"
													+ "<th id='idth'>"
													+ (i + 1)
													+ "</th>"
													+ "<th>"
													+ json[i].name
													+ "</th>"
													+ "<th>"
													+ json[i].chef.name
													+ "</th>"
													+ "<th>"
													+ json[i].type.name
													+ "</th>"
													+ "<th>"
													+ json[i].money
													+ "</th>"
													+ "<th>"
													+ json[i].other
													+ "</th>"
													+ "<th>"
													+ "<a data-toggle='modal' data-target='#myModal' class='button button-primary button-rounded button-small' onclick='updatafoodajax("
													+ json[i].fid
													+ ")'>修改</a>"
													+ "</th>"
													+ "<th>"
													+ "<a class='button button-glow button-small button-caution' onclick='delfoodajax("
													+ json[i].fid
													+ ")'>删除</a>"
													+ "</th>" + "</tr>")
						}//写入表格数据结束
					}//success结束
				})//ajax结束
	}
	function writeuserview(pagenum) {
		//页面刷新时记得将上方类型的阴影改为相应的
		//移除其他的tag阴影
		$("[id$=tag]").removeClass("active");//移除id以tag结尾的类属性
		//添加usertag的阴影
		$("#usertag").addClass("active");
		//更改下方updataurl的属性
		$("#urlflag").attr("value", "user_updataonejson")
		$("#simpleurlflag").attr("value", "user")
		//这个方法可以清除页面数据并写入新的user表格
		if (pagenum<999|pagenum>0) {
		} else {
			pagenum = 1
		}//该方法防止传入的页码为错误值
		$("#top").remove();//移除老表格	
		//重新ajax异步获取数据
		$.ajax({
					url : "user_querypagejson",
					data : {
						"page" : pagenum
					//获取第一页的数据
					},
					type : "POST",
					dataType : "JSON",
					success : function(jsondata) {
						console.log(jsondata);
						//开始向后方写入数据
						//写入标题
						var json = jsondata.data;
						$("nav").after(
								"<table id='top' class='table table-striped'>"
										+ "<thead><tr>" + "<th>ID</th>"
										+ "<th>Name</th>" + "<th>Acc</th>"
										+ "<th>Money</th>" + "<th>Other</th>"
										+ "<th>修改</th>" + "<th>删除</th>"
										+ "</tr></thead>" + "</table>");
						for (var i = json.length - 1; i > -1; i--) {
							$("thead").after(
											"<tr id='"+json[i].uid+"'  align='center'>"
													+ "<th id='idth'>"
													+ (i + 1)
													+ "</th>"
													+ "<th>"
													+ json[i].name
													+ "</th>"
													+ "<th>"
													+ json[i].acc
													+ "</th>"
													+ "<th>"
													+ json[i].money
													+ "</th>"
													+ "<th>"
													+ json[i].other
													+ "</th>"
													+ "<th>"
													+ "<a data-toggle='modal' data-target='#myModal' class='button button-primary button-rounded button-small' onclick='updatauserajax("
													+ json[i].uid
													+ ")'>修改</a>"
													+ "</th>"
													+ "<th>"
													+ "<a class='button button-glow button-small button-caution' onclick='deluserajax("
													+ json[i].uid
													+ ")'>删除</a>"
													+ "</th>" + "</tr>")//写入结束
						}//for循环结束
					}//sussecc结束
				})//ajax结束
	}
	function writechefview(pagenum) {
		//页面刷新时记得将上方类型的阴影改为相应的
		//移除其他的tag阴影
		$("[id$=tag]").removeClass("active");//移除id以tag结尾的类属性
		//添加usertag的阴影
		$("#cheftag").addClass("active");
		//更改下方updataurl的属性
		$("#urlflag").attr("value", "chef_updataonejson")
		$("#simpleurlflag").attr("value", "chef")
		//这个方法可以清除页面数据并写入新的user表格
		if (pagenum<999|pagenum>0) {
		} else {
			pagenum = 1
		}//该方法防止传入的页码为错误值
		$("#top").remove();//移除老表格	
		//重新ajax异步获取数据
		$.ajax({
					url : "chef_querypagejson",
					data : {
						"page" : pagenum
					//获取第一页的数据
					},
					type : "POST",
					dataType : "JSON",
					success : function(jsondata) {
						console.log(jsondata);
						//开始向后方写入数据
						//写入标题
						var json = jsondata.data;
						$("nav").after(
								"<table id='top' class='table table-striped'>"
										+ "<thead><tr>" + "<th>ID</th>"
										+ "<th>姓名</th>" + "<th>账号</th>"
										+ "<th>密码</th>" + "<th>手机</th>"
										+ "<th>其他</th>" + "<th>修改</th>"
										+ "<th>删除</th>" + "</tr></thead>"
										+ "</table>");
						for (var i = json.length - 1; i > -1; i--) {
							$("thead")
									.after(
											"<tr id='"+json[i].uid+"'  align='center'>"
													+ "<th id='idth'>"
													+ (i + 1)
													+ "</th>"
													+ "<th>"
													+ json[i].name
													+ "</th>"
													+ "<th>"
													+ json[i].acc
													+ "</th>"
													+ "<th>"
													+ json[i].pwd
													+ "</th>"
													+ "<th>"
													+ json[i].phone
													+ "</th>"
													+ "<th>"
													+ json[i].other
													+ "</th>"
													+ "<th>"
													+ "<a data-toggle='modal' data-target='#myModal' class='button button-primary button-rounded button-small' onclick='updatachefajax("
													+ json[i].cid
													+ ")'>修改</a>"
													+ "</th>"
													+ "<th>"
													+ "<a class='button button-glow button-small button-caution' onclick='delchefajax("
													+ json[i].cid
													+ ")'>删除</a>"
													+ "</th>" + "</tr>")//写入结束
						}//for循环结束
					}//sussecc结束
				})//ajax结束
	}