//package com.juniors.repository;
//
//import com.juniors.model.Book;
//import io.searchbox.client.JestClient;
//import io.searchbox.core.Index;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.IOException;
//
///**
// * @author Juniors
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class test {
//
//    @Autowired
//    JestClient jestClient;
//
//    @Test
//    public void contextLoad() throws IOException {
//
//        // 给 ES 索引一个文档
//        Book book = new Book(1,"火箭总冠军","Juniors");
//
//        // 构建一个索引功能
//        Index index = new Index.Builder(book).index("juniors").type("book").build();
//
//        jestClient.execute(index);
//    }
//}
