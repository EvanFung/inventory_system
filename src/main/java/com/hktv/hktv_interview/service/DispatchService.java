package com.hktv.hktv_interview.service;

import com.hktv.hktv_interview.model.Dispatch;

import java.util.Date;

public interface DispatchService {
    Dispatch addDispatch(Integer destStockId, Integer sourStockId, int qty, Date createAt) throws Exception;
}
