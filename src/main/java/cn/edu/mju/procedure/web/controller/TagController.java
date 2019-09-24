package cn.edu.mju.procedure.web.controller;

import cn.edu.mju.procedure.dto.TagDTO;
import cn.edu.mju.procedure.entity.Tag;
import cn.edu.mju.procedure.enums.TagStateEnum;
import cn.edu.mju.procedure.exception.TagOperationException;
import cn.edu.mju.procedure.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.TagElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/9/17
 */
@RestController
@Slf4j
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 查询所有的标签
     * @return
     */
    @GetMapping("/list")
    public Map<String,Object> list(){

        Map<String,Object> resultMap  =new HashMap<>();

        TagDTO tagDTO = tagService.list();

        if(tagDTO.getState() == TagStateEnum.SUCCESS.getState()){

            resultMap.put("success",true);
            resultMap.put("tagList",tagDTO.getTagList());
        }else{

            resultMap.put("success",false);
        }

        resultMap.put("message",tagDTO.getStateInfo());

        return resultMap;
    }


    /**
     * 增加
     * @param tag
     * @return
     */
    @PostMapping("/add")
    public Map<String,Object> add(Tag tag){

        Map<String,Object> resultMap = new HashMap<>();

        try{

            TagDTO tagDTO = tagService.add(tag);
            if(tagDTO.getState() == TagStateEnum.SUCCESS.getState()){

                resultMap.put("success",true);

            }else{
                resultMap.put("success",false);
            }

            resultMap.put("message",tagDTO.getStateInfo());

        }catch (TagOperationException e){
            resultMap.put("success",false);
            resultMap.put("message",e.getMessage());
        }

        return resultMap;

    }


    /**
     * 删除
     * @param tag
     * @return
     */
    @PostMapping("/del/id")
    public Map<String,Object> del(Tag tag){

        Map<String,Object> resultMap = new HashMap<>();

        try{

            TagDTO tagDTO = tagService.removeById(tag);
            if(tagDTO.getState() == TagStateEnum.SUCCESS.getState()){

                resultMap.put("success",true);

            }else{
                resultMap.put("success",false);
            }

            resultMap.put("message",tagDTO.getStateInfo());

        }catch (TagOperationException e){
            resultMap.put("success",false);
            resultMap.put("message",e.getMessage());
        }

        return resultMap;



    }


    /**
     * 修改信息
     * @param tag
     * @return
     */
    @PostMapping("/up")
    public Map<String,Object> update(Tag tag){

        Map<String,Object> resultMap = new HashMap<>();

        try{

            TagDTO tagDTO = tagService.update(tag);
            if(tagDTO.getState() == TagStateEnum.SUCCESS.getState()){

                resultMap.put("success",true);

            }else{
                resultMap.put("success",false);
            }

            resultMap.put("message",tagDTO.getStateInfo());

        }catch (TagOperationException e){
            resultMap.put("success",false);
            resultMap.put("message",e.getMessage());
        }

        return resultMap;


    }

    @GetMapping("/list/id/{id}")
    public Map<String,Object> getByTagId(@PathVariable("id")Integer id){


        Map<String,Object> resultMap  =new HashMap<>();

        Tag tag = new Tag();
        tag.setTagId(id);
        TagDTO tagDTO = tagService.getByTagId(tag);

        if(tagDTO.getState() == TagStateEnum.SUCCESS.getState()){

            resultMap.put("success",true);
            resultMap.put("tag",tagDTO.getTag());
        }else{

            resultMap.put("success",false);
        }

        resultMap.put("message",tagDTO.getStateInfo());

        return resultMap;

    }


    @GetMapping("/list/name/{name}")
    public Map<String,Object> getByTagName(@PathVariable("name") String name){


        Map<String,Object> resultMap  =new HashMap<>();

        Tag tag = new Tag();
        tag.setTagName(name);
        TagDTO tagDTO = tagService.getByTagName(tag);

        if(tagDTO.getState() == TagStateEnum.SUCCESS.getState()){

            resultMap.put("success",true);
            resultMap.put("tag",tagDTO.getTag());
        }else{

            resultMap.put("success",false);
        }

        resultMap.put("message",tagDTO.getStateInfo());

        return resultMap;

    }


}
