import React from 'react';
import styled from 'styled-components';
import MenuItem from '../../components/MenuItem';

const MenuConteiner = styled.ul`
  list-style: none;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
`;

function MainMenu() {
  return (
    <MenuConteiner>
      <MenuItem text="Home" linkTo="/" />
      <MenuItem text="Account" linkTo="/" />
      <MenuItem text="Transfer" linkTo="/" target="_blank" />
    </MenuConteiner>
  );
}

export default MainMenu;
