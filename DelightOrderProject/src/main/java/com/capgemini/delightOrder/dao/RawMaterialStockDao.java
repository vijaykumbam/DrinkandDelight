package com.capgemini.delightOrder.dao;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import com.capgemini.delightOrder.dto.RawMaterialStockBean;
import com.capgemini.delightOrder.exception.RawMaterialException;
import com.capgemini.delightOrder.util.*;

public class RawMaterialStockDao 
{ 
    RawMaterialStockRepository RawMaterialStockRepository=new RawMaterialStockRepository();
    
     Map<String, RawMaterialStockBean> Rawmateriallist = com.capgemini.delightOrder.util.RawMaterialStockRepository.getRawMaterialStocklist();
      
      
     //This method return the bean details..................
	 public RawMaterialStockBean trackRawMaterialOrder(String orderId)throws RawMaterialException
	 {
   		    return Rawmateriallist.get(orderId); 
	 }
	 
	 //....................tested................
	 //This will check the rawMaterialId id exist or not and return to parent method
	 public boolean doesRawMaterialOrderIdExist(String orderId) throws RawMaterialException
	 {
	 
		 for(RawMaterialStockBean values :Rawmateriallist.values())
		 {
			 if(values.getOrderId().equalsIgnoreCase(orderId))
			 {
				 return true;
			 }
		 }
		 return false;
		 
	 } 
	 
	 //-----------------Tested----------------
	 public String updateProcessDateinStock(String orderId,Date processDate) 
	 {
		 for (Entry<String,RawMaterialStockBean> mp:Rawmateriallist.entrySet()) 
		 {
			 if (mp.getValue().getOrderId().equals(orderId))
			 {
	           mp.getValue().setProcessDate(processDate);      
             } 
		 }
		 return "ProcessData is Successfully Updated";
	 }
	   
	 //.............TESTED.................
	 public String updateRawMaterialStock(String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck) throws RawMaterialException
	 { 
		 for (Entry<String , RawMaterialStockBean> mp:Rawmateriallist.entrySet()) 
		 {
			 if (mp.getValue().getOrderId().contentEquals(orderId))
			 {
	           mp.getValue().setManufacturingDate(manufacturing_date);
	           mp.getValue().setExpiryDate(expiry_date);
	           mp.getValue().setQualityCheck(qualityCheck);
			 }
		 }
		 return "Dates were successfully updated";
	 }
}
