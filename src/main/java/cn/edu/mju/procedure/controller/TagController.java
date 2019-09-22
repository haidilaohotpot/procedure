package cn.edu.mju.procedure.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/9/17
 */
@RestController
@Slf4j
public class TagController {


    @GetMapping("/nav/del/{navName}")
    public List<Object> list(@PathVariable("navName")String navName){
        log.info(navName);
        return null;
    }

}
