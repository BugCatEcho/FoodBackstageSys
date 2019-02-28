package com.catecho.foodbackstagesys.Service;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Food;

public interface FoodService {
	void addone(Food food);//Ôö
	void delone(int fid);//É¾
	void updata(Food food);//¸Ä
	List<Food> querypage(int page);//²é
	Food queryonebyid(Integer fid);
	List<Food> querypagebycid(int page, Integer cid);
}
