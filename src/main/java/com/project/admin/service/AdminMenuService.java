package com.project.admin.service;

import com.project.admin.model.front.AdminMenu;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminMenuService {

    public List<AdminMenu> getAdminMenu(){

        return Arrays.asList(
                AdminMenu.builder().title("ユーザー管理").url("/pages/user").code("user").build()
        );

    }

}
