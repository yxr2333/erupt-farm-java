package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.IGroup;
import com.ssssheep.farm.entity.Village;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 7:54 星期四
 */
@Service
@RequiredArgsConstructor
public class IGroupProxy implements DataProxy<IGroup> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(IGroup group) {
        group.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(IGroup group) {
        group.setUpdatedAt(timeUtil.generateDate());
    }
}
