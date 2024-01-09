package com.jxc.controller;

import com.jxc.dao.SearchDao;
import com.jxc.entity.SearchDto;
import com.jxc.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public String search(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        // 这里执行 MyBatis 查询
        List<SearchDto> searchResults = searchService.SearchProducts(keyword);

        // 将查询结果传递给视图
        model.addAttribute("SearchResults", searchResults);
        return "home";
    }
}
