package com.catecho.foodbackstagesys.Dao;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.User;

public interface UserDao {
//用户接口要实现的方法
	//查询一个用户通过ACCPWD
	public User queryOneByAccPwd(String acc,String pwd);
	//查询一个用户通过id
	public User queryOneById(int uid);
	//通过name 查询user
	public User queryOneByName(String name);
	//通过Acc 查询user
	public User queryOneByAcc(String acc);
	//增加一个用户
	public void addOne(User user);
	//删除一个用户通过id
	public void delOneById(int uid);
	//更改一个用户
	public void updataOne(User user);
	//查询多个用户根据页数
	List<User> queryManyByPage(int start,int amount) ;
}
