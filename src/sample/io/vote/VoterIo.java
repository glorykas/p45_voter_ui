package sample.io.vote;

import net.minidev.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import sample.domain.vote.Voter;
import sample.io.Api;
import sample.io.IoInterface;

import java.io.IOException;


public class VoterIo implements IoInterface<Voter, Integer> {


    private static VoterIo voterIo;

    private static RestTemplate restTemplate= new RestTemplate();
    private static HttpHeaders headers = new HttpHeaders();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static JSONObject personJsonObject;
    private static String voteURL = Api.getApi() + "voter/";

    public VoterIo() {
    }

    public static VoterIo getVoterIo() {
        if (voterIo == null) {
            voterIo = new VoterIo();
        }
        return voterIo;
    }

    @Override
    public int create(Voter voter) throws IOException {
        String createPersonUrl = voteURL + "create";
        headers.setContentType(MediaType.APPLICATION_JSON);
        personJsonObject = new JSONObject();
        ResponseEntity<Voter> response = restTemplate.postForEntity(createPersonUrl, voter, Voter.class);
        //System.out.println(response.getBody().getId());
        return response.getStatusCode().value();
    }

    @Override
    public int update(Voter voter) throws IOException {
        String createPersonUrl = voteURL + "update";
        headers.setContentType(MediaType.APPLICATION_JSON);
        personJsonObject = new JSONObject();
        ResponseEntity<Voter> response = restTemplate.postForEntity(createPersonUrl, voter, Voter.class);
        //System.out.println(response.getBody().getId());
        return response.getStatusCode().value();
    }

    @Override
    public Voter read(String id) throws IOException {
        String readURL = voteURL + "read?id="+id;
        ResponseEntity<Voter> response = restTemplate.getForEntity(readURL,Voter.class);
        //System.out.println(response.getBody().getId());
        return response.getBody();
    }

    @Override
    public Boolean delete(String id) {
        String deleteURL = voteURL + "delete?id="+id;
        ResponseEntity<Boolean> response = restTemplate.getForEntity(deleteURL, Boolean.class);
        //System.out.println(response.getBody());
        return response.getBody();
    }
    @Override
    public String readAll() {
        String deleteURL = voteURL + "reads";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(deleteURL, HttpMethod.GET,entity, String.class);
        //System.out.println(response.getBody());
        return response.getBody();
    }

    @Override
    public Long count() {
        String deleteURL = voteURL + "count";
        ResponseEntity<Long> response = restTemplate.getForEntity(deleteURL, Long.class);
        return response.getBody();
    }

    public static void main(String[] args) throws IOException {
        VoterIo voterIo = new VoterIo();
        System.out.println(voterIo.read("0102").toString());
    }
}
