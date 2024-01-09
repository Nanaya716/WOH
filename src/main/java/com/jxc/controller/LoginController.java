package com.jxc.controller;

import com.jxc.entity.SysUser;
import com.jxc.entity.Users;
import com.jxc.service.UsersService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
public class LoginController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService UsersService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }

    @RequestMapping("/toHome")
    public String toHome(){
        return "/home";
    }

//    @PostMapping("/login")
//    @ResponseBody
//    public Result login(@Valid SysUser user, HttpSession httpSession){
//        if(user==null) return Result.fail("参数不能为空！");
//        //根据用户名称获取用户信息
//        Users entity = UsersService.queryByName(user.getUserName());
//        if(entity!=null){
//            if(user.getPassword().equals(entity.getPassword())) {
//                //记录当前登录用户身份信息
//                httpSession.setAttribute("user", user);
//                return Result.ok("登录成功！");
//            } else
//                return Result.fail("用户密码错误！");
//        }
//        return Result.fail("账号不存在！");
//    }

    @PostMapping("/login")
    public String login(SysUser user, HttpSession httpSession, RedirectAttributes redirectAttributes) {
        System.out.println(user);
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "参数不能为空！");
            return "/error";
        }

        Users entity = UsersService.queryByName(user.getUserName());

        if (entity != null) {
            if (user.getPassword().equals(entity.getPassword())) {
                httpSession.setAttribute("user", user);
                redirectAttributes.addFlashAttribute("message", "登录成功！");
                return "/home";
            } else {
                redirectAttributes.addFlashAttribute("error", "用户密码错误！");
                return "/error";
            }
        }

        redirectAttributes.addFlashAttribute("error", "账号不存在！");
        return "/error";
    }


}
