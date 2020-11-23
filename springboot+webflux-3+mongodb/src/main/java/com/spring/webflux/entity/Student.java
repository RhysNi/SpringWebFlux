package com.spring.webflux.entity;

import lombok.Data;

/**
 * @author: Rhys.Ni
 * @date: 2020/6/3
 * @time: 17:28
 * @email rhys.ni@softtek.com
 */
@Data
public class Student {
    /**
     * 主键ID  ReactiveMongoRepository中必须用"id"字段作为主键 否则CRUD无法正常操作
     */
    private Long id;

    /**
     * 学生ID
     */
    private String studentName;

    /**
     * 学生年龄
     */
    private String age;

    /**
     * 描述
     */
    private String description;
}
