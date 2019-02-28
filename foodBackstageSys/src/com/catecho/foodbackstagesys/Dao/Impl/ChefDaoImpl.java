package com.catecho.foodbackstagesys.Dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catecho.foodbackstagesys.Dao.ChefDao;
import com.catecho.foodbackstagesys.Entity.Bill;
import com.catecho.foodbackstagesys.Entity.Chef;
@Repository("chefDao")
public class ChefDaoImpl implements ChefDao {
	@Resource
	SessionFactory sf;

	private Session getSession() {
		// ͨ��spring������SF���session
		return sf.getCurrentSession();
	}

	@Override
	public Chef queryOneByAccPwd(String acc, String pwd) {
		// �����˺������ѯһ����ʦ��¼
		return getSession().createQuery("from Chef where acc=?0 and pwd=?1",Chef.class).setParameter(0, acc).setParameter(1,pwd).uniqueResult();
	}

	@Override
	public List<Chef> queryAll() {
		// ��ѯ���г�ʦ
		return getSession().createQuery("from Chef",Chef.class).list();
	}

	@Override
	public Chef queryOneById(int id) {
		// ����ID��ѯһ����ʦ
		return getSession().createQuery("from Chef where cid=?0",Chef.class).setParameter(0,id).uniqueResult();
	}

	@Override
	public void addOne(Chef chef) {
		//���һ����ʦ
		getSession().save(chef);
		
	}

	@Override
	public void delOneByid(int id) {
		//ɾ��һ����ʦ����ID
		getSession().delete(queryOneById(id));
	}

	@Override
	public void updataOne(Chef chef) {
		// ����һ����¼
		getSession().update(chef);
		
	}
	public List<Chef> queryManyByPage(int start,int amount) {
		//��ҳ��ѯ
		return getSession().createQuery("from Chef",Chef.class).setFirstResult(start).setMaxResults(amount).list();
	}
}
