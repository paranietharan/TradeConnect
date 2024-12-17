import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './Pages/LoginPage';
import SignUpPage from './Pages/SignUpPage';
import HomePage from './Pages/HomePage';
import AboutPage from './Pages/About';

function AppRoutes() {
  return (
    <Router>
      <Routes>
        <Route path="/log-in" element={<LoginPage />} />
        <Route path='/sign-up' element={<SignUpPage />} />
        <Route path='/home' element={<HomePage />} />
        <Route path='/' element={<AboutPage />} />
      </Routes>
    </Router>
  );
}

export default AppRoutes;