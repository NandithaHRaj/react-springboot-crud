import axios from 'axios'

const RECIPES_BASE_URL = 'http://localhost:8080/recipes'

class RecipeService {
    getAllRecipes(){
      return axios.get(RECIPES_BASE_URL)
    }

    addRecipe(recipe){
      return axios.post(RECIPES_BASE_URL, recipe)
    }

    getRecipeById(id){
      return axios.get(RECIPES_BASE_URL + '/' + id)
    }

    updateRecipe(id,recipe){
      return axios.put(RECIPES_BASE_URL + '/' + id, recipe)
    }

    deleteRecipeById(id){
      return axios.delete(RECIPES_BASE_URL + '/' + id)
    }
}

export default new RecipeService();