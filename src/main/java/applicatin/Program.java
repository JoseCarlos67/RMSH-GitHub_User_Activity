package applicatin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.GitHubEvent;
import services.SendHttpRequest;

import java.util.List;

public class Program {
  public static void main(String[] args) throws JsonProcessingException {
    SendHttpRequest sendHttpRequest = new SendHttpRequest();

    String jsonResponse = sendHttpRequest.sendRequest("JoseCarlos67");

    ObjectMapper objectMapper = new ObjectMapper();
    List<GitHubEvent> gitHubEventList = objectMapper.readValue(jsonResponse, new TypeReference<List<GitHubEvent>>() {
    });

    for (GitHubEvent obj : gitHubEventList) {
      System.out.println(obj);
    }
  }
}
