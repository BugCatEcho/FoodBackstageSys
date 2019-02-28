package com.catecho.foodbackstagesys.Service;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.User;

public interface UserService {
	void addone(User user);// 增

	void delone(int uid);// 删

	void updataone(User user);// 改

	List<User> querypage(int page);// 查

	void addmoney(int uid, double money);// 加钱

	User queryonebyuid(Integer uid);

}
