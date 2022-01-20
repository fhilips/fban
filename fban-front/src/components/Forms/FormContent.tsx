import InputMask from "react-input-mask";
import styled from "styled-components";

export const FormRow = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  position: relative;   
`;

export const Label = styled.label`
  font-size: 16px;
  color: ${(props) => props.theme.colors.primary};
  font-weight: 400;
  line-height: 1.6;
  margin: 5px 0 3px 0;
`;

export const TextInput = styled.input`
  border: 1px solid #dadada;
  height: auto;
  font-size: 18px;
  line-height: 24px;
  color: ${(props) => props.theme.colors.primary};
  -webkit-box-flex: 1;
  flex-grow: 1;
  width: 100%;
  padding: 12px 8px;  

  &.invalid {
    border: 1px solid ${(props) => props.theme.colors.invalid};
  }

  &:hover:not(.invalid),
  &:focus:not(.invalid) {
    border: 1px solid ${(props) => props.theme.colors.primary};
  }

  &::placeholder {
    color: ${(props) => props.theme.colors.primary};
    font: 15px Poppins;
  }
`;

export const CheckboxInput = styled.input`
  position: relative;
  margin-right: 16px;
  border: 1px solid #b3b3b3;
  box-sizing: border-box;
  box-shadow: inset 0 0 0 #e5e5e5;
  width: 26px;
  height: 26px;
  border-radius: 50%;
  outline: none;
  -webkit-appearance: none;
  appearance: none;
  -webkit-flex-shrink: 0;
  flex-shrink: 0;

  &:checked {
    background-color: ${(props) => props.theme.colors.primary};
  }

  &::before {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    content: "";
    background: #fff;
    border-radius: 50%;
  }
  
  &:checked::before {
    background: ${(props) => props.theme.colors.primary};
  }

  &:checked::after {
    position: absolute;
    content: "";
    top: 25%;
    left: 25%;
    width: 4px;
    height: 4px;
    padding: 4px;
    border-radius: 50%;
    background: #fff;
    box-shadow: 0 1px 1px #e5e5e5;
  }
`;
