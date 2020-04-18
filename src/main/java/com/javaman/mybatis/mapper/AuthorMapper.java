package com.javaman.mybatis.mapper;

import com.javaman.mybatis.pojo.Author;

import java.util.List;

/**
 * @author pengzhe
 * @date 2018/6/9 14:31
 * @description
 */

public interface AuthorMapper {
    /**
     * selectAuthor()
     *
     * @return
     */
    Author selectAuthor();

    /**
     * selectAuthorList()
     *
     * @return
     */
    List<Author> selectAuthorList();

    void insertAuthorNoPrimaryKey(Author author);

    void insertAuthorWithPrimaryKey(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(Author author);

}
