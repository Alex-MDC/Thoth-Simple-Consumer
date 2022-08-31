package com.thothconsumer;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonStreamParser;

import org.json.JSONObject;
/**
 * Hello world!
 *
 */
import com.thothconsumer.TranscribeRequest;
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {
       printMenu();
       Scanner input = new Scanner(System.in);
       int expression = input.nextInt();
       do {
        //expression = input.nextInt();
        switch(expression) {
            case 1:
              // code block
              greetServer();
              printMenu();
              expression = input.nextInt();
              break;
            case 2:
              // code block
              buildPost();
              printMenu();
              expression = input.nextInt();
              break;
            case 3:
              // code block
              StartClient();
              printMenu();
              expression = input.nextInt();
              break;
            case 4:
              // code block
              beginJob();
              printMenu();
              expression = input.nextInt();
              break;
            case 5:
              // code block
              CheckJobStatus();
              printMenu();
              expression = input.nextInt();
              break;
            case 6:
              // code block
              getTranscript();
              printMenu();
              expression = input.nextInt();
              break;
            case 7:
              // code block
              uploadTranscript();
              printMenu();
              expression = input.nextInt();
              break;
            case 8:
              // code block
              closeClient();
              printMenu();
              expression = input.nextInt();
              break;
            default:
              printMenu();
              
          }
       } while (expression != 22);
       
    }

    public static void printMenu(){
        System.out.println("Thoth Menu: \n 1: Greet server \n 2: buildPost \n 3: StartClient \n 4: BeginJob \n 5:Check Job status\n 6:getTranscript\n 7:Upload transcript\n 8:close client\n22:exit");
    }

    public static void greetServer(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
               .uri(new URI("http://localhost:8080"))
               .GET()
               .build();
    
            HttpClient httpClient = HttpClient.newHttpClient();
    
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            System.out.println(getResponse.body());
    
            
    
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void buildPost(){

        //NOTE: Transcribe request class is not needed to run program. You just need any object that can work as a means to store the 
        // POST data to then be converted into JSON. You can also just build the jason with the Keys and values directly
        // I used the TranscribeRequest class just for consistency and clarity with the API code / to explain
        TranscribeRequest transcribeRequest = new TranscribeRequest();
        transcribeRequest.setJobName("testing-credentials-withID");
        transcribeRequest.setMediaFileUri("s3://aws-med-audios/test-audios/07401/MR10001-202207111239.mp3");
        transcribeRequest.setDoctorID("07401");
        transcribeRequest.setOutputBucket("aws-med-audios");
        transcribeRequest.setRegion("us-east-1");
        // for safety, edit out your credentials when not working locally
        transcribeRequest.setAccessKeyId("xxxx");
        transcribeRequest.setSecretAccessKey("xxxxx");
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcribeRequest);
        JsonObject json = (JsonObject) JsonParser.parseString(jsonRequest);

        System.out.println(jsonRequest+"\n");

        try {
            HttpRequest postRequest = HttpRequest.newBuilder()
               .uri(new URI("http://localhost:8080/transcribereq"))
               .header("Content-Type", "application/json")
               .POST(BodyPublishers.ofString(json.toString()))
               .build();
    
            HttpClient httpClient = HttpClient.newHttpClient();
    

            //TODO handle respomse, json is unsupported?
            HttpResponse<String> getResponse = httpClient.send(postRequest, BodyHandlers.ofString());
            System.out.println(getResponse.body());
            
            
    
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void StartClient(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
               .uri(new URI("http://localhost:8080/startTranscribeClient"))
               .GET()
               .build();
    
            HttpClient httpClient = HttpClient.newHttpClient();
    
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            System.out.println(getResponse.body());
    
            
    
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void beginJob(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
               .uri(new URI("http://localhost:8080/startTranscription"))
               .GET()
               .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            System.out.println(getResponse.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void CheckJobStatus(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
               .uri(new URI("http://localhost:8080/jobStatus"))
               .GET()
               .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            System.out.println(getResponse.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void getTranscript(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
               .uri(new URI("http://localhost:8080/getTranscription"))
               .GET()
               .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            System.out.println(getResponse.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void uploadTranscript(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
               .uri(new URI("http://localhost:8080/uploadTranscription"))
               .GET()
               .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            System.out.println(getResponse.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void closeClient(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
               .uri(new URI("http://localhost:8080/closeTranscribeClient"))
               .GET()
               .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            System.out.println(getResponse.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
