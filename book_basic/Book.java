package com.wang.han.book_basic;

public class Book {
	private String name;
	private String index;
	private String sort;
	private String author;
	private String publish;
	private double price;
	public Book(String name, String index, String sort, String author,
			String publish, double price) {
		super();
		this.name = name;
		this.index = index;
		this.sort = sort;
		this.author = author;
		this.publish = publish;
		this.price = price;
	}
	public Book() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", index=" + index + ", sort=" + sort
				+ ", author=" + author + ", publish=" + publish + ", price="
				+ price + "]";
	}
}
