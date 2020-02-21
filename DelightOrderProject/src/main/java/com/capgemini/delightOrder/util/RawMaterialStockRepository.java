package com.capgemini.delightOrder.util;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.delightOrder.dto.RawMaterialStockBean;


public class RawMaterialStockRepository
{

 public static Map<String, RawMaterialStockBean> RawMaterialStocklist=new HashMap<String,RawMaterialStockBean>();
 
public static void setRawMaterialStocklist(Map<String, RawMaterialStockBean> RawMaterialStocklist)
{
	RawMaterialStockRepository.RawMaterialStocklist = RawMaterialStocklist;
}

	public static Map<String,RawMaterialStockBean> getRawMaterialStocklist() 
	{
		return RawMaterialStocklist;
	}

public RawMaterialStockRepository()
{
	 RawMaterialStocklist.put("RawId11606974",new RawMaterialStockBean("RawId11606974","Tyre",1000,100,1,100000,"war1"));
	 RawMaterialStocklist.put("RawId11606975",new RawMaterialStockBean("RawId11606975","Blots",800,9,1,21000,"war2"));
	 RawMaterialStocklist.put("RawId11606976",new RawMaterialStockBean("RawId11606976","Steel",200,80,10,32000,"war3"));
	 RawMaterialStocklist.put("RawId11606977",new RawMaterialStockBean("RawId11606977","Iron",1000,100,1,100000,"war4"));
	 RawMaterialStocklist.put("RawId11606978",new RawMaterialStockBean("RawId11606978","Aluminum",800,9,1,21000,"war5"));
	 RawMaterialStocklist.put("RawId11606979",new RawMaterialStockBean("RawId11606979","Sliver",200,80,10,32000,"war6"));
	}
}