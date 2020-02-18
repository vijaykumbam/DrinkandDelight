package com.capgemini.delightOrder.service;

import java.util.Date;

import com.capgemini.delightOrder.dto.RawMaterialStockBean;

public interface RawMaterialService 
{
	public RawMaterialStockBean trackRawMaterialOrder(String orderId);
	public boolean doesRawMaterialOrderIdExist(String OrderId);
	public boolean processDateCheck(Date processDate);
	public String updateProcessDateinStock(String orderId,Date processDate);
	public boolean validateManfacturingDate(Date manufacturing_date);
	public boolean validateProcessDate(Date manufacturing_date,Date process_date);
	public String updateRawMaterialStock(String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck);
	public boolean doesRawMaterialOrderIdExistInStock(String orderId);
}