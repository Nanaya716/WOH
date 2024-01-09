package com.jxc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SalesRecords)实体类
 *
 * @author makejava
 * @since 2023-12-21 16:00:11
 */
public class SalesRecords implements Serializable {
    private static final long serialVersionUID = 194432451569751656L;
    
    private Integer id;
    
    private Integer productId;
    
    private Date saleTime;
    
    private Integer quantity;
    
    private Double unitPrice;
    
    private Double totalPrice;
    
    private String salesmanName;


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

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
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

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

}

