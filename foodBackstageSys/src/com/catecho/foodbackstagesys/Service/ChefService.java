package com.catecho.foodbackstagesys.Service;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Castle;
import com.catecho.foodbackstagesys.Entity.Chef;

public interface ChefService {

	void add(Chef chef);//增

	void delete(Integer cid);//删
	void updata(Chef chef);//改
	List<Chef> findAll();//查

	Chef queryOneByAccPwd(String acc, String pwd);//查byaccpwd

	boolean exist(String acc, String pwd);//login

	List<Chef> querypage(int page);

	Chef queryOneByCid(Integer cid);



}
