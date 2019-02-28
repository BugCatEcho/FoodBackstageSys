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
		// ����һ��type��json�ӿ�
		ts.addone(type);
		putjson(map, 0, "��ӳɹ�", null);
		return "addone1";
	}

	public String delonejson() {
		ts.delone(type.getTid());
		putjson(map, 0, "ɾ���ɹ�", null);
		return "delonejson1";
	}

	public String updataonejson() {
		ts.updata(type);
		putjson(map, 0, "�޸ĳɹ�", null);
		return "updatajson1";

	}

	public String queryalljson() {
		putjson(map, 0, "��ѯ�ɹ�",  ts.queryall());
		return "queryalljson1";
	}

}
