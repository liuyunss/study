package com.skies.controller;

import com.skies.bean.PersionVO;
import io.swagger.annotations.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
@Slf4j
@Api(value = "DemoController",tags = {"测试demo"})
@Validated
public class DemoController {

    @RequestMapping(value = "/demo1",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation( value = "获取轨迹数据", notes = "获取轨迹数据",httpMethod = "GET")
    public String demo1(@Validated @Max(value = 20,message = "最大值为20") int num, @NotBlank(message = "参数不能为空") String str){
        return "success";
    }


    @RequestMapping(value = "/demo2",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation( value = "获取轨迹数据", notes = "获取轨迹数据",httpMethod = "POST")
    public String demo2(@Validated PersionVO persionVO){
        return "success";
    }
}
