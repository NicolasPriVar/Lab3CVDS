package test.java.edu.eci.cvds.tdd.library.book;

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
class BookTest {

    @Test
    void testGetTittle() {
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890");
        assertEquals("Effective Java", book.getTittle());
    }

    @Test
    void testGetAuthor() {
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890");
        assertEquals("Joshua Bloch", book.getAuthor());
    }

    @Test
    void testGetIsbn() {
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890");
        assertEquals("1234567890", book.getIsbn());
    }

    @Test
    void testEqualsSameIsbn() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "1234567890");
        Book book2 = new Book("Another Java Book", "Author B", "1234567890"); // Same ISBN
        assertTrue(book1.equals(book2));
    }

    @Test
    void testEqualsDifferentIsbn() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "1234567890");
        Book book2 = new Book("Effective Java", "Joshua Bloch", "0987654321"); // Different ISBN
        assertFalse(book1.equals(book2));
    }
}