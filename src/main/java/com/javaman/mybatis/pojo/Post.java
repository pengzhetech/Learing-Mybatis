package com.javaman.mybatis.pojo;

import java.io.Serializable;

/**
 * @author pengzhe
 * @date 2018/4/26 00:30
 * @description
 */

public class Post implements Serializable {
    private int id;
    private Author author;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author=" + author +
                ", content='" + content + '\'' +
                '}';
    }
}
