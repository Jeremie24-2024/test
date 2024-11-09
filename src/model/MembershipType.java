package model;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "membership_type")
public class MembershipType {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "membership_type_id")
    private UUID membershipTypeId;

    @Column(name = "membership_name", nullable = false)
    private String membershipName;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "max_books", nullable = false)
    private int maxBooks;

    // Getters and Setters
    public UUID getMembershipTypeId() {
        return membershipTypeId;
    }

    public void setMembershipTypeId(UUID membershipTypeId) {
        this.membershipTypeId = membershipTypeId;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxBooks() {
        return maxBooks;
    }

    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }

}
