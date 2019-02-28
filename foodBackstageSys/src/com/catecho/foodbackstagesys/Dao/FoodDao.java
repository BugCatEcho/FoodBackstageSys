package com.catecho.foodbackstagesys.Dao;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Food;

public interface FoodDao {
//ʳ��ӿ�Ҫʵ�ֵķ���
	//����ʳ��
	public void addOne(Food food);
	//ɾ��ʳ�� Byid
	public void delOneBId(int fid);
	//ɾ��һ��ʳ��ͨ������id
	public void delManyByTid(int tid);
	//�޸�һ��ʳ��
	public void updataOne(Food food);
	//��ѯһ��ʳ��ͨ��id
	public Food queryOneById(int fid);
	//��ѯ���ͨ������
	public List<Food> queryManyByTid(int tid);
	//�������ֻ��߽���ģ����ѯ
	public List<Food> queryManyByText(String text);
	//���ݳ�ʦid��ѯ��Ʒ
	public List<Food> queryManyByCid(int cid);
	//����ҳ����ѯ
	public List<Food> queryManyByPage(int start,int amount);
	public List<Food> queryManyByPage(int start, int amount, int cid);
}
