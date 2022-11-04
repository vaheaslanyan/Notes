import React, { useState } from "react";

function NewNote(props) {
  const [noteData, setNoteData] = useState({
    noteTitle: "",
    noteContent: "",
  });

  function addNoteClicked(event) {
    event.preventDefault();
    props.onAdd(noteData);
    setNoteData({
      noteTitle: "",
      noteContent: ""
    });
  }

  function handleChange(event) {
    // const newValue = event.target.value;
    // const inputName = event.target.name;

    const { value: newValue, name: inputName } = event.target;

    setNoteData((prevValue) => {
      if (inputName === "title") {
        return {
          noteTitle: newValue,
          noteContent: prevValue.noteContent,
        };
      } else if (inputName === "content") {
        return {
          noteTitle: prevValue.noteTitle,
          noteContent: newValue,
        };
      }
    });
  }

  return (
    <form>
      <input
        name="title"
        onChange={handleChange}
        placeholder="Title"
        value={noteData.noteTitle}
      />
      <textarea
        name="content"
        onChange={handleChange}
        placeholder="Note this..."
        rows="3"
        value={noteData.noteContent}
      />
      <button onClick={addNoteClicked}>Add</button>
    </form>
  );
}

export default NewNote;

//
