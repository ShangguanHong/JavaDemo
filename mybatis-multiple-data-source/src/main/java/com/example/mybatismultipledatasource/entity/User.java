package com.example.mybatismultipledatasource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sgh
 * @date 2019/8/30 10:36
 */
@TableName(value = "user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 2342614017552552543L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "email")
    private String email;
}
