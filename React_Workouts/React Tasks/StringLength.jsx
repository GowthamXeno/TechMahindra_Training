// 2. check if the given string's length is even or odd and display the results

import React, { useState } from "react";

const StringLength = () => {
  const [inputString, setInputString] = useState("");
  const [result, setResult] = useState("");

  const handleInputChange = (event) => {
    setInputString(event.target.value);
  };

  const checkLength = () => {
    const length = inputString.length;

    if (length % 2 === 0) {
      setResult("Even");
    } else {
      setResult("Odd");
    }
  };

  return (
    <div>
      <h2>Check if String Length is Even or Odd</h2>
      <input
        type="text"
        value={inputString}
        onChange={handleInputChange}
        placeholder="Type a string here"
      />
      <button onClick={checkLength}>Check Length (If-Else)</button>

      <h3>Using If-Else:</h3>
      <p>Length is: {result}</p>

      <h3>Using Logical AND (&&):</h3>
      <p>
        {inputString.length > 0 &&
          (inputString.length % 2 === 0 ? "Length is Even" : "Length is Odd")}
      </p>

      <h3>Using Ternary Operator:</h3>
      <p>Length is: {inputString.length % 2 === 0 ? "Even" : "Odd"}</p>
    </div>
  );
};

export default StringLength;
