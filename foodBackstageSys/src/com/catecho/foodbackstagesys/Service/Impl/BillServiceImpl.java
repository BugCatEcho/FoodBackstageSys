package com.catecho.foodbackstagesys.Service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catecho.foodbackstagesys.Dao.BillDao;
import com.catecho.foodbackstagesys.Entity.Bill;
import com.catecho.foodbackstagesys.Service.BillService;

@Service("billService")
@Transactional
public class BillServiceImpl implements BillService {
	@Resource
	BillDao bd;
	int quantity = 3;

	@Override
	public List<Bill> querypage(int page) {
		if (page < 1) {// 如果页码小于1则为1
			return bd.queryManyByPage(0, quantity);
		} else {
			return bd.queryManyByPage((page - 1) * quantity, quantity);
		}
	}

	@Override
	public void addone(Bill bill) {
		bd.addone(bill);
	}

	@Override
	public void updataone(Bill bill) {
		bd.updateone(bill);
		
	}

	@Override
	public void delone(int bid) {
		bd.delone(bid);
		
	}

}
