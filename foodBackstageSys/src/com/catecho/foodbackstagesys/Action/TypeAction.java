package com.catecho.foodbackstagesys.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.catecho.foodbackstagesys.Entity.Type;
import com.catecho.foodbackstagesys.Service.TypeService;
@Controller
@Scope("prototype")
public class TypeAction {
	Type type;
	Map<String, Object> map = new HashMap<>();
	@Resource
	TypeService ts;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public TypeService getTs() {
		return ts;
	}

	public void setTs(TypeService ts) {
		this.ts = ts;
	}

	private void putjson(Map json, int code, String msg, Object data) {
		json.put("code", code);
		json.put("msg", msg);
		json.put("data", data);
	}

	public String addonejson() {
		// 增加一个type的json接口
		ts.addone(type);
		putjson(map, 0, "添加成功", null);
		return "addone1";
	}

	public String delonejson() {
		ts.delone(type.getTid());
		putjson(map, 0, "删除成功", null);
		return "delonejson1";
	}

	public String updataonejson() {
		ts.updata(type);
		putjson(map, 0, "修改成功", null);
		return "updatajson1";

	}

	public String queryalljson() {
		putjson(map, 0, "查询成功",  ts.queryall());
		return "queryalljson1";
	}

}
