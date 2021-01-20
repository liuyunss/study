package com.skies.controller;

import com.skies.bean.PersionVO;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;


@RestController
@RequestMapping("/demo")
@Slf4j
@Api(value = "DemoController",tags = {"测试demo"})
@Valid
public class DemoController {

    @RequestMapping(value = "/demo1",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation( value = "测试1",httpMethod = "POST")
    @ExceptionHandler
    public String demo1( @Max(value = 20,message = "最大值为20") int num, @NotBlank(message = "参数不能为空") String str){
        return "success";
    }


    @RequestMapping(value = "/demo2",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation( value = "测试2",httpMethod = "POST")
    public String demo2( @Valid PersionVO persionVO){
        return "success";
    }

    @GetMapping(value = "/demo3")
    @ApiOperation( value = "测试3", notes = "获取轨迹数据")
    public String demo3( PersionVO persionVO){
        return "success";
    }
}
