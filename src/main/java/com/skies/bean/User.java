package com.skies.bean;

import com.skies.demo.IdentityCardNumber;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Description TODO
 * @Author sunmeng
 * @Date 2021/01/20
 */
@Data
public class User {
    @NotBlank(message = "姓名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 16, message = "密码长度为6-16位")
    private String password;
    @Pattern(regexp = "0?(13|14|15|17|18|19)[0-9]{9}", message = "手机号格式不正确")
    private String phone;
    // 嵌套必须加 @Valid，否则嵌套中的验证不生效
    @Valid
    @NotNull(message = "userinfo不能为空")
    private UserInfo userInfo;
    @NotBlank(message = "身份证号不能为空")
    @IdentityCardNumber(message = "身份证信息有误,请核对后提交")
    private String clientCardNo;
}
