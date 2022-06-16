package com.ssssheep.farm.entity;

import javax.persistence.*;

import com.ssssheep.farm.proxy.PlantBreedProxy;
import lombok.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;
import java.util.Date;
/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 15:01 星期四
 */

@Erupt(name = "村户种植信息", dataProxy = PlantBreedProxy.class)
@Table(name = "t_plant_breeds")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class PlantBreed extends BaseModel {

    @EruptField(
            views = @View(
                    title = "种植数量", sortable = true
            ),
            edit = @Edit(
                    title = "种植数量",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Float plantCount;

    @EruptField(
            views = @View(
                    title = "种植描述"
            ),
            edit = @Edit(
                    title = "种植描述",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String plantDesc;

    @EruptField(
            views = @View(
                    title = "养殖数量", sortable = true
            ),
            edit = @Edit(
                    title = "养殖数量",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Float breadCount;

    @EruptField(
            views = @View(
                    title = "养殖描述"
            ),
            edit = @Edit(
                    title = "养殖描述",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String breadDesc;

    @EruptField(
            views = @View(
                    title = "所属户籍",
                    column = "name"
            ),
            edit = @Edit(
                    title = "所属户籍",
                    type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
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
