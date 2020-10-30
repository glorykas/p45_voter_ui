package sample.io.user;

import sample.domain.user.Party;

import java.util.List;

public class PartyList {
    private List<Party> partyList;

    public PartyList(List<Party> partyList) {
        this.partyList = partyList;
    }

    public PartyList() {
    }

    public List<Party> getPartyList() {
        return partyList;
    }

    public void setPartyList(List<Party> partyList) {
        this.partyList = partyList;
    }

    public static void main(String[] args) {

    }
}
