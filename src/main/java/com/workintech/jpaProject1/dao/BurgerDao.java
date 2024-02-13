package com.workintech.jpaProject1.dao;

import com.workintech.jpaProject1.entity.BreadType;
import com.workintech.jpaProject1.entity.Burger;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);
    Burger findByID(Long id);
    List<Burger> findAll();
    List<Burger> findByPrice(Double price);
    List<Burger> findByBreadType(BreadType  breadType);
    List<Burger> findByContent(String content);
    Burger update (Burger burger);
    Burger remove(Long id);
}
