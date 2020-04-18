package com.javaman;

import com.javaman.mybatis.mapper.AuthorMapper;
import com.javaman.mybatis.pojo.Author;
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
 * https://www.cnblogs.com/gdwkong/p/8734020.html
 *
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
        Author author = new Author();
        author.setId(40);
        author.setUsername("pengzheTest");
        author.setPassword("test");
        author.setEmail("123");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insert = sqlSession.insert
                ("com.javaman.mybatis.mapper.AuthorMapper.insertAuthorNoPrimaryKey", author);
        sqlSession.commit();
        System.out.println(insert);
        sqlSession.close();
    }

    @Test
    public void testInsertWithPrimaryKey() {
        Author author = new Author();
        author.setUsername("pengzheTestWith");
        author.setPassword("test");
        author.setEmail("123");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
        mapper.insertAuthorWithPrimaryKey(author);
        sqlSession.commit();
        System.out.println(author);
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        Author author = new Author();
        author.setUsername("pengzheTestWithUpdate");
        author.setPassword("test");
        author.setEmail("123");
        author.setId(40);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);

        mapper.updateAuthor(author);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testDelete() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int delete = sqlSession.delete("com.javaman.mybatis.mapper.AuthorMapper.deleteAuthor", 43);
        System.out.println(delete);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectOne() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Author author = (Author) sqlSession.selectOne
                ("com.javaman.mybatis.mapper.AuthorMapper.selectAuthor", 1);
        System.out.println(author);
    }

    @Test
    public void testSelectList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Author> authors = sqlSession.selectList("com.javaman.mybatis.mapper.AuthorMapper.selectAuthorList");
        System.out.println(authors);
    }

}
