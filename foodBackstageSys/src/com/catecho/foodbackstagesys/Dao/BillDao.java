package com.catecho.foodbackstagesys.Dao;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Bill;

public interface BillDao {
	// 账单接口要有什么方法
	// 增加一条账单
	public void addone(Bill bill);

	// 删除一条账单
	public void delone(int bid);

	// 修改一条账单
	public void updateone(Bill bill);

	// 查询一条账单byID
	public Bill queryOneById(int bid);

	// 通过用户id查询所有与之相关的账单
	public List<Bill> queryManyByUid(int uid);

	public List<Bill> queryManyByPage(int start,int amount);

}
