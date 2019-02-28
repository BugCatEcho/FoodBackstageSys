package com.catecho.foodbackstagesys.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer uid = null;
	@Column(nullable = false, unique = true)
	String acc = null;
	@Column(nullable = false)
	String pwd = null;
	@Column(nullable = false)
	String name = null;
	double money;
/*	@OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
	Set<Bill> bills = new HashSet<>();*/
	String other = null;

	public User(Integer uid, String acc, String pwd, String name, double money, Set<Bill> bills, String other) {
		super();
		this.uid = uid;
		this.acc = acc;
		this.pwd = pwd;
		this.name = name;
		this.money = money;
		/*this.bills = bills;*/
		this.other = other;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

/*	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}*/

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
}
