package org.example;

public class Person {

    private String firstname;
    private String lastname;
    private String dni;
    private String address;


    public Person(String firstname, String lastname, String dni, String address) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.dni = dni;
        this.address = address;
    }
    public Person() {


    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


}