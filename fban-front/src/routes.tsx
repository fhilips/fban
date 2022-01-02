import React from 'react'

import { BrowserRouter, Route, Routes } from 'react-router-dom';


import Header from './compositions/header/Header';
import LandingPage from './compositions/landingpage';
import LoginPage from './compositions/loginpage';

const RoutesComponent = () => (
  <BrowserRouter>
    <Header />
    <Routes>
      <Route path="/" element={<LandingPage />} />
    </Routes>
    <Routes>
      <Route path="/login" element={<LoginPage />} />
    </Routes>
  </BrowserRouter>
)

export default RoutesComponent;
