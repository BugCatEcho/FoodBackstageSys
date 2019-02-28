package com.catecho.foodbackstagesys.Service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catecho.foodbackstagesys.Dao.TypeDao;
import com.catecho.foodbackstagesys.Entity.Type;

@Service("typeService")
@Transactional
public class TypeServiceImpl implements com.catecho.foodbackstagesys.Service.TypeService {
	@Resource
	TypeDao td;

	@Override
	public void addone(Type type) {
		td.addOne(type);

	}

	@Override
	public void delone(int tid) {
		td.delOneById(tid);

	}

	@Override
	public void updata(Type type) {
		td.updataOne(type);

	}

	@Override
	public List<Type> queryall() {
		return td.queryAll();

	}
}
