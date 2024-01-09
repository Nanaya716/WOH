package com.jxc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Stock)实体类
 *
 * @author makejava
 * @since 2023-12-21 16:22:41
 */
public class Stock implements Serializable {
    private static final long serialVersionUID = 690585700519392115L;
    
    private Integer id;
    
    private Integer productId;
    
    private Integer quantity;
    
    private Date updateTime;


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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

