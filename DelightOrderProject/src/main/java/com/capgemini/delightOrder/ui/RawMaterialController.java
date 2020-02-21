package com.capgemini.delightOrder.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.capgemini.delightOrder.exception.InvalidDateException;
import com.capgemini.delightOrder.exception.RawMaterialException;
import com.capgemini.delightOrder.service.RawMaterialService;
import com.capgemini.delightOrder.service.RawMaterialServiceImpl;

public class RawMaterialController 
{
	public static void main(String[] args) throws ParseException, InvalidDateException, RawMaterialException 
	{
	Scanner sc =new Scanner(System.in);
	RawMaterialService rawMaterialServiceRef=new RawMaterialServiceImpl();
    while(true) 
    {	    
	    System.out.println("1->TrackRawMaterialorder\n2->updateProcessDate\n3->updateRawMaterialStock details\n4->TO display UpdatedRawMaterialstockManagement");
	    System.out.println("===================================");
	    System.out.println("Enter the choice");
	    String choice = sc.next();
	    switch(choice)
	    {
	    case "1": 
	    {
	    	 System.out.println("Enter RawMaterial Tracking orderId");
	    	 String orderId=sc.next();
	    	 System.out.println(rawMaterialServiceRef.doesRawMaterialOrderIdExist(orderId));
	    	 System.out.println(rawMaterialServiceRef.trackRawMaterialOrder(orderId));
	    	 System.out.println("===================================");
	    	 break;
	    }
	    
	    case "2":
	    {
	    	 while(true) 
	    	 {
		    	 System.out.println("Welcome to the Process date to RawMaterial");
		    	 System.out.println("Enter the  date ");
		    	 int day = sc.nextInt();
		    	 System.out.println("Enter the month ");
		    	 int month =sc.nextInt();
		    	 System.out.println("Enter the year ");
		    	 int year = sc.nextInt();
		    	 try 
		    	 	{
		    		     System.out.println(rawMaterialServiceRef.validateProcessDate(day, month, year));
				    	 String date=(rawMaterialServiceRef.validateProcessDate(day,month,year));
				    	 Date processDate=new SimpleDateFormat("dd/MM/yyyy").parse(date); 
				         System.out.println(rawMaterialServiceRef.processDateCheck(processDate));
				         System.out.println("Enter orderId");
				         String orderId=sc.next();
				         System.out.println(rawMaterialServiceRef.updateProcessDateinStock(orderId,processDate));
				         System.out.println("===================================");
				         break;
		    		 }
		    	 catch(InvalidDateException e)
		    	 {
		    			// e.printStackTrace();
		    		 System.out.println(e.getMessage());
		    	 }
	     } break; 
	    } 
	    
	    
	    case "3":
	    {
	    	while(true)
	    	{
	    	 System.out.println("Enter Manufacturing date");
	    	 System.out.println("Enter the  date ");
	    	 int day = sc.nextInt();
	    	 System.out.println("Enter the month ");
	    	 int month =sc.nextInt();
	    	 System.out.println("Enter the year ");
	    	 int year = sc.nextInt();
	    	 try
	    	 {
	    		System.out.println(rawMaterialServiceRef.validateProcessDate(day, month, year));
		        String date1=(rawMaterialServiceRef.validateProcessDate(day,month,year));
		        Date manufacturing_date=new SimpleDateFormat("dd/MM/yyyy").parse(date1); 
		        System.out.println(rawMaterialServiceRef.validateManfacturingDate(manufacturing_date));
		        System.out.println("Enter expiry date which is plus 1Year to manuf date in dd/MM/yyyy");
		        String date2=sc.next();
		        Date expiry_date=new SimpleDateFormat("dd/MM/yyyy").parse(date2);
		        System.out.println(rawMaterialServiceRef.validateProcessDate(manufacturing_date, expiry_date));
		        System.out.println("Enter Quality Check");
		        String qualityCheck=sc.next();
		        System.out.println("Enter OrderId");
		        String orderId=sc.next();
		        System.out.println(rawMaterialServiceRef.updateRawMaterialStock(orderId,manufacturing_date, expiry_date, qualityCheck));
		        System.out.println("===================================");
		        break; 
	        }
	    	 catch(InvalidDateException e)
	    	 {
	    		 System.out.println(e.getMessage());
	    	 }
	    	}
	    	break;
	    	} 
	    case "4":
	    {
	    	while(true)
	    	{
	    		try
	    		{
		    	 System.out.println("Enter orderId");
		    	 String orderId=sc.next();
		    	 System.out.println(rawMaterialServiceRef.doesRawMaterialOrderIdExist(orderId));
		    	 System.out.println(rawMaterialServiceRef.trackRawMaterialOrder(orderId));
		    	 System.out.println("Enter Process_date for RawMaterial in this format ->dd/MM/yyyy");
		         String date=sc.next(); 
		         Date Process_date=new SimpleDateFormat("dd/MM/yyyy").parse(date); 
		         System.out.println(rawMaterialServiceRef.processDateCheck(Process_date));
		         System.out.println(rawMaterialServiceRef.updateProcessDateinStock(orderId,Process_date));
		         System.out.println("Enter Manufacturing date");
		         String date1=sc.next();
		         Date manufacturing_date=new SimpleDateFormat("dd/MM/yyyy").parse(date1); 
		         System.out.println(rawMaterialServiceRef.validateManfacturingDate(manufacturing_date));
		         System.out.println("Enter expiry date in format-->dd/MM/yyyy it should be more than manfu_date");
		         String date2=sc.next();
		         Date expiry_date=new SimpleDateFormat("dd/MM/yyyy").parse(date2);
		         System.out.println(rawMaterialServiceRef.validateProcessDate(manufacturing_date, expiry_date));
		         System.out.println("Enter Quality of the RawMaterial");
		         String qualityCheck=sc.next();
		         System.out.println(rawMaterialServiceRef.updateRawMaterialStock(orderId,manufacturing_date, expiry_date, qualityCheck));
		         System.out.println(rawMaterialServiceRef.trackRawMaterialOrder(orderId));
		         System.out.println("===================================");
		         break;
	         }
	    	catch(RawMaterialException e)
	    		{
	    			System.out.println(e.getMessage());
	    		}
	    	
	    	  }
	    	break;	
	    	}
	    default:
	    {
	    	System.out.println("Bravoo !!!!Too Smart!!! --->Entered choice is invalid");
	    	System.out.println("=================================================");
	    	break;
	    }
	    }
   	}
    
	}
	
}
