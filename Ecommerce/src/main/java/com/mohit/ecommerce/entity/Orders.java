package com.mohit.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Orders {
	@Id
	private String Id;
	@NotNull
	private String item;
	@NotNull
	private int count;
	@NotNull
	private String email;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Inventory [Id=" + Id + ", item=" + item + ", count=" + count + ", email=" + email + "]";
	}

}