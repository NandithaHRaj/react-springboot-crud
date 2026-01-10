package com.crud.backend.repository.entity;

import com.crud.backend.model.RecipeModel;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 2000)
    private String ingredients;
    @Column(length = 5000)
    private String instructions;
    private String tags;
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    public Recipe() {
    }

    public Recipe(RecipeModel recipeModel) {
        this.title = recipeModel.getTitle();
        this.ingredients = recipeModel.getIngredients();
        this.instructions = recipeModel.getInstructions();
        this.tags = recipeModel.getTags();
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