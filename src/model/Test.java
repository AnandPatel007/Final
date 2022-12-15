package model;

import javafx.scene.image.Image;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {
    public static void main(String[] args) {
        try
        {
            String title = "The Matrix";
            title = title.trim().replace(" ","%20");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://movie-database-alternative.p.rapidapi.com/?s=" +title+"&r=json&page=1"))
                    .header("X-RapidAPI-Key", "8ecb910dc8msh030a3e8cce86d5ep13ee01jsn661ec74c2ed5")
                    .header("X-RapidAPI-Host", "movie-database-alternative.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            //Print the JSON file
            System.out.println(response.body());
            String json = response.body();
            //Parse the JSON file
            JSONObject obj = new JSONObject(json);
            //Get the Movie Type
            String type = obj.getJSONArray("Search").getJSONObject(0).getString("Type");
            //Get the Movie year
            String year = obj.getJSONArray("Search").getJSONObject(0).getString("Year");
            //Get the Movie Poster
            String poster = obj.getJSONArray("Search").getJSONObject(0).getString("Poster");
            //Get the Release Date
            String releaseDate = obj.getJSONArray("Search").getJSONObject(0).getString("Year");
            //Get the awards
            String awards = obj.getJSONArray("Search").getJSONObject(0).getString("imdbID");
            //Get the Genre
            String genre = obj.getJSONArray("Search").getJSONObject(0).getString("Type");
            // Create a new Movie object
            Movie movie = new Movie(title, type, year, releaseDate, genre, awards, poster);
            // System.out.println(response.body());
            System.out.println(movie.ToString());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
