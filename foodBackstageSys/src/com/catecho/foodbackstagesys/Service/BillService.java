package com.catecho.foodbackstagesys.Service;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Bill;

public interface BillService {

	//����ҳ����ѯ�����˵�
	List<Bill> querypage(int page);
	//���һ���˵�
	void addone(Bill bill);
	//�޸�һ���˵�
	void updataone(Bill bill);
	//ɾ��һ���˵�
	void delone(int bid);

}
