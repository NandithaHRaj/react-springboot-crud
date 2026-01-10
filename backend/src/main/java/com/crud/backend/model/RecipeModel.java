package com.crud.backend.model;

import com.crud.backend.repository.entity.Recipe;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class RecipeModel {
    private Long id;
    private String title;
    @Column(length = 2000)
    private String ingredients;
    @Column(length = 5000)
    private String instructions;
    private String tags;
    private LocalDateTime createdDate = LocalDateTime.now();

    public RecipeModel() {
    }

    public RecipeModel(Recipe recipe) {
        this.id = recipe.getId();
        this.title = recipe.getTitle();
        this.ingredients = recipe.getIngredients();
        this.instructions = recipe.getInstructions();
        this.tags = recipe.getTags();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
