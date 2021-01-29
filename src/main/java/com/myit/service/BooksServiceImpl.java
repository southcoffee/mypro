package com.myit.service;

import com.myit.dao.BooksMapper;
import com.myit.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements  BooksService {
    @Autowired
    BooksMapper  booksMapper;
    @Override
    public int getCount(Integer bookType, String bookName, Integer isBorrowed) {
        return booksMapper.getCount(bookType,bookName,isBorrowed);
    }

    @Override
    public List<Books> getBooks(Integer bookType, String bookName, Integer isBorrowed, Integer pageStrat, Integer pageSize) {
        return booksMapper.getBooks(bookType,bookName,isBorrowed,pageStrat,pageSize);
    }

    @Override
    public int updateBooks(Integer bookId) {
        return booksMapper.updateBooks(bookId);
    }
}
