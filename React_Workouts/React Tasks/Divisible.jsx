import React, { useState } from "react";

function UsingIf(num) {
  if (num % 13 === 0) {
    return <h1>The Number {num} is Divisible By 13</h1>;
  } else {
    return <h1>The Number {num} is Not Divisible By 13</h1>;
  }
}

function Divisible({ num }) {
  const [currentNum, setCurrentNum] = useState(num);

  const askNumber = () => {
    const inputNumber = Number(
      prompt("Enter the Number to Check Divisibility of 13")
    );
  };

  return (
    <div className="container">
      <h1>Using IF:</h1>
      {UsingIf(currentNum)}
      <br />

      <h1>Using Logical &&:</h1>
      {currentNum % 13 === 0 && (
        <h1>The Number {currentNum} is Divisible By 13</h1>
      )}
      {currentNum % 13 !== 0 && (
        <h1>The Number {currentNum} is Not Divisible By 13</h1>
      )}
      <br />

      <h1>Using Ternary Operator:</h1>
      {currentNum % 13 === 0 ? (
        <h1>The Number {currentNum} is Divisible By 13</h1>
      ) : (
        <h1>The Number {currentNum} is Not Divisible By 13</h1>
      )}
      <br />
      <br />
      <br />

      <h1>Custom Input:</h1>
      <button onClick={askNumber}>Click Here</button>
    </div>
  );
}

export default Divisible;
