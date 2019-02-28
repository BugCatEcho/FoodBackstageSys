package com.catecho.foodbackstagesys.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.catecho.foodbackstagesys.Entity.Chef;
import com.catecho.foodbackstagesys.Entity.Food;
import com.catecho.foodbackstagesys.Service.FoodService;

@Controller
@Scope("prototype")
public class FoodAction {
	@Resource
	FoodService fs;
	// foodaction
	Map<String, Object> map = new HashMap<>();
	Food food;
	int page;
	Chef chef;

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
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

	public String addonejson() {
		System.out.println("正在添加一道菜_类型为:"+food.getType().toString());
		// 食物的增加接口json
		fs.addone(food);
		putjson(map, 0, "addoneOK", null);
		return "addonejson1";
	}

	public String delonejson() {
		// 食物的删除接口json
		fs.delone(food.getFid());
		putjson(map, 0, "delOK", null);
		return "delonejson1";
	}

	public String updataonejson() {
		fs.updata(food);
		putjson(map, 0, "updataok", null);
		return "updataonejson1";
	}
	public String querypagejson() {
		List<Food> querypage = fs.querypage(page);
		//Hibernate.initialize(querypage);
		putjson(map, 0, "querypageOK", querypage);
		return "querypage1";
	}	
	public String queryonejson() {
		Food queryonebyid = fs.queryonebyid(food.getFid());
		//Hibernate.initialize(queryonebyid);
		putjson(map, 0, "查询一条菜品记录成功", queryonebyid);
		return "queryone1";
	}	
	public String querypagebychefjson() {
		//根据厨师查询他做的所有菜品中的某一页
			List<Food> foods=fs.querypagebycid(page,chef.getCid());
			//Hibernate.initialize(foods);//防止继续查询lazy对象
			putjson(map, 0, "查询一条菜品记录成功", foods);
			return "querypagebychefjson1";
		
	}

}
