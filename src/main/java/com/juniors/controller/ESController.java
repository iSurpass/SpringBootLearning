package com.juniors.controller;

import com.juniors.model.Book;
import com.juniors.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Juniors
 */
@Controller
public class ESController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/query")
    public String query(){

        Book book = new Book(1,"火箭总冠军","Juniors");
        bookRepository.index(book);

        return "success";
    }
}
