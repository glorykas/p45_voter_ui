package sample.domain.vote;

public class Vote {
    private String id;
    private String candidateId;
    private String date;
    private  String locationId;
    private String voterId;


    public Vote() {
    }

    public Vote(String id, String candidateId, String date, String locationId,String voterId) {
        this.id = id;
        this.candidateId = candidateId;
        this.date = date;
        this.locationId = locationId;
        this.voterId = voterId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
