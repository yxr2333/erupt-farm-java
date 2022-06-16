package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.Subsidy;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 16:04 星期四
 */
@Service
@RequiredArgsConstructor
public class SubsidyProxy implements DataProxy<Subsidy> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(Subsidy subsidy) {
        subsidy.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(Subsidy subsidy) {
        subsidy.setUpdatedAt(timeUtil.generateDate());
    }
}
