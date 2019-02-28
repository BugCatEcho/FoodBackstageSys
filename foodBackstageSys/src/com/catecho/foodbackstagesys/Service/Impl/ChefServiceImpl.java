package com.catecho.foodbackstagesys.Service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catecho.foodbackstagesys.Dao.ChefDao;
import com.catecho.foodbackstagesys.Entity.Bill;
import com.catecho.foodbackstagesys.Entity.Chef;
import com.catecho.foodbackstagesys.Service.ChefService;

@Service("chefService")
@Transactional
public class ChefServiceImpl implements ChefService {
	@Resource
	ChefDao cd;
	int quantity = 9;
	@Override
	public void add(Chef chef) {
		// 添加
		cd.addOne(chef);

	}

	@Override
	public List<Chef> findAll() {
		return cd.queryAll();

	}

	@Override
	public void delete(Integer cid) {
		// 删除
		cd.delOneByid(cid);

	}

	@Override
	public boolean exist(String acc, String pwd) {
		// TODO Auto-generated method stub
		System.out.println("ChefServicMsg_queryaccandpwd by acc=" + acc + ";pwd=" + pwd);
		return cd.queryOneByAccPwd(acc, pwd) != null;
	}

	@Override
	public void updata(Chef chef) {
		cd.updataOne(chef);

	}

	@Override
	public Chef queryOneByAccPwd(String acc, String pwd) {
		// TODO Auto-generated method stub
		return cd.queryOneByAccPwd(acc, pwd);
	}

	@Override
	public List<Chef> querypage(int page) {
		//查询一页厨师
		if (page < 1) {// 如果页码小于1则为1
			return cd.queryManyByPage(0, quantity);
		} else {
			return cd.queryManyByPage((page - 1) * quantity, quantity);
		}
	}

	@Override
	public Chef queryOneByCid(Integer cid) {
		return cd.queryOneById(cid);
	}
}
