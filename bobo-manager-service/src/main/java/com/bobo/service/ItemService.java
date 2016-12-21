package com.bobo.service;

import com.bobo.common.pojo.EasyUIDataGridResult;
import com.bobo.pojo.TbItem;

/**
 * Created by robot on 2016/11/18.
 */
public interface ItemService {
    TbItem getItemById(long itemId);
    EasyUIDataGridResult getItemList(int page,int rows);
}
