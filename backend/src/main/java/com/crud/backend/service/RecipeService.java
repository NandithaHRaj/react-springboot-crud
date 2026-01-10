package com.crud.backend.service;

import com.crud.backend.model.RecipeModel;
import com.crud.backend.repository.RecipeRepository;
import com.crud.backend.repository.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public RecipeModel saveRecipe(RecipeModel recipeModel) {
        Recipe recipe = new Recipe(recipeModel);
        return new RecipeModel(recipeRepository.saveAndFlush(recipe));
    }

    public Page<Recipe> getAllRecipes(Pageable pageable) {
        return recipeRepository.findAllByOrderByCreatedDateDesc(pageable);
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(
        );
    }

    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

    public RecipeModel updateRecipe(Long id,RecipeModel recipeModel) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(recipe.isPresent()){
            Recipe updateRecipe = recipe.get();
            updateRecipe.setTitle(recipeModel.getTitle());
            updateRecipe.setIngredients(recipeModel.getIngredients());
            updateRecipe.setInstructions(recipeModel.getInstructions());
            updateRecipe.setTags(recipeModel.getTags());
            return new RecipeModel(recipeRepository.save(updateRecipe));
        }
        return null;
    }
}