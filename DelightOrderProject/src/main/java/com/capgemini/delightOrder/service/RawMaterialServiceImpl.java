package com.capgemini.delightOrder.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import com.capgemini.delightOrder.dao.RawMaterialStockDao;
import com.capgemini.delightOrder.dto.RawMaterialStockBean;
import com.capgemini.delightOrder.exception.RawMaterialException;

public class RawMaterialServiceImpl implements RawMaterialService
{
	RawMaterialStockDao ps=new RawMaterialStockDao();
	
	
	public RawMaterialStockBean trackProductOrder(String orderId) 
	{
    try
    {
    	  if(doesRawMaterialOrderIdExist(orderId))
    		  
    		  return ps.trackRawMaterialOrder(orderId);
    	  else
    		 throw new RawMaterialException("No OrderId Exist");
      }
      catch(RawMaterialException e)
    {
    	 System.out.println(e);
    }
    return null;
	}
	
	
	public boolean doesRawMaterialOrderIdExist(String orderId)
	{	 
		try
		{
			return  ps.doesRawMaterialOrderIdExist(orderId);
		} 
		catch (RawMaterialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return false;
	}
	
	
	public boolean processDateCheck(Date processDate)
	{
      if(processDate==null)
      {
		return false;
      }
//      Date date = Calendar.getInstance().getTime();  
//      DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//      String str = "1234";
//      int inum = Integer.parseInt(str);
//      String strDate = dateFormat.format(date);  
      
      Date date1 = processDate;
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
      String strdate = dateFormat.format(date1);
      
      StringTokenizer str = new StringTokenizer(strdate+"/");
      while(str.hasMoreTokens())
      {
    	  String day =str.nextToken();
    	  String month =str.nextToken();
    	  String year = str.nextToken();
      }
      

      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      String Date=new SimpleDateFormat("dd/MM/yyyy").format(processDate);
      sdf.setLenient(false);
      try
      	{
			Date date = sdf.parse(Date);
		} 
       catch (ParseException e) 
       {
			
			e.printStackTrace();
			return false;
		}	
		return true;
	}
	
	
	
	public String updateExitDateinStock(String orderId,Date exitDate) {
		// TODO Auto-generated method stub
		if(processDateCheck(exitDate))	
		{
			return ps.updateProcessDateinStock(orderId,exitDate);
		  
		}
		else 
			return "null";
	}
	
	
	public boolean validateManfacturingDate(Date manufacturing_date) {
		// TODO Auto-generated method stub
		if(manufacturing_date==null)
	      {
			return false;
	      }

	      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	      String Date=new SimpleDateFormat("dd/MM/yyyy").format(manufacturing_date);
	      sdf.setLenient(false);
	      try {
				
				Date date = sdf.parse(Date);
			
			} catch (ParseException e) 
	      {
				
				e.printStackTrace();
				return false;
			}	
			return true;
			
	}
	public boolean validateProcessDate(Date manufacturing_date, Date expiry_date) {
		if(manufacturing_date==null || expiry_date==null)
	      {
			return false;
	      }
	      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	      String Date1=new SimpleDateFormat("dd/MM/yyyy").format(manufacturing_date);
	      String Date2=new SimpleDateFormat("dd/MM/yyyy").format(manufacturing_date);
	      sdf.setLenient(false);
	      try 
	      {
				Date date1 = sdf.parse(Date1);
				Date date2 = sdf.parse(Date2);
				
			} 
	      catch (ParseException e) 
	      {	
				e.printStackTrace();
				return false;
			}	
	      try
   	      {
   	      if(expiry_date.compareTo(manufacturing_date)>0)
			{
				return true;
			}
			else 
			{
				throw new RawMaterialException("No OrderId Exist");
			}
   	        }
	    	  catch(RawMaterialException e)
	    	    {
	    	    	 System.out.println(e);
	    	    	 return false;
	    	    }
		
	}
	
	
	public String updateRawMaterialStock(String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck)
	{
		//if(validateManfacturingDate( manufacturing_date) && validateExpiryDate( manufacturing_date,expiry_date))	
		
				return ps.updateRawMaterialStock(orderId,manufacturing_date, expiry_date, qualityCheck);
		
		
	}
	public boolean doesRawMaterialOrderIdExistInStock(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

	public RawMaterialStockBean trackRawMaterialOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}


	public String updateProcessDateinStock(String orderId, Date processDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public boolean exitDateCheck(Date exitDate) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
	 
	 
}