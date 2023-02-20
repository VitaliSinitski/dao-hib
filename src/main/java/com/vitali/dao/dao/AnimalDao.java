package com.vitali.dao.dao;

import com.vitali.dao.entity.Animal;
import com.vitali.dao.util.HibernateUtil;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

public class AnimalDao implements Dao<Integer, Animal> {
    private static final AnimalDao INSTANCE = new AnimalDao();
    public static AnimalDao getInstance() {
        return INSTANCE;
    }
    @Override
    public List<Animal> findAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Animal> criteriaQuery = cb.createQuery(Animal.class);
        Root<Animal> root = criteriaQuery.from(Animal.class);
        criteriaQuery.select(root);

        List<Animal> resultList = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    @Override
    public Animal findById(Integer id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();
        em.close();
        return animal;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.remove(animal);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Animal entity, Integer id) {
        String name = entity.getName();
        Integer weight = entity.getWeight();

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<Animal> criteriaUpdate = builder.createCriteriaUpdate(Animal.class);
        Root<Animal> root = criteriaUpdate.from(Animal.class);

        criteriaUpdate.set("name", name);
        criteriaUpdate.set("weight", weight);
        criteriaUpdate.where(builder.equal(root.get("id"), id));

        em.createQuery(criteriaUpdate).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @SneakyThrows
    @Override
    public Animal save(Animal entity) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Animal animal = Animal.builder()
                .name(entity.getName())
                .weight(entity.getWeight())
                .build();

        em.persist(animal);
        Integer id = animal.getId();
        animal.setId(id);

        em.getTransaction().commit();
        em.close();

        return animal;
    }
}
