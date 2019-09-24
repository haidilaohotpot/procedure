package cn.edu.mju.procedure.service.serviceImpl;

import cn.edu.mju.procedure.dto.TagDTO;
import cn.edu.mju.procedure.entity.Tag;
import cn.edu.mju.procedure.enums.TagStateEnum;
import cn.edu.mju.procedure.service.TagService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagServiceImplTest {

    @Autowired
    private TagService tagService;

    @Test
    public void list() {

        TagDTO list = tagService.list();

        Assert.assertNotEquals(null,list.getTagList());

    }

    @Test
    public void add() {

        Tag tag = new Tag();
        tag.setState(1);
        tag.setTagName("大数据");
        tag.setTagParent(0);

        TagDTO tagDTO = tagService.add(tag);
        Assert.assertEquals(tagDTO.getState(),TagStateEnum.SUCCESS.getState());

    }

    @Test
    public void remove() {
        Tag tag = new Tag();
        tag.setTagId(7);
        tag.setState(0);
        TagDTO dto = tagService.removeById(tag);
        Assert.assertEquals(TagStateEnum.SUCCESS.getState(),dto.getState());
    }


    @Test
    public void update() {
        Tag tag = new Tag();
        tag.setState(1);
        tag.setTagName("大数据");
        tag.setTagParent(0);
        tag.setTagId(7);
        TagDTO tagDTO = tagService.update(tag);
        Assert.assertEquals(TagStateEnum.SUCCESS.getState(),tagDTO.getState());

    }

    @Test
    public void getByTagName() {

        Tag tag = new Tag();
        tag.setState(1);
        tag.setTagName("大数据");

        TagDTO tagDTO = tagService.getByTagName(tag);
        Assert.assertEquals(TagStateEnum.SUCCESS.getState(),tagDTO.getState());

    }

    @Test
    public void getByTagId() {
        Tag tag = new Tag();
        tag.setState(1);
        tag.setTagId(7);

        TagDTO tagDTO = tagService.getByTagId(tag);
        Assert.assertEquals(TagStateEnum.SUCCESS.getState(),tagDTO.getState());
    }
}