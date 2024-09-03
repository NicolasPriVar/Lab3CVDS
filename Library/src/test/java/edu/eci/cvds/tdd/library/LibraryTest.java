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
        
        assertTrue(library.addBook(book1)); // Este debe pasar, libro nuevo agregado.
    }

    @Test
    public void testNotAddBookRepeated(){
        String tittle1 = "Cien años de soledad";
        String author1 = "Gabriel Garcia Marquez";
        String isbn1 = "8950";

        String tittle2 = "El resplandor";
        String author2 = "Stephen King";
        String isbn2 = "8950"; // Mismo ISBN que el primer libro.
        
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

    //Pruebas para User
    

    @Test
    public void testAddUser(){
        String name = "Nicolas Prieto";
        String id = "2108";

        User user = new User(id, name);
        
        assertTrue(library.addUser(user)); // Este debe pasar, usuario nuevo agregado.
    }

    //Prebas para Loan

    @Test 
    public void testLoanABook(){
        assertNull(library.loanABook(null,null));
    }


    
}