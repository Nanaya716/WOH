package com.jxc.entity;

import java.io.Serializable;

/**
 * (Products)实体类
 *
 * @author makejava
 * @since 2023-12-21 16:20:02
 */
public class Products implements Serializable {
    private static final long serialVersionUID = 230100024120303194L;
    
    private Integer id;
    
    private String name;
    
    private String code;
    
    private Double purchasePrice;
    
    private Double salePrice;
    
    private String unit;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}

