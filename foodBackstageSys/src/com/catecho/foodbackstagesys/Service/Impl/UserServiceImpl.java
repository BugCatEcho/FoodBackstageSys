package com.catecho.foodbackstagesys.Service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catecho.foodbackstagesys.Dao.UserDao;
import com.catecho.foodbackstagesys.Entity.User;
import com.catecho.foodbackstagesys.Service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	UserDao ud;
	int quantity = 9;

	@Override
	public void addone(User user) {
		user.setMoney((double) Math.floor(user.getMoney() * 100) / 100);
		ud.addOne(user);

	}

	@Override
	public void delone(int uid) {
		ud.delOneById(uid);

	}

	@Override
	public void updataone(User user) {
		user.setMoney((double) Math.floor(user.getMoney() * 100) / 100);
		ud.updataOne(user);
	}

	@Override
	public List<User> querypage(int page) {
		if (page < 1) {// 如果页码小于1则为1
			return ud.queryManyByPage(0, quantity);
		} else {
			return ud.queryManyByPage((page - 1) * quantity, quantity);
		}
	}

	@Override
	public void addmoney(int uid, double money) {
		// 根据uid给某人加钱

		User olduser = ud.queryOneById(uid);// 获取原来的用户
		olduser.setMoney(olduser.getMoney() + money);// 更改余额
		// 注:为了防止user处于游离状态无法更改余额,重新调用更改方法更新余额
		ud.updataOne(olduser);
	}

	@Override
	public User queryonebyuid(Integer uid) {
		// 根据uid查询一个用户
		return ud.queryOneById(uid);
	}
}
