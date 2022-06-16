package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.Guarantees;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 14:47 星期四
 */
@Service
@RequiredArgsConstructor
public class GuaranteesProxy implements DataProxy<Guarantees> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(Guarantees guarantees) {
        guarantees.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(Guarantees guarantees) {
        guarantees.setUpdatedAt(timeUtil.generateDate());
    }
}
