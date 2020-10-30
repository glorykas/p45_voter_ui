package sample.domain.vote;

public class Vote {
    private String id;
    private String candidateId;
    private String date;
    private  String location;

    public Vote() {
    }

    public Vote(String id, String candidateId, String date, String location) {
        this.id = id;
        this.candidateId = candidateId;
        this.date = date;
        this.location = location;
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

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
