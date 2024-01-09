package com.jxc.service.impl;

import com.jxc.entity.Products;
import com.jxc.dao.ProductsDao;
import com.jxc.service.ProductsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Products)表服务实现类
 *
 * @author makejava
 * @since 2023-12-21 16:20:02
 */
@Service("productsService")
public class ProductsServiceImpl implements ProductsService {
    @Resource
    private ProductsDao productsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Products queryById(Integer id) {
        return this.productsDao.queryById(id);
    }

    public Products queryByName(String name) {
        return this.productsDao.queryByName(name);
    }

    /**
     * 分页查询
     *
     * @param products 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Products> queryByPage(Products products, PageRequest pageRequest) {
        long total = this.productsDao.count(products);
        return new PageImpl<>(this.productsDao.queryAllByLimit(products, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    @Override
    public Products insert(Products products) {
        this.productsDao.insert(products);
        return products;
    }

    /**
     * 修改数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    @Override
    public Products update(Products products) {
        this.productsDao.update(products);
        return this.queryById(products.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productsDao.deleteById(id) > 0;
    }
}
