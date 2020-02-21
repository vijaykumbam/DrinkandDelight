package com.capgemini.delightOrder.dao.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.capgemini.delightOrder.dao.RawMaterialStockDao;
import com.capgemini.delightOrder.dto.RawMaterialStockBean;
import com.capgemini.delightOrder.exception.RawMaterialException;
import com.capgemini.delightOrder.util.RawMaterialStockRepository;

public class RawMaterialStockDaoTest 
{
	RawMaterialStockDao obj = new RawMaterialStockDao();
	Map<String,RawMaterialStockBean>map = RawMaterialStockRepository.getRawMaterialStocklist();
	
	@Test
	public void testDoesRawMaterialOrderIdExist() throws RawMaterialException
	{ 
		assertEquals(map.containsKey("RawId11606975"),obj.doesRawMaterialOrderIdExist("RawId11606975"));
		assertEquals(obj.doesRawMaterialOrderIdExist("RawId11606"),false);
	}
	 @Test
	 public void testDoesRawMaterialOrderIdExist1() throws RawMaterialException
	 {
		 assertEquals(obj.trackRawMaterialOrder("RawId11606974"),RawMaterialStockRepository.RawMaterialStocklist.get("RawId11606974"));
	 } 
	 
	  
	 @Test
	 public void updateProcessDateinStock() throws ParseException
	 {
		 	String date ="12/02/2020";
			Date processDate=new SimpleDateFormat("dd/MM/yyyy").parse(date);
			String orderId="RawId11606974",expected="ProcessData is Successfully Updated";
			assertEquals(obj.updateProcessDateinStock(orderId, processDate),expected);
	 }
	 
	 
	 @Test
	 public void updateRawMaterialStock() throws ParseException, RawMaterialException
	 {//String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck
		 String orderId="RawId11606974",qualityCheck ="good";
		 String md = "12/02/2023";
		 String ed = "12/02/2024";
		 Date manufacturing_date =new SimpleDateFormat("dd/MM/yyyy").parse(md);
		 Date expiry_date=new SimpleDateFormat("dd/MM/yyyy").parse(ed);
		 assertEquals(obj.updateRawMaterialStock(orderId, manufacturing_date, expiry_date, qualityCheck),"Dates were successfully updated");
	 }
	 
}
 