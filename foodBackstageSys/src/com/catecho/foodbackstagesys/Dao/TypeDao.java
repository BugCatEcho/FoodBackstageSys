package com.catecho.foodbackstagesys.Dao;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Type;

public interface TypeDao {
//���ͽӿ�Ҫʵ�ֵķ���
	//����һ������
	public void addOne(Type type);
	//ɾ��һ������byID
	public void delOneById(int tid);
	//����һ������
	public void updataOne(Type type);
	//��ѯһ������ͨ��id
	public Type queryOneById(int id);
	//��ѯһ������ͨ��name
	public Type queryOneByName(String name);
	//��ѯ���е�����
	public List<Type> queryAll();
}
