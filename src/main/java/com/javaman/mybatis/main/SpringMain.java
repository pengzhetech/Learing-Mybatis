package com.javaman.mybatis.main;

import com.javaman.mybatis.dao.AuthorDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author pengzhe
 * @date 2020/4/18 22:30
 * @description
 */

public class SpringMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        AuthorDao authorDao = applicationContext.getBean("userDao", AuthorDao.class);
        System.out.println(authorDao.select());
    }

}
