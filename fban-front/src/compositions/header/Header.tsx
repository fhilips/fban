import styled from "styled-components";
import Logo from "../../components/Logo";
import MenuItem from "../../components/MenuItem";

const HeaderContent = styled.header`
  display: flex;
  align-items: center;
  justify-content: space-around;
  min-height: 80px;
  width: 100%;
  top: 0px;
  z-index: 100;
  position: fixed;
  background-color: #243743;  
  padding-left: 2rem;
`;

const Nav = styled.nav`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;  
  min-height: 80px;
  box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
  img {
    margin-left: 2rem;
  }

  @media (min-width: 40rem) {
    width: 35rem;
    img {
      margin-left: 0;
    }
  }

  @media (min-width: 60rem) {
    width: 50rem;
    img {
      margin-left: 0;
    }
  }
`;

type Props = {
  children: React.ReactNode;
}

function Header({ children }: Props) {
  return (
    <HeaderContent>
      <Logo width={150} height={60} />
      <Nav>
        {children}
      </Nav>
      <MenuItem text="Login" linkTo="/login" />
    </HeaderContent>
  );
}

export default Header;
