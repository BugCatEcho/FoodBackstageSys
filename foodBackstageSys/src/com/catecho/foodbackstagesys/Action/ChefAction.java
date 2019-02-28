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
	// ��ʦservice
	Chef chef;
	// ���ڽ���ǰ��һ����ʦ����Ϣ
	Map<String, Object> map = new HashMap<>();
	// ���ڷ�����ǰ�˵�json
	int page;
	// ���ڽ���page

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
		if(cs.exist(chef.getAcc(),chef.getPwd())) {//����ʦ�Ƿ����
			Chef demo=cs.queryOneByAccPwd(chef.getAcc(),chef.getPwd());//ͨ���˺������ó�ʦ����
			//Hibernate.initialize(demo);//��ֹ������ѯlazy����
			System.out.println(demo.toString());//��ʾ�û���Ϣ ���ڲ���
			ServletActionContext.getRequest().setAttribute("chefme",demo);//�����û���������Ϣ����ǰ̨
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
		// ��ѯ���в�ͨ��struts
		List<Chef> findAll = cs.findAll();
		//Hibernate.initialize(findAll);
		putjson(map, 0, "queryallOK", findAll);
		return "queryalljson";
	}
	public String querypagejson() {
		//��ѯһҳ��ʦ
		List<Chef> querypage = cs.querypage(page);
		////Hibernate.initialize(querypage);
		putjson(map, 0, "��ѯ��ʦ�ɹ�",querypage);
		return "querypagejson1";		
	}

	public String addonejson() {
		cs.add(chef);
		putjson(map, 0, "addOK", "");
		return "addonejson1";
	}

	public String deljson() {
		// �첽ɾ������
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
		putjson(map, 0, "�޸ĳɹ�", null);
		return "updataonejson1";
	}
	public String queryonejson() {
		//ͨ��cid��ѯһ����ʦ�Ľӿ�
		putjson(map, 0, "��ѯone�ɹ�", cs.queryOneByCid(chef.getCid()));
		return "queryonejson1";
		
	}
}