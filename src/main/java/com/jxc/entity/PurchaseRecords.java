package com.jxc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PurchaseRecords)实体类
 *
 * @author makejava
 * @since 2023-12-21 15:32:06
 */
public class PurchaseRecords implements Serializable {
    private static final long serialVersionUID = 713047472588414839L;
    
    private Integer id;
    
    private Integer productId;
    
    private Date purchaseTime;
    
    private Integer quantity;
    
    private Double unitPrice;
    
    private Double totalPrice;
    
    private String supplierName;
    
    private String purchaserName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

}

