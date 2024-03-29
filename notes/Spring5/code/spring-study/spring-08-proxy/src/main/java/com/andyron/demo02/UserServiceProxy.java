package com.andyron.demo02;

/**
 * @author Andy Ron
 */
public class UserServiceProxy implements UserService {
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        log("delete");
        userService.delete();
    }

    public void update() {
        log("update");
        userService.update();
    }

    public void query() {
        log("query");
        userService.query();
    }

    /**
     * 日志
     * @param msg
     */
    public void log(String msg) {
        System.out.println("[Debug] 使用了" + msg + "方法");
    }
}
