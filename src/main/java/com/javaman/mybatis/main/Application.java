package com.javaman.mybatis.main;

import com.javaman.mybatis.pojo.Author;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author pengzhe
 * @date 2018/6/9 14:35
 * @description
 */

public class Application {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Author author = (Author) sqlSession.selectOne("com.javaman.mybatis.mapper.AuthorMapper.selectAuthor");
        List<Author> authors = sqlSession.selectList("com.javaman.mybatis.mapper.AuthorMapper.selectAuthorList");
        System.out.println(author);
        System.out.println("-------------------------------");
        System.out.println(authors);

    }
}
