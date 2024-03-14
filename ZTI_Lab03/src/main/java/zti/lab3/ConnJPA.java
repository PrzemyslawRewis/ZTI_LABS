package zti.lab3;

import java.util.List;
import java.util.Map;

import jakarta.persistence.*;

import zti.model.Person;

public class ConnJPA {
    private EntityManagerFactory managerFactory; // = Persistence.createEntityManagerFactory(persistenceUnitName);
    private EntityManager entityManager; // = managerFactory.createEntityManager();
    private EntityTransaction entityTransaction;

    public ConnJPA(String persistenceUnitName ) {
        managerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = managerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @SuppressWarnings("unchecked")
    public List<Person> getPersonList() {
        List<Person> people = null;
        try {
            people = (List<Person>) entityManager.createNamedQuery("findAll").getResultList();
            // manager.close();
        } catch (Exception e) {
            System.out.println("Failed !!! " + e.getMessage());
        }
        return people;
    }
    public void savePerson( Person entity) {
        //entityTransaction.begin();
        System.out.println("[ConnJPA] Save entity - " + entity.getLname() );
        entityTransaction.begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityTransaction.commit();
    }

    public void updatePerson(Person entity) {
        entityTransaction.begin();
        entityManager.merge(entity);
        entityTransaction.commit();
    }

    public void deletePerson(Person entity) {
        System.out.println("Delete entity - " + entity.getLname() + " ID: " + entity.getId().toString());
        entityTransaction.begin();
        entityManager.remove(entity);
        entityManager.flush();
        entityTransaction.commit();
    }

    public Person findPerson(int id) {
        Person entity = (Person) entityManager.find(Person.class, id);
        return entity;
    }
    public List<Person> searchByName(String name) {
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM person p WHERE p.lname LIKE :name", Person.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public List<Person> searchByEmail(String email) {
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM person p WHERE p.email LIKE :email", Person.class);
        query.setParameter("email", "%" + email + "%");
        return query.getResultList();
    }


}