package com.alibaba.uglymonkey.web.icontroller;

import com.alibaba.uglymonkey.web.model.UserRequestType;
import com.alibaba.uglymonkey.web.model.UserResponseType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jack on 2018/3/21.
 */
@RequestMapping(value = "/user")
public interface IUserController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<UserResponseType> getUser();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    String postUser(@RequestBody UserRequestType user);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserRequestType getUser(@PathVariable Long id);

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    String putUser(@PathVariable Long id, @ModelAttribute UserRequestType user);

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    String deleteUser(@PathVariable Long id);

}
