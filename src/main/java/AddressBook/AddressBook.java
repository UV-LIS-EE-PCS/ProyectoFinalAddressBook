package AddressBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    public List<AddressEntry> addressEntryList;

    public AddressBook() {
        addressEntryList = new ArrayList<>();
    }

    public void show() {
        if (addressEntryList.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("Elementos de la lista: ");
            for (AddressEntry entry : addressEntryList) {
                System.out.println(entry);
            }
        }
    }

    public void remove(String lastName) {
        List<AddressEntry> entriesFound = new ArrayList<>();
        for (AddressEntry entry : addressEntryList) {
            if (entry.getLastName().equals(lastName)) {
                entriesFound.add(entry);
            }
        }

        if (entriesFound.isEmpty()) {
            System.out.println("No se encontraron coincidencias");
        } else {
            System.out.println("/   /   /   /   /   /   /   /   /   /");
            for (AddressEntry entry : entriesFound) {
                System.out.println(entry);
            }

            System.out.println("Index: ");
            Scanner in = new Scanner(System.in);
            int index = Integer.parseInt(in.nextLine()) - 1;

            System.out.println("Introduzca 'y' para borrar, o 'n' para regresar al menu");
            System.out.println(entriesFound.get(index));
            String confirmation = in.nextLine();

            if (confirmation.equals("y")) {
                addressEntryList.remove(entriesFound.get(index));
            }

            in.close();
        }
    }

    public void add(AddressEntry addressEntry) {
        addressEntryList.add(addressEntry);
    }

    public void readFromFile(File file) {
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (!line.isEmpty()) {
                    String[] data = line.split(";");

                    if (data.length == 8) {
                        String firstName = data[0];
                        String lastName = data[1];
                        String street = data[2];
                        String city = data[3];
                        String state = data[4];
                        int zipCode = Integer.parseInt(data[5]);
                        String phoneNumber = data[6];
                        String email = data[7];

                        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zipCode, phoneNumber, email);
                        addressEntryList.add(entry);
                    }
                }
            }

            System.out.println("Archivo encontrado");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
    }

    public List<AddressEntry> find(String lastNameTemporal) {
        List<AddressEntry> entriesFound = new ArrayList<>();

        for (AddressEntry entry : addressEntryList) {
            if (entry.getLastName().startsWith(lastNameTemporal)) {
                entriesFound.add(entry);
            }
        }

        if (entriesFound.isEmpty()) {
            System.out.println("No se encontraron coincidencias");
        } else {
            System.out.println("/   /   /   /   /   /   /   /   /   /");
            for (AddressEntry entry : entriesFound) {
                System.out.println(entry);
            }
        }

        return entriesFound;
    }

    // Getter para addressEntryList
    public List<AddressEntry> getAddressEntryList() {
        return addressEntryList;
    }
}
