import { useState } from "react";
import styled from "styled-components";
import Wave from "../../assets/wave.svg";
import { CardConteiner } from "../../components/Card";
import { FormRow, TextInput } from "../../components/Forms/FormContent";
import MainButton from "../../components/MainButton";
import { requestBackendLogin } from "../../services/requests";
import { saveAuthData } from "../../services/storage";

const Main = styled.main`
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
  width: 100%;
  padding-top: 152px;
  background-color: ${(props) => props.theme.colors.white};
  background-image: url(${Wave});
  background-repeat: no-repeat;
  background-position: bottom center;

  h1 { 
    align-self: center;
    font-family: Poppins;
  }  
  
  @media (max-width: 560px) {
    padding-top: 102px;
  }
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
  border-top: 10px solid ${props => props.theme.colors.primary};

  @media (min-width: 40rem) {
    padding: 1rem 1.5rem;
  }

`;

type CredentialsDTO = {
  username: string;
  password: string;
};
function LoginPage() {
  const [username, setUsername] = useState("");
  const [usernameInvalid, setUsernameInvalid] = useState(false);
  const [password, setPassword] = useState("");
  const [passwordInvalid, setPasswordInvalid] = useState(false);

  function handleUsernameChange(event: React.ChangeEvent<HTMLInputElement>) {
    setUsername(event.target.value);
  }
  function handlePasswordChange(event: React.ChangeEvent<HTMLInputElement>) {
    setPassword(event.target.value);
  }

  function checkValues() {
    if (!username) {
      setUsernameInvalid(true);
    } else {
      setUsernameInvalid(false);
    }

    if (!password) {
      setPasswordInvalid(true);
    } else {
      setPasswordInvalid(false);
    }
  }

  function handleFormSubmit(event: React.FormEvent<HTMLFormElement>) {
    const formData = {
      username, password
    }
    event.preventDefault();
    requestBackendLogin(formData)
      .then((response) => {
        saveAuthData(response.data);
        console.log(response)

      })
      .catch((error) => {
        console.log('ERRO', error);
      });

    if (!username || !password) {
      checkValues();
    } else {
      setUsername(username);
      setPassword(password);

    }
  }

  return (
    <Main>
      <FormCadastro onSubmit={handleFormSubmit}>
        <h1>Sign in</h1>
        <FormRow>
          <TextInput
            type="text"
            id="input-nome"
            placeholder="Email or Username"
            className={usernameInvalid ? 'invalid' : ''}
            onBlur={checkValues}
            onChange={handleUsernameChange}
          />
        </FormRow>
        <FormRow>
          <TextInput
            type="password"
            id="input-nome"
            className={passwordInvalid ? 'invalid' : ''}
            placeholder="Password"
            onBlur={checkValues}
            onChange={handlePasswordChange}
          />
        </FormRow>
        <MainButton text="LOGIN" />
        <span>Forgot your password? <a href="/">Click Here</a></span>
      </FormCadastro>

    </Main >
  );
}

export default LoginPage;
