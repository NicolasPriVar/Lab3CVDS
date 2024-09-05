package edu.eci.cvds.tdd.library;

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

import java.beans.Transient;
import java.time.LocalDateTime;


public class LibraryTest{
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    //Pruebas para Book

    @Test
    public void testAddBook(){
        String tittle1 = "Cien años de soledad";
        String author1 = "Gabriel Garcia Marquez";
        String isbn1 = "8950";

        Book book1 = new Book(tittle1, author1, isbn1);
        
        assertTrue(library.addBook(book1));
    }

    @Test
    public void testNotAddBookRepeated(){
        String tittle1 = "Cien años de soledad";
        String author1 = "Gabriel Garcia Marquez";
        String isbn1 = "8950";

        String tittle2 = "El resplandor";
        String author2 = "Stephen King";
        String isbn2 = "8950";
        
        Book book1 = new Book(tittle1, author1, isbn1);
        Book book2 = new Book(tittle2, author2, isbn2);

        library.addBook(book1);

        assertFalse(library.addBook(book2));
    }

    @Test
    public void testAddTwoBook(){
        String tittle1 = "Cien años de soledad";
        String author1 = "Gabriel Garcia Marquez";
        String isbn1 = "8950";

        String tittle2 = "El resplandor";
        String author2 = "Stephen King";
        String isbn2 = "1234";
        
        Book book1 = new Book(tittle1, author1, isbn1);
        Book book2 = new Book(tittle2, author2, isbn2);

        library.addBook(book1);

        assertTrue(library.addBook(book2));
    }

    @Test
    public void testAddNullBook(){
        Book book1 = null;

        assertFalse(library.addBook(book1));
    }


    //Pruebas para LoanABook

    @Test
    public void testLoanABookNoNULL() {
        
        // Crear un libro y un usuario
        Book book = new Book("El señor de los anillos", "J. R. R. Tolkien.", "4544");
        User user = new User("1234", "Juan Cancelado");

        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook("1234", "4544");
        assertNotNull(loan);
    }

    @Test
    public void testLoanABookUSER(){
        Book book = new Book("El señor de los anillos", "J. R. R. Tolkien.", "4544");
        User user = new User("1234", "Juan Cancelado");
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook("1234", "4544");

        assertEquals(user, loan.getUser());
    }

    @Test
    void testLoanBookWithNullBook() {
        Library library = new Library();
        User user = new User("001", "Juan");
        library.addUser(user);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.loanABook(user.getId(), null);
        });

        String expectedMessage = "Book with ISBN null does not exist.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testLoanABook(){
        Book book = new Book("El señor de los anillos", "J. R. R. Tolkien.", "4544");
        User user = new User("1234", "Juan Cancelado");
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook("1234", "4544");

        assertEquals(book, loan.getBook());
    }

    @Test
    public void testLoanABookActive(){
        Book book = new Book("El señor de los anillos", "J. R. R. Tolkien.", "4544");
        User user = new User("1234", "Juan Cancelado");
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook("1234", "4544");

        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
    }

    @Test
    public void testLoanABooksizeBook() {
        Library library = new Library();
        
        User user1 = new User("User1", "John Doe");
        Book book1 = new Book("ISBN1", "Title1", "Author1");
        Book book2 = new Book("ISBN2", "Title2", "Author2");

        library.addUser(user1);
        library.addBook(book1);
        library.addBook(book2);
        Loan loan = library.loanABook(user1.getId(), book1.getIsbn());
        assertEquals(2, library.getBooks().size());
    }

    @Test
    public void testnoCopiesToLoan() {
        Library library = new Library();
        User user1 = new User("User1", "John Doe");
        Book book = new Book("ISBN1", "Title1", "Author1");
        
        
        library.addUser(user1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            library.loanABook(user1.getId(), book.getIsbn());
        }, "Book with ISBN ISBN1 does not exist.");
    }
    
    @Test
    public void testLoanSameIsbnId(){
        Library library = new Library();
        User user1 = new User("User1", "John Doe");
        Book book = new Book("ISBN1", "Title1", "Author1");
        library.addUser(user1);
        library.addBook(book);
        Loan loanABook = library.loanABook(user1.getId(), book.getIsbn());
        assertThrows(IllegalArgumentException.class, () -> {
            library.loanABook(user1.getId(), book.getIsbn());
        }, "User with ID User1 already has an active loan for book with ISBN Author1");
    }
    
    // Otros casos de prueba

    @Test
    public void testLoanABookADDBook() {
    Library library = new Library();
    
    User user1 = new User("User1", "John Doe"); 
    Book book1 = new Book("ISBN1", "Title1", "Author1");
    Book book2 = new Book("ISBN2", "Title2", "Author2");

    library.addUser(user1);
    library.addBook(book1);
    library.addBook(book2);
    assertFalse(library.addBook(book2));
    }

    //Pruebas para returnLoan

    @Test
    public void testLoanABookReturn(){
        Library library = new Library();
        User user = new User("User1", "John Doe");
        Book book1 = new Book("ISBN1", "Title1", "Author1");
        library.addUser(user);
        library.addBook(book1);
        Loan loan = library.loanABook(user.getId(), book1.getIsbn());
        Loan returnedLoan = library.returnLoan(loan);
        assertEquals(LoanStatus.RETURNED, returnedLoan.getStatus());
        assertNotNull(returnedLoan.getReturnDate());
        assertEquals(1, library.getBooks().get(book1));
    }

    @Test
    public void testReturnLoanDoesntExistent() {
        Library library = new Library();
        User user1 = new User("User1", "John Doe");
        Book book = new Book("ISBN1", "Title1", "Author1");
        Loan loan = new Loan(user1, book, LocalDateTime.now(), LoanStatus.ACTIVE);

        // Intentar devolver un préstamo no registrado en la lista de préstamos
        assertThrows(IllegalArgumentException.class, () -> {
            library.returnLoan(loan);
        }, "Loan doesn't exist.");
    }


    public void testReturnNonExistentLoan() {
        Library library = new Library();
        User user = new User("User1", "John Doe");
        Book book1 = new Book("ISBN1", "Title1", "Author1");
        library.addUser(user);
        library.addBook(book1);
        Loan nonExistentLoan = new Loan(user, book1, LocalDateTime.now(), LoanStatus.ACTIVE);
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnLoan(nonExistentLoan);
        });
        assertEquals("Loan doesn't exist.", exception.getMessage()); 
    }

    //Pruebas para User    

    @Test
    public void testAddUser(){
        String name = "Nicolas Prieto";
        String id = "2108";
        User user = new User(id, name);
        assertTrue(library.addUser(user));
    }

    @Test
    public void testAddTwoUserSameId(){
        String name1 = "Nicolas Prieto";
        String id1 = "2108";

        String name2 = "Juan Cancelado";
        String id2 = "2108";

        User user = new User(id1, name1);
        library.addUser(user);
        User user2 = new User(id2, name2);
        assertFalse(library.addUser(user2));
    }

    @Test
    public void testAddTwoUserSameName(){
        String name1 = "Juan Cancelado";
        String id1 = "2108";

        String name2 = "Juan Cancelado";
        String id2 = "2109";

        User user = new User(id1, name1);
        library.addUser(user);
        User user2 = new User(id2, name2);
        assertTrue(library.addUser(user2));
    }


}

