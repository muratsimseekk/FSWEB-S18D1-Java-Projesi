package com.workintech.jpaProject1.dao;

import com.workintech.jpaProject1.entity.BreadType;
import com.workintech.jpaProject1.entity.Burger;
import com.workintech.jpaProject1.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

//DML (Data Manipulation Language) ( INSERT , UPDATE , DELETE ) => @Transactional

@Repository
public class BurgerDaoImpl implements BurgerDao{

    private EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findByID(Long id) {
        Burger burger = entityManager.find(Burger.class,id);
        if (burger==null){
            throw new BurgerException("Burger with given id is not exist: " +id , HttpStatus.NOT_FOUND);
        }
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> findAll = entityManager.createQuery("SELECT b FROM Burger b",Burger.class);
        return findAll.getResultList();
    }

    @Override
    public List<Burger> findByPrice(Double price) {
        TypedQuery<Burger> findByID = entityManager.createQuery("SELECT b FROM Burger b WHERE b.price >:price ORDER BY b.price desc", Burger.class);
        findByID.setParameter("price",price); // ??????
        return findByID.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> findBreadQuery = entityManager.createQuery("SELECT b FROM Burger b WHERE b.breadType =:breadType ORDER BY b.id asc", Burger.class);
        findBreadQuery.setParameter("breadType",breadType);
        return findBreadQuery.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.contents LIKE CONCAT('%', :content.'%'", Burger.class);

        query.setParameter("content",content);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Transactional
    @Override
    public Burger remove(Long id) {
        Burger burger = findByID(id);
        entityManager.remove(burger);
        return burger;
    }
}
