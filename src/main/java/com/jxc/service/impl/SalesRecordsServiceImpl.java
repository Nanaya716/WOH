package com.jxc.service.impl;

import com.jxc.entity.SalesRecords;
import com.jxc.dao.SalesRecordsDao;
import com.jxc.service.SalesRecordsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SalesRecords)表服务实现类
 *
 * @author makejava
 * @since 2023-12-21 16:00:11
 */
@Service("salesRecordsService")
public class SalesRecordsServiceImpl implements SalesRecordsService {
    @Resource
    private SalesRecordsDao salesRecordsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SalesRecords queryById(Integer id) {
        return this.salesRecordsDao.queryById(id);
    }
    public List<SalesRecords> queryListByProductId(Integer id){
        return this.salesRecordsDao.queryByProductId(id);
    }

    /**
     * 分页查询
     *
     * @param salesRecords 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SalesRecords> queryByPage(SalesRecords salesRecords, PageRequest pageRequest) {
        long total = this.salesRecordsDao.count(salesRecords);
        return new PageImpl<>(this.salesRecordsDao.queryAllByLimit(salesRecords, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param salesRecords 实例对象
     * @return 实例对象
     */
    @Override
    public SalesRecords insert(SalesRecords salesRecords) {
        this.salesRecordsDao.insert(salesRecords);
        return salesRecords;
    }

    /**
     * 修改数据
     *
     * @param salesRecords 实例对象
     * @return 实例对象
     */
    @Override
    public SalesRecords update(SalesRecords salesRecords) {
        this.salesRecordsDao.update(salesRecords);
        return this.queryById(salesRecords.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.salesRecordsDao.deleteById(id) > 0;
    }
}
