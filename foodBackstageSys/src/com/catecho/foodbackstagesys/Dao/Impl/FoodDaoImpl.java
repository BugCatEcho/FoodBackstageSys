package com.catecho.foodbackstagesys.Dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catecho.foodbackstagesys.Dao.FoodDao;
import com.catecho.foodbackstagesys.Entity.Bill;
import com.catecho.foodbackstagesys.Entity.Food;

@Repository("foodDao")
public class FoodDaoImpl implements FoodDao {
	@Resource
	SessionFactory sf;

	private Session getSession() {
		// ͨ��spring������SF���session
		return sf.getCurrentSession();
	}

	@Override
	public void addOne(Food food) {
		// ���һ����¼
		getSession().save(food);

	}

	@Override
	public void delOneBId(int fid) {
		// ɾ��һ����¼����ID
		getSession().delete(queryOneById(fid));
	}

	@Override
	public void delManyByTid(int tid) {
		// ɾ�������������ID

	}

	@Override
	public void updataOne(Food food) {
		// ����һ������
		getSession().update(food);		
		
	}

	@Override
	public Food queryOneById(int fid) {
		// ����ID��ѯһ����Ʒ��¼
		return getSession().createQuery("from Food where fid=?0", Food.class).setParameter(0, fid).uniqueResult();
	}

	@Override
	public List<Food> queryManyByTid(int tid) {
		// ��ѯ��������������ID
		return getSession().createQuery("from Food where tid=?0", Food.class).setParameter(0, tid).list();
	}

	@Override
	public List<Food> queryManyByText(String text) {
		// ��ѯ������ݹؼ���
		return getSession().createQuery("from Food where name like ?0 or other like ?0", Food.class)
				.setParameter(0, "%" + text + "%").list();
		/*
		 * return getSession().
		 * createQuery("from Food where name like '%?0%' or other like '%?0%'",
		 * Food.class) .setParameter(0, "%" + text + "%").list();
		 */
	}

	@Override
	public List<Food> queryManyByCid(int cid) {
		// ��ѯ������ݳ�ʦID
		return getSession().createQuery("from Food where cid=?0", Food.class).setParameter(0, cid).list();
	}
	
	public List<Food> queryManyByPage(int start,int amount) {
		//��ҳ��ѯ
		return getSession().createQuery("from Food",Food.class).setFirstResult(start).setMaxResults(amount).list();
	}
	
	public List<Food> queryManyByPageAndText(int start,int amount,String text) {
		//��ҳģ����ѯ
		return getSession().createQuery("from Bill where name like ?0 or other like ?0",Food.class).setParameter(0,"%"+text+"%").setFirstResult(start).setMaxResults(amount).list();
	}

	@Override
	public List<Food> queryManyByPage(int start, int amount, int cid) {
		// ��ҳ��ѯĳ����ʦ�Ĳ�Ʒ
		return getSession().createQuery("from Food where cid=?0",Food.class).setParameter(0,cid).setFirstResult(start).setMaxResults(amount).list();
	}
}
