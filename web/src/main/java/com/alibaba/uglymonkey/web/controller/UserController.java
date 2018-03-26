package com.alibaba.uglymonkey.web.controller;

import com.alibaba.uglymonkey.web.icontroller.IUserController;
import com.alibaba.uglymonkey.web.model.UserRequestType;
import com.alibaba.uglymonkey.web.model.UserResponseType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by jack on 2018/3/21.
 */
@RestController
public class UserController implements IUserController{


    @Override
    public  List<UserResponseType> getUser() {
        UserResponseType user = new UserResponseType();
        user.setUid("zkj");
        user.setUname("祝孔杰");
        return asList(user);
    }

    @Override
    public String postUser(@RequestBody UserRequestType user) {
        return user.toString();
    }

    @Override
    public UserRequestType getUser(Long id) {
        return null;
    }

    @Override
    public String putUser(Long id, UserRequestType user) {
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        return null;
    }

    /*@Override
    public String postUser(UserRequestType user) {
        return null;
    }

    @Override
    public UserRequestType getUser(Long id) {
        return null;
    }

    @Override
    public String putUser(Long id, UserRequestType user) {
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        return null;
    }*/
}
