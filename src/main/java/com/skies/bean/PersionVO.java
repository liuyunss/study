package com.skies.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class PersionVO {
    @Size(max = 90,min = 0)
    private int age;
    @NotBlank(message = "名称不能为空")
    private String name;
    private boolean isMan;
    @Past
    private Date birth;
}
