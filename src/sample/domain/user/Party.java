package sample.domain.user;

public class Party {
    private String id;
    private String name;
    private String abbreviation;
    private byte[] flag;

    public Party() {
    }

    public Party(String id, String name, String abbreviation, byte[] flag) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.flag = flag;
    }

    public byte[] getFlag() {
        return flag;
    }

    public void setFlag(byte[] flag) {
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static void main(String[] args) {

    }
}
