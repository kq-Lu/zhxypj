package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.Clazz;
import com.briup.zhxypj.bean.ex.ClazzEx;
import com.briup.zhxypj.service.IClazzService;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clazz")
@Api(description = "课程表管理")
public class ClazzController {
    @Autowired
    private IClazzService clazzService;
    @PostMapping("/selectAll")
    @ApiOperation("课程查找")
    public Message findAll(){
        List<ClazzEx> list=clazzService.findAllEXClazz();
        return MessageUtil.success(list);
    }
    @GetMapping("/delete")
    @ApiOperation("课程删除")
    public Message delete(int id){

        clazzService.deleteById(id);
        return MessageUtil.success();
    }
    @GetMapping("/add")
    @ApiOperation("课程添加")
    public  Message addClazz(Clazz clazz){
        clazzService.saveOrupdate(clazz);
        return  MessageUtil.success();
    }
    @GetMapping("/update")
    @ApiOperation("课程更新")
    public  Message updateClazz(Clazz clazz){
        clazzService.saveOrupdate(clazz);
        return  MessageUtil.success(clazz);
    }
    @PostMapping("/search")
    @ApiOperation("课程条件查找")
    public Message search(String key,String word){
        List<ClazzEx> list=clazzService.search(key,word);
        return MessageUtil.success(list);
    }
    @GetMapping("/delBatch")
    @ApiOperation("课程批量删除")
  public Message delBatch(int[] ids){
        for(int id:ids){
         clazzService.deleteById(id);
       }

        return MessageUtil.success();
    }
}
