package com.catecho.foodbackstagesys.Entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_type")
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer tid = null;
	@Column(nullable=false)
	String name = null;
	String other = null;
	/*@OneToMany(mappedBy = "type",fetch=FetchType.LAZY)
	Set<Food> foods = new HashSet<>();*/

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Type [tid=" + tid + ", name=" + name + ", other=" + other + "]";
	}

	public Type(Integer tid, String name, String other, Set<Food> foods) {
		super();
		this.tid = tid;
		this.name = name;
		this.other = other;
		/*this.foods = foods;*/
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
