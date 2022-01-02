import styled from 'styled-components';

export const Button = styled.button`    
    width: 100%;
    background-color: ${(props) => props.theme.colors.primary};
    color: #fff;
    border-radius: 6px;
    padding: 12px 24px;
    font-size: 18px;
    font-weight: 500;
    line-height: 24px;
    border: 0;
    cursor: pointer;
    box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
    backdrop-filter: blur( 4.5px );
    -webkit-backdrop-filter: blur( 4.5px );    

`;

type Props = {
  text: string;
}
function MainButton({ text }: Props) {
  return (
    <Button type="submit">
      {text}
    </Button>
  )
}

export default MainButton;


