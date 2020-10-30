package sample.domain.location;

public class Location {
    private String id;
    private String location;
    private String address;
    private String description;
    private String parentLocation;

    public Location() {
    }

    public Location(String id, String location, String address, String description, String parentLocation) {
        this.id = id;
        this.location = location;
        this.address = address;
        this.description = description;
        this.parentLocation = parentLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentLocation() {
        return parentLocation;
    }

    public void setParentLocation(String parentLocation) {
        this.parentLocation = parentLocation;
    }
}
