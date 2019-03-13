package com.example.vijjereddy.githubquery;

public class GithubQueryModel {
    String job;
    String location;
    String how_to_apply;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHow_to_apply() {
        return how_to_apply;
    }

    public void setHow_to_apply(String how_to_apply) {
        this.how_to_apply = how_to_apply;
    }

    public GithubQueryModel(String job, String location, String how_to_apply) {

        this.job = job;
        this.location = location;
        this.how_to_apply = how_to_apply;
    }
}
