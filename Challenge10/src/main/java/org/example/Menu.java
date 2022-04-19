package org.example;


import java.util.Scanner;

public class Menu {

    public Menu()
    {
    }
    public static void menu()
    {
        PersonController pc = new PersonController();
        Scanner scan = new Scanner(System.in);
        int option;
        boolean flag = true;
        while(flag)
        {
            System.out.println("1- Data Register");
            System.out.println("2- Data Query");
            System.out.println("3- Data Delete");
            System.out.println("4- Data List");
            System.out.println("5- Exit");
            option = scan.nextInt();

            switch(option) {

                case 1:

                    Person person = new Person();

                    System.out.println("First Name: ");
                    scan.nextLine();
                    person.setFirstname(scan.nextLine());
                    System.out.println("Last Name: ");
                    person.setLastname(scan.nextLine());
                    System.out.println("DNI: ");
                    person.setDni(scan.nextLine());
                    System.out.println("Address: ");
                    person.setAddress(scan.nextLine());

                    pc.insertPerson(person);
                    break;
                case 2:

                    System.out.println("Enter Dni: ");
                    scan.nextLine();

                    pc.getPersonDni(scan.nextLine());

                    break;
                case 3:


                    System.out.println("Enter DNI: ");
                    scan.nextLine();

                    pc.deletePerson(scan.nextLine());

                    break;
                case 4:


                    pc.getPersons();

                    break;
                case 5: flag = false;
                    break;
                default: System.out.println("Invalid Option");
                    break;
            }
        }

    }
}