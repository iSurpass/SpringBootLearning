package com.juniors.service;

import com.juniors.model.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Juniors
 */
@Service
public class BookService {

    @RabbitListener(queues = "juniors.news")
    public void receive(Book book){

        System.out.println("Receive Success!"+" "+book);
    }
}
