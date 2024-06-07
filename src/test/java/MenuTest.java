import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import AddressBook.*;

public class MenuTest {

    private AddressBook addressBook;
    private Menu menu;

    @BeforeEach
    public void setUp() {
        addressBook = new AddressBook();
        menu = new Menu(addressBook);
    }

    @Test
    public void testAdd() {
        String input = "Jose\nPerez\n123 Quevedo\nCoatzacoalcos\nVeracruz\n12345\n9215551234\nJose@gmail.com";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.add();
        assertEquals(1, addressBook.addressEntryList.size());
    }

    @Test
    public void testFind() {
        AddressEntry entry1 = new AddressEntry("Jose", "Perez", "123 Quevedo", "Coatzacoalcos", "Veracruz", 12345, "9215551234", "Jose@gmail.com");
        AddressEntry entry2 = new AddressEntry("Juan", "Perez", "456 Juan escutia", "Cityville", "Veracruz", 54321, "9215555678", "Juan@gmail.com");
        addressBook.add(entry1);
        addressBook.add(entry2);

        String input = "Perez";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menu.find();
        // Verificar que se encuentren dos registros con el apellido "Perez"
        assertEquals(2, addressBook.find("Perez").size());
    }

    @Test
    public void testRemove() {
        AddressEntry entry = new AddressEntry("Juan", "Hernadez", "456 Juan escutia", "Cityville", "Veracruz", 54321, "9215555678", "Juan@gmail.com");
        addressBook.add(entry);

        String input = "Hernadez";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menu.remove();
        assertEquals(0, addressBook.addressEntryList.size());
    }

    @Test
    public void testUserInput() {
        // Simular entrada del usuario
        String input = "a\nfile.txt";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Prueba de la opción 'a' para cargar un archivo
        menu.userInput("a");
        assertEquals(1, addressBook.addressEntryList.size());

        // Prueba de la opción 'b' para agregar un registro
        input = "b\nJose\nPerez\n123 Quevedo\nCoatzacoalcos\nVeracruz\n12345\n9215551234\nJose@gmail.com";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.userInput("b");
        assertEquals(2, addressBook.addressEntryList.size());

        // Prueba de la opción 'c' para eliminar un registro
        input = "c\nPerez";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.userInput("c");
        assertEquals(1, addressBook.addressEntryList.size());

        // Prueba de la opción 'd' para buscar un registro
        input = "d\nPerez";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.userInput("d");

        // Prueba de la opción 'e' para mostrar la lista de registros
        menu.userInput("e");
        assertEquals(1, addressBook.addressEntryList.size());
    }
}

