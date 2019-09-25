package cn.edu.mju.procedure.controller;

import cn.edu.mju.procedure.pojo.Nav;
import cn.edu.mju.procedure.pojo.ResultMap;
import cn.edu.mju.procedure.service.NavService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yfl
 * 2019-9-22
 */
@RestController
@RequestMapping("/nav")
public class NavController {
    
    @Autowired
    private NavService navService;
    
    @GetMapping("/findAll")
    public ResultMap findAll() {
        try {
            return ResultMap.SUCCESS().setData(navService.findAll());
        } catch (Exception e) {
            return ResultMap.FAIL(e.getMessage());
        }
    }
    
    @RequestMapping("/delete")
    public ResultMap delete(@Param("id") Integer id){
        try {
            navService.delete(id);
        } catch (Exception e){
            return ResultMap.FAIL(e.getMessage());
        }
        return ResultMap.SUCCESS();
    }
    
    @PostMapping("/update")
    public ResultMap update(@RequestBody Nav nav){
        try {
            navService.update(nav);
        }catch (Exception e){
            return ResultMap.FAIL(e.getMessage());
        }
        return ResultMap.SUCCESS();
    }
    
    @PostMapping("/insert")
    public ResultMap insert(@RequestBody Nav nav){
        try {
            navService.insert(nav);
        }catch (Exception e){
            return ResultMap.FAIL(e.getMessage());
        }
        return ResultMap.SUCCESS();
    }
    
    @RequestMapping("/findById")
    public ResultMap findById(@Param("id") Integer id){
        try {
            return ResultMap.SUCCESS().setData(navService.findById(id));
        } catch (Exception e){
            return ResultMap.FAIL(e.getMessage());
        }
    }
    
}
