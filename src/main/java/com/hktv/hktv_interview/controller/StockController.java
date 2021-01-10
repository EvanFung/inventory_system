package com.hktv.hktv_interview.controller;

import com.hktv.hktv_interview.dto.ProductDto;
import com.hktv.hktv_interview.dto.StockDto;
import com.hktv.hktv_interview.model.Product;
import com.hktv.hktv_interview.model.Stock;
import com.hktv.hktv_interview.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//product in & out stock table.
@RestController
@RequestMapping(path = "/stock")
public class StockController {
    @Autowired
    StockService stockService;

    //添加一個進或出倉庫記錄的明細單 - In store
    @PostMapping(value = "/add")
    public @ResponseBody
    StockDto addStock(
            @RequestParam Integer warehouseId,
            @RequestParam Integer productId,
            String operator,
            int qty,
            String type) {
        Stock stock = stockService.addStock(warehouseId,productId,operator,qty,type, new Date());
        return new StockDto(stock);
    }

    //查找全部進或出的倉庫記錄的明細單
    @GetMapping(value = "/all")
    public @ResponseBody
    List<StockDto> getAllStocks() {
        List<Stock> stocks = stockService.getAllStock();
        return stocks.stream().map(StockDto::new).collect(Collectors.toList());
    }
}
