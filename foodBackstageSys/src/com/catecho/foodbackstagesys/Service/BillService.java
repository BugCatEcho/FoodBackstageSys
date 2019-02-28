package com.catecho.foodbackstagesys.Service;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Bill;

public interface BillService {

	//根据页数查询多条账单
	List<Bill> querypage(int page);
	//添加一条账单
	void addone(Bill bill);
	//修改一条账单
	void updataone(Bill bill);
	//删除一条账单
	void delone(int bid);

}
