import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import AddressBook.*;

public class AddressBookTest {

    private AddressBook addressBook;

    @BeforeEach
    public void setUp() {
        addressBook = new AddressBook();
    }

    @Test
    public void testAdd() {
        AddressEntry entry = new AddressEntry("Juan", "Perez", "123 Quevedo", "Coatzacoalcos", "Veracruz", 12345, "9215551234", "Juan@gmail.com");
        addressBook.add(entry);
        assertEquals(1, addressBook.addressEntryList.size());
    }

    @Test
    public void testRemove() {
        AddressEntry entry = new AddressEntry("Jose", "Hernadez", "456 Juan escutia", "Coatzacoalcos", "Veracruz", 54321, "9215555678", "Jose@gmail.com");
        addressBook.add(entry);
        addressBook.remove("Hernadez");
        assertEquals(0, addressBook.addressEntryList.size());
    }

    @Test
    public void testFind() {
        AddressEntry entry1 = new AddressEntry("Juan", "Perez", "123 Quevedo", "Coatzacoalcos", "Veracruz", 12345, "9215551234", "Juan@gmail.com");
        AddressEntry entry2 = new AddressEntry("Jose", "Perez", "456 Juan escutia", "Coatzacoalcos", "Veracruz", 54321, "9215555678", "Jose@gmail.com");
        addressBook.add(entry1);
        addressBook.add(entry2);
        assertEquals(2, addressBook.find("Perez").size());
    }

    @Test
    public void testReadFromFile() {
        File file = new File("personas.txt");
        addressBook.readFromFile(file);
        assertEquals(1, addressBook.addressEntryList.size());
    }
}
