import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class InfoAPI {
    String apikey = "d829809fb05f34f06290b130";
    public Map<String, Double> getInformation(String fromC){
        // Get the information
        URI endpoint = URI.create("https://v6.exchangerate-api.com/v6/" + apikey + "/latest/" + fromC);
        // Create the client and request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endpoint)
                .build();
        // Make the request
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            GsonFormat body = gson.fromJson(response.body(), GsonFormat.class);
            // Return only the currency conversions
            return body.getConversion_rates();
        } catch (Exception e){
            throw new RuntimeException("Invalid currency code");
        }
    }

    public double makeConversion(String fromC, String toC, Double amount){
        // Get all the currency conversions
        Map<String, Double> info = getInformation(fromC);
        // Return the conversion as a double
        return amount * info.get(toC);
    }
}
