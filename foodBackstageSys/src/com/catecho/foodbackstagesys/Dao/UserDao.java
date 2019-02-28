package com.catecho.foodbackstagesys.Dao;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.User;

public interface UserDao {
//�û��ӿ�Ҫʵ�ֵķ���
	//��ѯһ���û�ͨ��ACCPWD
	public User queryOneByAccPwd(String acc,String pwd);
	//��ѯһ���û�ͨ��id
	public User queryOneById(int uid);
	//ͨ��name ��ѯuser
	public User queryOneByName(String name);
	//ͨ��Acc ��ѯuser
	public User queryOneByAcc(String acc);
	//����һ���û�
	public void addOne(User user);
	//ɾ��һ���û�ͨ��id
	public void delOneById(int uid);
	//����һ���û�
	public void updataOne(User user);
	//��ѯ����û�����ҳ��
	List<User> queryManyByPage(int start,int amount) ;
}
