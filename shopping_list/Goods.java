package com.wang.han.shopping_list;

public class Goods {
	private int id;
	private String name;
	private double price;
	private String made;
	private String date;
	private int amount;
	private String size;

	public Goods(){
	
	}
	


	public Goods(int id, String name, double price, String made, String date,
			int amount, String size) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.made = made;
		this.date = date;
		this.amount = amount;
		this.size = size;
	}



	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}

	public void setPrice(double price){
		this.price=price;
	}
	public double getPrice(){
		return this.price;
	}

	public void setMade(String made){
		this.made=made;
	}
	public String getMade(){
		return this.made;
	}

	public void setDate(String date){
		this.date=date;
	}
	public String getDate(){
		return this.date;
	}

	public void setAmount(int amount){
		this.amount=amount;
	}
	public int getAmount(){
		return this.amount;
	}

	public void setSize(String size){
		this.size=size;
	}
	public String getSize(){
		return this.size;
	}
	
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price
				+ ", made=" + made + ", date=" + date + ", amount=" + amount
				+ ", size=" + size + "]";
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
