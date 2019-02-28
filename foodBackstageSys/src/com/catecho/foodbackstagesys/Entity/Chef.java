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
@Table(name = "tb_Chef")
public class Chef {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer cid = null;
	@Column(nullable = false)
	String name = null;
	@Column(unique = true, nullable = false)
	String acc = null;
	@Column(nullable = false)
	String pwd = null;
	String phone = null;
	String other = null;
/*	@OneToMany(mappedBy="chef",orphanRemoval=true,fetch=FetchType.LAZY)
	Set<Food> foods=new HashSet<>();*/
	public Chef(Integer cid, String name, String acc, String pwd, String phone, String other, Set<Food> foods) {
		super();
		this.cid = cid;
		this.name = name;
		this.acc = acc;
		this.pwd = pwd;
		this.phone = phone;
		this.other = other;
		/*this.foods = foods;*/
	}
	public Chef() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
/*	public Set<Food> getFoods() {
		return foods;
	}
	public void setFoods(Set<Food> foods) {
		this.foods = foods;
	}*/
	@Override
	public String toString() {
		return "Chef [cid=" + cid + ", name=" + name + ", acc=" + acc + ", pwd=" + pwd + ", phone=" + phone + ", other="
				+ other + "]";
	}


}
