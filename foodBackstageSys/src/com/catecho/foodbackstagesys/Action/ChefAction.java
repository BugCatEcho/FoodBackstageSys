package com.catecho.foodbackstagesys.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.catecho.foodbackstagesys.Entity.Chef;
import com.catecho.foodbackstagesys.Service.ChefService;

@Controller
@Scope("prototype")
public class ChefAction {

	@Resource
	ChefService cs;
	// 厨师service
	Chef chef;
	// 用于接收前端一个厨师的信息
	Map<String, Object> map = new HashMap<>();
	// 用于发送向前端的json
	int page;
	// 用于接收page

	public Map<String, Object> getMap() {
		return map;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Chef getMenu() {
		return chef;
	}

	public void setMenu(Chef chef) {
		this.chef = chef;
	}
	public String login() {
		if(cs.exist(chef.getAcc(),chef.getPwd())) {//检测厨师是否存在
			Chef demo=cs.queryOneByAccPwd(chef.getAcc(),chef.getPwd());//通过账号密码获得厨师对象
			//Hibernate.initialize(demo);//防止继续查询lazy对象
			System.out.println(demo.toString());//显示用户信息 用于测试
			ServletActionContext.getRequest().setAttribute("chefme",demo);//将该用户的所有信息传向前台
			return "login1";
		}
		return "login2";
	}
	private void putjson(Map json, int code, String msg, Object data) {
		json.put("code", code);
		json.put("msg", msg);
		json.put("data", data);
	}

	public String queryalljson() {
		// 查询所有并通过struts
		List<Chef> findAll = cs.findAll();
		//Hibernate.initialize(findAll);
		putjson(map, 0, "queryallOK", findAll);
		return "queryalljson";
	}
	public String querypagejson() {
		//查询一页厨师
		List<Chef> querypage = cs.querypage(page);
		////Hibernate.initialize(querypage);
		putjson(map, 0, "查询厨师成功",querypage);
		return "querypagejson1";		
	}

	public String addonejson() {
		cs.add(chef);
		putjson(map, 0, "addOK", "");
		return "addonejson1";
	}

	public String deljson() {
		// 异步删除方法
		try { 
			cs.delete(chef.getCid());
			putjson(map, 0, "delOK", null);
		} catch (Exception e) {
			// TODO: handle exception
			putjson(map, -2, "delError", null);
		}
		return "deletejson1";

	}
	public String updataonejson() {
		cs.updata(chef);
		putjson(map, 0, "修改成功", null);
		return "updataonejson1";
	}
	public String queryonejson() {
		//通过cid查询一个厨师的接口
		putjson(map, 0, "查询one成功", cs.queryOneByCid(chef.getCid()));
		return "queryonejson1";
		
	}
}