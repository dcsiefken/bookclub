package com.bookclub;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.security.SecurityConfig;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SecurityConfig.class)
public class BookClubUnitTests {
    public BookClubUnitTests() {
    }

    @Autowired
    MongoBookOfTheMonthDao dao;

    @MockBean
    MongoTemplate mongo;

    @Test
    public void testMongoBookOfTheMonthDaoAdd() {
        BookOfTheMonth book = new BookOfTheMonth();
        book.setId("1");
        book.setIsbn("1234");
        book.setMonth(1);
        dao.add(book);
        Mockito.verify(mongo, Mockito.times(1)).save(book);
    }

    @Test
    public void testMongoBookOfTheMonthDaoRemove() {
        dao.remove("1234");
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is("1234"));
        Mockito.verify(mongo, Mockito.times(1)).remove(query, BookOfTheMonth.class);
    }

}
