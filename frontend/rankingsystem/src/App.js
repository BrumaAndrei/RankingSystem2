import React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import './App.css';
import HomePage from './pages/home/homepage.component';
import LoginPage from './pages/login/login-registerpage.component';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path='/' element={<Navigate to='/login' replace />} />
          <Route exact path='/home' element={<HomePage />} /> 
          <Route exact path='/login' element={<LoginPage />} /> 
        </Routes>
      </Router>
    </div>
  );
}

export default App;
