import React from 'react'

import { BrowserRouter, Route, Routes } from 'react-router-dom';


import Header from './compositions/header/Header';
import LandingPage from './compositions/landingpage/LandingPage';

const RoutesComponent = () => (
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Header />} />
    </Routes>
    <Routes>
      <Route path="/" element={<LandingPage />} />
    </Routes>
  </BrowserRouter>
)

export default RoutesComponent;
