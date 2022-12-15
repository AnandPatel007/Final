package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Movie;
import org.json.JSONObject;

import javax.swing.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//This is the controller class for the Main fxml file.
public class MainController {
    public static List<Movie> movieList;
    //Import all the fxml controls
    //TextFields
    @FXML
    private TextField search;
    //ImageViews
    @FXML
    private ImageView moviePoster;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    @FXML
    private ImageView image7;
    @FXML
    private ImageView image8;
    //Buttons
    @FXML
    private Button login;
    @FXML
    private Button myList;
    @FXML
    private Button play;
    @FXML
    private Button share;
    @FXML
    private Button searchbtn;
    @FXML
    private Button info;
    @FXML
    private Button actionMovies;
    @FXML
    private Button comedyMovies;
    @FXML
    private Button scifiMovies;
    @FXML
    private Button horrorMovies;
    @FXML
    private Button animationMovies;
    //Initialize method
    @FXML
    public void initialize() {
        //Set the images for the imageViews
        search.setPromptText("Search");
        //Stretch the images to fit the imageViews
        moviePoster.setPreserveRatio(false);
        moviePoster.setFitHeight(191);
        moviePoster.setFitWidth(456);
        moviePoster.setImage(new Image("/images/blackAdam.png"));
        image1.setPreserveRatio(false);
        image1.setFitHeight(36);
        image1.setFitWidth(109);

        //Set the icon to the buttons
        login.setGraphic(new ImageView(new Image("https://image.flaticon.com/icons/png/512/25/25231.png")));
        share.setGraphic(new ImageView(new Image("/images/share.png")));
        info.setGraphic(new ImageView(new Image("/images/info.png")));
        play.setGraphic(new ImageView(new Image("/images/play.png")));
        myList.setGraphic(new ImageView(new Image("/images/myList.png")));
        //Set imageview different images for the movie categories from the API https://rapidapi.com/rapidapi/api/movie-database-alternative
        image1.setImage(new Image("https://image.tmdb.org/t/p/w500/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg"));
        //Set imageview images from MoviePosterDB
        //Stretch the images to fit the imageViews
        image2.setPreserveRatio(false);
        image2.setFitHeight(36);
        image2.setFitWidth(109);
        image2.setImage(new Image("https://image.tmdb.org/t/p/w500/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg"));
        image3.setPreserveRatio(false);
        image3.setFitHeight(36);
        image3.setFitWidth(109);
        image3.setImage(new Image("https://image.tmdb.org/t/p/w500/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg"));
        image4.setPreserveRatio(false);
        image4.setFitHeight(36);
        image4.setFitWidth(109);
        image4.setImage(new Image("https://image.tmdb.org/t/p/w500/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg"));
        image5.setPreserveRatio(false);
        image5.setFitHeight(36);
        image5.setFitWidth(109);
        image5.setImage(new Image("https://image.tmdb.org/t/p/w500/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg"));
        image6.setPreserveRatio(false);
        image6.setFitHeight(36);
        image6.setFitWidth(109);
        image6.setImage(new Image("https://image.tmdb.org/t/p/w500/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg"));
        image7.setPreserveRatio(false);
        image7.setFitHeight(36);
        image7.setFitWidth(109);
        image7.setImage(new Image("https://image.tmdb.org/t/p/w500/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg"));
        image8.setPreserveRatio(false);
        image8.setFitHeight(36);
        image8.setFitWidth(109);
        image8.setImage(new Image("/images/blackAdam.png"));

        movieList = new ArrayList<>();
        //Get the movies from this API: https://rapidapi.com/rapidapi/api/movie-database-alternative

    }
    //Action Listeners for the buttons
    @FXML
    public void loginButtonClicked() {
        //Display Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login");
        alert.setHeaderText("LogIn Functionality is coming soon!!");
        alert.showAndWait();
    }
    static Movie getMovie(String title)
    {

        try {
            //replace any space within the Mov string to make it url friendly.
            title = title.trim().replace(" ","%20");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://movie-database-alternative.p.rapidapi.com/?s=" +title+"&r=json&page=1"))
                    .header("X-RapidAPI-Key", "8ecb910dc8msh030a3e8cce86d5ep13ee01jsn661ec74c2ed5")
                    .header("X-RapidAPI-Host", "movie-database-alternative.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            //Get the JSON file
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
            title = title.replace("%20"," ");
            Movie movie = new Movie(title, type, year, releaseDate, genre, awards, poster);
           // System.out.println(response.body());
            movieList.add(movie);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return movieList.get(0);
    }
    @FXML
    public void playButtonClicked() {
        //Display Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Play");
        alert.setHeaderText("Play Functionality is coming soon!!");
        alert.showAndWait();
        //JOptionPane.showMessageDialog(null,"Play Integration with Media Player is coming soon!.");
    }
    @FXML
    public void shareButtonClicked() {
        //Display Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Share");
        alert.setHeaderText("Sharing your List Functionality is coming soon!!");
        alert.showAndWait();

    }
    @FXML
    public void infoButtonClicked() {
        if(search.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter a movie title");
            alert.showAndWait();
        }
        else
        {
            //Get the movie from the API
            Movie movie = getMovie(search.getText());
            //Display Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Movie Info");
            alert.setContentText("Title: " + movie.getTitle() + "\n" +
                    "Type: " + movie.getType() + "\n" +
                    "Year: " + movie.getYear() + "\n" +
                    "Release Date: " + movie.getReleased() + "\n" +
                    "Genre: " + movie.getGenre() + "\n" +
                    "Awards: " + movie.getAwards() + "\n");
            alert.showAndWait();
        }

    }
    @FXML
    public void searchButtonClicked() {
    if(search.getText().isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Please enter a movie title");
                alert.showAndWait();
            }
            else
            {
                //Get the movie from the API
                Movie movie = getMovie(search.getText());
                //Display Alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Search");
                alert.setHeaderText("Enhanced Search Functionality is coming soon!!");
                alert.setContentText("Title: " + movie.getTitle() + "\n" +
                        "Type: " + movie.getType() + "\n" +
                        "Year: " + movie.getYear() + "\n" +
                        "Release Date: " + movie.getReleased() + "\n" +
                        "Genre: " + movie.getGenre() + "\n" +
                        "Awards: " + movie.getAwards() + "\n");
                alert.showAndWait();
            }
    }
    @FXML
    public void setMyListButtonClicked() {
        if(search.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter a movie title");
            alert.showAndWait();
        }
        else
        {
            //Get the movie from the API
            Movie movie = getMovie(search.getText());
            movieList.add(movie);
            //Display Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Movie Added to my list!!");
            alert.setContentText("Title: " + movie.getTitle() + "\n" +
                    "Type: " + movie.getType() + "\n" +
                    "Year: " + movie.getYear() + "\n" +
                    "Release Date: " + movie.getReleased() + "\n" +
                    "Genre: " + movie.getGenre() + "\n" +
                    "Awards: " + movie.getAwards() + "\n");
            alert.showAndWait();
        }

    }
    public List<Movie> getMoviewsByType(String type)
    {
        return movieList.stream().filter(movie -> movie.getType().equals(type)).collect(Collectors.toList());
    }
    @FXML
    public void actionMoviesButtonClicked() {
        //Create an Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Action Movies");
        alert.setHeaderText("Action Movies Functionality is coming soon!.");
        alert.showAndWait();

    }
    @FXML
    public void comedyMoviesButtonClicked() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Action Movies");
        alert.setHeaderText("Comedy Movies Functionality is coming soon!.");
        alert.showAndWait();
    }
    @FXML
    public void setScifiMovies() {
        //Display JOPtionPane
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sci-Fi Movies");
        alert.setHeaderText("Sci-Fi Movies Functionality is coming soon!.");
        alert.showAndWait();
    }
    @FXML
    public void setHorrorMovies() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sci-Fi Movies");
        alert.setHeaderText("Sci-Fi Movies Functionality is coming soon!.");
        alert.showAndWait();
    }
    @FXML
    public void setAnimationMovies() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Animation Movies");
        alert.setHeaderText("Animation Movies Functionality is coming soon!.");
        alert.showAndWait();
    }

}
