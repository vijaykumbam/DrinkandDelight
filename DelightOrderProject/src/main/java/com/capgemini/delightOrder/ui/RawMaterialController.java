package com.capgemini.delightOrder.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.capgemini.delightOrder.service.RawMaterialServiceImpl;

public class RawMaterialController 
{
	public static void main(String[] args) throws ParseException 
	{
    Scanner sc=new Scanner(System.in);
	RawMaterialServiceImpl pss=new RawMaterialServiceImpl();
    while(true)
    {	    
	    System.out.println("1->TrackRawMaterialorder\n2->updateProcessDate\n3->updateRawMaterialStock details\n4->UpdatedRawMaterialstockManagement");
	    System.out.println("===================================");
	    System.out.println("Enter the choice");
	    int choice=sc.nextInt();
	    sc.nextLine();
	    switch(choice)
	    {
	    case 1:
	    {
	    	 System.out.println("Enter RawMaterial Tracking orderId");
	    	 String orderId=sc.nextLine();
	    	 System.out.println(pss.doesRawMaterialOrderIdExist(orderId));
	    	 System.out.println(pss.trackProductOrder(orderId));
	    	 System.out.println("===================================****");
	    	 break;
	    }
	    case 2:
	    {
	    	 System.out.println("Enter Process date in this format --> dd/MM/yyyy");
	         String date=sc.nextLine();
	         Date processDate=new SimpleDateFormat("dd/MM/yyyy").parse(date); 
	         System.out.println(pss.processDateCheck(processDate));
	         System.out.println("Enter orderId");
	         String orderId=sc.nextLine();
	         System.out.println(pss.updateExitDateinStock(orderId,processDate));
	         System.out.println("===================================");
	        break;
	    }
	    case 3:
	    {
	    	System.out.println("Enter Manufacturing date");
	        String date1=sc.nextLine();
	        Date manufacturing_date=new SimpleDateFormat("MM/dd/yyyy").parse(date1); 
	        System.out.println(pss.validateManfacturingDate(manufacturing_date));
	        System.out.println("Enter expiry date");
	        String date2=sc.nextLine();
	        Date expiry_date=new SimpleDateFormat("MM/dd/yyyy").parse(date2);
	        System.out.println(pss.validateProcessDate(manufacturing_date, expiry_date));
	        System.out.println("Enter Quality Check");
	        String qualityCheck=sc.nextLine();
	        System.out.println("Enter OrderId");
	        String orderId=sc.nextLine();
	        System.out.println(pss.updateRawMaterialStock(orderId,manufacturing_date, expiry_date, qualityCheck));
	        System.out.println("===================================");
	        break;
	    }
	    case 4:
	    {
	    	 System.out.println("Enter orderId");
	    	 String orderId=sc.nextLine();
	    	 System.out.println(pss.doesRawMaterialOrderIdExist(orderId));
	    	 System.out.println(pss.trackProductOrder(orderId));
	    	 System.out.println("Enter Exit date in this format -> MM/dd/yyyy");
	         String date=sc.nextLine();
	         Date exitDate=new SimpleDateFormat("MM/dd/yyyy").parse(date); 
	         System.out.println(pss.processDateCheck(exitDate));
	         System.out.println(pss.updateExitDateinStock(orderId,exitDate));
	         System.out.println("Enter Manufacturing date");
	         String date1=sc.nextLine();
	         Date manufacturing_date=new SimpleDateFormat("MM/dd/yyyy").parse(date1); 
	         System.out.println(pss.validateManfacturingDate(manufacturing_date));
	         System.out.println("Enter expiry date");
	         String date2=sc.nextLine();
	         Date expiry_date=new SimpleDateFormat("MM/dd/yyyy").parse(date2);
	         System.out.println(pss.validateProcessDate(manufacturing_date, expiry_date));
	         System.out.println("Enter Quality Check");
	         String qualityCheck=sc.nextLine();
	         System.out.println(pss.updateRawMaterialStock(orderId,manufacturing_date, expiry_date, qualityCheck));
	         System.out.println(pss.trackProductOrder(orderId));
	         System.out.println("===================================");
	         break;
	    }
	    default:
	    {
	    	System.out.println("Enter choice is invalid");
	    	break;
	    }
	    }
   	}
    
	}
	
}
