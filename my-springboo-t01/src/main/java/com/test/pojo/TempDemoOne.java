package com.test.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("t_temp_demo_one")
public class TempDemoOne {

    //Stirng --> 数据库中的 varchar
    //Long  ---> 数据中的字段为 bigInt
    @TableId(value = "temp_id", type = IdType.ASSIGN_UUID)
    public String tempId;

    @TableField(value = "temp_name" ,exist = true)
    public String name;

    @TableField(value = "temp_age" ,exist = true)
    public Double age;

    @TableField(value = "mark" ,exist = false)
    public String mark;

    //value为默认值  delval为删除数据时要填的值
    @TableLogic(value = "0",delval = "1")
    @TableField(value = "temp_tag" ,exist = true)  //此处的exist如果为false,逻辑删除将不生效，会直接delete而不是update
    public Integer logjicTag;


    @Version  //每次做update时候回校验前后的该字段值是否一致，不一致则放弃此次更新，update结果为0条但不会报错
    @TableField(value = "temp_version" ,exist = true)
    public Integer checkVersion;
}
