package services;

import com.sun.source.tree.BreakTree;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SendHttpRequest {
  public String sendRequest(String userName) {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com/users/" + userName + "/events"))
            .header("Accept", "application/json")
            .GET()
            .build();

    try {
      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
      System.out.println("HTTP status code: " + response.statusCode());
      if (response.statusCode() == 200) {
        return response.body();
      }
      System.out.println("ERROr -> " + response.statusCode());
      return null;
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
