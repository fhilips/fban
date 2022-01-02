import styled from "styled-components";
import PropTypes from "prop-types";
import logo from "../../assets/logo.png";


const LogoContent = styled.img`
  width: ${props => props.width}px;
  height: ${props => props.height}px;
`;

type Props = {
  width: number;
  height: number;
}

function Logo({ width, height }: Props) {
  return <LogoContent src={logo} width={width} height={height} />;
}

Logo.defaultProps = {
  width: 80,
  height: 43,
};

Logo.propTypes = {
  width: PropTypes.number,
  height: PropTypes.number,
};

export default Logo;
