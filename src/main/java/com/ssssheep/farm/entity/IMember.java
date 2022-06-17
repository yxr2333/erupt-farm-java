package com.ssssheep.farm.entity;

import com.ssssheep.farm.proxy.IMemberProxy;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import xyz.erupt.annotation.Erupt;

import javax.persistence.*;

import lombok.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import java.util.Date;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 15:18 星期四
 */

@Erupt(
        name = "农户人员信息",
        dataProxy = IMemberProxy.class,
        power = @Power(
                export = true,
                importable = true)
)
@Table(name = "t_members")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class IMember extends BaseModel {

    @EruptField(
            views = @View(
                    export = true,
                    title = "成员名称"
            ),
            edit = @Edit(
                    title = "成员名称",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String name;

    @EruptField(
            views = @View(
                    title = "与户主关系"
            ),
            edit = @Edit(
                    title = "与户主关系",
                    type = EditType.CHOICE, search = @Search, notNull = true,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "本人", label = "本人"),
                            @VL(value = "配偶", label = "配偶"),
                            @VL(value = "之长子", label = "之长子"),
                            @VL(value = "之长媳", label = "之长媳"),
                            @VL(value = "之长孙", label = "之长孙"),
                            @VL(value = "之长女", label = "之长女"),
                            @VL(value = "之长婿", label = "之长婿"),
                            @VL(value = "之外孙", label = "之外孙"),
                    })
            )
    )
    private String relation;

    @EruptField(
            views = @View(
                    title = "性别"
            ),
            edit = @Edit(
                    title = "性别",
                    type = EditType.CHOICE, search = @Search, notNull = true,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "男", label = "男"),
                            @VL(value = "女", label = "女")
                    })
            )
    )
    private String sex;

    @EruptField(
            views = @View(
                    title = "身份证号"
            ),
            edit = @Edit(
                    title = "身份证号",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType(regex = "^[1-9]\\d{5}(?:18|19|20)\\d{2}(?:0[1-9]|10|11|12)(?:0[1-9]|[1-2]\\d|30|31)\\d{3}[\\dXx]$")
            )
    )
    private String idCard;

    @EruptField(
            views = @View(
                    title = "民族"
            ),
            edit = @Edit(
                    title = "民族",
                    type = EditType.CHOICE, search = @Search, notNull = true,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "汉族", label = "汉族"),
                            @VL(value = "蒙古族", label = "蒙古族"),
                            @VL(value = "回族", label = "回族"),
                            @VL(value = "藏族", label = "藏族"),
                            @VL(value = "维吾尔族", label = "维吾尔族"),
                            @VL(value = "苗族", label = "苗族"),
                            @VL(value = "彝族", label = "彝族"),
                            @VL(value = "土家族", label = "土家族"),
                            @VL(value = "壮族", label = "壮族"),
                            @VL(value = "白族", label = "白族")
                    })
            )
    )
    private String nation;

    @EruptField(
            views = @View(
                    title = "出生日期"
            ),
            edit = @Edit(
                    title = "出生日期",
                    type = EditType.DATE, search = @Search, notNull = true,
                    dateType = @DateType
            )
    )
    private Date birth;

    @EruptField(
            views = @View(
                    title = "电话号码"
            ),
            edit = @Edit(
                    title = "电话号码",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType(
                            regex = "^(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-79])|(?:5[0-35-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[189]))\\d{8}$"
                    )
            )
    )
    private String phone;

    @EruptField(
            views = @View(
                    title = "政治面貌"
            ),
            edit = @Edit(
                    title = "政治面貌",
                    type = EditType.CHOICE, search = @Search, notNull = true,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "中共党员", label = "中共党员"),
                            @VL(value = "中共预备党员", label = "中共预备党员"),
                            @VL(value = "共青团员", label = "共青团员"),
                            @VL(value = "群众", label = "群众"),
                    })
            )
    )
    private String political;

    @EruptField(
            views = @View(
                    title = "婚姻状况"
            ),
            edit = @Edit(
                    title = "婚姻状况",
                    type = EditType.CHOICE, search = @Search,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "未婚", label = "未婚"),
                            @VL(value = "已婚", label = "已婚"),
                            @VL(value = "丧偶", label = "丧偶"),
                            @VL(value = "离婚", label = "离婚")
                    })
            )
    )
    private String marriage;

    @EruptField(
            views = @View(
                    title = "身体状况"
            ),
            edit = @Edit(
                    title = "身体状况",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String physicalCondition;

    @EruptField(
            views = @View(
                    title = "是否残疾"
            ),
            edit = @Edit(
                    title = "是否残疾",
                    boolType = @BoolType(),
                    search = @Search, notNull = true
            )
    )
    private Boolean disability;

    @EruptField(
            views = @View(
                    title = "残疾分级"
            ),
            edit = @Edit(
                    showBy = @ShowBy(
                            dependField = "disability",
                            expr = "value === true"
                    ),
                    title = "残疾分级",
                    type = EditType.CHOICE, search = @Search,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "一级", label = "一级"),
                            @VL(value = "二级", label = "二级"),
                            @VL(value = "三级", label = "三级"),
                            @VL(value = "四级", label = "四级")
                    })
            )
    )
    private String disabilityLevel;

    @EruptField(
            views = @View(
                    title = "是否办理残疾证"
            ),
            edit = @Edit(
                    showBy = @ShowBy(
                            dependField = "disability",
                            expr = "value === true"
                    ),
                    title = "是否办理残疾证",
                    boolType = @BoolType(trueText = "是", falseText = "否"),
                    search = @Search
            )
    )
    private Boolean disabilityCeritificate;

    @EruptField(
            views = @View(
                    title = "所属户籍",
                    column = "name"
            ),
            edit = @Edit(
                    title = "所属户籍",
                    type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                    referenceTableType = @ReferenceTableType
            )
    )
    @ManyToOne
    private HouseHold houseHold;

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

    @EruptField(
            views = @View(
                    title = "是否是学生"
            ),
            edit = @Edit(
                    title = "是否是学生",
                    boolType = @BoolType(trueText = "是", falseText = "否"), search = @Search, notNull = true
            )
    )
    private Boolean isStudent;

    @EruptField(
            views = @View(
                    title = "是否是适龄儿童"
            ),
            edit = @Edit(
                    title = "是否是适龄儿童",
                    boolType = @BoolType(trueText = "是", falseText = "否"), search = @Search, notNull = true
            )
    )
    private Boolean isChild;

    @EruptField(
            views = @View(
                    title = "是否完成义务教育"
            ),
            edit = @Edit(
                    title = "是否完成义务教育",
                    boolType = @BoolType(trueText = "是", falseText = "否"), search = @Search, notNull = true
            )
    )
    private Boolean isDutyEdu;

    @EruptField(
            views = @View(
                    title = "是否辍学"
            ),
            edit = @Edit(
                    title = "是否辍学",
                    boolType = @BoolType(trueText = "是", falseText = "否"), search = @Search, notNull = true
            )
    )
    private Boolean isDropOut;
}
