package com.juniors.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Juniors
 */
@Setter
@Getter
public class book {

    private String name;

    private String author;

    /**
     * 默认 SpringBoot 集成的 jsckson-databind 解析器
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;
}
