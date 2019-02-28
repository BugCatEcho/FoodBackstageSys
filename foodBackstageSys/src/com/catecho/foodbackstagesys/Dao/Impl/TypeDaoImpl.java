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
		// 通过spring创建的SF获得session
		return sf.getCurrentSession();
	}

	@Override
	public void addOne(Type type) {
		// 添加一个类型
		getSession().save(type);

	}

	@Override
	public void delOneById(int tid) {
		// 根据ID删除一个类型
		getSession().delete(queryOneById(tid));

	}

	@Override
	public void updataOne(Type type) {
		// 更新一个类型记录
getSession().update(type);
	}

	@Override
	public Type queryOneById(int id) {
		// 根据ID查询一条记录
		return getSession().createQuery("from Type where tid=?0",Type.class).setParameter(0, id).uniqueResult();
	}

	@Override
	public Type queryOneByName(String name) {
		//根据name查询一条记录
		return getSession().createQuery("from Type where name=?0",Type.class).setParameter(0, name).uniqueResult();
	}

	@Override
	public List<Type> queryAll() {
		// 查询所有
		return getSession().createQuery("from Type",Type.class).list();
	}

}
