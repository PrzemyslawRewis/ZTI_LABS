package zti.model;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.component.UIParameter;
import jakarta.faces.event.ActionEvent;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@ManagedBean(name = "personBean")
@RequestScoped
public class Person {
    @Enumerated(EnumType.STRING)
    private Subscription subscription;
    private String lname;
    private String fname;
    private String city;
    private String email;
    private String tel;
    private Integer id;

    public Person() {
    }

    public Person(String lname, String fname, String city, String email, String tel, Integer id, Subscription subscription) {
        this.lname = lname;
        this.fname = fname;
        this.city = city;
        this.email = email;
        this.tel = tel;
        this.id = id;
        this.subscription = subscription;
    }

    public void setPerson(Person person) {
        this.setLname(person.getLname());
        this.setFname(person.getFname());
        this.setCity(person.getCity());
        this.setEmail(person.getEmail());
        this.setTel(person.getTel());
        this.setId(person.getId());
        this.setSubscription(person.getSubscription());
    }

    public Person getPerson() {
        return new Person(this.getLname(), this.getFname(), this.getCity(), this.getEmail(), this.getTel(), this.getId(), this.getSubscription());
    }

    public void setFname(String newValue) {
        fname = newValue;
    }

    public String getFname() {
        return fname;
    }

    public void setLname(String newValue) {
        lname = newValue;
    }

    public String getLname() {
        return lname;
    }

    public void setCity(String newValue) {
        city = newValue;
    }

    public String getCity() {
        return city;
    }

    public void setEmail(String newValue) {
        email = newValue;
    }

    public String getEmail() {
        return email;
    }

    public void setTel(String newValue) {
        tel = newValue;
    }

    public String getTel() {
        return tel;
    }

    public void setId(Integer newValue) {
        id = newValue;
    }

    public Integer getId() {
        return id;
    }

    public Subscription getSubscription() {
        return subscription;
    }


    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }


    public List<Person> getPeople() {
        Database baza = new Database();
        List<Person> people = baza.getPersonList();
        return people;
    }

    @PostConstruct
    public void init() {
        subscription = Subscription.TRIAL;
    }

    public void savePerson(ActionEvent event) {
        Database baza = new Database();
        baza.createPerson(this.getPerson());
        return;
    }

    public void selectPerson(ActionEvent event) {
        Database baza = new Database();
        UIParameter component = (UIParameter) event.getComponent().findComponent("editId");
        String id = component.getValue().toString();
        this.setPerson(baza.readPerson(id));
        return;
    }

    public void updatePerson(ActionEvent event) {
        Database baza = new Database();
        baza.updatePerson(this.getPerson());
        return;
    }

    public void deletePerson(ActionEvent event) {
        Database baza = new Database();
        UIParameter component = (UIParameter) event.getComponent().findComponent("deleteId");
        String id = component.getValue().toString();
        baza.deletePerson(id);
        return;
    }


}