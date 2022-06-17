package com.ssssheep.farm.entity;

import javax.persistence.*;

import com.ssssheep.farm.proxy.HealthProxy;
import lombok.*;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;
import java.util.Date;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;

import javax.persistence.ManyToOne;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/17 21:21 星期五
 */

@Erupt(name = "健康信息",dataProxy = HealthProxy.class,power = @Power(export = true,importable = true))
@Table(name = "t_healths")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Health extends BaseModel {

    @EruptField(
            views = @View(
                    title = "成员",
                    column = "name"
            ),
            edit = @Edit(
                    title = "成员",
                    type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private IMember member;

    @EruptField(
            views = @View(
                    title = "是否有疾病"
            ),
            edit = @Edit(
                    title = "是否有疾病",
                    boolType = @BoolType(trueText = "是", falseText = "否"),
                    search = @Search, notNull = true
            )
    )
    private Boolean isDisease;

    @EruptField(
            views = @View(
                    title = "疾病描述"
            ),
            edit = @Edit(
                    showBy = @ShowBy(
                            dependField = "isDisease",
                            expr = "value === true"
                    ),
                    title = "疾病描述",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String diseaseDesc;

    @EruptField(
            views = @View(
                    title = "是否有慢性病"
            ),
            edit = @Edit(
                    showBy = @ShowBy(
                            dependField = "isDisease",
                            expr = "value === true"
                    ),
                    title = "是否有慢性病",
                    boolType = @BoolType(trueText = "是", falseText = "否"),
                    search = @Search
            )
    )
    private Boolean isChronic;

    @EruptField(
            views = @View(
                    title = "是否申请慢门"
            ),
            edit = @Edit(
                    title = "是否申请慢门",
                    showBy = @ShowBy(
                            dependField = "isChronic",
                            expr = "value === true"
                    ),
                    boolType = @BoolType(trueText = "是", falseText = "否"),
                    search = @Search
            )
    )
    private Boolean isApplyTreat;

    @EruptField(
            views = @View(
                    title = "是否已享受慢门政策"
            ),
            edit = @Edit(
                    title = "是否已享受慢门政策",
                    showBy = @ShowBy(
                            dependField = "isApplyTreat",
                            expr = "value === true"
                    ),
                    boolType = @BoolType(trueText = "是", falseText = "否"),
                    search = @Search
            )
    )
    private Boolean isTreat;

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