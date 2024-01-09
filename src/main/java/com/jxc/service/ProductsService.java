package com.jxc.service;

import com.jxc.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Products)表服务接口
 *
 * @author makejava
 * @since 2023-12-21 16:20:02
 */
public interface ProductsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Products queryById(Integer id);
    Products queryByName(String name);

    /**
     * 分页查询
     *
     * @param products 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Products> queryByPage(Products products, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    Products insert(Products products);

    /**
     * 修改数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    Products update(Products products);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
