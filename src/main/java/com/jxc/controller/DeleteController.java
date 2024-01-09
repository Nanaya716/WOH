package com.jxc.controller;

import com.jxc.service.ProductsService;
import com.jxc.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

    @Autowired
    private ProductsService productsService;  // 假设你有一个 ProductService 负责处理商品相关的业务

    @Autowired
    private StockService stockService;  // 假设你有一个 StockService 负责处理库存相关的业务

    @GetMapping("/deleteData")
    public String deleteProduct(@RequestParam("id") Integer productId) {
        // 根据商品ID删除商品
        productsService.deleteById(productId);
        stockService.deleteByProductId(productId);

        // 返回到首页或其他页面
        return "home";
    }

}

