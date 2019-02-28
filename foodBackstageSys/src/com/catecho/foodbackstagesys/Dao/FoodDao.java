package com.catecho.foodbackstagesys.Dao;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Food;

public interface FoodDao {
//食物接口要实现的方法
	//增加食物
	public void addOne(Food food);
	//删除食物 Byid
	public void delOneBId(int fid);
	//删除一组食物通过类型id
	public void delManyByTid(int tid);
	//修改一个食物
	public void updataOne(Food food);
	//查询一个食物通过id
	public Food queryOneById(int fid);
	//查询多个通过类型
	public List<Food> queryManyByTid(int tid);
	//根据名字或者介绍模糊查询
	public List<Food> queryManyByText(String text);
	//根据厨师id查询菜品
	public List<Food> queryManyByCid(int cid);
	//根据页数查询
	public List<Food> queryManyByPage(int start,int amount);
	public List<Food> queryManyByPage(int start, int amount, int cid);
}
