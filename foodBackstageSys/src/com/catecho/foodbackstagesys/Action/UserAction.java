package com.catecho.foodbackstagesys.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.catecho.foodbackstagesys.Entity.User;
import com.catecho.foodbackstagesys.Service.UserService;

@Controller
@Scope("prototype")
public class UserAction {
	@Resource
	UserService us;
	User user;
	Map<String, Object> map = new HashMap<String, Object>();
	int page;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	private void putjson(Map json, int code, String msg, Object data) {
		json.put("code", code);
		json.put("msg", msg);
		json.put("data", data);
	}

	public String querypagejson() {
		// 查询某一页的json接口
		List<User> querypage = us.querypage(page);
		//Hibernate.initialize(querypage);
		putjson(map, 0, "查询成功", querypage);
		return "querypagejson1";
	}

	public String addonejson() {
		// 添加一个用户的json接口
		us.addone(user);
		putjson(map, 0, "addOk", null);
		return "addonejson1";
	}

	public String delonejson() {
		// 删除一个用户的json接口
		us.delone(user.getUid());
		putjson(map, 0, "删除成功", null);
		return "delonejson1";
	}

	public String updataonejson() {
		us.updataone(user);
		putjson(map, 0, "updatajsonOK", null);
		return "updataonejson1";

	}

	public String queryonejson() {
		User queryonebyuid = us.queryonebyuid(user.getUid());
		//Hibernate.initialize(queryonebyuid);
		putjson(map, 0, "查询一个用户成功", queryonebyuid);

		return "queryonejson1";
	}
}
