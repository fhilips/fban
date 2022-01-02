import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import PropTypes from 'prop-types';

const CustomLink = styled(Link)`
  text-decoration: none;
  color: unset;
  height: 100%;
  display: flex;
`;

const MenuItemConteiner = styled.li`
  min-height: 80px;
  padding: 0.5rem 0.75rem;
  font-size: 20px;
  line-height: 24px;
  font-weight: 500;
  text-align: center;
  color: ${props => props.theme.colors.white};
  margin: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: 0.5s;
  opacity: 0.8;

  .selected {    
    color: ${props => props.theme.colors.white};
    font-weight: bold;    
  }

  .span {
    margin: 0;
    padding: 0;
  }

  &:hover {
    background-color: ${props => props.theme.colors.secondary};  
    opacity: 1;     
    border: 0px solid rgba( 255, 255, 255, 0.18 );    
  }

  @media (min-width: 40rem) {
    padding: 1rem 1.5rem;
  }
`;

type Props = {
  text: string;
  linkTo: string
  target: string
}

function MenuItem({ text, linkTo, target }: Props) {

  return (
    <CustomLink to={linkTo} target={target}>
      <MenuItemConteiner>
        <span className={target === '_blank' ? 'selected' : ''}>{text}</span>
      </MenuItemConteiner>
    </CustomLink>
  )
}

MenuItem.defaultProps = {
  target: '_self',
}

MenuItem.propTypes = {
  text: PropTypes.string.isRequired,
  linkTo: PropTypes.string.isRequired,
  target: PropTypes.string
}

export default MenuItem;
