package sample.io.vote;

import net.minidev.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sample.domain.vote.Vote;
import sample.io.Api;
import sample.io.IoInterface;

import java.io.IOException;

public class VoteIo implements IoInterface<Vote, String> {

    private static VoteIo voteIo;
    private static RestTemplate restTemplate = new RestTemplate();
    private static HttpHeaders headers = new HttpHeaders();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static JSONObject personJsonObject;

    private static String voteURL= Api.getApi()+"vote/";

    public VoteIo()
    {}

    public static VoteIo getVoteIo() {
        if (voteIo==null){
            voteIo = new VoteIo();
        }
        return voteIo;
    }

    @Override
    public int create(Vote vote) throws IOException {
        String createPersonUrl = voteURL + "create";
        headers.setContentType(MediaType.APPLICATION_JSON);
        personJsonObject = new JSONObject();
        ResponseEntity<Vote> response = restTemplate.postForEntity(createPersonUrl, vote, Vote.class);
        return response .getStatusCode().value();
    }

    @Override
    public int update(Vote vote) throws IOException {
        String createPersonUrl = voteURL + "update";
        headers.setContentType(MediaType.APPLICATION_JSON);
        personJsonObject = new JSONObject();
        ResponseEntity<Vote> response = restTemplate.postForEntity(createPersonUrl, vote, Vote.class);
        return response.getStatusCode().value();
    }

    @Override
    public Vote read(String id) throws IOException {
        String readUrl = voteURL + "read?id="+id;
        ResponseEntity<Vote> response = restTemplate.getForEntity(readUrl,Vote.class);
        return response.getBody();
    }

    @Override
    public Boolean delete(String id) {
        String deleteUrl = voteURL + "delete?id="+id;
        ResponseEntity<Boolean> response = restTemplate.getForEntity(deleteUrl,Boolean.class);
        return response.getBody();
    }

    @Override
    public String readAll() {
        String deleteURL = voteURL + "readAll";
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

    public static void main(String[] args) {
        VoteIo voteIo = new VoteIo();
        System.out.println(voteIo.readAll());
    }
}
