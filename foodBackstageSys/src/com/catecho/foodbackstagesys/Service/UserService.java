package com.catecho.foodbackstagesys.Service;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.User;

public interface UserService {
	void addone(User user);// ��

	void delone(int uid);// ɾ

	void updataone(User user);// ��

	List<User> querypage(int page);// ��

	void addmoney(int uid, double money);// ��Ǯ

	User queryonebyuid(Integer uid);

}
