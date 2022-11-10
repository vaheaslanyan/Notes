import React, { useContext, useState } from "react";
import NoteContext from "../../context/NoteContext";
import { UserNote } from "../../models/UserNote.ts";
import { User } from "../../models/User.ts";

function NewNote(props) {

  const { addNote } = useContext(NoteContext)

  const [noteData, setNoteData] = useState({
    noteTitle: "",
    noteContent: "",
  });

  function addNoteClicked(event) {
    // event.preventDefault();
    // props.onAdd(noteData);
    // setNoteData({
    //   noteTitle: "",
    //   noteContent: ""
    // });
    event.preventDefault();
    const thisUser = new User(1);
    const newNote = new UserNote(noteData.noteTitle, noteData.noteContent, thisUser);

    addNote(newNote);
    console.log(newNote);
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
