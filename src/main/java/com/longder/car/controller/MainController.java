package com.longder.car.controller;

import com.longder.car.entity.po.SysRole;
import com.longder.car.entity.po.SysUser;
import com.longder.car.service.UserManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserManageService userManageService;

    /**
     * 主页默认跳转到登陆页
     * @return
     */
    @GetMapping("/")
    public String index(){
        return "redirect:toLogin";
    }

    /**
     * 去登陆页
     * @return
     */
    @GetMapping("/toLogin")
    public String toLogin(){
        logger.debug("去登陆页面!");
        return "login";
    }

    /**
     * 去注册页面
     * @return
     */
    @GetMapping("/toRegister")
    public String toRegister(){
        logger.debug("去注册页面！");
        return "register";
    }


    /**
     * 检查登录名
     * @return
     */
    @ResponseBody
    @PostMapping("/checkLoginName")
    public Boolean checkLoginName(String loginName){
        return userManageService.checkLoginName(loginName);
    }

    /**
     * 注册一个用户
     * @param sysUser
     * @return
     */
    @PostMapping("/register")
    public String register(SysUser sysUser){
        logger.debug("开始注册用户，登录名：{}",sysUser.getLoginName());
        userManageService.saveOneUser(sysUser, SysRole.ROLE_USER);
        return "redirect:toLogin";
    }

    /**
     * 后台主页,登陆后访问的首页
     * @return
     */
    @GetMapping("/admin/index")
    public String adminIndex(){
        logger.debug("去后台主页");
        return "index";
    }

    /**
     * 仪表盘，欢迎页面
     * @return
     */
    @GetMapping("/admin/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
