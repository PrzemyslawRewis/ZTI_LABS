package zti.lab04;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import zti.model2.Person;

@Path("/jpa/person")
public class JPAResource {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public JPAResource() {
        managerFactory = Persistence.createEntityManagerFactory("PU_Postgresql");
        entityManager = managerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Person[] get() {
        System.out.println("GET");
        List<Person> people = null;
        try {
            @SuppressWarnings("unchecked")
            List<Person> resultList = (List<Person>) entityManager.createNamedQuery("findAll").getResultList();
            //people = (List<Person>) entityManager.createNamedQuery("findAll").getResultList();
            people = resultList;
            // manager.close();
        } catch (Exception e) {
            System.out.println("Failed !!! " + e.getMessage());
        }
        return people.toArray(new Person[0]);
    }


    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Person get(@PathParam("id") String id) {
        System.out.println("GET");
        Person entity = (Person) entityManager.find(Person.class, Integer.parseInt(id));
        return entity;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String post(Person person) {
        System.out.println("POST");
        entityTransaction.begin();
        entityManager.persist(person);
        entityManager.flush();
        entityTransaction.commit();
        return "add record";
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String put(Person person) {
        Person existingPerson = entityManager.find(Person.class, person.getId());
        if (existingPerson == null) {
            throw new NotFoundException("Person with ID " + person.getId() + " not found");
        }
        if (person.getFname().isBlank()) {
            person.setFname(existingPerson.getFname());
        }
        if (person.getLname().isBlank()) {
            person.setLname(existingPerson.getLname());
        }
        if (person.getCity().isBlank()) {
            person.setCity(existingPerson.getCity());
        }
        if (person.getEmail().isBlank()) {
            person.setEmail(existingPerson.getEmail());
        }
        if (person.getTel().isBlank()) {
            person.setTel(existingPerson.getTel());
        }
        System.out.println("PUT");
        entityTransaction.begin();
        entityManager.merge(person);
        entityTransaction.commit();
        return "Poprawiono rekord";
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String delete(@PathParam("id") String id) {
        System.out.println("DELETE");
        entityTransaction.begin();
        Person entity = (Person) entityManager.find(Person.class, Integer.parseInt(id));
        entityManager.remove(entity);
        entityManager.flush();
        entityTransaction.commit();
        return "delete record";
    }

}