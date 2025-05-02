package com.tuanfans.action;

import com.tuanfans.service.UserService;

/**
 * @author TuanFans
 * &#064;date 2025/4/15
 * &#064description
 */
public class UserServiceAction {
    private UserService userService;

    public UserServiceAction(){

    }

    public UserServiceAction(UserService userService) {
        this.userService = userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void getUser() {
        System.out.println("UserServiceAction.getUser()...");
        userService.getUser();
    }

}
