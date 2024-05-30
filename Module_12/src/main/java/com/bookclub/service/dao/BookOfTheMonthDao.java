package com.bookclub.service.dao;

import java.util.List;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.GenericCrudDao;

public interface BookOfTheMonthDao extends GenericCrudDao<BookOfTheMonth, String> {
    void add(BookOfTheMonth entity);

    void update(BookOfTheMonth entity);

    boolean remove(String key);

    List<BookOfTheMonth> list(String key);

    BookOfTheMonth find(String key);
}
