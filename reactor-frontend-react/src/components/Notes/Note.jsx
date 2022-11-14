import React, { useState, useContext, useSyncExternalStore } from "react";
import NoteContext from "../../context/NoteContext";
import { UserNote } from "../../models/UserNote";

function Note(props) {

  const { deleteNote } = useContext(NoteContext);

  const [buttonClass, setButtonClass] = useState("button-idle");

  function handleMouseOver() {
    setButtonClass("button-hover");
  }

  function handleMouseOut() {
    setButtonClass("button-idle");
  }

  function handleDeleteClicked() {
    // props.onDelete(props.id);
    const noteToBeDeleted = new UserNote();
    noteToBeDeleted.noteId = props.id;

    deleteNote(noteToBeDeleted);
    console.log("CLICKED");
  }

  return (
    <div className="note">
      <h1>{props.title}</h1>
      <p>{props.content}</p>
      {/* <button className={buttonClass} onClick={handleCompleteClicked} onMouseOver={handleMouseOver} onMouseOut={handleMouseOut}>Complete</button> */}
      <div className="delete-button-div">
        <i className="bi bi-x-circle" onClick={handleDeleteClicked}></i>
      </div>
    </div>
  );
}

export default Note;
