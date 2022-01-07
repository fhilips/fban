import { useState } from "react";
import styled from "styled-components";
import Wave from "../../assets/wave.svg";
import { FormRow, TextInput } from "../../components/Forms/FormContent";
import MainButton from "../../components/MainButton";
import { requestBackendLogin } from "../../services/requests";
import { saveAuthData } from "../../services/storage";
import PhaseUserCreate from "./PhaseUserCreate";

const Main = styled.main`
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
  justify-content: center;
  background-color: ${(props) => props.theme.colors.white};
  background-image: url(${Wave});
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

  .new-account {
    margin-top: 30px;
    font-size: 1.3rem;
    color: ${props => props.theme.colors.white};

    a { 
      color: ${props => props.theme.colors.white};
      box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
      backdrop-filter: blur( 4.5px );
      -webkit-backdrop-filter: blur( 4.5px );       
    }
    a:hover {       
      opacity: 0.8;
      background: -webkit-linear-gradient(#eee, ${props => props.theme.colors.secondary});
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
    }
  }
`;

const InvalidLogin = styled.div`
  padding: 5px;
  border: 1px solid ${props => props.theme.colors.white};
  border-radius: 3px;
  color: ${props => props.theme.colors.white};  
  background-color: ${props => props.theme.colors.invalid};
  box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
  backdrop-filter: blur( 4.5px );
  -webkit-backdrop-filter: blur( 4.5px ); 
  font-size: 15px;
  opacity: 0.6;
`;

const FormCadastro = styled.form`
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
  border-left: 10px solid ${props => props.theme.colors.primary};

  .separator {
    width: 70%;
    align-self: center;
    border-top: 1px solid ${props => props.theme.primary};
  }
  @media (min-width: 40rem) {
    padding: 1rem 1.5rem;
  }
 `;

export enum Phase {
  userCredencials,
  userDetails
}

function CreateUser() {
  const [phaseSelected, setPhaseSelected] = useState<Phase>(Phase.userCredencials);
  const [username, setUsername] = useState("");
  const [usernameInvalid, setUsernameInvalid] = useState(false);
  const [password, setPassword] = useState("");
  const [passwordInvalid, setPasswordInvalid] = useState(false);
  const [loginInvalid, setLoginInvalid] = useState(false);

  function handleUsernameChange(event: React.ChangeEvent<HTMLInputElement>) {
    setUsername(event.target.value);
  }
  function handlePasswordChange(event: React.ChangeEvent<HTMLInputElement>) {
    setPassword(event.target.value);
  }
  function checkUsernameValue() {
    if (!username) {
      setUsernameInvalid(true);
    } else {
      setUsernameInvalid(false);
    }
  }
  function checkPasswordValue() {
    if (!password) {
      setPasswordInvalid(true);
    } else {
      setPasswordInvalid(false);
    }
  }

  function handleFormSubmit(event: React.FormEvent<HTMLFormElement>) {
    const formData = { username, password }
    event.preventDefault();
    requestBackendLogin(formData)
      .then((response) => {
        saveAuthData(response.data);
        console.log(response)
        setLoginInvalid(false);
      })
      .catch((error) => {
        console.log('ERRO', error);
        setLoginInvalid(true);
      });
  }

  return (
    <Main>
      <PhaseUserCreate phaseSelected={phaseSelected} />
      <FormCadastro onSubmit={handleFormSubmit}>
        <h1>Create</h1>
        <FormRow>

          <TextInput
            type="text"
            id="input-nome"
            placeholder="Email or Username"
            className={usernameInvalid ? 'invalid' : ''}
            onBlur={checkUsernameValue}
            onChange={handleUsernameChange}
          />
        </FormRow>
        <FormRow>
          <TextInput
            type="password"
            id="input-nome"
            className={passwordInvalid ? 'invalid' : ''}
            placeholder="Password"
            onBlur={checkPasswordValue}
            onChange={handlePasswordChange}
          />
        </FormRow>
        {loginInvalid &&
          <InvalidLogin>
            Email or Password Invalid!
          </InvalidLogin>
        }

        <MainButton text="LOGIN" />
        <div className="separator" />
        <span>Forgot your password? <a href="/">Click Here</a></span>

      </FormCadastro>
      <strong className="new-account">or <a href="/newuser">Create new account</a></strong>
    </Main >
  );
}

export default CreateUser;
