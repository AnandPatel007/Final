package model;


import javafx.scene.image.Image;

public class Movie {
    String title;
    String type;
    String year;

    String released;
    String date;
    String genre;
    String awards;
    String posterUrl;
    public Movie(String title, String type, String year, String date, String genre, String awards, String poster) {
        this.title = title;
        this.type = type;
        this.year = year;
        this.released = null;
        this.date = date;
        this.genre = genre;
        this.awards = awards;
        this.posterUrl = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return posterUrl;
    }

    public void setPoster(String poster) {
        this.posterUrl = poster;
    }
    public String ToString() {
        return "Title: " + title + " Type: " + type + " Year: " + year + " Released: " + released + " Date: " + date + " Genre: " + genre + " Awards: " + awards + " Poster: " + posterUrl;
    }
}
