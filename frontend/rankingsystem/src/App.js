import React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import './App.css';
import HomePage from './pages/home/homepage.component';
import LoginPage from './pages/login/login-registerpage.component';
import JudgeQuestPage from './pages/myquests/judge/judgequest.component';
import MyQuestsPage from './pages/myquests/myquests.component';
import MyStartedQuestPage from './pages/myquests/started/mystartedquests.component';
import StartQuestPage from './pages/myquests/startquest/startquest.component';
import RankingPage from './pages/ranking/ranking.component';

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
          <Route exact path='/startquest' element={<StartQuestPage />} /> 
          <Route exact path='/judge' element={<JudgeQuestPage />} /> 
          <Route exact path='/ranking' element={<RankingPage />} /> 
        </Routes>
      </Router>
    </div>
  );
}

export default App;
