package exec.models;

import java.io.Serializable;

/**
 * Слой сущностей БД (Model)
 * класс-Person: содержит информацию о читателях
 */
public class Person implements Serializable {

    private Long idOfPerson;
    private String nameOfPerson;
    private String surnameOfPerson;
    private String middleNameOfPerson;

    private String dateOfBirthPerson;

    public Person() {
    }

    public Person(Long idOfPerson, String dateOfBirthPerson, String nameOfPerson, String surnameOfPerson, String middleNameOfPerson) {
        this.idOfPerson = idOfPerson;
        this.dateOfBirthPerson = dateOfBirthPerson;
        this.nameOfPerson = nameOfPerson;
        this.surnameOfPerson = surnameOfPerson;
        this.middleNameOfPerson = middleNameOfPerson;
    }

    public Long getIdOfPerson() {
        return idOfPerson;
    }

    public void setIdOfPerson(Long idOfPerson) {
        this.idOfPerson = idOfPerson;
    }

    public String getDateOfBirthPerson() {
        return dateOfBirthPerson;
    }

    public void setDateOfBirthPerson(String dateOfBirthPerson) {
        this.dateOfBirthPerson = dateOfBirthPerson;
    }

    public String getMiddleNameOfPerson() {
        return middleNameOfPerson;
    }

    public void setMiddleNameOfPerson(String middleNameOfPerson) {
        this.middleNameOfPerson = middleNameOfPerson;
    }

    public String getSurnameOfPerson() {
        return surnameOfPerson;
    }

    public void setSurnameOfPerson(String surnameOfPerson) {
        this.surnameOfPerson = surnameOfPerson;
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (idOfPerson != null ? !idOfPerson.equals(person.idOfPerson) : person.idOfPerson != null) return false;
        if (nameOfPerson != null ? !nameOfPerson.equals(person.nameOfPerson) : person.nameOfPerson != null)
            return false;
        if (surnameOfPerson != null ? !surnameOfPerson.equals(person.surnameOfPerson) : person.surnameOfPerson != null)
            return false;
        if (middleNameOfPerson != null ? !middleNameOfPerson.equals(person.middleNameOfPerson) : person.middleNameOfPerson != null)
            return false;
        return dateOfBirthPerson != null ? dateOfBirthPerson.equals(person.dateOfBirthPerson) : person.dateOfBirthPerson == null;

    }

    @Override
    public int hashCode() {
        int result = idOfPerson != null ? idOfPerson.hashCode() : 0;
        result = 31 * result + (nameOfPerson != null ? nameOfPerson.hashCode() : 0);
        result = 31 * result + (surnameOfPerson != null ? surnameOfPerson.hashCode() : 0);
        result = 31 * result + (middleNameOfPerson != null ? middleNameOfPerson.hashCode() : 0);
        result = 31 * result + (dateOfBirthPerson != null ? dateOfBirthPerson.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nameOfPerson='" + nameOfPerson + '\'' +
                ", surnameOfPerson='" + surnameOfPerson + '\'' +
                ", middleNameOfPerson='" + middleNameOfPerson + '\'' +
                '}';
    }
}
