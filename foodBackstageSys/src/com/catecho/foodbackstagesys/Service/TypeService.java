package com.catecho.foodbackstagesys.Service;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Type;

public interface TypeService {
	void addone(Type type);//��
	void delone(int tid);//ɾ
	void updata(Type type);//��
	List<Type> queryall();//��
}
