package model;

import java.util.Set;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "Location")
public class Location {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private UUID locationId;

	    @Column(name = "location_code", nullable = false)
	    private String locationCode;

	    @Column(name = "location_name", nullable = false)
	    private String locationName;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "location_type", nullable = false)
	    private LocationType locationType;

	    @ManyToOne
	    @JoinColumn(name = "parent_id")
	    private Location parent;

	    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	    private Set<Location> children;

	    // Getters and Setters
	    public UUID getLocationId() {
	        return locationId;
	    }

	    public void setLocationId(UUID locationId) {
	        this.locationId = locationId;
	    }

	    public String getLocationCode() {
	        return locationCode;
	    }

	    public void setLocationCode(String locationCode) {
	        this.locationCode = locationCode;
	    }

	    public String getLocationName() {
	        return locationName;
	    }

	    public void setLocationName(String locationName) {
	        this.locationName = locationName;
	    }

	    public LocationType getLocationType() {
	        return locationType;
	    }

	    public void setLocationType(LocationType locationType) {
	        this.locationType = locationType;
	    }

	    public Location getParent() {
	        return parent;
	    }

	    public void setParent(Location parent) {
	        this.parent = parent;
	    }

	    public Set<Location> getChildren() {
	        return children;
	    }

	    public void setChildren(Set<Location> children) {
	        this.children = children;
	    
	    }


}
