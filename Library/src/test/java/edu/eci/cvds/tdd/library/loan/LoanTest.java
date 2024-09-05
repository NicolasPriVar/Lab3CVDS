package test.java.edu.eci.cvds.tdd.library.loan;

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


class LoanTest {

    @Test
    void testGetBook() {
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890");
        User user = new User("001", "Juan");
        Loan loan = new Loan(user, book, LocalDateTime.now(), LoanStatus.ACTIVE);
        assertEquals(book, loan.getBook());
    }

    @Test
    void testSetBook() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "1234567890");
        Book book2 = new Book("Clean Code", "Robert C. Martin", "0987654321");
        User user = new User("001", "Juan");
        Loan loan = new Loan(user, book1, LocalDateTime.now(), LoanStatus.ACTIVE);
        loan.setBook(book2);
        assertEquals(book2, loan.getBook());
    }

    @Test
    void testGetUser() {
        User user = new User("001", "Juan");
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890");
        Loan loan = new Loan(user, book, LocalDateTime.now(), LoanStatus.ACTIVE);
        assertEquals(user, loan.getUser());
    }

    @Test
    void testSetUser() {
        User user1 = new User("001", "Juan");
        User user2 = new User("002", "Maria");
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890");
        Loan loan = new Loan(user1, book, LocalDateTime.now(), LoanStatus.ACTIVE);
        loan.setUser(user2);
        assertEquals(user2, loan.getUser());
    }

    @Test
    void testGetLoanDate() {
        LocalDateTime now = LocalDateTime.now();
        User user = new User("001", "Juan");
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890");
        Loan loan = new Loan(user, book, now, LoanStatus.ACTIVE);
        assertEquals(now, loan.getLoanDate());
    }

    @Test
    void testSetLoanDate() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime later = now.plusDays(1);
        User user = new User("001", "Juan");
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890");
        Loan loan = new Loan(user, book, now, LoanStatus.ACTIVE);
        loan.setLoanDate(later);
        assertEquals(later, loan.getLoanDate());
    }

    @Test
    void testGetStatus() {
        User user = new User("001", "Juan");
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890");
        Loan loan = new Loan(user, book, LocalDateTime.now(), LoanStatus.ACTIVE);
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
    }


    @Test
    void testGetReturnDateInitiallyNull() {
        User user = new User("001", "Juan");
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890");
        Loan loan = new Loan(user, book, LocalDateTime.now(), LoanStatus.ACTIVE);
        assertNull(loan.getReturnDate());
    }

    @Test
    void testSetReturnDate() {
        User user = new User("001", "Juan");
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890");
        LocalDateTime returnDate = LocalDateTime.now().plusDays(7);
        Loan loan = new Loan(user, book, LocalDateTime.now(), LoanStatus.ACTIVE);
        loan.setReturnDate(returnDate);
        assertEquals(returnDate, loan.getReturnDate());
    }
}
