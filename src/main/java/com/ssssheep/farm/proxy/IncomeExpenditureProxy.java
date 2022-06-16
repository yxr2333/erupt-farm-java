package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.IncomeExpenditure;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 14:28 星期四
 */
@Service
@RequiredArgsConstructor
public class IncomeExpenditureProxy implements DataProxy<IncomeExpenditure> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(IncomeExpenditure incomeExpenditure) {
        incomeExpenditure.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(IncomeExpenditure incomeExpenditure) {
        incomeExpenditure.setUpdatedAt(timeUtil.generateDate());
    }
}
