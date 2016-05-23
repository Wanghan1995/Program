package com.wang.han.shopping_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Shopping {
	
	
	private List<Goods> goods=new ArrayList<Goods>();
	private List<Goods> buy=new ArrayList<Goods>();

	public List<Goods> find(){
		return goods;
	}

	public void save(Goods good){
		goods.add(good);
		
	}
	public Goods queryById(int id){
		for (Goods good:goods){
			if(good.getId()==id){
				return good;
			}
		}
		return null;
	}
	public int findAmount(int id){
		int number=-1;
		for(Goods good:goods){
			if(good.getId()==id){
				number=good.getAmount();
				return number;
			}
		}
		return number;
	}

	public void deleteById(int id){
		Iterator<Goods> iter=goods.iterator();
		while(iter.hasNext()){
			if(iter.next().getId()==id){
				iter.remove();
				break;
			}
		}
	}
	
	public void update(Goods good){
		
		for(Goods G:goods){
			if(G.getId()==good.getId()){
				G.setAmount(good.getAmount());
				G.setDate(good.getDate());
				G.setMade(good.getMade());
				G.setName(good.getName());
				G.setPrice(good.getPrice());
				G.setSize(good.getSize());
				break;
			}
		}
	}

	public void Buy(int id){
		for(Goods good:goods){
			if(good.getId()==id){
				buy.add(good);
			}
		}
	}
	public void findBuy(){
		Iterator<Goods> iter=buy.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		System.out.println("总共购买的商品个数为："+buy.size()+"个");
	}
	public void menu(){
		System.out.println("&&&&&&&&&&&购物管理系统&&&&&&&&&&&");
		System.out.println("1) 查询商品基本信息");
		System.out.println("2) 输入商品信息");
		System.out.println("3) 查询商品的剩余数量");
		System.out.println("4) 删除商品信息");
		System.out.println("5) 更新商品信息");
		System.out.println("6) 购买商品");
		System.out.println("7) 查询购买的商品");
		System.out.println("help 获取帮助 ");
		System.out.println("exit 退出系统！");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	}
	public static void main(String[] args){
 	Scanner sc=new Scanner(System.in);
		Shopping shop=new Shopping();
		shop.menu();
		while (true){
			try {
				System.out.println("请输入对应指令");
				String option=sc.nextLine();
				switch(option){
					case "1":
						System.out.println("以下是商品信息");
						List<Goods> goods=shop.find();
						for(Goods good:goods){
							System.out.println(good);
						}
						System.out.println("总共查询到"+goods.size()+"个商品信息");
						break;
					case "2":
						while(true){
							try{
								System.out.println(" 请输入商品信息【id#name#price#made#date#amount#size】或输入break返回上一级目录");
								String inStr=sc.nextLine();
								if(inStr.equals("break")){
									break;
								}
								String[] commodity=inStr.split("#");
								int id=Integer.parseInt(commodity[0]);
								String name=commodity[1];
								double price=Double.parseDouble(commodity[2]);
								String made = commodity[3];
								String date=commodity[4];
								int amount=Integer.parseInt(commodity[5]);
								String size=commodity[6];
								Goods good=new Goods(id,name,price,made,date,amount,size);
								shop.save(good);
								System.out.println("保存成功");
							}catch(Exception e){
								System.out.println("输入错误，请按格式输入");
							}
					}				
						break;
					case "3":
						while(true){
							try{
								System.out.println("请输入查询剩余数量的商品【id】或输入break返回上一级目录");
								String inStr=sc.nextLine();
								if(inStr.equals("break")){
									break;
								}
								int id =Integer.parseInt(inStr);
								int num=shop.findAmount(id);
								System.out.println(num==-1?"对不起，未查询到您要的商品的剩余数量":"您要查询的商品的剩余数量为："+num);
							}catch(Exception e){
								System.out.println("输入错误，请按格式输入");
							}
							
					}					
						break;
					case "4":
						while(true){
							try{
								System.out.println("请输入删除商品的【id】或输入break返回上一级目录");
								String inStr=sc.nextLine();
								if(inStr.equals("break")){
									break;
								}
								int id =Integer.parseInt(inStr);
								Goods good=shop.queryById(id);
								if (good==null){
									System.out.println("对不起，您所查询的商品不存在");
									continue;
								}else{
									System.out.println("您要删除的商品信息为"+good+"\n确定请输入Yes\n");
									String op = sc.nextLine();
									if(op.equals("Yes")){
										shop.deleteById(id);
										System.out.println("删除成功！");
									}else{
										System.out.println("删除失败！！！");

									}
								}
							}catch(Exception e){
								System.out.println("输入错误，请按格式输入");
							}
							
					}				
						break;
					case "5":
						while(true){
							try{
								System.out.println("请输入更新商品的【id】或输入break返回上一级目录");
								String inStr=sc.nextLine();
								if(inStr.equals("break")){
									break;
								}
								int id =Integer.parseInt(inStr);
								Goods good=shop.queryById(id);
								if(good ==null){
									System.out.println("您要更新的商品信息不存在");
									break;
								}
								System.out.println("您要更新的商品信息为："+good);
								System.out.println("输入新信息【name#price#made#date#amount#size】");
								String str=sc.nextLine();
								String[] goodArr=str.split("#");
								String name=goodArr[0];
								double price=Double.parseDouble(goodArr[1]);
								String made =goodArr[2];
								String date =goodArr[3];
								int amount=Integer.parseInt(goodArr[4]);
								String size=goodArr[5];
								Goods newgood=new Goods(id,name,price,made,date,amount,size);
								shop.update(newgood);
								System.out.println("修改成功");
								
							}catch(Exception e){
								System.out.println("输入错误，请按格式输入");
							}
							
					}					
						break;
					case "6":
						while(true){
							try{

								System.out.println("输入购买商品的【id】或输入break返回上要一级目录");
								String inStr=sc.nextLine();
								if(inStr.equals("break")){
									break;
								}
								int id =Integer.parseInt(inStr);
								Goods Buy=shop.queryById(id);
								
								if(Buy ==null){
									System.out.println("您要购买的商品信息不存在");
									break;
								}
								
								System.out.println("购买的商品为"+Buy+"\n确认请输入Yes");
								String op = sc.nextLine();
									if(op.equals("Yes")){
										shop.Buy(id);
										System.out.println("购买成功！");
									}else{
										System.out.println("购买失败！！！");
									}
								
							}catch(Exception e){
								System.out.println("输入错误，请按格式输入");
							}
							
					}					
						break;
					case "7":
						System.out.println("以下是所购买的商品信息");
						shop.findBuy();
						break;
					case "help":
						shop.menu();
						break;
					case "exit":
						System.out.println("&&欢迎下次使用&&");
						sc.close();
						System.exit(0);
						break;
					default:
						System.out.println("输入信息错误！！！请重新输入");
				}
			} catch (Exception e) {
				System.out.println("您输入错误请重新输入");
				continue;
			}
		}
	}
}
