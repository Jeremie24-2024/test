package model;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "shelf")
public class Shelf {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="shelf_id")
    private UUID shelf_id;

    @Column(name ="available_stock")
    private int available_stock;

    @Column(name ="book_category")
    private String book_category;

    @Column(name ="borrowed_number")
    private int borrowed_number;

    @Column(name ="initial_stock")
    private int initial_stock;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room_id;

    // Getters and Setters

    public UUID getShelf_id() {
        return shelf_id;
    }

    public void setShelf_id(UUID shelf_id) {
        this.shelf_id = shelf_id;
    }

    public int getAvailable_stock() {
        return available_stock;
    }

    public void setAvailable_stock(int available_stock) {
        this.available_stock = available_stock;
    }

    public String getBook_category() {
        return book_category;
    }

    public void setBook_category(String book_category) {
        this.book_category = book_category;
    }

    public int getBorrowed_number() {
        return borrowed_number;
    }

    public void setBorrowed_number(int borrowed_number) {
        this.borrowed_number = borrowed_number;
    }

    public int getInitial_stock() {
        return initial_stock;
    }

    public void setInitial_stock(int initial_stock) {
        this.initial_stock = initial_stock;
    }

    public Room getRoom() {
        return room_id;
    }

    public void setRoom(Room room) {
        this.room_id = room;
    }

}
