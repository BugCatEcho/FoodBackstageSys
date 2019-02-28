package com.catecho.foodbackstagesys.Dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catecho.foodbackstagesys.Dao.BillDao;
import com.catecho.foodbackstagesys.Entity.Bill;

@Repository("billDao")
public class BillDaoImpl implements BillDao {
	@Resource
	SessionFactory sf;

	private Session getSession() {
		// 通过spring创建的SF获得session
		return sf.getCurrentSession();
	}

	@Override
	public void addone(Bill bill) {
		// 增加一条账单
		getSession().save(bill);
		
	}

	@Override
	public void delone(int bid) {
		// 删除一条账单通过id
		getSession().delete(queryOneById(bid));
	}

	@Override
	public void updateone(Bill bill) {
		//修改一条账单记录
		/*Bill flag=getSession().get(Bill.class,bill.getBid());//通过id与原记录创建链接
		flag=bill;//更新*/
		//getSession().createQuery("update Teacher t set t.name = 'yangtianb' where id = ?0").setParameter(0,bill.getBid()).executeUpdate();
		
		//queryOneById是同类中的方法通过ID查询出一条bill记录
		getSession().update(bill);
	}

	@Override
	public Bill queryOneById(int bid) {
		// 查询一条记录通过账单ID
		return getSession().createQuery("from Bill where bid=?0",Bill.class).setParameter(0,bid).uniqueResult();
	}

	@Override
	public List<Bill> queryManyByUid(int uid) {
		//根据用户ID查询所有有关账单
		return getSession().createQuery("from Bill where uid=?0").setParameter(0,uid).list();
	}
	public List<Bill> queryManyByPage(int start,int amount) {
		//分页查询
		return getSession().createQuery("from Bill",Bill.class).setFirstResult(start).setMaxResults(amount).list();
	}

}
