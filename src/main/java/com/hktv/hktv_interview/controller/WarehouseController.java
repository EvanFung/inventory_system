package com.hktv.hktv_interview.controller;

import com.hktv.hktv_interview.dto.WarehouseDto;
import com.hktv.hktv_interview.model.Warehouse;
import com.hktv.hktv_interview.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @PostMapping(value = "/add")
    public @ResponseBody
    WarehouseDto addWarehouse(@RequestParam String code,
                              @RequestParam String name
    ) {
        Warehouse warehouse = warehouseService.addWarehouse(code,name);
        return new WarehouseDto(warehouse);
    }

}
