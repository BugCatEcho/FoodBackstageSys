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
		// 通过spring创建的SF获得session
		return sf.getCurrentSession();
	}

	@Override
	public void addOne(Food food) {
		// 添加一条记录
		getSession().save(food);

	}

	@Override
	public void delOneBId(int fid) {
		// 删除一条记录根据ID
		getSession().delete(queryOneById(fid));
	}

	@Override
	public void delManyByTid(int tid) {
		// 删除多个根据类型ID

	}

	@Override
	public void updataOne(Food food) {
		// 更新一条数据
		getSession().update(food);		
		
	}

	@Override
	public Food queryOneById(int fid) {
		// 根据ID查询一条菜品记录
		return getSession().createQuery("from Food where fid=?0", Food.class).setParameter(0, fid).uniqueResult();
	}

	@Override
	public List<Food> queryManyByTid(int tid) {
		// 查询多个根据外键类型ID
		return getSession().createQuery("from Food where tid=?0", Food.class).setParameter(0, tid).list();
	}

	@Override
	public List<Food> queryManyByText(String text) {
		// 查询多个根据关键词
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
		// 查询多个根据厨师ID
		return getSession().createQuery("from Food where cid=?0", Food.class).setParameter(0, cid).list();
	}
	
	public List<Food> queryManyByPage(int start,int amount) {
		//分页查询
		return getSession().createQuery("from Food",Food.class).setFirstResult(start).setMaxResults(amount).list();
	}
	
	public List<Food> queryManyByPageAndText(int start,int amount,String text) {
		//分页模糊查询
		return getSession().createQuery("from Bill where name like ?0 or other like ?0",Food.class).setParameter(0,"%"+text+"%").setFirstResult(start).setMaxResults(amount).list();
	}

	@Override
	public List<Food> queryManyByPage(int start, int amount, int cid) {
		// 分页查询某个厨师的菜品
		return getSession().createQuery("from Food where cid=?0",Food.class).setParameter(0,cid).setFirstResult(start).setMaxResults(amount).list();
	}
}
