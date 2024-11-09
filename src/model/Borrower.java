package model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "Borrower")
public class Borrower {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "borrower_id")
    private UUID borrowerId;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    
    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "fine")
    private int fine;

    @Column(name = "late_charge_fees")
    private int lateChargeFees;

    
    @Column(name = "pickup_date")
    private Date pickupDate;

    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    private User reader;

    
    @Column(name = "return_date")
    private Date returnDate;

    // Getters and Setters
    public UUID getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(UUID borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public int getLateChargeFees() {
        return lateChargeFees;
    }

    public void setLateChargeFees(int lateChargeFees) {
        this.lateChargeFees = lateChargeFees;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public User getReader() {
        return reader;
    }

    public void setReader(User reader) {
        this.reader = reader;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
