package com.yk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * created by 不器 on 2018/12/6.
 */
@Controller
public class SignController {
    @RequestMapping("/user/{userId}")
    public void Spring(@PathVariable("userId") String userId,
                       @RequestParam("msg") String msg,
                       @RequestHeader("host") String host,
                       Writer writer)throws IOException{
        writer.write("userId="+userId+",msg="+msg+",header="+host);
    }
    @RequestMapping("/user/login")
//    @ResponseBody
    public String login(@RequestParam("name") String name, @RequestParam("password") String password,
                        ModelMap map, HttpServletRequest request, HttpServletResponse response)
        throws IOException{

        HttpSession session=request.getSession();
        session.setMaxInactiveInterval(15);

        System.out.println("1:"+name+" "+password);
        if(session.getAttribute("name")!=null&&session.getAttribute("password")!=null){
            name=(String)session.getAttribute("name");
            password=(String)session.getAttribute("password");
        }

        System.out.println("2:"+name+" "+password);
//        System.out.println("1:"+name+" "+password);
//        if(name.equals("zyk")&&password.equals("123")){
//            Cookie nameCookie=new Cookie("name",name);
//            Cookie passwordCookie=new Cookie("password",password);
//            nameCookie.setMaxAge(10);
//            passwordCookie.setMaxAge(10);
//            response.addCookie(nameCookie);
//            response.addCookie(passwordCookie);
//        }
//        Cookie[] cookies=request.getCookies();
//        if(cookies!=null){
//            for(Cookie cookie:cookies){
//                if(cookie.getName().equals("name")){
//                    name=cookie.getValue();
//                }
//                if(cookie.getName().equals("password")){
//                    password=cookie.getValue();
//                }
//            }
//            System.out.println("2:"+name+" "+password);
//        }
        if(name.equals("zyk")&&password.equals("123")){


            session.setAttribute("name",name);
            session.setAttribute("password",password);
            map.addAttribute("name",name);
            map.addAttribute("password","******");
            return "user";
        }else {
            return "error";
        }




    }




}
