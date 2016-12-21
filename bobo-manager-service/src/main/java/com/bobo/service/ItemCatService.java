package com.bobo.service;

import com.bobo.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by robot on 2016/11/28.
 */
public interface ItemCatService {
    List<EasyUITreeNode> getItemCatList(long parentId);
}
