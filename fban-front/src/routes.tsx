
import { BrowserRouter, Route, Routes } from 'react-router-dom';

import Header from './compositions/header/Header';
import MainMenu from './compositions/header/MainManu';
import LandingPage from './compositions/landingpage';
import LoginPage from './compositions/loginpage';
import Recover from './compositions/loginpage/Recover';

const RoutesComponent = () => (
  <BrowserRouter>

    <Routes>
      <Route path="/" element={
        <>
          <Header>
            <MainMenu />
          </Header>
          <LandingPage />
        </>
      } />
    </Routes>
    <Routes>
      <Route path="/login" element={<LoginPage />} />
      <Route path="/login/recover" element={<Recover />} />
    </Routes>

  </BrowserRouter>
)

export default RoutesComponent;
