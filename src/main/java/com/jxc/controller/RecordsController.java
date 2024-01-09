package com.jxc.controller;

import com.jxc.entity.Products;
import com.jxc.entity.PurchaseRecords;
import com.jxc.entity.SalesRecords;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecordsController {
    @Autowired
    private PurchaseRecordsService purchaseRecordsService;
    @Autowired
    private SalesRecordsService salesRecordsService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private StockService stockService;

    @PostMapping ("/addPurchaseRecords")
    public String addPurchaseRecords(@ModelAttribute PurchaseRecords purchaseRecords) {
        // 添加商品进货记录
        purchaseRecordsService.insert(purchaseRecords);
        Stock stock = stockService.queryByProductId(purchaseRecords.getProductId());
        stock.setQuantity(stock.getQuantity()+purchaseRecords.getQuantity());
        stockService.update(stock);

        return "home";
    }
    @PostMapping ("/addSalesRecords")
    public String addSalesRecords(@ModelAttribute SalesRecords salesRecords) {
        // 添加商品出货记录
        salesRecordsService.insert(salesRecords);
        Stock stock = stockService.queryByProductId(salesRecords.getProductId());
        stock.setQuantity(stock.getQuantity()-salesRecords.getQuantity());
        stockService.update(stock);

        return "home";
    }

    @GetMapping("/purchaseOperateDetails")
    public String showViewPurchaseOperateDetails(@RequestParam("id")Integer id, Model model){
        Products products = productsService.queryById(id);

        model.addAttribute("productsData",products);
        return "purchaseOperateDetails";
    }

    @GetMapping("/salesOperateDetails")
    public String showViewSalesOperateDetails(@RequestParam("id")Integer id, Model model){
        Products products = productsService.queryById(id);

        model.addAttribute("productsData",products);
        return "salesOperateDetails";
    }
}
