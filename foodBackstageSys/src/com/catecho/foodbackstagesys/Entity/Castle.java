package com.catecho.foodbackstagesys.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_castle")
public class Castle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer cid = null;
	@Column(nullable = false)
	String name = null;
	@Column(unique = true, nullable = false)
	String acc = null;
	@Column(nullable = false)
	String pwd = null;

	public Castle(Integer cid, String name, String acc, String pwd) {
		super();
		this.cid = cid;
		this.name = name;
		this.acc = acc;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Castle [cid=" + cid + ", name=" + name + ", acc=" + acc + ", pwd=" + pwd + "]";
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Castle() {
		super();
		// TODO Auto-generated constructor stub
	}
}
