import React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import './App.css';
import HomePage from './pages/home/homepage.component';
import LoginPage from './pages/login/login-registerpage.component';
import MyQuestsPage from './pages/myquests/myquests.component';
import MyStartedQuestPage from './pages/myquests/started/mystartedquests.component';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path='/' element={<Navigate to='/home' replace />} />
          <Route exact path='/home' element={<HomePage />} /> 
          <Route exact path='/login' element={<LoginPage />} /> 
          <Route exact path='/mystartedquests' element={<MyStartedQuestPage />} /> 
          <Route exact path='/myquests' element={<MyQuestsPage />} /> 
        </Routes>
      </Router>
    </div>
  );
}

export default App;
