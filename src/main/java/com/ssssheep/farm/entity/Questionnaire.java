package com.ssssheep.farm.entity;

import com.ssssheep.farm.proxy.QuestionnaireProxy;
import lombok.*;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.BoolType;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.ShowBy;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/17 21:54 星期五
 */
@Erupt(name = "问卷信息",dataProxy = QuestionnaireProxy.class,power = @Power(export = true,importable = true))
@Table(name = "t_questionnaires")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Questionnaire extends BaseModel {

    @EruptField(
            views = @View(
                    title = "如何评价家庭（家族）关系"
            ),
            edit = @Edit(
                    title = "如何评价家庭（家族）关系",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType
            )
    )
    private String familyRelation;

    @EruptField(
            views = @View(
                    title = "如何评价邻里关系"
            ),
            edit = @Edit(
                    title = "如何评价邻里关系",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType
            )
    )
    private String neighborRelation;

    @EruptField(
            views = @View(
                    title = "如何评价村委干部"
            ),
            edit = @Edit(
                    title = "如何评价村委干部",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType
            )
    )
    private String councilRelation;

    @EruptField(
            views = @View(
                    title = "存在哪些困难"
            ),
            edit = @Edit(
                    title = "存在哪些困难",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType
            )
    )
    private String difficulty;

    @EruptField(
            views = @View(
                    title = "有何建议"
            ),
            edit = @Edit(
                    title = "有何建议",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType
            )
    )
    private String suggestion;

    @EruptField(
            views = @View(
                    title = "有什么愿望"
            ),
            edit = @Edit(
                    title = "有什么愿望",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType
            )
    )
    private String wish;

    @EruptField(
            views = @View(
                    title = "觉得生活幸福吗"
            ),
            edit = @Edit(
                    title = "觉得生活幸福吗",
                    type = EditType.BOOLEAN, search = @Search, notNull = true,
                    boolType = @BoolType(trueText = "幸福", falseText = "不幸福")
            )
    )
    private Boolean isHappy;

    @EruptField(
            views = @View(
                    title = "原因"
            ),
            edit = @Edit(
                    title = "原因",
                    showBy = @ShowBy(
                            dependField = "isHappy",
                            expr = "value"
                    ),
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String reason;

    @EruptField(
            views = @View(
                    title = "主要帮扶措施"
            ),
            edit = @Edit(
                    title = "主要帮扶措施",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType
            )
    )
    private String help;

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