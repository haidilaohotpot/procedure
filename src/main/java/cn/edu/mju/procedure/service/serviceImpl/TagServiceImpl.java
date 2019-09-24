package cn.edu.mju.procedure.service.serviceImpl;

import cn.edu.mju.procedure.dto.TagDTO;
import cn.edu.mju.procedure.entity.Tag;
import cn.edu.mju.procedure.enums.TagStateEnum;
import cn.edu.mju.procedure.exception.TagOperationException;
import cn.edu.mju.procedure.mapper.TagMapper;
import cn.edu.mju.procedure.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/9/22
 */
@Service
@Slf4j
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper mapper;

    @Override
    public TagDTO list() {
        List<Tag> tagList = mapper.selectAll();

        if(null == tagList){
           return new TagDTO(TagStateEnum.EMPTY);
        }

        List<Tag> tags = build(tagList);


        return new TagDTO(TagStateEnum.SUCCESS,tags);
    }

    @Override
    @Transactional
    public TagDTO add(Tag tag) throws TagOperationException {

        if(isEmpty(tag)){
            log.error("增加标签失败:{}",TagStateEnum.EMPTY.getStateInfo());
            throw new TagOperationException(TagStateEnum.EMPTY);
        }

        try{
            int effectNum = mapper.insert(tag);

            if(effectNum <= 0){
                log.error("增加标签失败:{}",TagStateEnum.FAIL.getStateInfo());
                throw new TagOperationException(TagStateEnum.FAIL);
            }

            return new TagDTO(TagStateEnum.SUCCESS);

        }catch (Exception e){
            log.error("增加标签失败:{}",e.getMessage());
            throw new TagOperationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public TagDTO removeById(Tag tag) throws TagOperationException {

        if(isEmpty(tag)){
            log.error("删除标签失败:{}",TagStateEnum.EMPTY.getStateInfo());
            throw new TagOperationException(TagStateEnum.EMPTY);
        }

        try{
            //删除
            int effectNum = mapper.update(tag);

            if(effectNum <= 0){
                log.error("删除标签失败:{}",TagStateEnum.FAIL.getStateInfo());
                throw new TagOperationException(TagStateEnum.FAIL);
            }

            return new TagDTO(TagStateEnum.SUCCESS);

        }catch (Exception e){
            log.error("删除标签失败:{}",e.getMessage());
            throw new TagOperationException(e.getMessage());
        }

    }

    @Override
    @Transactional
    public TagDTO update(Tag tag) throws TagOperationException {

        if(isEmpty(tag)){
            log.error("更新标签失败:{}",TagStateEnum.EMPTY.getStateInfo());
            throw new TagOperationException(TagStateEnum.EMPTY);
        }

        try{
            //更新
            int effectNum = mapper.update(tag);

            if(effectNum <= 0){
                log.error("更新标签失败:{}",TagStateEnum.FAIL.getStateInfo());
                throw new TagOperationException(TagStateEnum.FAIL);
            }

            return new TagDTO(TagStateEnum.SUCCESS);

        }catch (Exception e){
            log.error("更新标签失败:{}",e.getMessage());
            throw new TagOperationException(e.getMessage());
        }
    }

    @Override
    public TagDTO getByTagName(Tag tag) {

        Tag item = mapper.select(tag);

        if(null == item){
            return new TagDTO(TagStateEnum.EMPTY);
        }

        return new TagDTO(TagStateEnum.SUCCESS,item);
    }

    @Override
    public TagDTO getByTagId(Tag tag) {
        Tag item = mapper.select(tag);

        if(null == item){
            return new TagDTO(TagStateEnum.EMPTY);
        }

        return new TagDTO(TagStateEnum.SUCCESS,item);
    }


    private boolean isEmpty(Tag tag){
        return null==tag;
    }

    /**
     * 构建父子关系
     * @param tagList
     * @return
     */
    private List<Tag> build(List<Tag> tagList){

        Map<Integer, Tag> tagMap = new HashMap<Integer, Tag>();

        List<Tag> tags = new ArrayList<>();

        for (Tag tag : tagList) {
            tagMap.put(tag.getTagId(), tag);
        }

        for (Tag tag : tagList) {
            Tag child = tag;
            if (child.getTagParent() == 0) {
                tags.add(tag);
            } else {
                Tag parent = tagMap.get(child.getTagParent());
                parent.getChildren().add(child);
            }

        }
        return tags;
    }

}
