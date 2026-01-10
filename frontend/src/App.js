import './App.css';
import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListComponents from './components/ListComponents';
import AddRecipe from './components/AddRecipeComponent';

function App() {
  return (
    <div>
      <Router>
       <HeaderComponent />
       <div className="container">
        <Routes>
           localhost:3000/
          <Route path="/" element={<ListComponents/>}></Route>
          <Route path="/recipes" element={<ListComponents/>}></Route>
          <Route path="/add-recipe" element={<AddRecipe/>}></Route>
          <Route path="/edit-recipe/:id" element={<AddRecipe/>}></Route>
        </Routes>
       </div>
       <FooterComponent />
       </Router>
    </div>
  );
}

export default App;
