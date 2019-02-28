package com.catecho.foodbackstagesys.Service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catecho.foodbackstagesys.Dao.CastleDao;
import com.catecho.foodbackstagesys.Entity.Castle;
import com.catecho.foodbackstagesys.Service.CastleService;
@Service("castleService")
@Transactional
public class CastleServiceImpl implements CastleService {
	@Resource
	CastleDao cd;
	int quantity = 3;
	@Override
	public boolean exist(String acc, String pwd) {
		// TODO Auto-generated method stub
		System.out.println("servicmsg_queryaccandpwd by acc="+acc+";pwd="+pwd);
		return cd.queryOneByAccPwd(acc, pwd)!=null;
	}

	@Override
	public boolean exist(int cid) {
		// TODO Auto-generated method stub
		return cd.queryOneById(cid).getAcc()!=null;
	}

	@Override
	public boolean exist(String acc) {
		// TODO Auto-generated method stub
		return cd.queryOneByName(acc)!=null;
	}

	@Override
	public Castle queryOneByAccPwd(String acc, String pwd) {
		// TODO Auto-generated method stub
		return cd.queryOneByAccPwd(acc, pwd);
	}
}
