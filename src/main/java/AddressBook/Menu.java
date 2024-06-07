package AddressBook;

import java.io.File;
import java.util.Scanner;

// Clase que representa el menú de la aplicación de la libreta de direcciones.
public class Menu {
    Scanner in = new Scanner(System.in);
    AddressBook book;
    AddressEntry entry;

    // Constructor de la clase Menu.
    public Menu(AddressBook book) {
        this.book = book;
    }

    // Muestra el menú en la consola.
    public void displayMenu() {
        System.out.println("=   =   =   =   =   =   =   =   =   =   =   =");
        System.out.println("\nSelecciona una opcion: ");
        System.out.println("\na) file upload\nb) add\nc) remove\nd) find\ne) show \nf) go out\n");
        System.out.println("=   =   =   =   =   =   =   =   =   =   =   =");
    }

    // Agrega un nuevo registro a la libreta de direcciones.
    public void add() {
        String fisrtName;
        String lastName;
        String street;
        String city;
        String state;
        int zipCode;
        String phoneNumber;
        String email;

        System.out.println("First Name: ");
        fisrtName = in.nextLine();

        System.out.println("Last Name: ");
        lastName = in.nextLine();

        System.out.println("Street: ");
        street = in.nextLine();

        System.out.println("City: ");
        city = in.nextLine();

        System.out.println("State: ");
        state = in.nextLine();

        System.out.println("Zip Code: ");
        zipCode = Integer.parseInt(in.nextLine());

        System.out.println("Phone Number: ");
        phoneNumber = in.nextLine();

        System.out.println("Email: ");
        email = in.nextLine();

        entry = new AddressEntry(fisrtName, lastName, street, city, state, zipCode, phoneNumber, email);
        book.add(entry);

    }

    // Busca los registros que coincidan con el apellido introducido.
    public void find() {
        System.out.println("Introduzca el apellido que desea buscar: ");
        String lastNameTemporal = in.nextLine();
        book.find(lastNameTemporal);
    }

    // Elimina los registros que coincidan con el apellido introducido.
    public void remove() {
        System.out.println("Introduzca el apellido que desea eliminar: ");
        String lastNameTemporal = in.nextLine();
        book.remove(lastNameTemporal);

    }

    // Procesa la opcion dada por el usuario.
    public void userInput(String opcion) {

        switch (opcion) {
            case "a":
                System.out.println("Enter the file name: ");
                String fileName = in.nextLine();
                File file = new File(fileName);
                book.readFromFile(file);
                break;

            case "b":
                add();

                break;

            case "c":
                remove();
                break;

            case "d":
                find();
                break;

            case "e":
                book.show();
                break;

            default:
                break;
        }
    }
}