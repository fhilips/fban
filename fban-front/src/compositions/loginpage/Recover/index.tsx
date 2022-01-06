
import styled from "styled-components";


const Main = styled.main`
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
  width: 100%;
  padding-top: 152px;
  background-color: ${(props) => props.theme.colors.white};

  background-repeat: no-repeat;
  background-position: bottom center;

  h1 { 
    align-self: center;
    font-family: Poppins;
    margin-bottom: 8px;
  }  
  
  @media (max-width: 560px) {
    padding-top: 102px;
  }
`;

function Recover() {

  return (
    <Main>
      <h1>Recover</h1>
    </Main >
  );
}

export default Recover;
