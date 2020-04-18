package com.javaman;

import com.javaman.mybatis.pojo.Author;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author pengzhe
 * @date 2020/4/18 19:28
 * @description
 */
public class MybatisTest {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void before() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testInsert() {

    }

    @Test
    public void testSelectOne() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Author author = (Author) sqlSession.selectOne
                ("com.javaman.mybatis.mapper.AuthorMapper.selectAuthor");
        System.out.println(author);
    }

    @Test
    public void testSelectList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Author> authors  = sqlSession.selectList("com.javaman.mybatis.mapper.AuthorMapper.selectAuthorList");
        System.out.println(authors);
    }

}
