import React, { useEffect, useState, useTransition } from 'react'
import {useNavigate, useParams, Link, useFetcher} from 'react-router-dom'
import RecipeService from '../services/RecipeService'

const AddRecipe = () => {

    const [title, setTitle] = useState('')
    const [ingredients, setIngredients] = useState('')
    const [instructions, setInstructions] = useState('')
    const [tags, setTags] = useState('')
    const navigate = useNavigate();
    const {id} = useParams();

    const saveOrUpdateRecipe = (e) => {
        e.preventDefault();

        const recipe = {title, ingredients, instructions, tags}

        if(id){

            RecipeService.updateRecipe(id, recipe).then((response) =>{
                navigate('/recipes')
            }).catch(error => {
                console.log(error);
            })
        }else{

        RecipeService.addRecipe(recipe).then((response) => {
            console.log(response.data);
            navigate('/recipes');

        }).catch(error => {
          console.log(error);
        })
    }
    }

    useEffect(() => {
        RecipeService.getRecipeById(id).then((response) => {
            setTitle(response.data.title)
            setIngredients(response.data.ingredients)
            setInstructions(response.data.instructions)
            setTags(response.data.tags)
        }).catch(error => {
            console.log(error);
        })  
    }, [])
    
    const heading = () => {
        if(id) {
            return <h2 className="text-center"> Update Recipe </h2>
        }else{
            return <h2 className="text-center"> Add Recipe </h2>
        }
    }

  return (
    <div>
        <br/> 
        <div className='container'>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    {
                        heading()
                    }
                     <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                <label className="form-label">Title</label>
                                <input type="text" placeholder="Recipe name here" name="title" className="form-control" value={title} onChange={(e) => setTitle(e.target.value)}></input>
                            </div>

                            <div className='form-group mb-2'>
                                <label className="form-label">Ingredients</label>
                                <input type="text" placeholder="Recipe ingredients here" name="ingredients" className="form-control" value={ingredients} onChange={(e) => setIngredients(e.target.value)}></input>
                            </div>

                            
                            <div className='form-group mb-2'>
                                <label className="form-label">Instructions</label>
                                <input type="text" placeholder="Recipe instructions here" name="instructions" className="form-control" value={instructions} onChange={(e) => setInstructions(e.target.value)}></input>
                            </div>

                            
                            <div className='form-group mb-2'>
                                <label className="form-label">Tags</label>
                                <input type="text" placeholder="Tag the recipe" name="tags" className="form-control" value={tags} onChange={(e) => setTags(e.target.value)}></input>
                            </div>

                            <button className="btn btn-success" onClick={(e) => saveOrUpdateRecipe(e)} style={{marginRight:"10px"}} > Save Recipe </button>
                            <Link to="/recipes" className="btn btn-danger" > Cancel </Link>

                        </form>
                     </div>

                </div>

            </div>
        </div>
    </div>
  )
}

export default AddRecipe
