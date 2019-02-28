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
		// ͨ��spring������SF���session
		return sf.getCurrentSession();
	}

	@Override
	public void addone(Bill bill) {
		// ����һ���˵�
		getSession().save(bill);
		
	}

	@Override
	public void delone(int bid) {
		// ɾ��һ���˵�ͨ��id
		getSession().delete(queryOneById(bid));
	}

	@Override
	public void updateone(Bill bill) {
		//�޸�һ���˵���¼
		/*Bill flag=getSession().get(Bill.class,bill.getBid());//ͨ��id��ԭ��¼��������
		flag=bill;//����*/
		//getSession().createQuery("update Teacher t set t.name = 'yangtianb' where id = ?0").setParameter(0,bill.getBid()).executeUpdate();
		
		//queryOneById��ͬ���еķ���ͨ��ID��ѯ��һ��bill��¼
		getSession().update(bill);
	}

	@Override
	public Bill queryOneById(int bid) {
		// ��ѯһ����¼ͨ���˵�ID
		return getSession().createQuery("from Bill where bid=?0",Bill.class).setParameter(0,bid).uniqueResult();
	}

	@Override
	public List<Bill> queryManyByUid(int uid) {
		//�����û�ID��ѯ�����й��˵�
		return getSession().createQuery("from Bill where uid=?0").setParameter(0,uid).list();
	}
	public List<Bill> queryManyByPage(int start,int amount) {
		//��ҳ��ѯ
		return getSession().createQuery("from Bill",Bill.class).setFirstResult(start).setMaxResults(amount).list();
	}

}
