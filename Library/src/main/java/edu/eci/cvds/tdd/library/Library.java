package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.LoanStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        if (book == null) {
        return false;
        }

        
        for (Book existingBook : books.keySet()) {
            if (existingBook.getIsbn().equals(book.getIsbn())) {
                return false;
            }
        }

        books.put(book, 1);
        return true;
    }

    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
     */
    public Loan loanABook(String userId, String isbn) {
    Book bookToLoan = null;
    for (Book book : books.keySet()) {
        if (book.getIsbn().equals(isbn)) {
            bookToLoan = book;
            break;
        }
    }
    if (bookToLoan == null) {
        throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist.");
    }

    if (books.get(bookToLoan) <= 0) {
        throw new IllegalArgumentException("No copies of book with ISBN " + isbn + " are available.");
    }

    User user = null;
    for (User u : users) {
        if (u.getId().equals(userId)) {
            user = u;
            break;
        }
    }
    

    for (Loan loan : loans) {
        if (loan.getUser().getId().equals(userId) && loan.getBook().getIsbn().equals(isbn) &&
            loan.getStatus() == LoanStatus.ACTIVE) {
            throw new IllegalArgumentException("User with ID " + userId + " already has an active loan for book with ISBN " + isbn);
        }
    }

    Loan newLoan = new Loan(user, bookToLoan, LocalDateTime.now(), LoanStatus.ACTIVE);
    loans.add(newLoan);

    books.put(bookToLoan, books.get(bookToLoan) - 1);

    return newLoan;
}



        

    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        if (!loans.contains(loan)){
            throw new IllegalArgumentException ("Loan doesn't exist.");
        }
        loan.setStatus(LoanStatus.RETURNED);
        loan.setReturnDate(LocalDateTime.now());
        Book book = loan.getBook();
        books.put(book, books.get(book)+1);                          
        return loan;
    }

    public boolean addUser(User user) {
        for (User existingUser : users) {
            if (existingUser.getId().equals(user.getId())) {
                return false; 
            }
        }
        return users.add(user);
    }
    
    public Map<Book, Integer> getBooks() {
    return new HashMap<>(books); 
    }



}