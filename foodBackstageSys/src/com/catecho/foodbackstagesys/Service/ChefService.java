package com.catecho.foodbackstagesys.Service;

import java.util.List;

import com.catecho.foodbackstagesys.Entity.Castle;
import com.catecho.foodbackstagesys.Entity.Chef;

public interface ChefService {

	void add(Chef chef);//��

	void delete(Integer cid);//ɾ
	void updata(Chef chef);//��
	List<Chef> findAll();//��

	Chef queryOneByAccPwd(String acc, String pwd);//��byaccpwd

	boolean exist(String acc, String pwd);//login

	List<Chef> querypage(int page);

	Chef queryOneByCid(Integer cid);



}
