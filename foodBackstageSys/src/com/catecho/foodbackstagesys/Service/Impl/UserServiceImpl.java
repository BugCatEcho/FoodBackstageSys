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
		if (page < 1) {// ���ҳ��С��1��Ϊ1
			return ud.queryManyByPage(0, quantity);
		} else {
			return ud.queryManyByPage((page - 1) * quantity, quantity);
		}
	}

	@Override
	public void addmoney(int uid, double money) {
		// ����uid��ĳ�˼�Ǯ

		User olduser = ud.queryOneById(uid);// ��ȡԭ�����û�
		olduser.setMoney(olduser.getMoney() + money);// �������
		// ע:Ϊ�˷�ֹuser��������״̬�޷��������,���µ��ø��ķ����������
		ud.updataOne(olduser);
	}

	@Override
	public User queryonebyuid(Integer uid) {
		// ����uid��ѯһ���û�
		return ud.queryOneById(uid);
	}
}
