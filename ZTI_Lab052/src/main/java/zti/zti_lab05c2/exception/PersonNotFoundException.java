package zti.zti_lab05c2.exception;

public class PersonNotFoundException  extends RuntimeException {

    public PersonNotFoundException(Integer id) {
        super("Could not find person " + id);
    }
}