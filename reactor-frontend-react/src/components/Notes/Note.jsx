import React, { useState } from "react";

function Note(props) {

  const [buttonClass, setButtonClass] = useState("button-idle");

  function handleMouseOver() {
    setButtonClass("button-hover");
  }

  function handleMouseOut() {
    setButtonClass("button-idle");
  }

  function handleCompleteClicked() {
    props.onDelete(props.id);
  }

  return (
    <div className="note">
      <h1>{props.title}</h1>
      <p>{props.content}</p>
      <button className={buttonClass} onClick={handleCompleteClicked} onMouseOver={handleMouseOver} onMouseOut={handleMouseOut}>Complete</button>
    </div>
  );
}

export default Note;
