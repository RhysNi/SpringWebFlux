package com.commons.entity;

import lombok.Data;

/**
 * @author: Rhys.Ni
 * @date: 2020/6/3
 * @time: 17:28
 * @email rhys.ni@softtek.com
 */
@Data
public class City {
    /**
     * 城市ID
     */
    private Long id;

    /**
     * 省份ID
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;
}
