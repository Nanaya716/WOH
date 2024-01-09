package com.jxc.dao;

import com.jxc.entity.SearchDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

// ProductStockMapper.java
@Mapper
public interface SearchDao {

    List<SearchDto> selectProductStock(@Param("keyword") String keyword);
}
