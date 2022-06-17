package com.ssssheep.farm.entity;

import com.ssssheep.farm.proxy.IncomeExpenditureProxy;
import lombok.*;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 14:27 星期四
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Erupt(name = "收支信息", dataProxy = IncomeExpenditureProxy.class, power = @Power(export = true, importable = true))
@Table(name = "t_income_expenditures")
@Entity
public class IncomeExpenditure extends BaseModel {

    @EruptField(
            views = @View(
                    title = "年份", sortable = true
            ),
            edit = @Edit(
                    title = "年份",
                    type = EditType.DATE, search = @Search, notNull = true,
                    dateType = @DateType(type = DateType.Type.YEAR)
            )
    )
    private String fYear;

    @EruptField(
            views = @View(
                    title = "去年家庭总收入"
            ),
            edit = @Edit(
                    title = "去年家庭总收入",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType(
                            type = "number",
                            suffix = {
                                    @VL(value = "元", label = "元"),
                                    @VL(value = "千", label = "千"),
                                    @VL(value = "万", label = "万"),
                                    @VL(value = "十万", label = "十万")
                            }
                    )
            )
    )
    private String lastYearIncome;

    @EruptField(
            views = @View(
                    title = "去年人均纯收入"
            ),
            edit = @Edit(
                    title = "去年人均纯收入",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType(
                            type = "number",
                            suffix = {
                                    @VL(value = "元", label = "元"),
                                    @VL(value = "千", label = "千"),
                                    @VL(value = "万", label = "万"),
                                    @VL(value = "十万", label = "十万")
                            }
                    )
            )
    )
    private String lastYearAvgIncome;

    @EruptField(
            views = @View(
                    title = "去年生产支出"
            ),
            edit = @Edit(
                    title = "去年生产支出",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType(
                            type = "number",
                            suffix = {
                                    @VL(value = "元", label = "元"),
                                    @VL(value = "千", label = "千"),
                                    @VL(value = "万", label = "万"),
                                    @VL(value = "十万", label = "十万")
                            }
                    )
            )
    )
    private String lastYearExpenditure;

    @EruptField(
            views = @View(
                    title = "去年住院医疗支出"
            ),
            edit = @Edit(
                    title = "去年住院医疗支出",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType(
                            type = "number",
                            suffix = {
                                    @VL(value = "元", label = "元"),
                                    @VL(value = "千", label = "千"),
                                    @VL(value = "万", label = "万"),
                                    @VL(value = "十万", label = "十万")
                            }
                    )
            )
    )
    private String lastYearHospitalExpenditure;

    @EruptField(
            views = @View(
                    title = "所属户籍",
                    column = "name"
            ),
            edit = @Edit(
                    title = "所属户籍",
                    type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private HouseHold houseHold;

    @EruptField(
            views = @View(
                    title = "创建时间", sortable = true
            )
    )
    private Date createdAt;

    @EruptField(
            views = @View(
                    title = "更新时间", sortable = true
            )
    )
    private Date updatedAt;

}