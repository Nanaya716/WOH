package com.jxc.controller;

import com.jxc.entity.PurchaseRecords;
import com.jxc.service.PurchaseRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PurchaseRecordsController {

    @Autowired
    private PurchaseRecordsService purchaseRecordsService;

    @GetMapping("/purchaseDetails")
    public String showPurchaseDetails(@RequestParam(name = "id") Integer productId, Model model) {
        // 根据商品ID查询进货详情数据
        List<PurchaseRecords> purchaseDetails = purchaseRecordsService.queryListByProductId(productId);

        // 将查询结果传递给视图
        model.addAttribute("purchaseResults", purchaseDetails);
        return "purchaseDetails"; // 请替换成你的实际页面名称
    }
}
