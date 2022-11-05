package com.milon.milonproject.Model;

public class ObjectDataClass {



    String original_title;
    String release_date;
    String vote_average;
    String poster_path;


    public ObjectDataClass() {
    }

    public ObjectDataClass(String original_title, String release_date, String vote_average, String poster_path) {
        this.original_title = original_title;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.poster_path = poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
