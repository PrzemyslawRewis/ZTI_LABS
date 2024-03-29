package zti.lab3;

import java.util.List;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import zti.model.Person;

@ManagedBean(name = "servJPABean")
@SessionScoped
public class ServJPA {

    private Person person;
    private Person editPerson;
    private Person newPerson;
    private ConnJPA baza;
    private String searchName;
    private String searchEmail;

    public ServJPA() {
        System.out.println("Init Persitance Unit");
        baza = new ConnJPA("PU_Postgresql");
        person = new Person();
        editPerson = new Person();
        newPerson = new Person();
    }

    public List<Person> getPeople() {
        List<Person> people;
        if (searchName != null && !searchName.isEmpty()) {
            people = baza.searchByName(searchName);
        } else if (searchEmail != null && !searchEmail.isEmpty()) {
            people = baza.searchByEmail(searchEmail);
        } else {
            people = baza.getPersonList();
        }
        return people;
    }

    public String delPerson(Person entity) {
        baza.deletePerson(entity);
        return "allRecPost" ;
    }

    public Person getPerson() {
        return person;
    }

    public Person getEditPerson() {
        return editPerson;
    }

    public Person getNewPerson() {
        return newPerson;
    }

    public String selectPerson(Person entity) {
        person = copy(entity);
        return "viewRecPost" ;
    }

    public String updPerson(Person entity) {
        editPerson = copy(entity);
        System.out.println("updPerson -- " + editPerson.getLname());
        return "updRecPost" ;
    }

    private Person copy(Person entity) {
        person = new Person();
        person.setId(entity.getId());
        person.setFname(entity.getFname());
        person.setLname(entity.getLname());
        person.setCity(entity.getCity());
        person.setEmail(entity.getEmail());
        person.setTel(entity.getTel());
        return person ;
    }


    public String savePerson() {
        Person entity = newPerson;
        System.out.println("[ServJPA] Save entity - " + entity.getLname() );
        baza.savePerson(entity);
        newPerson = new Person();
        return "allRecPost";
    }

    public String updatePerson() {
        baza.updatePerson(editPerson);
        editPerson = new Person();
        return "allRecPost";
    }
    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getSearchEmail() {
        return searchEmail;
    }

    public void setSearchEmail(String searchEmail) {
        this.searchEmail = searchEmail;
    }

    public List<Person> searchByName() {
        return baza.searchByName(searchName);
    }

    public List<Person> searchByEmail() {
        return baza.searchByEmail(searchEmail);
    }


}