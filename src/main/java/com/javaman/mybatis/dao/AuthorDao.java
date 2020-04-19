package com.javaman.mybatis.dao;

import com.javaman.mybatis.mapper.AuthorMapper;
import com.javaman.mybatis.pojo.Author;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengzhe
 * @date 2020/4/18 22:26
 * @description
 */

public class AuthorDao {

    @Autowired
    private AuthorMapper authorMapper;
    public Author select() {
        return authorMapper.selectAuthor();
    }

    public void batchInsert() {
        List<Author> authors = new ArrayList<Author>();
        for (int i = 0; i < 100; i++) {
            Author author = new Author();
            author.setEmail("luanma.com");
            author.setPassword("12312");
            author.setUsername("luanma"+i);
            authors.add(author);
        }
        authorMapper.batchInsert(authors);

    }
}
