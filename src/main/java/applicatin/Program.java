package applicatin;

import services.SendHttpRequest;

public class Program {
  public static void main(String[] args) {
    System.out.println("Hello World");
    SendHttpRequest sendHttpRequest = new SendHttpRequest();
    sendHttpRequest.sendRequest("JoseCarlos67");
  }
}
