package com.javaman.mybatis.dao;

import com.javaman.mybatis.mapper.AuthorMapper;
import com.javaman.mybatis.pojo.Author;
import org.springframework.beans.factory.annotation.Autowired;

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
}
