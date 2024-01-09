package com.jxc.service.impl;

import com.jxc.dao.SearchDao;
import com.jxc.entity.SearchDto;
import com.jxc.service.SearchService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
    @Resource
    private SearchDao searchDao;
    public List<SearchDto> SearchProducts(@Param("keyword") String keyword){
        return this.searchDao.selectProductStock(keyword);
    }
}
