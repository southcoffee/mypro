package com.myit.dao;

import com.myit.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
@Repository
public interface BooksMapper {
   // @Select("<script>select count(*) from book_info where bookType=#{bookType} and bookName like '%#{bookName}%' and  isBorrowed=#{isBorrowed}</script>")
    public int getCount(@Param("bookType") Integer bookType,@Param("bookName") String bookName,@Param("isBorrowed") Integer isBorrowed);
   // @Select("<script>select * from book_info where bookType=#{bookType} and bookName like '%#{bookName}%' and  isBorrowed=#{isBorrowed} limit #{pageStart},#{pageSize}</script>")
    public List<Books> getBooks(@Param("bookType") Integer bookType, @Param("bookName") String bookName, @Param("isBorrowed") Integer isBorrowed,@Param("pageStart") Integer pageStart,@Param("pageSize") Integer pageSize);
    @Update("update book_info set isBrrowed=1 where bookId=#{bookId}")
    public int updateBooks(@Param("bookId") Integer bookId);

}
