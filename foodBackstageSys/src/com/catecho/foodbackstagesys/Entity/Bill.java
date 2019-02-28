package com.catecho.foodbackstagesys.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer bid = null;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "uid")
	User user;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "fid")
	Food food;
	Date date;
	Integer settlement=null;//(1为已结算 2 为未结算)
	public Integer getSettlement() {
		return settlement;
	}

	public void setSettlement(Integer settlement) {
		this.settlement = settlement;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Bill(Integer bid, User user, Food food, Date date) {
		super();
		this.bid = bid;
		this.user = user;
		this.food = food;
		this.date = date;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

}
