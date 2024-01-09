package com.jxc.controller;

import com.jxc.entity.Products;
import com.jxc.entity.Stock;
import com.jxc.service.ProductsService;
import com.jxc.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailsController {

    @Autowired
    private ProductsService productsService;
    @Autowired
    private StockService stockService;

    @GetMapping("/productDetails")
    public String showProductDetails(@RequestParam("id") Integer productId, Model model) {
        // 根据商品ID从数据库中获取商品详细信息
        Products productDetails = productsService.queryById(productId);
        Stock stockDetails = stockService.queryByProductId(productId);

        // 将商品详细信息传递给视图
        model.addAttribute("productDetails", productDetails);
        model.addAttribute("stockDetails", stockDetails);

        // 返回商品详情页面的视图名称（请根据您的实际页面名称进行更改）
        return "productDetails";
    }
}
