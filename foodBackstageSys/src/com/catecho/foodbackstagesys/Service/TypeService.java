package com.catecho.foodbackstagesys.Service;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Type;

public interface TypeService {
	void addone(Type type);//Ôö
	void delone(int tid);//É¾
	void updata(Type type);//¸Ä
	List<Type> queryall();//²é
}
