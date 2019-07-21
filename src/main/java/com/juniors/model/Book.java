package com.juniors.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author Juniors
 */
@Setter
@Getter
// ES 文档，索引（数据库），类型（表）
@Document(indexName = "juniors",type = "employee")
public class Book{

    private Integer id;

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

    public Book(Integer id,String name,String author){

        this.id = id;
        this.name = name;
        this.author = author;
    }
}
