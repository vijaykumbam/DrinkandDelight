package com.capgemini.delightOrder.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.capgemini.delightOrder.dao.RawMaterialStockDao;
import com.capgemini.delightOrder.dto.RawMaterialStockBean;
import com.capgemini.delightOrder.exception.InvalidDateException;
import com.capgemini.delightOrder.exception.RawMaterialException;

public class RawMaterialServiceImpl implements RawMaterialService
{
	RawMaterialStockDao rawMaterialDaoRef=new RawMaterialStockDao(); //object
	
	//..........tested...................
		public boolean doesRawMaterialOrderIdExist(String orderId)
		{	 
			try 
			{ 
				return  rawMaterialDaoRef.doesRawMaterialOrderIdExist(orderId);
			}
			catch (RawMaterialException e)
			{
				//e.printStackTrace();
				 e.getMessage();
			}
		    return false; 
		}
		
	
	//..............Partially Tested.........
	public RawMaterialStockBean trackRawMaterialOrder(String orderId) 
	{
	    	try
	    	{
	    	  if(doesRawMaterialOrderIdExist(orderId))
	    		  return rawMaterialDaoRef.trackRawMaterialOrder(orderId);
	    	  else
	    		 throw new RawMaterialException("No OrderId Exist");
	      }
	      catch(RawMaterialException e)
		    {
		    	 e.getMessage();
		    }
    return null;
	}
	 
	
	
	//..............should do...............
	public boolean processDateCheck(Date processDate)
	{
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//String strDate = dateFormat.format(processDate);
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
	
	
	//...................should do.....................
	public String updateExitDateinStock(String orderId,Date exitDate) {
		// TODO Auto-generated method stub
		if(processDateCheck(exitDate))	
		{
			return rawMaterialDaoRef.updateProcessDateinStock(orderId,exitDate);
		  
		}
		else 
			return "null";
	}
	//....................................................................
	public boolean validateManfacturingDate(Date manufacturing_date) 
	{
	      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	      String Date=new SimpleDateFormat("dd/MM/yyyy").format(manufacturing_date);
	      sdf.setLenient(false);
	      try {
				
				Date date = sdf.parse(Date);
			
			} catch (ParseException e) 
	      {
				 e.getMessage();
				//e.printStackTrace();
				return false;
			}	
			return true;
			
	}
	
	
	
	public boolean validateProcessDate(Date manufacturing_date, Date expiry_date) 
	{
		if(manufacturing_date==null || expiry_date==null)
	      {
			return false;
	      }
	      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	      String Date1=new SimpleDateFormat("dd/MM/yyyy").format(manufacturing_date);
	      String Date2=new SimpleDateFormat("dd/MM/yyyy").format(expiry_date);
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
	    	   	 //System.out.println(e);
	    	   	 return false;
	    	   }
		
	} 
	
	 
	public String updateRawMaterialStock(String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck) throws RawMaterialException
	{	
		if(validateManfacturingDate(manufacturing_date)&&validateProcessDate(manufacturing_date,expiry_date))
		{
			return rawMaterialDaoRef.updateRawMaterialStock(orderId,manufacturing_date, expiry_date, qualityCheck);
		}
		else
		{
			return null;
		}
	}
	
	
	//----------------tested----------------
	public boolean doesRawMaterialOrderIdExistInStock(String orderId)
	{ 
		// TODO Auto-generated method stub
		return false;
	}


//...............currently.............
	public String updateProcessDateinStock(String orderId, Date processDate) 
	{
		if(doesRawMaterialOrderIdExist(orderId))
		{
			return rawMaterialDaoRef.updateProcessDateinStock(orderId, processDate);
		}
		else
		return "OrderId is not valid try to enter the correct OrderId";
		
	}

	
	//..........tested...................
	public String validateProcessDate(int day, int month, int year) throws InvalidDateException 
	{
		String processDate = null;
		if((day<=31 && day>=1)&&(month<=12 &&month>=1)&&(year<=2030 &&year>=2010))
		{
			String dd= String.format("%02d", day);
			String MM= String.format("%02d", month);
			String yyyy= String.valueOf(year);
			processDate = dd+"/"+MM+"/"+yyyy;
		}
		else
		{
			throw new InvalidDateException("Invalid date try to enter the correct format");
		}
		return processDate;
	}
		 
}