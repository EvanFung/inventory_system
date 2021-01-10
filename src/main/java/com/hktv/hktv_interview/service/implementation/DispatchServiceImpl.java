package com.hktv.hktv_interview.service.implementation;

import com.hktv.hktv_interview.model.Dispatch;
import com.hktv.hktv_interview.model.Inventory;
import com.hktv.hktv_interview.model.Stock;
import com.hktv.hktv_interview.repository.DispatchRepository;
import com.hktv.hktv_interview.repository.InventoryRepository;
import com.hktv.hktv_interview.repository.ProductRepository;
import com.hktv.hktv_interview.repository.StockRepository;
import com.hktv.hktv_interview.service.DispatchService;
import com.hktv.hktv_interview.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DispatchServiceImpl implements DispatchService {
    @Autowired
    private DispatchRepository dispatchRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Dispatch addDispatch(Integer destStockId, Integer sourStockId, int qty, Date createAt) throws Exception {
        //首先出货单的产品ID 和入伙单的产品ID 肯定一样
        Stock destStock = stockRepository.findById(destStockId).orElse(null);
        Stock sourStock = stockRepository.findById(sourStockId).orElse(null);

        int productId = sourStock.getProductId();
        int sourceWarehouseId = sourStock.getWarehouseId();
        int destWarehouseId = destStock.getWarehouseId();

//        //发起一个out-stock单在源仓库
//        Stock outStock = new Stock();
//        outStock.setType("OUT_STOCK");
//        outStock.setOperator(sourStock.getOperator());
//        outStock.setProductId(sourStock.getProductId());
//        outStock.setWarehouseId(sourceWarehouseId);
//        outStock.setCreateAt(createAt);
//        outStock.setQty(qty);
//        stockRepository.save(outStock);
//
//        //发起一个in-stock单在目标仓库
//        Stock inStock = new Stock();
//        inStock.setType("IN_STOCK");
//        inStock.setOperator(destStock.getOperator());
//        inStock.setProductId(destStock.getProductId());
//        inStock.setWarehouseId(destWarehouseId);
//        inStock.setCreateAt(createAt);
//        inStock.setQty(qty);
//        stockRepository.save(inStock);

        Optional<Inventory> sourceInventory = inventoryRepository.findByProductIdAndWarehouseId(productId, sourceWarehouseId);
        Optional<Inventory> destInventory = inventoryRepository.findByProductIdAndWarehouseId(productId, destWarehouseId);

        if (!sourceInventory.isPresent()) {
            //throw an exception
            throw new Exception("Please do the in-stock at source stock.");
        }
//        //如果存货表存在，即更新
        if (sourceInventory.isPresent()) {
            Inventory sourceI = sourceInventory.get();
            sourceI.setQty(sourceI.getQty() - qty);
            //保存
            inventoryRepository.save(sourceI);
        }
        //如果目标仓库没有存货记录，创造一个新的记录给目标仓库
        if(!destInventory.isPresent()) {
            Inventory destI = new Inventory();
            destI.setQty(qty);
            destI.setCreateAt(createAt);
            destI.setWarehouseId(destWarehouseId);
            destI.setProductId(productId);
            inventoryRepository.save(destI);
        } else {
            //如果有即更新
            Inventory destI = destInventory.get();
            destI.setQty(destI.getQty() + qty);
            inventoryRepository.save(destI);
        }

        //建立一个新的dispatch-调仓单
        Dispatch dispatch = new Dispatch();
        dispatch.setDestStockId(destStockId);
        dispatch.setSourStockId(sourStockId);
        dispatch.setQty(qty);
        dispatch.setCreateAt(createAt);
        dispatch =  dispatchRepository.save(dispatch);
        return dispatch;
    }
}
