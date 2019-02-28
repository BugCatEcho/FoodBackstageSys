package com.catecho.foodbackstagesys.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_food")
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer fid = null;
	@Column(nullable = false)
	String name = null;
	@ManyToOne(fetch=FetchType.EAGER,targetEntity=Chef.class)
	@JoinColumn(name = "cid")
	Chef chef;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "tid")
	Type type;
/*	@OneToMany(mappedBy = "food",fetch=FetchType.LAZY)
	Set<Bill> bills = new HashSet<>();*/
	double money;
	String other;

	public Food(Integer fid, String name, Chef chef, Type type, double money, String other) {
		super();
		this.fid = fid;
		this.name = name;
		this.chef = chef;
		this.type = type;
		this.money = money;
		this.other = other;
	}

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "Food [fid=" + fid + ", name=" + name + ", chef=" + chef + ", type=" + type + ", money=" + money
				+ ", other=" + other + "]";
	}
}
