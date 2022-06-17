package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.OutWorkMsg;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/17 20:39 星期五
 */
@Service
@RequiredArgsConstructor
public class OutWorkMsgProxy implements DataProxy<OutWorkMsg> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(OutWorkMsg outWorkMsg) {
        outWorkMsg.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(OutWorkMsg outWorkMsg) {
        outWorkMsg.setUpdatedAt(timeUtil.generateDate());
    }
}
