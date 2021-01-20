package com.skies.controller;
import com.skies.bean.User;
import com.skies.bean.UserInfo;
import com.skies.demo.MyValidationUtils;
import com.skies.demo.ParamaErrorException;
import com.skies.demo.ResponseResult;
import com.skies.demo.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@Api(value = "测试使用validation验证参数")
public class TestController {

    /**
     * 测试get方法,手动if进行判空,校验失败时手动抛出自定义异常
     *
     * @param username 姓名
     * @return ResponseResult
     */
    @ApiOperation(value = "测试get方法", notes = "输入用户名")
    @GetMapping("/testGet")
    public ResponseResult testGet(String username) {
        if (username == null || "".equals(username)) {
            throw new ParamaErrorException("username 不能为空");
        }
        return new ResponseResult(ResultEnum.SUCCESS);
    }

    /**
     * 使用注解校验get请求平面参数,需要在Controller类头部添加@Validated注解,否则不能成功校验，这种方法不用手动抛出异常
     *
     * @param username
     * @return
     */
    @ApiOperation(value = "测试get方法", notes = "输入用户名")
    @GetMapping("/testGetByValidated")
    public ResponseResult testGetByValidated(@Length(max = 4) @RequestParam("username") String username) {
        return new ResponseResult(ResultEnum.SUCCESS);
    }


    /**
     * post方法传入单个对象进行校验,在参数前添加@Valid注解,校验失败时会抛出异常并使用全局异常进行处理
     *
     * @param userInfo 用户信息
     * @return ResponseResult
     */
    @ApiOperation(value = "post方法传入单个对象", notes = "传入json对象")
    @PostMapping("/testUserInfo")
    public ResponseResult testUserInfo(@Valid @RequestBody UserInfo userInfo) {
        return new ResponseResult(ResultEnum.SUCCESS);
    }

    /**
     * post方法传入对象,手动校验,此时参数前没有添加@Valid注解,所以不会自动进行校验,手动调用validate方法进行校验,失败时会抛出异常
     *
     * @param userInfo
     * @return ResponseResult
     */
    @ApiOperation(value = "post方法传入对象,手动测试", notes = "单个对象")
    @PostMapping("/checkByMethod")
    public ResponseResult checkByMethod(@RequestBody UserInfo userInfo) {
        //调用api校验
        MyValidationUtils.validate(userInfo);
        return new ResponseResult(ResultEnum.SUCCESS);
    }

    /**
     * post方法传入多个对象,当使用@Valid校验对象集合时,要在控制层添加@Validated注解,否则不会对集合中的每个对象进行校验
     *
     * @param userInfo
     * @return ResponseResult
     */
    @ApiOperation(value = "post方法传入多个对象", notes = "多个对象")
    @PostMapping("/testUserList")
    public ResponseResult testUserList(@Valid @RequestBody List<UserInfo> userInfo) {
        return new ResponseResult(ResultEnum.SUCCESS);
    }

    /**
     * 测试对象中嵌套对象的情况,此时也要在对象属性上添加@Valid注解
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "测试对象中嵌套对象的情况")
    @PostMapping("/checkUser")
    public ResponseResult checkUser(@Valid @RequestBody User user) {
        return new ResponseResult(ResultEnum.SUCCESS);
    }

    /**
     * 将校验结果放进BindingResult里面,用户自行判断并处理
     *
     * @param userInfo
     * @param bindingResult
     * @return
     */
    @PostMapping("/testBindingResult")
    public String testBindingResult(@RequestBody @Valid UserInfo userInfo, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            String messages = bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .reduce((m1, m2) -> m1 + "；" + m2)
                    .orElse("参数输入有误！");
            //这里可以抛出自定义异常,或者进行其他操作
            throw new IllegalArgumentException(messages);
        }
        return "操作成功！";
    }

}
