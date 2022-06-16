package com.ssssheep.farm.entity;

import javax.persistence.*;

import com.ssssheep.farm.proxy.IMemberProxy;
import com.ssssheep.farm.proxy.SubsidyProxy;
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
 * @date 2022/6/16 15:53 星期四
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Erupt(name = "补助信息",dataProxy = SubsidyProxy.class)
@Table(name = "t_subsidies")
@Entity
public class Subsidy extends BaseModel {

    @EruptField(
            views = @View(
                    title = "补助金额", sortable = true
            ),
            edit = @Edit(
                    title = "补助金额",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Float subsidy;

    @EruptField(
            views = @View(
                    title = "补助原因"
            ),
            edit = @Edit(
                    title = "补助原因",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String subsidyReason;

    @EruptField(
            views = @View(
                    title = "补助时间", sortable = true
            ),
            edit = @Edit(
                    title = "补助时间",
                    type = EditType.DATE, search = @Search, notNull = true,
                    dateType = @DateType(type = DateType.Type.DATE_TIME)
            )
    )
    private Date subsidyTime;

    @EruptField(
            views = @View(
                    title = "领取人员",
                    column = "name"
            ),
            edit = @Edit(
                    title = "领取人员",
                    type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private IMember member;

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