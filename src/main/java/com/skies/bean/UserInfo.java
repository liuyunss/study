package com.skies.bean;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
/**
 * @Description TODO
 * @Author sunmeng
 * @Date 2021/01/20
 */
@Data
public class UserInfo {
    @NotBlank(message = "年龄不为空")
    @Max(value = 18, message = "不能超过18岁")
    private String age;
    @NotBlank(message = "性别不能为空")
    private String gender;
}
