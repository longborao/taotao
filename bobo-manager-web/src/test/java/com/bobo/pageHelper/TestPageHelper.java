package com.bobo.pageHelper;

import com.bobo.mapper.TbItemMapper;
import com.bobo.pojo.TbItem;
import com.bobo.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by robot on 2016/11/20.
 */

public class TestPageHelper {
    @Test
    public void testPageHelper(){
        //1.获取mapper对象
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        TbItemMapper bean=applicationContext.getBean(TbItemMapper.class);
        //2.设置分页
        PageHelper.startPage(1,30);
        //3.执行查询
        TbItemExample example=new TbItemExample();
        List<TbItem> items=bean.selectByExample(example);
        //4.取分页的结果
        PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(items);
        long total=pageInfo.getTotal();
        System.out.println("total:"+total);
        int pages=pageInfo.getPages();
        System.out.println("pages:"+pages);
        int pageSize=pageInfo.getPageSize();
        System.out.println("pageSize:"+pageSize);
    }
}
