/*临时代码块 记得变为外部js文件  */
	$(document).ready(function() {
						// 当厨师界面载入时要执行的操作有 生成菜品表格
						writefoodview(1)
						$("#bt_submit_updata").click(function() {// 修改按钮监听开始
									console.log("点击了一次提交修改按钮")
									// 当这个按钮按下时应该ajax提交要提交的数据
									var urlflag = $("#urlflag").val()
									console.log(urlflag)
									console.log("执行异步修改方法")
										// 如果地址是更新用户
										$.ajax({
													url : urlflag,
													data : {
														"food.fid" : $(
																"input[name='food.fid']")
																.val(),
														"food.name" : $(
																"input[name='food.name']")
																.val(),
														"food.chef.cid" : $(
																"input[name='food.chef.cid']")
																.val(),
														"food.type.tid" : $(
																"select[name='food.type.tid']")
																.val(),
														"food.money" : $(
																"input[name='food.money']")
																.val(),
														"food.other" : $(
																"input[name='food.other']")
																.val()
													},
													type : "POST",
													dataType : "JSON",
													success : function(jsondata) {													
														$('#myModal').modal('hide');// 关闭弹窗
														alert("修改成功") 
														// 修改页面数据
														// 刷新页面数据方法
														writefoodview($(thispage).val());
													}
												})
								})// 修改按钮监听结束
				$("#bt_showaddview").click(function() {// 显示添加窗口按钮监听开始
									// 当显示添加按钮被按下时应当清空添加窗口的信息并重新赋值
									$("#addview_body").empty()// 删除添加窗口信息
									// 获得当前操作主题是userh还是food...
									var simpleurlflag = $("#simpleurlflag").val()
									console.log("正在操作的视图是"+ simpleurlflag)
									switch (simpleurlflag) {
									case "food":
										$("#addviewtitle").html("添加一道新菜品")// 修改标题
								// 理应现ajax获得所有类型和所有厨师
								/* 暂时先直接写厨师id和类型id */
								/* 18/12/20 异步获取单选类型按钮组与厨师select实现 */
								$("#addview_body").append(// 现写入表格大致
									"菜名:<input name='food.name' class='form-control'  type='text' placeholder='请输入菜名'/><br/>"
									+ "厨师:<input name='food.chef.cid' class='form-control'  type='text' placeholder='请输入厨师id'/><br/>"
									+ "类型:<select onChange='selectchange()' id='typeselect' name='food.type.tid' class='form-control'></select><br/>"																															
									+ "价钱:<input name='food.money' class='form-control'  type='number'  placeholder='0.00'/><br/>"
									+ "备注:<input name='food.other' class='form-control'  type='text' placeholder='请输入备注'/><br/>")
								$.ajax({
											url : "type_queryalljson",
											type : "POST",
											dataType : "JSON",
											success : function(jsondata) {
												console.log("querytypeall"+ jsondata)
												var typejson = jsondata.data // 获得typelist
												// <label class="btn
												// btn-primary"> <input
												// type="radio" name="type.name"
												// id="option2"
												// autocomplete="off">名字</label>
												for (var tpsi = 0; tpsi < typejson.length; tpsi++) {
													$("#typeselect	").append(// 向单选按钮组div写入按钮
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
										// 理应现ajax获得所有类型和所有厨师
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

								})// 显示添加窗口按钮监听结束
				$("#bt_submit_add").click(function() {// 提交添加按钮的监听开始
					var simpleurlflag = $("#simpleurlflag").val()
					console.log("正在执行异步添加一个" + simpleurlflag)
									switch (simpleurlflag) {
									case "food":
										$.ajax({
													url : simpleurlflag
															+ "_addonejson",
													data : {
														"food.name" : $(
																"input[name='food.name']")
																.val(),
														"food.money" : $(
																"input[name='food.money']")
																.val(),
														"food.chef.cid" : $(
																"input[name='food.chef.cid']")
																.val(),
														"food.type.tid" : $(
																"select[name='food.type.tid']")
																.val(),
														"food.other" : $(
																"input[name='food.other']")
																.val()
													},
													type : "POST",
													dataType : "JSON",
													success : function(jsondata) {
														$('#addModal').modal(
																		'hide')// 关闭模态框
														alert("添加成功");// 提示
														// 刷新页面数据方法
														writefoodview($(thispage).val());
													}
												})
										break;
									default:
										break;
									}
								})// 提交添加按钮的监听结束
			})
function selectchange(selectobj) { 
		$("#typeselect option").removeAttr("selected") 
		$("#typeselect option:selected").attr("selected","selected") 
}
function repage() {
// 这个方法用来初始化页码
$("#pagenum li").removeClass("active")
$("#thispage").val(1)
$("#bt_page1").html(1);
$("#bt_page2").html(2);
$("#bt_page3").html(3);
$("#bt_page4").html(4);
$("#bt_page5").html(5);
$("#bt_page1").addClass("active")
}
	function updatafoodajax(fid) {
		console.log("正在操作的id为:" + fid)
		// 异步更新菜品方法
		// 首先清空更改窗口的数据
		$("#updata_body").empty() // 写入前要先清除updata_body中的老内容
		// 异步获取该菜品的老数据并生成input
		$.ajax({
					url : "food_queryonejson",
					data : {
						"food.fid" : fid
					},
					type : "POST",
					dataType : "JSON",
					success : function(jsondata) {
						console.log(jsondata);
						var oldfood = jsondata.data;// 取出获得的老数据
						$("#updata_body").append(
							"正在修改的菜品ID为:"
							+ fid
							+ "<input name='food.fid' value='"+fid+"' type='hidden'><br/>"
							+ "菜名:<input value='"+oldfood.name+"' name='food.name' type='text' />"
							+ "<input value='"+oldfood.chef.cid+"'  name='food.chef.cid' type='hidden' />"
							+ "<input value='"+oldfood.type.tid+"'  name='food.type.tid' type='hidden' /><br/>"
							+ "单价:<input value='"+oldfood.money+"'  name='food.money' type='text' /><br/>"
							+ "简介:<input value='"+oldfood.other+"'  name='food.other' type='text' /><br/>")
					}
				})
	}
	function delfoodajax(fid) {
		// 异步删除菜品方法
		// ajax请求通过id删除该菜品
		$.ajax({
			url : "food_delonejson",
			data : {
				"food.fid" : fid
			},
			type : "POST",
			dataType : "JSON",
			success : function(jsondata) {
				// 刷新页面数据
				writefoodview($("#thispage").val())
			}
		})// 异步删除菜品完成
	}
	function repage() {
		// 这个方法用来初始化页码
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
		var numflag = $(btobj).text(); // 记得要先转为jquery对象才能使用
		console.log("pagetest="+numflag)
		if(numflag=="&laquo;"){
			numflag=1
		}
		console.log("正在跳转到第"+numflag+"页")
		// 获得想要跳转的页码后
		// 判断页码的正确性 不能小于1
		if (numflag > 0) {
			// 更改5个页码的文字bt_page1。。。bt_page5
			$("#thispage").val(numflag)// 让全局知道当前页数
			if (numflag < 4) {// 页码小于3则为12345
				var flag = (Number(numflag) + 1) 
				$("#pagenum li").removeClass("active")
				$("#bt_page1").html(1);
				$("#bt_page2").html(2);
				$("#bt_page3").html(3);
				$("#bt_page4").html(4);
				$("#bt_page5").html(5);
				$("#pagenum li:nth-child(" + flag + ")").addClass("active")
			} else {
				$("#thispage").val(numflag)// 让全局知道当前页数
				$("#pagenum li").removeClass("active")
				$("#bt_page1").html(Number(numflag) - 2);
				$("#bt_page2").html(Number(numflag) - 1);
				$("#bt_page3").html(Number(numflag));
				$("#bt_page4").html(Number(numflag) + 1);
				$("#bt_page5").html(Number(numflag) + 2);
				$("#midli").addClass("active")
			}
			// 页码大于maxpage-(页码一半长度)则为 maxpage-5 + + + +
			// 点击页码后更改页码样式class="active"给li
				writefoodview(numflag)
		} else {
			alert("操作有误请，请选择正确的页码！");
		}
	}
	function writefoodview(pagenum) {		
		// 页面刷新时记得将上方类型的阴影改为相应的还要修改下方updatade url
		// 移除其他的tag阴影
		$("[id$=tag]").removeClass("active");// 移除id以tag结尾的类属性
		// 添加food的阴影
		$("#foodtag").addClass("active");
		// 更改下方updataurl的属性
		$("#urlflag").attr("value", "food_updataonejson")
		$("#simpleurlflag").attr("value", "food")
		// 重新生成食品页面的方法
		if (pagenum<999|pagenum>0) {
		} else {
			pagenum = 1
		}// 该方法防止传入的页码为错误值
		$("#top").remove()// 清除原始的信息表格
		$.ajax({// 获得新的数据 food_querypagejson
					url : "food_querypagebychefjson",
					data : {
						"page" : pagenum,
						"chef.cid":$("#thiscefid").val()
					// 获取第一页的数据
					},  
					type : "POST",
					dataType : "JSON",
					success : function(jsondata) {
						console.log(jsondata); // test
						var json = jsondata.data;
						$("nav").after(// 书写标题行以及表格骨骼
							"<table id='top' class='table table-hover' >"  
							+ "<thead><tr>" + "<th>ID</th>"
							+ "<th>菜名</th>" + "<th>厨师</th>"
							+ "<th>类型</th>" + "<th>Other</th>"
							+ "<th>修改</th>" + "<th>删除</th>"
							+ "</tr></thead>" + "</table>");   
						// 向表格写入数据
						for (var i = json.length - 1; i > -1; i--) { 
							$("thead").after(
								"<tr id='"+json[i].uid+"' >"
								+ "<th id='idth' align='center'>" 
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
						}// 写入表格数据结束
					}// success结束
				})// ajx结束
	}
	