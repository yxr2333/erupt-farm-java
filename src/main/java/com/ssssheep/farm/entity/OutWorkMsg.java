package com.ssssheep.farm.entity;

import com.ssssheep.farm.proxy.OutWorkMsgProxy;
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
 * @date 2022/6/17 20:35 星期五
 */
@Erupt(name = "务工信息",dataProxy = OutWorkMsgProxy.class,power = @Power(export = true,importable = true))
@Table(name = "t_out_work_msg")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class OutWorkMsg extends BaseModel {

    @EruptField(
            views = @View(
                    title = "务工项目"
            ),
            edit = @Edit(
                    title = "务工项目",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType
            )
    )
    private String project;

    @EruptField(
            views = @View(
                    title = "务工地"
            ),
            edit = @Edit(
                    title = "务工地",
                    type = EditType.MAP, notNull = true
            )
    )
    private String workPlace;

    @EruptField(
            views = @View(
                    title = "务工月收入"
            ),
            edit = @Edit(
                    title = "务工月收入",
                    type = EditType.INPUT, notNull = true,
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
    private String monthIncome;

    @EruptField(
            views = @View(
                    title = "年度", sortable = true
            ),
            edit = @Edit(
                    title = "年度",
                    type = EditType.DATE, search = @Search, notNull = true,
                    dateType = @DateType(type = DateType.Type.YEAR)
            )
    )
    private String year;

    @EruptField(
            views = @View(
                    title = "村民信息",
                    column = "name"
            ),
            edit = @Edit(
                    title = "村民信息",
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