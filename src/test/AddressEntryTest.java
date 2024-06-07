package AddressBook;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressEntryTest {

    @Test
    public void testConstructorWithParameters() {
        AddressEntry entry = new AddressEntry("Jose", "Perez", "123 Quevedo", "Coatzacoalcos", "Veracruz", 12345, "9215551234", "Jose@gmail.com");
        assertEquals("Jose", entry.getFisrtName());
        assertEquals("Perez", entry.getLastName());
        assertEquals("123 Quevedo", entry.getStreet());
        assertEquals("Coatzacoalcos", entry.getCity());
        assertEquals("Veracruz", entry.getState());
        assertEquals(12345, entry.getZipCode());
        assertEquals("9215551234", entry.getPhoneNumber());
        assertEquals("Jose@gmail.com", entry.getEmail());
    }

    @Test
    public void testConstructorWithoutParameters() {
        AddressEntry entry = new AddressEntry();
        assertNull(entry.getFisrtName());
        assertNull(entry.getLastName());
        assertNull(entry.getStreet());
        assertNull(entry.getCity());
        assertNull(entry.getState());
        assertEquals(0, entry.getZipCode());
        assertNull(entry.getPhoneNumber());
        assertNull(entry.getEmail());
    }

    @Test
    public void testToString() {
        AddressEntry entry = new AddressEntry("Jose", "Perez", "123 Quevedo", "Coatzacoalcos", "Veracruz", 12345, "9215551234", "Jose@gmail.com");
        String expected = "\nFisrt Name: Jose\nLast Name: Perez\nStreet: 123 Quevedo\nCity: Coatzacoalcos\nState: Veracruz\nZip Code: 12345\nphoneNumber: 9215551234\nEmail: Jose@gmail.com\n";
        assertEquals(expected, entry.toString());
    }

    @Test
    public void testSettersAndGetters() {
        AddressEntry entry = new AddressEntry();
        entry.setFisrtName("Juan");
        entry.setLastName("Hernandez");
        entry.setStreet("456 Juan escutia");
        entry.setCity("Coatzacoalcos");
        entry.setState("Veracruz");
        entry.setZipCode(54321);
        entry.setPhoneNumber("9215555678");
        entry.setEmail("Juan@gmail.com");

        assertEquals("Juan", entry.getFisrtName());
        assertEquals("Hernandez", entry.getLastName());
        assertEquals("456 Juan escutia", entry.getStreet());
        assertEquals("Coatzacoalcos", entry.getCity());
        assertEquals("Veracruz", entry.getState());
        assertEquals(54321, entry.getZipCode());
        assertEquals("9215555678", entry.getPhoneNumber());
        assertEquals("Juan@gmail.com", entry.getEmail());
    }
}
