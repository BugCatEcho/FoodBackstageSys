package com.catecho.foodbackstagesys.Service;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Food;

public interface FoodService {
	void addone(Food food);//��
	void delone(int fid);//ɾ
	void updata(Food food);//��
	List<Food> querypage(int page);//��
	Food queryonebyid(Integer fid);
	List<Food> querypagebycid(int page, Integer cid);
}
