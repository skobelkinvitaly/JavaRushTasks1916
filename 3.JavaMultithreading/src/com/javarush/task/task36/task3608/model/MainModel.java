package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {

    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();


    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }

    private List<User> getAllUsers() {
        List<User> users = userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
        return users;
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
//        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
        modelData.setUsers(getAllUsers());
//        getAllUsers();


    }

    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }

}
