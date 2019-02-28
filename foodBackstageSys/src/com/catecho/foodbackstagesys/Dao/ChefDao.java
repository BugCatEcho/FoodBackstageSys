package com.catecho.foodbackstagesys.Dao;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Chef;

public interface ChefDao {
//��ʦ�ӿ�ʵ�ֵķ���
	//��½ ��ѯһ����ʦͨ��acc pwd
	public Chef queryOneByAccPwd(String acc ,String pwd) ;
	//��ѯ����
	public List<Chef> queryAll();
	//��ѯ��ʦͨ��id
	public Chef queryOneById(int id);
	//���һ����ʦ
	public void addOne(Chef chef);
	//ɾ��һ����ʦͨ��id 
	public void delOneByid(int id);
	//����һ����ʦ��¼
	public void updataOne(Chef chef);
	public List<Chef> queryManyByPage(int i, int quantity);
}
