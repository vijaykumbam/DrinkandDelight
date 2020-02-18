package com.capgemini.delightOrder.dto;

import java.util.Date;

public class RawMaterialStockBean 
{
	private String orderId;
	private String name;
	private double price_per_unit;
	private double quantityValue;
	private double quantityUnit;
	private double price;
	private String warehouseID;
	private Date deliveryDate;
	private Date manufacturingDate;
	private Date processDate;
	private String qualityCheck;
	private Date exitDate;
	
	
	public RawMaterialStockBean(String orderId, String name, double price_per_unit, double quantityValue, double quantityUnit,
			double price, String warehouseID) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.price_per_unit = price_per_unit;
		this.quantityValue = quantityValue;
		this.quantityUnit = quantityUnit;
		this.price = price;
		this.warehouseID = warehouseID;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice_per_unit() {
		return price_per_unit;
	}
	public void setPrice_per_unit(double price_per_unit) {
		this.price_per_unit = price_per_unit;
	}
	public double getQuantityValue() {
		return quantityValue;
	}
	public void setQuantityValue(double quantityValue) {
		this.quantityValue = quantityValue;
	}
	public double getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(double quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getWarehouseID() {
		return warehouseID;
	}
	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public Date getProcessDate() {
		return processDate;
	}
	
	public void setExpiryDate(Date processDate) {
		this.processDate = processDate;
	}
	public String getQualityCheck() {
		return qualityCheck;
	}
	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}
	public Date getExitDate() {
		return exitDate;
	}
	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}
	@Override
	public String toString() {
		return "ProductStock--> [\n orderId =" + orderId + "\t\t name =" + name + "\t\t price_per_unit =" + price_per_unit
				+ "\n\t quantityValue =" + quantityValue + "\t quantityUnit=" + quantityUnit + "\t price=" + price
				+ "\n\t warehouseID=" + warehouseID + "\t deliveryDate=" + deliveryDate + "\t manufacturingDate="
				+ manufacturingDate + ",\n\t processDate=" + processDate + "\t qualityCheck=" + qualityCheck + "\t exitDate="
				+ exitDate + "\n]";
	}	
}