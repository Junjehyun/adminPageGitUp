package com.project.admin.repository;

import com.project.admin.AdminApplicationTests;
import com.project.admin.model.entity.Item;
import com.project.admin.model.enumclass.ItemStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends AdminApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = new Item();
        item.setStatus(ItemStatus.UNREGISTERED);
        item.setName("MacBOOK");
        item.setTitle("MacBOOK PRO");
        item.setContent("2022년형 노트북 입니다.");
        //item.setPrice(900000);
        item.setBrandName("APPLE");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        //item.setPartnerId(1L); // Long -> Partner


        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
    }

    @Test
    public void read(){

        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        Assertions.assertTrue(item.isPresent());
    }
}
