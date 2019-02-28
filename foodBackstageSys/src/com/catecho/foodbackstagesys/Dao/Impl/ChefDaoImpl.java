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
		// 通过spring创建的SF获得session
		return sf.getCurrentSession();
	}

	@Override
	public Chef queryOneByAccPwd(String acc, String pwd) {
		// 根据账号密码查询一个厨师记录
		return getSession().createQuery("from Chef where acc=?0 and pwd=?1",Chef.class).setParameter(0, acc).setParameter(1,pwd).uniqueResult();
	}

	@Override
	public List<Chef> queryAll() {
		// 查询所有厨师
		return getSession().createQuery("from Chef",Chef.class).list();
	}

	@Override
	public Chef queryOneById(int id) {
		// 根据ID查询一个厨师
		return getSession().createQuery("from Chef where cid=?0",Chef.class).setParameter(0,id).uniqueResult();
	}

	@Override
	public void addOne(Chef chef) {
		//添加一个厨师
		getSession().save(chef);
		
	}

	@Override
	public void delOneByid(int id) {
		//删除一个厨师根据ID
		getSession().delete(queryOneById(id));
	}

	@Override
	public void updataOne(Chef chef) {
		// 更新一条记录
		getSession().update(chef);
		
	}
	public List<Chef> queryManyByPage(int start,int amount) {
		//分页查询
		return getSession().createQuery("from Chef",Chef.class).setFirstResult(start).setMaxResults(amount).list();
	}
}
