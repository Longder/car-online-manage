package com.longder.car.controller;

import com.longder.car.entity.po.SysUser;
import com.longder.car.service.CarManageService;
import com.longder.car.service.UserManageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理的Controller
 */
@Controller
@RequestMapping("/admin/user")
public class UserManageController {

    @Resource
    private CarManageService carManageService;
    @Resource
    private UserManageService userManageService;

    /**
     * 用户列表
     * @return
     */
    @GetMapping("/list")
    public String toUserList(Model model){
        List<SysUser> userList = userManageService.listCommonUser();
        model.addAttribute("userList",userList);
        return "user/list";
    }

    /**
     * 用户下的绑定车辆列表页面
     * @return
     */
    @GetMapping("/userCarList")
    public String userCarList(Long userId,Model model){
        model.addAttribute("carList",carManageService.listCarForUser(userId));
        return "car/list-for-admin-modal";
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @GetMapping("/deleteUser")
    public String deleteUser(Long userId){
        userManageService.deleteUser(userId);
        return "redirect:/admin/user/list";
    }

    /**
     * 去修改密码页面
     * @return
     */
    @GetMapping("/toChangePassword")
    public String toChangePassword(){
        return "user/changePasswordModal";
    }

    /**
     * 修改密码
     * @return
     */
    @ResponseBody
    @PostMapping("/changePassword")
    public String changePassword(String password){
        userManageService.changePassword(password);
        return "ok";
    }
}
