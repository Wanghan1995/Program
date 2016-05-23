package com.wang.han.book_basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Bms {
private List<Book> books=new ArrayList<Book>();
	
	public void  save(Book book){
		books.add(book);
	}
	/**
	 * public Book findByName(String name){
		for(Book book:books){
			if(book.getName().equals(name)){
				return book;
			}			
		}
		return null;
	}
	*/
	
	public Book findByName(String name){
		Book book=null;
		Iterator<Book> iter=books.iterator();
		while(iter.hasNext()){
			Book b = iter.next();
			if( b.getName().equals(name)){
				book=b;
			}
		}
		return book;
	}	
	public Book findByAuthor(String author){
		Book book=null;
		Iterator<Book> iter=books.iterator();
		while(iter.hasNext()){
			Book b = iter.next();
			if(b.getAuthor().equals(author)){
				book=b;
			}
		}
		return book;
	}
	/**public Book findByAuthor(String author){
		for(Book book:books){
			if(book.getAuthor().equals(author)){
				return book;
				
			}			
		}
		return null;
	}*/
	public List<Book> findBySort(String sort){
		List<Book> SortList=new ArrayList<Book>();
		Book book=null;
		Iterator<Book> iter=books.iterator();
		while(iter.hasNext()){
			Book b=iter.next();
			if(b.getSort().equals(sort)){
				SortList.add(book);
			}
		}
		return SortList;
	}
	/**public List<Book> findBySort(String sort){
		List<Book> Sortlist=new ArrayList<Book>();
		for(Book book:books){
			if(book.getSort().equals(sort)){
				Sortlist.add(book);
			}
		}
		return Sortlist;
	}
	*/
	public void delete(String name){
		Iterator<Book> iter=books.iterator();
		while(iter.hasNext()){
			if(iter.next().getName().equals(name)){
				iter.remove();
				break;
			}
		}
	}
	public void update(Book book){
		Iterator<Book> iter=books.iterator();
		while(iter.hasNext()){
			if(iter.next().getName().equals(book.getName())){
				iter.next().setName(book.getName());
				iter.next().setAuthor(book.getAuthor());
				iter.next().setIndex(book.getIndex());
				iter.next().setSort(book.getSort());
				iter.next().setPublish(book.getPublish());
				iter.next().setPrice(book.getPrice());
				break;
			}
		}
	}
	
	/**public void update(Book book){
		for(Book B:books){
			if(B.getName().equals(book.getName())){
				B.setName(book.getName());
				B.setAuthor(book.getAuthor());
				B.setIndex(book.getIndex());
				B.setSort(book.getSort());
				B.setPublish(book.getPublish());
				B.setPrice(book.getPrice());
				break;
			}
		}
		
	}*/
	public void menu(){
		System.out.println("--------iterator--------");
		System.out.println("1)输入图书信息");
		System.out.println("2)通过书名查询图书信息");
		System.out.println("3)通过作者查询图书信息");
		System.out.println("4)通过分类查询图书");
		System.out.println("5)删除图书信息");
		System.out.println("6)更新图书信息");
		System.out.println("7)back   返回主菜单");
		System.out.println("8)exit！   退出系统");
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Bms bms=new Bms();
		bms.menu();
		while(true){
			try {
				System.out.println("请输入对应指令");
				String option=new String();
				option =sc.nextLine();
				switch (option) {
				case "1":
					while (true) {
						try {
							System.out.println("请输入你要输入的图书信息【name#index#sort#author#publish#price】或输入break返回上一级目录");
							String inStr=sc.nextLine();
							if (inStr.equals("break")) {
								break;
							}
							String[] Arr=inStr.split("#");
							String name=Arr[0];
							String index=Arr[1];
							String sort=Arr[2];
							String author=Arr[3];
							String publish=Arr[4];
							double price=Double.parseDouble(Arr[5]);
							Book book=new Book(name,index,sort,author,publish,price);
							bms.save(book);
							System.out.println("保存成功！");
						} catch (Exception e) {
							System.out.println("您输入格式有误！请按格式重新输入");
						}
					}
					break;
				case "2":
					while(true){
						try {
							System.out.println("请输入您所要查询的图书的【name】或输入break返回上一级目录");
							String inStr=sc.nextLine();
							if(inStr.equals("break")){
								break;
							}
							String name=inStr;
							Book book=bms.findByName(name);
							System.out.println("您要查询的图书信息为："+book);
						} catch (Exception e) {
							System.out.println("您输入格式有误！请按格式重新输入");
						}
					}
					break;
				case "3":
					while(true){
						try {
							System.out.println("请输入您所要查询的图书的【author】或输入break返回上一级目录");
							String inStr=sc.nextLine();
							if(inStr.equals("break")){
								break;
							}
							String author=inStr;
							Book book=bms.findByAuthor(author);
							System.out.println("您要查询的图书信息为："+book);
						} catch (Exception e) {
							System.out.println("您输入格式有误！请按格式重新输入");
						}
					}
					break;
				case "4":
					while(true){
						try {
							System.out.println("请输入您要查询的图书的【sort】或输入break返回上一级目录");
							String inStr=sc.nextLine();
							if(inStr.equals("break")){
								break;
							}
							
						} catch (Exception e) {
							System.out.println("您输入格式有误！请按格式重新输入");
						}
					}
					break;
				case "5":
					while(true){
						try {
							System.out.println("请输入您要删除的图书的【name】或输入break返回上一级目录");
							String inStr=sc.nextLine();
							if(inStr.equals("break")){
								break;
							}
							String name=inStr;
							System.out.println("您要删除的图书信息为"+bms.findByName(name)+"\n确定删除请输入Yes");
							String op=sc.nextLine();
							if (op.equals("Yes")) {
								bms.delete(name);
								System.out.println("删除成功！");
								
							} else {
							System.out.println("删除失败！");	
							}
							
						} catch (Exception e) {
							System.out.println("您输入格式有误！请按格式重新输入");
						}
					}
					break;
				case "6":
					while(true){
						try {
							System.out.println("请输入您要更新的图书的【name#index#sort#author#publish#price】或输入break返回上一级目录");
							String inStr=sc.nextLine();
							if(inStr.equals("break")){
								break;
							}
							String[] Arr=inStr.split("#");
							String name=Arr[0];
							String index=Arr[1];
							String sort=Arr[2];
							String author=Arr[3];
							String publish=Arr[4];
							double price=Long.parseLong(Arr[5]);
							Book book=new Book(name,index,sort,author,publish,price);
							System.out.println("您要更新的图书信息为"+bms.findByName(name)+"\n确定删除请输入Yes");
							String op=sc.nextLine();
							if (op.equals("Yes")) {
								bms.update(book);
								System.out.println("更新成功！");
								
							} else {
							System.out.println("更新失败！");	
							}
							
						} catch (Exception e) {
							System.out.println("您输入格式有误！请按格式重新输入");
						}
					}
					break;
				case "back":
					bms.menu();
					break;
				case "exit":
					System.out.println("欢迎下次使用   ^_^");
					sc.close();
					System.exit(0);
					break;
				default:
					break;
				}
			}
			 catch (Exception e) {
				System.out.println("您输入信息有误！请重新输入");
			}
		}
	}
}
