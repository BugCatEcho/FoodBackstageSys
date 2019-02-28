package com.catecho.foodbackstagesys.Dao;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Type;

public interface TypeDao {
//类型接口要实现的方法
	//增加一个类型
	public void addOne(Type type);
	//删除一个类型byID
	public void delOneById(int tid);
	//更改一个类型
	public void updataOne(Type type);
	//查询一个类型通过id
	public Type queryOneById(int id);
	//查询一个类型通过name
	public Type queryOneByName(String name);
	//查询所有的类型
	public List<Type> queryAll();
}
