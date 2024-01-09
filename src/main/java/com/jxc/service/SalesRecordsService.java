package com.jxc.service;

import com.jxc.entity.SalesRecords;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (SalesRecords)表服务接口
 *
 * @author makejava
 * @since 2023-12-21 16:00:11
 */
public interface SalesRecordsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SalesRecords queryById(Integer id);
    List<SalesRecords> queryListByProductId(Integer id);

    /**
     * 分页查询
     *
     * @param salesRecords 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SalesRecords> queryByPage(SalesRecords salesRecords, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param salesRecords 实例对象
     * @return 实例对象
     */
    SalesRecords insert(SalesRecords salesRecords);

    /**
     * 修改数据
     *
     * @param salesRecords 实例对象
     * @return 实例对象
     */
    SalesRecords update(SalesRecords salesRecords);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
