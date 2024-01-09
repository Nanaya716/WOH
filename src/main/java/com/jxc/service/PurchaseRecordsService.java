package com.jxc.service;

import com.jxc.entity.PurchaseRecords;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (PurchaseRecords)表服务接口
 *
 * @author makejava
 * @since 2023-12-21 15:32:12
 */
public interface PurchaseRecordsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseRecords queryById(Integer id);
    List<PurchaseRecords> queryListByProductId(Integer id);

    /**
     * 分页查询
     *
     * @param purchaseRecords 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<PurchaseRecords> queryByPage(PurchaseRecords purchaseRecords, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param purchaseRecords 实例对象
     * @return 实例对象
     */
    PurchaseRecords insert(PurchaseRecords purchaseRecords);

    /**
     * 修改数据
     *
     * @param purchaseRecords 实例对象
     * @return 实例对象
     */
    PurchaseRecords update(PurchaseRecords purchaseRecords);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
