import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    outline: 0 !important;
    font-family: 'Red Hat Display', Poppins, sans-serif ;
    font-weight: 300;
    text-rendering: optimizeLegibility !important;
    -webkit-font-smoothing: antialiased !important;
  }

  html, body, #root {
    height: 100%;
    width: 100%;
  }

  a { 
    text-decoration: none;
    color: #243743;
    font-weight: bold;
  }
  body {
    background: #f2f2f2;
  }

  #root {
    position: relative;
    display: flex;
    flex-direction: column;
  }
`;

export default GlobalStyle;
