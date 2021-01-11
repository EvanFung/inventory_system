package com.hktv.hktv_interview.controller;

import com.hktv.hktv_interview.dto.ProductDto;
import com.hktv.hktv_interview.dto.StockCountDto;
import com.hktv.hktv_interview.dto.StockDto;
import com.hktv.hktv_interview.model.Product;
import com.hktv.hktv_interview.model.Stock;
import com.hktv.hktv_interview.response.ResponseMessage;
import com.hktv.hktv_interview.service.StockService;
import com.hktv.hktv_interview.utils.CSVHelper;
import com.hktv.hktv_interview.utils.IStockCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        Stock stock = stockService.addStock(warehouseId, productId, operator, qty, type, new Date());
        return new StockDto(stock);
    }

    //查找全部進或出的倉庫記錄的明細單
    @GetMapping(value = "/all")
    public @ResponseBody
    List<StockDto> getAllStocks() {
        List<Stock> stocks = stockService.getAllStock();
        return stocks.stream().map(StockDto::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/products/{productId}")
    public @ResponseBody
    List<StockDto> getStocksByProductId(@PathVariable Integer productId) {
        List<Stock> stocks = stockService.getStockByProductId(productId);
        return stocks.stream().map(StockDto::new).collect(Collectors.toList());
    }


    @GetMapping(value = "/groupstock/{productId}")
    public @ResponseBody
    List<StockCountDto> getStocksByProductIdAndType(@PathVariable Integer productId) {
        List<IStockCount> stocks = stockService.findGroupStockByProductIdAndType("IN_STOCK", productId);
        return stocks.stream().map(s -> {
            StockCountDto stockCountDto = new StockCountDto();
            stockCountDto.setProductId(s.getPId());
            stockCountDto.setType(s.getStatus());
            stockCountDto.setTotal(s.getTotal());
            stockCountDto.setWarehouseId(s.getWId());
            stockCountDto.setWarehouseName(s.getWarehouseName());
            return stockCountDto;
        }).collect(Collectors.toList());
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam MultipartFile file) {
        String message = "";
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                stockService.uploadStock(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                System.out.println(e);
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}
