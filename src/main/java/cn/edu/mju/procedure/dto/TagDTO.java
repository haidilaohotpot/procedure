package cn.edu.mju.procedure.dto;


import cn.edu.mju.procedure.entity.Tag;
import cn.edu.mju.procedure.enums.TagStateEnum;
import lombok.Data;

import java.util.List;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/9/22
 */
@Data
public class TagDTO {

    // 结果状态
    private int state;

    // 状态信息
    private String stateInfo;

    //数量
    private int count;

    // 操作的tag
    private Tag tag;

    // 获取的tag列表
    private List<Tag> tagList;

    public TagDTO() {
    }

    public TagDTO(TagStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public TagDTO(TagStateEnum stateEnum, Tag tag) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.tag = tag;
    }

    public TagDTO(TagStateEnum stateEnum, List<Tag> tagList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.tagList = tagList;
    }
}
