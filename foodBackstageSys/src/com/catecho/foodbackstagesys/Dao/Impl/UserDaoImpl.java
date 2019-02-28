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
		// ͨ��spring������SF���session
		return sf.getCurrentSession();
	}

	@Override
	public User queryOneByAccPwd(String acc, String pwd) {
		// ����accpwd��ѯһ����¼
		return getSession().createQuery("from User where acc=?0 and pwd=?1",User.class).setParameter(0, acc).setParameter(1, pwd)
				.uniqueResult();
	}

	@Override
	public User queryOneById(int uid) {
		// ����ID��ѯһ����¼
		return getSession().createQuery("from User where uid=?0",User.class).setParameter(0, uid).uniqueResult();
	}

	@Override
	public User queryOneByName(String name) {
		// ����name��ѯһ����¼
		return getSession().createQuery("from User where name=?0",User.class).setParameter(0, name).uniqueResult();
	}

	@Override
	public User queryOneByAcc(String acc) {
		// �����˺Ų�ѯһ����¼
		return getSession().createQuery("from User where acc=?0",User.class).setParameter(0, acc).uniqueResult();
	}

	@Override
	public void addOne(User user) {
		//���һ���û�
		getSession().save(user);
	}

	@Override
	public void delOneById(int uid) {
		// ɾ��һ����¼����ID
		getSession().delete(queryOneById(uid));

	}

	@Override
	public void updataOne(User user) {
		// ����һ����¼
		getSession().update(user);
	}
	public List<User> queryManyByPage(int start,int amount) {
		//��ҳ��ѯ
		return getSession().createQuery("from User",User.class).setFirstResult(start).setMaxResults(amount).list();
	}
	public List<User> queryManyByPageAndText(int start,int amount,String text) {
		//��ҳģ����ѯ
		return getSession().createQuery("from Bill where name like ?0 or acc like ?0 or other like ?0",User.class).setParameter(0,"%"+text+"%").setFirstResult(start).setMaxResults(amount).list();
	}
}
