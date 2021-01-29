package com.myit.controller;

import com.myit.pojo.Books;
import com.myit.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BooksController {
    @Autowired
    BooksService  booksService;
    @RequestMapping("/logout")
    public String  logout(HttpSession  session){
        session.removeAttribute("users");
        return "login";
    }

    @RequestMapping("/index")
    public String  index(HttpSession  session){
        return "index";
    }

    @RequestMapping("/search")
    @ResponseBody
    public Map<String,Object> search( @RequestParam(value = "bookType",required = false)String bookType,@RequestParam(value = "bookName",required = false)String bookName,@RequestParam(value = "isBorrowed",required = false)String isBorrowed,@RequestParam(value = "pageIndex",required = false)String pageIndex,@RequestParam(value = "pageSize",required = false)String pageSize){
        Map<String,Object> map=new HashMap<>();
       int pindex=1;
       int psize=3;
       int count=0;
       int pcount=0;
       Integer btype=null;
       String bname=null;
       Integer isb=null;
       if(pageIndex!="")
           pindex=Integer.valueOf(pageIndex);
       if(pageSize!="")
           psize=Integer.valueOf(pageSize);
       if(bookType!=""&&bookType!="-1")
           btype=Integer.parseInt(bookType);
       if(bookName!=""){
           bname=bookName;
       }
       if(isBorrowed!=""&&isBorrowed!="-1")
           isb=Integer.parseInt(isBorrowed);

     count=  booksService.getCount(btype,bname,isb);
     if(count>0)
         pcount=count%psize==0?count/psize:(count/psize)+1;

       if(pindex<0)
           pindex=1;
       if(pindex>pcount&&pcount>0){
           pindex=pcount;
       }
        List<Books> booksList=booksService.getBooks(btype,bname,isb,(pindex-1)*psize,psize);
       map.put("pageIndex",pindex);
       map.put("pageSize",psize);
       map.put("pageCount",pcount);
       map.put("booksList",booksList);
       map.put("bookType",btype);
       map.put("bookName",bname);
       map.put("isBorrowed",isb);

    return map;
    }

    @RequestMapping("/update")
    @ResponseBody
    public   String   update(@RequestParam("bookId")String bookId){
     int r=   booksService.updateBooks(Integer.valueOf(bookId));
          String res="no";
          if(r>0)
              res="ok";
        return res;
    }


}
