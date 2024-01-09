package com.jxc.service.impl;

import com.jxc.entity.PurchaseRecords;
import com.jxc.dao.PurchaseRecordsDao;
import com.jxc.service.PurchaseRecordsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PurchaseRecords)表服务实现类
 *
 * @author makejava
 * @since 2023-12-21 15:32:12
 */
@Service("purchaseRecordsService")
public class PurchaseRecordsServiceImpl implements PurchaseRecordsService {
    @Resource
    private PurchaseRecordsDao purchaseRecordsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PurchaseRecords queryById(Integer id) {
        return this.purchaseRecordsDao.queryById(id);
    }
    public List<PurchaseRecords> queryListByProductId(Integer id) {
        return this.purchaseRecordsDao.queryByProductId(id);
    }

    /**
     * 分页查询
     *
     * @param purchaseRecords 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<PurchaseRecords> queryByPage(PurchaseRecords purchaseRecords, PageRequest pageRequest) {
        long total = this.purchaseRecordsDao.count(purchaseRecords);
        return new PageImpl<>(this.purchaseRecordsDao.queryAllByLimit(purchaseRecords, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param purchaseRecords 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseRecords insert(PurchaseRecords purchaseRecords) {
        this.purchaseRecordsDao.insert(purchaseRecords);
        return purchaseRecords;
    }

    /**
     * 修改数据
     *
     * @param purchaseRecords 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseRecords update(PurchaseRecords purchaseRecords) {
        this.purchaseRecordsDao.update(purchaseRecords);
        return this.queryById(purchaseRecords.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.purchaseRecordsDao.deleteById(id) > 0;
    }
}
