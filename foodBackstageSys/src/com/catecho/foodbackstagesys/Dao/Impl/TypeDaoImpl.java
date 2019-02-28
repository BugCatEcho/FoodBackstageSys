package com.catecho.foodbackstagesys.Dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catecho.foodbackstagesys.Dao.TypeDao;
import com.catecho.foodbackstagesys.Entity.Type;

@Repository("typeDao")
public class TypeDaoImpl implements TypeDao {
	@Resource
	SessionFactory sf;

	private Session getSession() {
		// ͨ��spring������SF���session
		return sf.getCurrentSession();
	}

	@Override
	public void addOne(Type type) {
		// ���һ������
		getSession().save(type);

	}

	@Override
	public void delOneById(int tid) {
		// ����IDɾ��һ������
		getSession().delete(queryOneById(tid));

	}

	@Override
	public void updataOne(Type type) {
		// ����һ�����ͼ�¼
getSession().update(type);
	}

	@Override
	public Type queryOneById(int id) {
		// ����ID��ѯһ����¼
		return getSession().createQuery("from Type where tid=?0",Type.class).setParameter(0, id).uniqueResult();
	}

	@Override
	public Type queryOneByName(String name) {
		//����name��ѯһ����¼
		return getSession().createQuery("from Type where name=?0",Type.class).setParameter(0, name).uniqueResult();
	}

	@Override
	public List<Type> queryAll() {
		// ��ѯ����
		return getSession().createQuery("from Type",Type.class).list();
	}

}
