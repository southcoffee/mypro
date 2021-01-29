package com.myit.controller;

import com.myit.pojo.Users;
import com.myit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UsersController {
    @Autowired
    UserService  userService;
    @RequestMapping("/")
    public String login_view(){
        return  "login";
    }
    @RequestMapping("/login")
    @ResponseBody
    public Object login(HttpSession  session,String userCode, String password){
        String   res="ok";
    Users users=null;
            users=userService.getUsersById(userCode);
            if(users==null)
                res="1";
            else if(!users.getPassword().equals(password))
                res="2";
            else
            {
                res="ok";
                Date date=new Date();
                SimpleDateFormat  format=new SimpleDateFormat("yyyy-MM-dd");
                 try {
                int r=     userService.updateUserTimeById(userCode, format.format(date));
                 if(r>0) {
                     res = "ok";
                     session.setAttribute("users",users);
                 }
                 else
                     res="3";
                 }catch (Exception ex){

                 }

            }

        return  res;
    }

}
