package test.java.edu.eci.cvds.tdd.library.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import java.util.Map;

import edu.eci.cvds.tdd.library.Library;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import java.time.LocalDateTime;


class UserTest {

    @Test
    void testGetName() {
        User user = new User("123", "Juan");
        assertEquals("Juan", user.getName());
    }

    @Test
    void testSetName() {
        User user = new User("123", "Juan");
        user.setName("Carlos");
        assertEquals("Carlos", user.getName());
    }

    @Test
    void testGetId() {
        User user = new User("123", "Juan");
        assertEquals("123", user.getId());
    }

    @Test
    void testSetId() {
        User user = new User("123", "Juan");
        user.setId("456");
        assertEquals("456", user.getId());
    }

    @Test
    void testConstructorValidData() {
        User user = new User("123", "Juan");
        assertNotNull(user);
        assertEquals("123", user.getId());
        assertEquals("Juan", user.getName());
    }

    @Test
    void testConstructorInvalidData() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, "Juan"));
        assertThrows(IllegalArgumentException.class, () -> new User("123", null));
        assertThrows(IllegalArgumentException.class, () -> new User("", "Juan"));
        assertThrows(IllegalArgumentException.class, () -> new User("123", ""));
    }
}
