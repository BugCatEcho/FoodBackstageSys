package com.catecho.foodbackstagesys.Dao;

import com.catecho.foodbackstagesys.Entity.Castle;

public interface CastleDao {
	//����Ա�ӿ�Ҫʵ�ֵķ���
	//��ѯ�û�ͨ���˺�����
	public Castle queryOneByAccPwd(String acc,String pwd);
	//��ѯbyId
	public Castle queryOneById(int cid);
	//��ѯbyName
	public Castle queryOneByName(String name);
	//��ѯbyAcc
	public Castle queryOneByAcc(String name);
}
