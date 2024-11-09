package model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "Membership")
public class Membership {

	@Id
    @Column(name = "membership_id")
    private UUID membershipId = UUID.randomUUID();

    @Column(name = "membership_code", nullable = false)
    private String membershipCode;

    
    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    
    @Column(name = "expiring_time", nullable = false)
    private Date expiringTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "membership_status", nullable = false)
    private Status membershipStatus;

    @ManyToOne
    @JoinColumn(name = "membership_type_id", nullable = false)
    private MembershipType membershipType;

    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    private User reader;

    // Getters and Setters
    public UUID getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(UUID membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipCode() {
        return membershipCode;
    }

    public void setMembershipCode(String membershipCode) {
        this.membershipCode = membershipCode;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getExpiringTime() {
        return expiringTime;
    }

    public void setExpiringTime(Date expiringTime) {
        this.expiringTime = expiringTime;
    }

    public Status getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(Status membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public User getReader() {
        return reader;
    }

    public void setReader(User reader) {
        this.reader = reader;
    }
}
