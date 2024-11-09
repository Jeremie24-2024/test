package model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private UUID bookId;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_status", nullable = false)
    private BookStatus bookStatus;

    @Column(name = "edition", nullable = false)
    private int edition;

    @Column(name = "ISBN_code", nullable = false)
    private String ISBNCode;

     
    @Column(name = "publication_year", nullable = false)
    private Date publicationYear;

    @Column(name = "publisher_name", nullable = false)
    private String publisherName;

    @ManyToOne
    @JoinColumn(name = "shelf_id", nullable = false)
    private Shelf shelf;

    @Column(name = "title", nullable = false)
    private String title;

    // Getters and Setters
    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(String ISBNCode) {
        this.ISBNCode = ISBNCode;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Shelf getShelf() {
        return shelf;
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }  

}
