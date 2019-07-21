package com.juniors.repository;

import com.juniors.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author Juniors
 */
@Component
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

}
