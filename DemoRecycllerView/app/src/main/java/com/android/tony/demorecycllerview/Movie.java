package com.android.tony.demorecycllerview;

public class Movie {

    String title,genre,year;

    Movie(String title,String genre,String year)
    {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }
}
