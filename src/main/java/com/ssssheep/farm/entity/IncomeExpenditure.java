package com.ssssheep.farm.entity;

import lombok.*;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.DateType;
import xyz.erupt.annotation.sub_field.sub_edit.NumberType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
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
@Erupt(name = "收支信息")
@Table(name = "t_income_expenditures")
@Entity
public class IncomeExpenditure extends BaseModel {

    @EruptField(
            views = @View(
                    title = "去年家庭总收入", sortable = true
            ),
            edit = @Edit(
                    title = "去年家庭总收入",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Integer lastYearIncome;

    @EruptField(
            views = @View(
                    title = "去年人均纯收入", sortable = true
            ),
            edit = @Edit(
                    title = "去年人均纯收入",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Integer lastYearAvgIncome;

    @EruptField(
            views = @View(
                    title = "去年生产支出", sortable = true
            ),
            edit = @Edit(
                    title = "去年生产支出",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Integer lastYearExpenditure;

    @EruptField(
            views = @View(
                    title = "去年住院医疗支出", sortable = true
            ),
            edit = @Edit(
                    title = "去年住院医疗支出",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Integer lastYearHospitalExpenditure;

    @EruptField(
            views = @View(
                    title = "所属户籍",
                    column = "name"
            ),
            edit = @Edit(
                    title = "所属户籍",
                    type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
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