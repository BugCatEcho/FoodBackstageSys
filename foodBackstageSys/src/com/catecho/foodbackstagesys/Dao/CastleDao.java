package com.catecho.foodbackstagesys.Dao;

import com.catecho.foodbackstagesys.Entity.Castle;

public interface CastleDao {
	//管理员接口要实现的方法
	//查询用户通过账号密码
	public Castle queryOneByAccPwd(String acc,String pwd);
	//查询byId
	public Castle queryOneById(int cid);
	//查询byName
	public Castle queryOneByName(String name);
	//查询byAcc
	public Castle queryOneByAcc(String name);
}
