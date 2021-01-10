package com.hktv.hktv_interview.controller;

import com.hktv.hktv_interview.dto.DispatchDto;
import com.hktv.hktv_interview.model.Dispatch;
import com.hktv.hktv_interview.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "/dispatch")
public class DispatchController {
    @Autowired
    private DispatchService dispatchService;


    @PostMapping(value = "/add")
    public @ResponseBody
    DispatchDto addDispatch(
            @RequestParam Integer destStockId,
            @RequestParam Integer sourStockId,
            @RequestParam Integer qty) throws Exception {
        Dispatch dispatch = dispatchService.addDispatch(destStockId,sourStockId,qty,new Date());
        return new DispatchDto(dispatch);
    }
}
