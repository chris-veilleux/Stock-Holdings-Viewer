package com.example.comp1011assignment2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class APIUtility {
    /**
     * Method to call the SimpleStockTracker API
     * @return Holding - The Java object created from the JSON
     */
    public static void getHoldingsFromSSS() throws IOException, InterruptedException {
        // Uniform Resource Identifier for API to be used
        String uri = "https://simplestocktracker.azurewebsites.net/api/holdings";

        // Create the client and request objects
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        // Write the response to a file, named jsonData.json
        HttpResponse<Path> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofFile(Paths.get("jsonData.json")));
    }

    /**
     * Read the jsonData.json file and create a list of Holding objects
     */
    public static List<Holding> getHoldingsFromJsonFile()
    {
        // GSON object
        Gson gson = new Gson();

        // Calling the api returns multiple responses, each containing data about one holding. All responses are stored in a List object
        List<Holding> apiResponses = null;

        try(
                // read from the json file in the root of the project
                FileReader fileReader = new FileReader("jsonData.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            // save the api responses to the apiResponses List
            apiResponses = gson.fromJson(jsonReader, new TypeToken<ArrayList<Holding>>(){}.getType());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return apiResponses;
    }
}
