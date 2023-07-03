import React, { useState } from "react";

// 컴포넌트 이름은 대문자!
// 리액트는 컴포넌트의 상태가 변할때마다 리랜더링을  수행함
const InputTest = () => {

    const [inputValue, setInputValue] = useState("초기값");
    //      변수            함수

    const changeInputValue = (e) => {
        console.log(e.target.value);
        setInputValue(e.target.value)
    }


    return (
        <input type="text" value={inputValue}
            onChange={ changeInputValue } />
            // onCange={ (e) => {setInputValue(e.target.value)} } />
    );

};

export default InputTest;