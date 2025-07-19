package com.example.controler;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import com.example.service.IdentityParameters;
import com.example.service.UserService;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping(path = "/user/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("email") String email,
                         @RequestParam("phone") String phone) {
        String result = null;
        IdentityParameters identityParameters = new IdentityParameters();
        identityParameters.setName(username);
        identityParameters.setEmail(email);
        identityParameters.setPhone(phone);
        identityParameters.setPasswd(password);
        int signUpCode = userService.signUp(identityParameters);
        if (signUpCode == 0) {
            result = "注册成功";
        } else if (signUpCode == -2) {
            result = "邮箱或手机号已存在";
        } else if (signUpCode == -3) {
            result = "密码长度不能小于6";
        } else if (signUpCode == -4) {
            result = "用户名不能为空";
        } else if (signUpCode == -5) {
            result = "邮箱格式错误";
        } else if (signUpCode == -6) {
            result = "手机号格式错误";
        } else {
            result = "注册失败";
        }
        return result;
    }
}
