package com.example.finalprojectbbcnews;

import java.util.ArrayList;

public class main {

    private String status;
    private String totalResults;
    private ArrayList<news_list> articles;

    public main(String status, String totalResults, ArrayList<news_list> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<news_list> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<news_list> articles) {
        this.articles = articles;
    }
}
