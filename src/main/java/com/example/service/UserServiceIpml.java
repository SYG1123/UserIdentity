package com.example.service;

import com.example.entity.User;
import org.apache.commons.lang3.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.repository.UserRepo;

@Service
public class UserServiceIpml implements UserService {
    @Resource
    private UserRepo userRepo;


    @Override
    public int signUp(IdentityParameters identityParameters) {
        String username = identityParameters.getName();
        String email = identityParameters.getEmail();
        String phone = identityParameters.getPhone();
        String passwd = identityParameters.getPasswd();
        //-4
        boolean isUsernameValid = StringUtils.isNotEmpty(username);
        //-5
        boolean isEmailValid = StringUtils.containsAny(email, "@", ".");
        //-6
        boolean isPhoneValid = StringUtils.isNumeric(phone);
        //-3
        boolean isPasswdValid = StringUtils.length(passwd) >= 6;
        if (!isPasswdValid)
            return -3;
        if (!isUsernameValid)
            return -4;
        if (!isEmailValid)
            return -5;
        if (!isPhoneValid)
            return -6;
        boolean isSameEmail = userRepo.findUserByEmail(email) != null;
        boolean isSamePhone = userRepo.findUserByPhone(phone) != null;
        if (isSameEmail || isSamePhone) {
            return -2;
        }
        User newUser = new User();
        newUser.setName(username);
        newUser.setEmail(email);
        newUser.setPhone(phone);
        newUser.setPasswd(passwd);
        userRepo.save(newUser);
        return 0;
    }

    @Override
    public void login(IdentityParameters identityParameters) throws UserException {

    }
}
