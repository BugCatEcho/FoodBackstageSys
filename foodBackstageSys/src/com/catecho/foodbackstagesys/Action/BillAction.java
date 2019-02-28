package com.catecho.foodbackstagesys.Action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.catecho.foodbackstagesys.Entity.Bill;
import com.catecho.foodbackstagesys.Service.BillService;

@Controller
@Scope("prototype")
public class BillAction {
	@Resource
	BillService bs;
	Map<String, Object> json = new HashMap<>();
	Bill bill = new Bill();
	int page;

	public Map<String, Object> getJson() {
		return json;
	}

	public void setJson(Map<String, Object> json) {
		this.json = json;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	private void putjson(Map json, int code, String msg, Object data) {
		json.put("code",code);
		json.put("msg",msg);
		json.put("data",data);
	}

	public String showpagejson() {
		// ��ѯ�˵���json�ӿ�
		putjson(json, 0, "getOK", bs.querypage(page));
		return "showpagejson1";
	}

	public String addbilljson() {
		// ����˵���json�ӿ�
		bs.addone(bill);
		putjson(json, 1, "addOK", "");
		return "addbilljson1";
	}
	public String delonejson() {
		//ɾ���˵��Ľӿ�
		bs.delone(bill.getBid());
		putjson(json, 1, "delOK", "");
		return "delonejson1";
	}
}