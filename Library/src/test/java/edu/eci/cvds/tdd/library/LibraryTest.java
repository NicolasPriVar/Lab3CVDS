package edu.eci.cvds.tdd.library;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Map;

import edu.eci.cvds.tdd.library.Library;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;

public class LibraryTest{
    private Library library;

    @BeforeEach
    public void setUp(){
        library = new Library();
    }

    @Test

    public void testAddBook(){
        String tittle = "Cien años de soledad";
        String author = "Gabriel Garcia Marquez";
        String isbn = "8950";
        
        Book book = new Book(tittle, author,isbn);
        assertTrue(library.addBook(book));
    }
}