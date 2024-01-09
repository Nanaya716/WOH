package com.jxc.dao;

import com.jxc.entity.PurchaseRecords;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (PurchaseRecords)表数据库访问层
 *
 * @author makejava
 * @since 2023-12-21 15:32:06
 */
public interface PurchaseRecordsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseRecords queryById(Integer id);
    List<PurchaseRecords> queryByProductId(Integer id);

    /**
     * 查询指定行数据
     *
     * @param purchaseRecords 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PurchaseRecords> queryAllByLimit(PurchaseRecords purchaseRecords, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param purchaseRecords 查询条件
     * @return 总行数
     */
    long count(PurchaseRecords purchaseRecords);

    /**
     * 新增数据
     *
     * @param purchaseRecords 实例对象
     * @return 影响行数
     */
    int insert(PurchaseRecords purchaseRecords);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PurchaseRecords> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PurchaseRecords> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PurchaseRecords> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PurchaseRecords> entities);

    /**
     * 修改数据
     *
     * @param purchaseRecords 实例对象
     * @return 影响行数
     */
    int update(PurchaseRecords purchaseRecords);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

