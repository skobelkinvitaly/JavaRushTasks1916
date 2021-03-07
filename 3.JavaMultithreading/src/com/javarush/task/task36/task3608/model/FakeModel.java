package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {

    com.javarush.task.task36.task3608.model.ModelData ModelData;
    private ModelData modelData = new ModelData();

    @Override
    public com.javarush.task.task36.task3608.model.ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> user = new ArrayList<>();
        user.add(new User("A", 1, 1));
        user.add(new User("B", 110, 5));
        modelData.setUsers(user);
    }

}
