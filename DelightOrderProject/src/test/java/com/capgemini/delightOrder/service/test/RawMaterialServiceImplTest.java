package com.capgemini.delightOrder.service.test;

import static org.junit.Assert.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.capgemini.delightOrder.exception.InvalidDateException;
import com.capgemini.delightOrder.service.RawMaterialServiceImpl;

public class RawMaterialServiceImplTest
{ 
	RawMaterialServiceImpl obj = new RawMaterialServiceImpl();
	@Test 
	public void doesRawMaterialOrderIdExist()
	{
		String orderId1="RawId11606974";
		boolean ans1=true;
		boolean val1;
		val1 = obj.doesRawMaterialOrderIdExist(orderId1);
		assertEquals(ans1,val1);
	}
	@Test
	public void doesRawMaterialOrderIdExist1()
	{
		String orderId2 ="RawId252";
		assertEquals(obj.doesRawMaterialOrderIdExist(orderId2),false);
	}
	@Test 
	public void testValidateProcessDate() throws InvalidDateException
	{
		int day=12;
		int month =1;
		int year =2020;
		String expected="12/01/2020";
		String processDate = obj.validateProcessDate(day, month, year);
		assertEquals(processDate,expected);
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
	public void testTrackRawMaterialOrder()
	{
		String orderId = "RawId11606970";
		assertEquals(obj.trackRawMaterialOrder(orderId),null);
	}
	@Test
	public void doesRawMaterialOrderIdExistInStock()
	{
		assertEquals(false,obj.doesRawMaterialOrderIdExistInStock(null));
	}
}
