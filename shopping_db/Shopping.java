package com.wang.han.shopping_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shopping {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private List<Goods> listbuy=new ArrayList<Goods>();
	public List<Goods> queryAll(){
		List<Goods> list=new ArrayList<Goods>();
		try {
			try{
				conn=ConnectionFactory.getConn();
				String sql="select * from s_goods";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Long id=rs.getLong("id");
					String name=rs.getString("name");
					Double price=rs.getDouble("price");
					String made=rs.getString("made");
					String  date=rs.getString("date");
					int amount=rs.getInt("amount");
					String size=rs.getString("size");
					Goods goods=new Goods(id, name, price, made, date, amount, size);
					list.add(goods);
				}
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void deleteById(Long id){
		try {
			try{
				conn=ConnectionFactory.getConn();
				String sql="delete from s_goods where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				int num = pstmt.executeUpdate();
				System.out.println(num+"条删除成功");
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Goods queryById(Long id){
		Goods goods=null;
		try {
			try{
				conn=ConnectionFactory.getConn();
				String sql="select * from s_goods where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					String name=rs.getString("name");
					Double price=rs.getDouble("price");
					String made=rs.getString("made");
					String  date=rs.getString("date");
					Integer amount=rs.getInt("amount");
					String size=rs.getString("size");
					goods=new Goods(id, name, price, made, date, amount, size);
				}
			}finally{
				ConnectionFactory.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}
	public void update(Goods goods){
		try {
			try{
				conn=ConnectionFactory.getConn();
				String sql="update s_goods "
						+ "set name=?,price=?,made=?,date=?,amount=?,size=?  where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,goods.getName());
				pstmt.setDouble(2, goods.getPrice());
				pstmt.setString(3, goods.getMade());
				pstmt.setString(4, goods.getDate());
				pstmt.setInt(5, goods.getAmount());
				pstmt.setString(6, goods.getSize());
				pstmt.setLong(7, goods.getId());
				int num=pstmt.executeUpdate();
				System.out.println(num+"条修改成功");
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void buy(Long id){
		try {
			try{
				conn=ConnectionFactory.getConn();
				String sql="select * from s_goods where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					String name=rs.getString("name");
					Double price=rs.getDouble("price");
					String made=rs.getString("made");
					String  date=rs.getString("date");
					int amount=rs.getInt("amount");
					String size=rs.getString("size");
					Goods goods=new Goods(id, name, price, made, date, amount, size);
					listbuy.add(goods);
				}
			}finally{
				ConnectionFactory.close(null, pstmt,conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void save(Goods goods){
		
		try {
			try{
				conn=ConnectionFactory.getConn();
				String sql="insert into s_goods(name,price,made,date,amount,size)  values(?,?,?,?,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,goods.getName());
				pstmt.setDouble(2, goods.getPrice());
				pstmt.setString(3, goods.getMade());
				pstmt.setString(4, goods.getDate());
				pstmt.setInt(5, goods.getAmount());
				pstmt.setString(6, goods.getSize());
				int num=pstmt.executeUpdate();
				System.out.println(num+"条插入成功");
			}finally{
				ConnectionFactory.close(null, pstmt,conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Goods> queryBuy(){
		return listbuy;
	}
	public void menu(){
		System.out.println("&&&&&&&&&&&服装购物管理系统&&&&&&&&&&&");
		System.out.println("1) 查询服装基本信息");
		System.out.println("2) 输入服装信息");
		System.out.println("3) 删除服装信息");
		System.out.println("4) 更新服装信息");
		System.out.println("5) 购买服装");
		System.out.println("6) 查询购买的服装");
		System.out.println("help 获取帮助 ");
		System.out.println("exit 退出系统！");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Shopping shop=new Shopping();
		shop.menu();
		while(true){
			System.out.println("请输入对应指令");
			String option=sc.nextLine();
			switch (option) {
			case "1":
				System.out.println("以下是服装信息");
				List<Goods> goods=shop.queryAll();
				for(Goods good:goods){
					System.out.println(good);
				}
				System.out.println("总共查询到"+goods.size()+"个服装信息");
				break;
			case "2":
				while(true){
					try {
						System.out.println(" 请输入服装信息【name#price#made#date#amount#size】或输入break返回上一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						String[] commodity=inStr.split("#");			
						String name=commodity[0];
						Double price=Double.parseDouble(commodity[1]);
						String made = commodity[2];
						String date=commodity[3];
						int amount=Integer.parseInt(commodity[4]);
						String size=commodity[5];
						Goods good=new Goods(null,name,price,made,date,amount,size);
						shop.save(good);
						System.out.println("保存成功");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				break;
			case "3":
				while(true){
					try{
						System.out.println("请输入删除服装的【id】或输入break返回上一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						Long id=Long.parseLong(inStr);
						Goods good=shop.queryById(id);
						if (good==null){
							System.out.println("对不起，您所查询的服装不存在");
							continue;
						}else{
							System.out.println("您要删除的服装信息为"+good+"\n确定请输入Yes\n");
							String op = sc.nextLine();
							if(op.equals("Yes")){
								shop.deleteById(id);;
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
			case "4":
				while(true){
					try{
						System.out.println("请输入更新服装的【id】或输入break返回上一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						Long id =Long.parseLong(inStr);
						Goods good=shop.queryById(id);
						if(good ==null){
							System.out.println("您要更新的服装信息不存在");
							break;
						}
						System.out.println("您要更新的服装信息为："+good);
						System.out.println("输入新信息【name#price#made#date#amount#size】");
						String str=sc.nextLine();
						String[] goodArr=str.split("#");
						String name=goodArr[0];
						double price=Double.parseDouble(goodArr[1]);
						String made =goodArr[2];
						String date =goodArr[3];
						int amount=Integer.parseInt(goodArr[4]);
						String size=goodArr[5];
						Goods newgoods=new Goods(id, name, price, made, date, amount, size);
						shop.update(newgoods);
						System.out.println("修改成功");
						
					}catch(Exception e){
						System.out.println("输入错误，请按格式输入");
					}
			}					
				break;
			case "5":
				while(true){
					try{
						System.out.println("输入购买服装的【id】或输入break返回上要一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						Long id =Long.parseLong(inStr);
						Goods Buy=shop.queryById(id);
						if(Buy ==null){
							System.out.println("您要购买的服装信息不存在");
							break;
						}
						
						System.out.println("购买的服装为"+Buy+"\n确认请输入Yes");
						String op = sc.nextLine();
							if(op.equals("Yes")){
								shop.buy(id);
								System.out.println("购买成功！");
							}else{
								System.out.println("购买失败！！！");
							}
						
					}catch(Exception e){
						System.out.println("输入错误，请按格式输入");
					}
					
			}					
				break;
			case "6":
				System.out.println("以下是所购买的服装信息");
				List<Goods> lbuy=shop.queryBuy();
				for(Goods good:lbuy){
					System.out.println(good);
				}
				System.out.println("总共查询到"+lbuy.size()+"个服装信息");
				break;
			case "help":
				shop.menu();
				break;
			case "exit":
				System.out.println("&&&&&&&&欢迎下次使用&&&&&&&&");
				sc.close();
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}
}
