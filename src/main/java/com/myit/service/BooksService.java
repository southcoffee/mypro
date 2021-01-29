package com.myit.service;

import com.myit.pojo.Books;

import java.util.List;

public interface BooksService {
    public int getCount(Integer bookType,String bookName,Integer isBorrowed);

    public List<Books> getBooks(Integer bookType, String bookName, Integer isBorrowed, Integer pageStart, Integer pageSize);
    public int updateBooks(Integer bookId);
}
