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
		// ��ѯĳһҳ��json�ӿ�
		List<User> querypage = us.querypage(page);
		//Hibernate.initialize(querypage);
		putjson(map, 0, "��ѯ�ɹ�", querypage);
		return "querypagejson1";
	}

	public String addonejson() {
		// ���һ���û���json�ӿ�
		us.addone(user);
		putjson(map, 0, "addOk", null);
		return "addonejson1";
	}

	public String delonejson() {
		// ɾ��һ���û���json�ӿ�
		us.delone(user.getUid());
		putjson(map, 0, "ɾ���ɹ�", null);
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
		putjson(map, 0, "��ѯһ���û��ɹ�", queryonebyuid);

		return "queryonejson1";
	}
}
