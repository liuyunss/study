package com.skies.bean;

import lombok.Data;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class PersionVO {
    @Size(max = 90,min = 0)
    private int age;
    @NotBlank(message = "名称不能为空")
    private String name;
    @AssertFalse
    private boolean isMan;
    @Past
    private Date birth;
}
