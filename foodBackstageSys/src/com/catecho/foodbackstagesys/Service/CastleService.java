package com.catecho.foodbackstagesys.Service;

import com.catecho.foodbackstagesys.Entity.Castle;

public interface CastleService {

	boolean exist(String acc, String pwd);
	boolean exist(int cid);
	boolean exist(String acc);
	Castle queryOneByAccPwd(String acc, String pwd);


}
