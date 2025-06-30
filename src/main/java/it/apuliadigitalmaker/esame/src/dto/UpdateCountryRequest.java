package it.apuliadigitalmaker.esame.src.dto;

public class UpdateCountryRequest {
    private Boolean visited;
    private String notes;
    private Integer rating;

    public UpdateCountryRequest() {
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}