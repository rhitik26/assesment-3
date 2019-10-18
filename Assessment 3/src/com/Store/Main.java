package com.Store;
import java.util.*;

public class Main {
List<Stock>stocks;
//List<Sales>sales;
int vindex=-1,uindex=-1;
boolean flag=false,uflag=false;
public Main() {
	stocks=new ArrayList<>();
//	sales=new ArrayList<>();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Main m=new Main();
		while (true) {
			System.out.println("1:clerk");
			System.out.println("2:Customer");
			System.out.println("3:Exit");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				while(true) {
					System.out.println("1:Enter new item");
					System.out.println("2:Update stock");
					System.out.println("3:View stock");
					
					int ch2=sc.nextInt();
					switch(ch2) {
					case 1:m.addItem();
					break;
					case 2:m.update();
					break;
					case 3:
						m.viewItem();
						break;
				}
				break;
			}break;
			case 2:
				while(true) {
					System.out.println("1:shop");
					System.out.println("2:Exit");
					int ch3=sc.nextInt();
					switch(ch3) {
					case 1:
						m.shop();
						break;
					case 2:
//						m.bill();
//						System.exit(0);
					break;
					}break;
				}break;
			case 3:System.exit(0);
			break;
			}
		}
		}
	public void addItem() {
		Stock s=new Stock();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name");
		String name=sc.next();
		s.setName(name);
		System.out.println("Enter Code");
		int code =sc.nextInt();
		s.setCode(code);
		System.out.println("Enter Quantity");
		int quantity=sc.nextInt();
		s.setQuantity(quantity);
		System.out.println("Enter cost");
		float cost=sc.nextFloat();
		s.setCost(cost);
		stocks.add(s);
	}
	public void viewItem() {
		for(Stock s:stocks) {
			System.out.println(s.getCode());
			System.out.println(s.getName());
			System.out.println(s.getQuantity());
			System.out.println(s.getCost());
		}
	}
	public void update() {
		Stock s=new Stock();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter item code to be modified");
		int ucode =sc.nextInt();
		for(int i=0;i<stocks.size();i++) {
			if(stocks.get(i).getCode()==ucode) {
				s.setCode(ucode);
				System.out.println("Enter New Name");
				String name=sc.next();
				s.setName(name);
				System.out.println("Enter new Quantity");
				int quantity=sc.nextInt();
				s.setQuantity(quantity);
				System.out.println("Enter new Cost");
				float cost=sc.nextFloat();
				s.setCost(cost);
				stocks.remove(i);
				stocks.add(s);
			}
		}
	}
	public void shop() {
		Stock s=new Stock();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Name of item ");
		String cname=sc.next();
		for(int i=0;i<stocks.size();i++) {
			if(stocks.get(i).getName().compareToIgnoreCase(cname)==0) {
				System.out.println("enter Quantity to be purchased");
				int cquant=sc.nextInt();
				if(stocks.get(i).getQuantity()<cquant)
					System.out.println("Stock not available");
				else {
					System.out.println("Added To cart");
					stocks.get(i).setQuantity(stocks.get(i).getQuantity()-cquant);
					System.out.println("total bill amount is:");
				    stocks.get(i).setCost(stocks.get(i).getCost()*cquant);
				    float cc=stocks.get(i).getCost();
					System.out.println(cc);
				}
			}
		}
	}
	
	}

	
//	sc.close();
	


