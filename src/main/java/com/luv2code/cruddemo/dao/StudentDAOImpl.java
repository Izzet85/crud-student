package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> thequery = entityManager.createQuery("FROM Student order by lastName asc",Student.class);
        return thequery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> thequery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData ",Student.class);

        thequery.setParameter("theData",theLastName);

        return thequery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);


    }

    @Override
    @Transactional
    public void delete(Integer id) {
    Student student =   entityManager.find(Student.class,id);

    entityManager.remove(student);

    }

    @Override
    @Transactional
    public int deleteAll() {
      int numRowsDeleted =  entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }


}










