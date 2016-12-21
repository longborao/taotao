package com.bobo.service.impl;

import com.bobo.common.pojo.EasyUIDataGridResult;
import com.bobo.mapper.TbItemMapper;
import com.bobo.pojo.TbItem;
import com.bobo.pojo.TbItemExample;
import com.bobo.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by robot on 2016/11/18.
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private TbItemMapper itemMapper;
    @Override
    public TbItem getItemById(long itemId) {
        TbItem item=null;
        TbItemExample example=new TbItemExample();
        //创建查询条件
        TbItemExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list=itemMapper.selectByExample(example);
        if (list!=null&&list.size()>0){
            item=list.get(0);
        }
        return item;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        EasyUIDataGridResult easyUIDataGridResult=null;
        //分页处理
        PageHelper.startPage(page,rows);
        //分页查询
        TbItemExample example=new TbItemExample();
        List<TbItem> list=itemMapper.selectByExample(example);
        //取分页信息
        PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(list);
        //返回结果
        easyUIDataGridResult=new EasyUIDataGridResult();
        easyUIDataGridResult.setTotal(pageInfo.getTotal());
        easyUIDataGridResult.setRows(list);
        return easyUIDataGridResult;
    }
}
