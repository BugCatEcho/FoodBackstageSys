package com.catecho.foodbackstagesys.Dao;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Chef;

public interface ChefDao {
//厨师接口实现的方法
	//登陆 查询一个厨师通过acc pwd
	public Chef queryOneByAccPwd(String acc ,String pwd) ;
	//查询所有
	public List<Chef> queryAll();
	//查询厨师通过id
	public Chef queryOneById(int id);
	//添加一个厨师
	public void addOne(Chef chef);
	//删除一个厨师通过id 
	public void delOneByid(int id);
	//更改一个厨师记录
	public void updataOne(Chef chef);
	public List<Chef> queryManyByPage(int i, int quantity);
}
