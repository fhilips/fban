import styled from 'styled-components';

export const CardConteiner = styled.li`
  min-height: 350px;
  min-width: 350px; 
  font-size: 20px;
  line-height: 24px;
  font-weight: 500;  
  color: ${props => props.theme.colors.primary};
  background-color: ${props => props.theme.colors.primary};
 
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  transition: 0.5s;  

  background: rgba( 255, 255, 255, 0.2 );
  box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
  backdrop-filter: blur( 4.5px );
  -webkit-backdrop-filter: blur( 4.5px );  
  border-radius: 5px;
  border: 1px solid rgba( 255, 255, 255, 0.18 );
  border-top: 10px solid ${props => props.theme.colors.primary};

  @media (min-width: 40rem) {
    padding: 1rem 1.5rem;
  }
`;
