package com.catecho.foodbackstagesys.Dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catecho.foodbackstagesys.Dao.UserDao;
import com.catecho.foodbackstagesys.Entity.Bill;
import com.catecho.foodbackstagesys.Entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Resource
	SessionFactory sf;

	private Session getSession() {
		// 通过spring创建的SF获得session
		return sf.getCurrentSession();
	}

	@Override
	public User queryOneByAccPwd(String acc, String pwd) {
		// 根据accpwd查询一条记录
		return getSession().createQuery("from User where acc=?0 and pwd=?1",User.class).setParameter(0, acc).setParameter(1, pwd)
				.uniqueResult();
	}

	@Override
	public User queryOneById(int uid) {
		// 根据ID查询一条记录
		return getSession().createQuery("from User where uid=?0",User.class).setParameter(0, uid).uniqueResult();
	}

	@Override
	public User queryOneByName(String name) {
		// 根据name查询一条记录
		return getSession().createQuery("from User where name=?0",User.class).setParameter(0, name).uniqueResult();
	}

	@Override
	public User queryOneByAcc(String acc) {
		// 根据账号查询一条记录
		return getSession().createQuery("from User where acc=?0",User.class).setParameter(0, acc).uniqueResult();
	}

	@Override
	public void addOne(User user) {
		//添加一个用户
		getSession().save(user);
	}

	@Override
	public void delOneById(int uid) {
		// 删除一条记录根据ID
		getSession().delete(queryOneById(uid));

	}

	@Override
	public void updataOne(User user) {
		// 更新一条记录
		getSession().update(user);
	}
	public List<User> queryManyByPage(int start,int amount) {
		//分页查询
		return getSession().createQuery("from User",User.class).setFirstResult(start).setMaxResults(amount).list();
	}
	public List<User> queryManyByPageAndText(int start,int amount,String text) {
		//分页模糊查询
		return getSession().createQuery("from Bill where name like ?0 or acc like ?0 or other like ?0",User.class).setParameter(0,"%"+text+"%").setFirstResult(start).setMaxResults(amount).list();
	}
}
