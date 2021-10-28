package com.accenture.corner.domain.review;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Review {

    @NotNull private String createdBy;
    @NotNull private Long createdAt;
    @NotNull private List<String> reviews;

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    public List<String> getReviews() {
        return reviews;
    }
}
