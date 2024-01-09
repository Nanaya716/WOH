package com.jxc.service;

import com.jxc.entity.SearchDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchService {
    List<SearchDto> SearchProducts(@Param("keyword") String keyword);
}
