package com.test.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userChild")
public class UserChild {

    private Integer userChildId;

    private String userChildName;

    private Double userChildSalary;

    private Integer userId;

}
