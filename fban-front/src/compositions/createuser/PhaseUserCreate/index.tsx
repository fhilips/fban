import { useState } from "react";
import styled from "styled-components";


const PhaseContainer = styled.div`
    width: 50%;
    display: flex;   
    align-items: center;   
    justify-content: space-between; 
    flex-wrap: wrap;
    
    .phase-icon-container {      
      position: block;    
      display: flex;      
      width: 100%;
      justify-content: center;
      align-items: center;

      .phase-line-separator {
        width: 45%;
        border-top: 1px solid  ${(props) => props.theme.colors.primary};
      }
    }   

    .phase-text {      
     width: 50%;
     display: flex;
     justify-content: center;
     margin: 15px 0;     
     font-size: 1rem;
    }    

    .text-selected {
      font-weight: bold;
    }

`
const PhaseIcon = styled.div`
  background-color: ${(props) => props.theme.colors.primary};
  width: 4vh;
  height: 4vh;
  border-radius: 50%;

  display: flex;
  justify-content: center;
  align-items: center;
  .phase-inside {
    background-color: ${(props) => props.theme.colors.white};
    width: 1vh;
    height: 1vh;
    border-radius: 50%;    
  }
  .selected {
    width: 1.5vh;
    height: 1.5vh;
    background-color: ${(props) => props.theme.colors.secondary};
    color: ${(props) => props.theme.colors.secondary}
  }
`
enum Phase {
  userCredencials,
  userDetails
}

type Props = {
  phaseSelected: Phase
}

function PhaseUserCreate({ phaseSelected }: Props) {

  return (
    <PhaseContainer>
      <div className="phase-icon-container">
        <PhaseIcon>
          <div className={phaseSelected === Phase.userCredencials ? 'phase-inside selected' : 'phase-inside'} />
        </PhaseIcon>
        <div className="phase-line-separator" />
        <PhaseIcon>
          <div className={phaseSelected === Phase.userDetails ? 'phase-inside selected' : 'phase-inside'} />
        </PhaseIcon>
      </div>

      <div className={phaseSelected === Phase.userCredencials ? 'phase-text text-selected' : 'phase-text'} >
        Insira seus dados
      </div>
      <div className={phaseSelected === Phase.userDetails ? 'phase-text text-selected' : 'phase-text'}>
        Detalhes do cliente
      </div>
    </PhaseContainer>
  );
}

export default PhaseUserCreate;
