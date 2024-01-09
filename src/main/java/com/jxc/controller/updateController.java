package com.jxc.controller;

import com.jxc.entity.Products;
import com.jxc.entity.PurchaseRecords;
import com.jxc.entity.SearchDto;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class updateController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private StockService stockService;
    @Autowired
    private PurchaseRecordsService purchaseRecordsService;
    @Autowired
    private SalesRecordsService salesRecordsService;

    @GetMapping("/updateDetails")
    public String updateProductDetails(@RequestParam("id") Integer productId, Model model) {
        // 根据商品ID从数据库中获取商品详细信息
        Products productDetails = productsService.queryById(productId);
        Stock stockDetails = stockService.queryByProductId(productId);

        // 将商品详细信息传递给视图
        model.addAttribute("productDetails", productDetails);
        model.addAttribute("stockDetails", stockDetails);

        // 返回商品详情页面的视图名称（请根据您的实际页面名称进行更改）
        return "updateDetails";
    }


    @RequestMapping("/updateData")
    public String updateData(@ModelAttribute Products updatedProduct,@ModelAttribute Stock updadedStock, Model model) {
        // updatedProduct 包含了表单提交的所有数据

        // 进行数据库修改操作
        productsService.update(updatedProduct);
        stockService.update(updadedStock);

        // 返回商品详情页面的视图名称（请根据您的实际页面名称进行更改）
        return "home";
    }


}
