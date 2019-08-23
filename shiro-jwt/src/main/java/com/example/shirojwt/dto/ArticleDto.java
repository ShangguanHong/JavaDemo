package com.example.shirojwt.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleDto implements java.io.Serializable {
    private static final long serialVersionUID = -2440471074054288487L;

    private Long id;
    private String title;
    private String author;
    private Date issueTime;
    private Date created;
    private Date modified;
    private Long createUserId;
    private String createUserName;
    private Integer status; //0:待发布, 1:已发布,  2:已删除
    private String content;
    private String headImgUrl;  //标题图片

}
