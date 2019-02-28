package com.catecho.foodbackstagesys.Service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catecho.foodbackstagesys.Dao.FoodDao;
import com.catecho.foodbackstagesys.Entity.Bill;
import com.catecho.foodbackstagesys.Entity.Food;
import com.catecho.foodbackstagesys.Service.FoodService;

@Service("foodService")
@Transactional
public class FoodServiceImpl implements FoodService {
	@Resource
	FoodDao fd;

	int quantity = 9;//每页显示多少条菜品数据

	@Override
	public void addone(Food food) {
		// TODO Auto-generated method stub
		if(food.getMoney()>=0) {
		food.setMoney((double) Math.floor(food.getMoney() * 100) / 100);
		fd.addOne(food);}else {
			System.out.println("errormsg_添加了错误的用户余额");
		}
	}

	@Override
	public void delone(int fid) {
		// TODO Auto-generated method stub
		fd.delOneBId(fid);

	}

	@Override
	public void updata(Food food) {
		// TODO Auto-generated method stub
		Food oldfood = fd.queryOneById(food.getFid());
		if (food.getName() != null || !"".equals(food.getName())) {
			oldfood.setName(food.getName());
		}
		if (food.getMoney() >=0) {
			//更新的价钱大于0			
			oldfood.setMoney((double) Math.floor(food.getMoney() * 100) / 100);
		}
		oldfood.setOther(food.getOther());
		fd.updataOne(oldfood);
	}

	@Override
	public List<Food> querypage(int page) {
		if (page < 1) {// 如果页码小于1则为1
			return fd.queryManyByPage(0, quantity);
		} else {
			return fd.queryManyByPage((page - 1) * quantity, quantity);
		}
	}

	@Override
	public Food queryonebyid(Integer fid) {
		// 通过id查询一道菜
		return fd.queryOneById(fid);
	}

	@Override
	public List<Food> querypagebycid(int page, Integer cid) {
		// 查询某厨师做的某一页的菜
		if (page < 1) {// 如果页码小于1则为1
			return fd.queryManyByPage(0, quantity, cid);
		} else {
			return fd.queryManyByPage((page - 1) * quantity, quantity, cid);
		}
	}
}
