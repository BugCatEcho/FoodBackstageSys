package com.catecho.foodbackstagesys.Action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.catecho.foodbackstagesys.Entity.Castle;
import com.catecho.foodbackstagesys.Service.CastleService;
@Controller
@Scope("prototype")
public class CastleAction {
	Castle castle=new Castle();
	@Resource
	CastleService cs;
	public Castle getCastle() {
		return castle;
	}
	public void setCastle(Castle castle) {
		this.castle = castle;
	}
	public String login() {
		if(cs.exist(castle.getAcc(),castle.getPwd())) {
			Castle demo=cs.queryOneByAccPwd(castle.getAcc(),castle.getPwd());
			ServletActionContext.getRequest().setAttribute("me",demo);
			return "login1";
		}
		return "login2";
	}
	
}
