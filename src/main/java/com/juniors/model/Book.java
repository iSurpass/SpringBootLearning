package com.juniors.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Juniors
 */
@Setter
@Getter
public class Book{

    private String name;

    private String author;

    /**
     * 默认 SpringBoot 集成的 jsckson-databind 解析器

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;
    */

    /**
     * Listener 监听时接受数据要有无参构造器
     */
    public Book(){
        super();
    }

    public Book(String name,String author){

        this.name = name;
        this.author = author;
    }
}
