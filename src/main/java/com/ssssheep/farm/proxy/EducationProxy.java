package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.Education;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 16:05 星期四
 */
@Service
@RequiredArgsConstructor
public class EducationProxy implements DataProxy<Education> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(Education education) {
        education.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(Education education) {
        education.setUpdatedAt(timeUtil.generateDate());
    }
}
