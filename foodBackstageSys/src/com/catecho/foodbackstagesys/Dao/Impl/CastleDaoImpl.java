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
		// 通过spring创建的SF获得session
		return sf.getCurrentSession();
	}

	@Override
	public Castle queryOneByAccPwd(String acc, String pwd) {
		// 通过accpwd查询一个管理员
		return getSession().createQuery("from Castle where acc=?0 and pwd=?1", Castle.class).setParameter(0, acc)
				.setParameter(1, pwd).uniqueResult();
	}

	@Override
	public Castle queryOneById(int cid) {
		//通过ID查询一个
		return getSession().createQuery("from Castle where cid=?0",Castle.class).setParameter(0,cid).uniqueResult();
	}

	@Override
	public Castle queryOneByName(String name) {
		//通过name查询一个
		return getSession().createQuery("from Castle where name=?0",Castle.class).setParameter(0,name).uniqueResult();

	}
	public Castle queryOneByAcc(String acc) {
		//通过acc查询一个
		return getSession().createQuery("from Castle where acc=?0",Castle.class).setParameter(0,acc).uniqueResult();

	}
	public List<Castle> queryManyByPage(int start,int amount) {
		//分页查询
		return getSession().createQuery("from Castle",Castle.class).setFirstResult(start).setMaxResults(amount).list();
	}
}
