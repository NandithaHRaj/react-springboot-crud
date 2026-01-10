package com.crud.backend.controller;

import com.crud.backend.model.RecipeModel;
import com.crud.backend.repository.entity.Recipe;
import com.crud.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public ResponseEntity<RecipeModel> saveRecipe(@RequestBody RecipeModel recipe){
        RecipeModel newRecipe = recipeService.saveRecipe(recipe);
        return new ResponseEntity<>(newRecipe,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeModel> updateRecipe(@PathVariable Long id, @RequestBody RecipeModel recipe){
        RecipeModel updatedRecipe = recipeService.updateRecipe(id,recipe);
        return ResponseEntity.ok(updatedRecipe);
    }

    @GetMapping
    public ResponseEntity<List<RecipeModel>>  getAllRecipes(Pageable pageable){
        Page<Recipe> recipes = recipeService.getAllRecipes(pageable);
        Page<RecipeModel> recipeModel = recipes.map(RecipeModel::new);
        return new ResponseEntity<>(recipeModel.getContent(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeModel>  getRecipeById(@PathVariable Long id){
        Recipe recipe = recipeService.getRecipeById(id);
        return new ResponseEntity<>(new RecipeModel(recipe), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteRecipeById(@PathVariable Long id){
        recipeService.deleteRecipeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}