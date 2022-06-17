package com.ssssheep.farm.entity;

import javax.persistence.*;

import com.ssssheep.farm.proxy.OldMedicalProxy;
import lombok.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.erupt.jpa.model.BaseModel;
import java.util.Set;
import java.util.Date;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/17 21:40 星期五
 */

@Erupt(name = "老年保险信息表",dataProxy = OldMedicalProxy.class,power = @Power(export = true,importable = true))
@Table(name = "t_old_medicals")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class OldMedical extends BaseModel {

    @EruptField(
            views = @View(
                    title = "村民",
                    column = "name"
            ),
            edit = @Edit(
                    title = "村民",
                    type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private IMember member;

    @EruptField(
            views = @View(
                    title = "上月共领取养老金（元）"
            ),
            edit = @Edit(
                    title = "上月共领取养老金（元）",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Integer lastMonthOldMoney;

    @EruptField(
            views = @View(
                    title = "上月共领取高龄补贴（元）"
            ),
            edit = @Edit(
                    title = "上月共领取高龄补贴（元）",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Integer lastMonthOldSubsidy;

    @EruptField(
            views = @View(
                    title = "是否缴纳基本养老保险"
            ),
            edit = @Edit(
                    title = "是否缴纳基本养老保险",
                    type = EditType.BOOLEAN, search = @Search, notNull = true,
                    boolType = @BoolType(trueText = "是", falseText = "否")
            )
    )
    private Boolean isBasicMedicalInsurance;

    @EruptField(
            views = @View(
                    title = "是否缴纳养老保险"
            ),
            edit = @Edit(
                    title = "是否缴纳养老保险",
                    type = EditType.BOOLEAN, search = @Search, notNull = true,
                    boolType = @BoolType(trueText = "是", falseText = "否")
            )
    )
    private Boolean isOldMedicalInsurance;

    @EruptField(
            views = @View(
                    title = "登记时间", sortable = true
            ),
            edit = @Edit(
                    title = "登记时间",
                    type = EditType.DATE, search = @Search, notNull = true,
                    dateType = @DateType(type = DateType.Type.DATE_TIME)
            )
    )
    private Date date;

    @EruptField(
            views = @View(
                    title = "创建时间"
            )
    )
    private Date createdAt;

    @EruptField(
            views = @View(
                    title = "更新时间"
            )
    )
    private Date updatedAt;

}