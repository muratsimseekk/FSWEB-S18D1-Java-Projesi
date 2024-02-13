package com.workintech.jpaProject1.controller;

import com.workintech.jpaProject1.dao.BurgerDao;
import com.workintech.jpaProject1.entity.BreadType;
import com.workintech.jpaProject1.entity.Burger;
import com.workintech.jpaProject1.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/burger")
public class BurgerController {
    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }
    @PostMapping("/")
    public Burger save(Burger burger){
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }

    @GetMapping("/")
    public List<Burger> findAll(){
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger findByID(@PathVariable Long id){
        return burgerDao.findByID(id);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable Double price){
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/bread/{breadType}")
    public List<Burger> findByBread(@PathVariable String breadType){
        BreadType bt = BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(bt);
    }
    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }

    @PutMapping("/")
    public Burger update(Burger burger){
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger remove(Long id){
        return burgerDao.remove(id);
    }
}
