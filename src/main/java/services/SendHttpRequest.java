package services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SendHttpRequest {
  public void sendRequest(String userName) {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com/users/" + userName + "/events"))
            .GET()
            .build();

    try {
      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
      System.out.println("HTTP status code: " + response.statusCode());
      System.out.println("\n" + response.body());
      System.out.println(response.version());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(request);
  }
}
