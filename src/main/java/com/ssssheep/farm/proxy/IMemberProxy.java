package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.IMember;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 15:34 星期四
 */
@Service
@RequiredArgsConstructor
public class IMemberProxy implements DataProxy<IMember> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(IMember IMember) {
        IMember.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(IMember IMember) {
        IMember.setUpdatedAt(timeUtil.generateDate());
    }
}
