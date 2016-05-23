package com.wang.han.shopping_db;

public class Goods {
	private Long id;
	private String name;
	private Double price;
	private String made;
	private String date;
	private Integer amount;
	private String size;

	public Goods(){
	
	}

	public Goods(Long id, String name, Double price, String made, String date,
			Integer amount, String size) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.made = made;
		this.date = date;
		this.amount = amount;
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMade() {
		return made;
	}

	public void setMade(String made) {
		this.made = made;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price
				+ ", made=" + made + ", date=" + date + ", amount=" + amount
				+ ", size=" + size + "]";
	}
	
}
