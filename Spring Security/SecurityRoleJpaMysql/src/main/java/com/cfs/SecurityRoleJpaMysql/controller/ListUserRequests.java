package com.cfs.SecurityRoleJpaMysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class ListUserRequests {

    List<UserRequest> users;

    public List<UserRequest> getUsers() {
        return users;
    }

    public void setUsers(List<UserRequest> users) {
        this.users = users;
    }
}
