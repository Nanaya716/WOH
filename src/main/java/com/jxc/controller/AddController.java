package com.jxc.controller;

import com.jxc.entity.Products;
import com.jxc.entity.Stock;
import com.jxc.service.ProductsService;
import com.jxc.service.PurchaseRecordsService;
import com.jxc.service.SalesRecordsService;
import com.jxc.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private StockService stockService;
    @Autowired
    private PurchaseRecordsService purchaseRecordsService;
    @Autowired
    private SalesRecordsService salesRecordsService;
    @PostMapping("/addData")
    public String addProduct(@ModelAttribute Products product, @ModelAttribute Stock stock) {
        // 处理添加商品的逻辑
        productsService.insert(product);

        stock.setProductId(productsService.queryByName(product.getName()).getId());
        stockService.insert(stock);
        // 添加商品后重定向到首页或其他页面
        return "home";
    }

    @GetMapping("/addData")
    public String showAddProductPage() {
        // 显示添加商品页面
        return "AddDetails";
    }

}
