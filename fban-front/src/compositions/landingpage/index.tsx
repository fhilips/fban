
import styled from "styled-components";
import Wave from "../../assets/wave.svg";
import Logo from "../../components/Logo";

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

  .home-title {
    font-family: Poppins;
    font-weight: 300;
    margin-bottom: 30px;    
  }

  .home-text {
    text-align: center;
    font-family: Poppins;
    font-size: 18px;
    padding: 15px;
    border-radius: 8px;    
    background: ${(props) => props.theme.colors.white};
    box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
    a {
    text-decoration: none;
    color: ${(props) => props.theme.colors.secondary};
    font-weight: bold;
    }
  }

  @media (max-width: 560px) {
    padding-top: 102px;
  }
`;

function LandingPage() {


  return (
    <Main>
      <Logo width={150} height={63} />
      <h1 className="home-title">Welcome to our page!</h1>
      <span className="home-text">
        Manage your account in a simples way with our services! <br /><br />
        Doesn't have an account?  <a href="/">Sign up now</a>
      </span>
    </Main>
  );
}

export default LandingPage;
