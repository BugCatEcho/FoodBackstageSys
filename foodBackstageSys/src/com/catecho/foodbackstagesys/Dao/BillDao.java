package com.catecho.foodbackstagesys.Dao;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Bill;

public interface BillDao {
	// �˵��ӿ�Ҫ��ʲô����
	// ����һ���˵�
	public void addone(Bill bill);

	// ɾ��һ���˵�
	public void delone(int bid);

	// �޸�һ���˵�
	public void updateone(Bill bill);

	// ��ѯһ���˵�byID
	public Bill queryOneById(int bid);

	// ͨ���û�id��ѯ������֮��ص��˵�
	public List<Bill> queryManyByUid(int uid);

	public List<Bill> queryManyByPage(int start,int amount);

}
