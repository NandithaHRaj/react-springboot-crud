import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import RecipeService from '../services/RecipeService'

const ListComponents = () => {
    const [recipes, setRecipes] = useState([])

    useEffect(() => {
        getAllRecipes();
    }, [])

    const getAllRecipes = () => {
        RecipeService.getAllRecipes().then( (response) => {
                setRecipes(response.data)
                console.log(response.data);
            }).catch(error => {
            console.log(error);
            })  
    }

    const deleteRecipe =  (id)  => {
        RecipeService.deleteRecipeById(id).then((response) => {
        getAllRecipes();
        }).catch(error => {
            console.log(error);
        })
    }

  return (
    <div className="container">
        <h2 className="text-centered">Recipes List</h2>
        <Link to="/add-recipe" className="btn btn-primary mb-2">Add Recipe</Link>
        <table className="table table-bordered table-striped">
            <thead>
                <th>No.</th>
                <th>Title</th>
                <th>Tags</th>
                <th>Ingredients</th>
                <th>Instructions</th>
                <th>Actions</th>
            </thead>
            <tbody>
                {
                    recipes.map(
                        recipe =>
                            <tr key = {recipe.id}>
                            <td>{recipe.id}</td>
                            <td>{recipe.title}</td>
                            <td>{recipe.tags}</td>
                            <td>{recipe.ingredients}</td>
                            <td style={{ whiteSpace: "pre-line" }} >{recipe.instructions}</td>
                            <td>
                                <Link className="btn btn-info" to={`/edit-recipe/${recipe.id}`}> Update </Link>
                                <button className="btn btn-danger" onClick={() => deleteRecipe(recipe.id)} style={{marginLeft:"10px"}}> Delete </button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
      
    </div>
  )
}

export default ListComponents
