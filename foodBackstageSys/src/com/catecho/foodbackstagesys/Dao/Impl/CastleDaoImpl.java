package com.catecho.foodbackstagesys.Dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catecho.foodbackstagesys.Dao.CastleDao;
import com.catecho.foodbackstagesys.Entity.Bill;
import com.catecho.foodbackstagesys.Entity.Castle;

@Repository("castleDao")
public class CastleDaoImpl implements CastleDao {
	@Resource
	SessionFactory sf;

	private Session getSession() {
		// ͨ��spring������SF���session
		return sf.getCurrentSession();
	}

	@Override
	public Castle queryOneByAccPwd(String acc, String pwd) {
		// ͨ��accpwd��ѯһ������Ա
		return getSession().createQuery("from Castle where acc=?0 and pwd=?1", Castle.class).setParameter(0, acc)
				.setParameter(1, pwd).uniqueResult();
	}

	@Override
	public Castle queryOneById(int cid) {
		//ͨ��ID��ѯһ��
		return getSession().createQuery("from Castle where cid=?0",Castle.class).setParameter(0,cid).uniqueResult();
	}

	@Override
	public Castle queryOneByName(String name) {
		//ͨ��name��ѯһ��
		return getSession().createQuery("from Castle where name=?0",Castle.class).setParameter(0,name).uniqueResult();

	}
	public Castle queryOneByAcc(String acc) {
		//ͨ��acc��ѯһ��
		return getSession().createQuery("from Castle where acc=?0",Castle.class).setParameter(0,acc).uniqueResult();

	}
	public List<Castle> queryManyByPage(int start,int amount) {
		//��ҳ��ѯ
		return getSession().createQuery("from Castle",Castle.class).setFirstResult(start).setMaxResults(amount).list();
	}
}
