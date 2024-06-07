package AddressBook;

import java.util.Scanner;

// Clase principal que ejecuta la aplicación de la libreta de direcciones.
public class AddressBookAplication {

    // Método Main que ejecuta la aplicación.
    public static void main(String[] args) {

        AddressBook book = new AddressBook();
        Menu menu = new Menu(book);
        Scanner sc = new Scanner(System.in);

        String opcion;

        do {
            menu.displayMenu();
            opcion = sc.nextLine();
            menu.userInput(opcion);
        } while (!opcion.equals("f"));
    }
}