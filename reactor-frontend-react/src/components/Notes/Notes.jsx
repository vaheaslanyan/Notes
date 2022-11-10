import React, { useState, useContext } from "react";
import NewNote from "./NewNote";
import Note from "./Note";
import NoteContext from "../../context/NoteContext";
import Spinner from "../Spinner";

function Notes() {
  const { notesData, isLoading } = useContext(NoteContext);

  // const [ notes, setNotes ] = useState(notesData);

  if (!isLoading && (!notesData || notesData.length === 0)) {
    return <p>You don't have any notes yet.</p>;
  }

  function addNewNote(newNote) {
    
  }

  function deleteNote(noteId) {
    // setNotes((prevNotes) => {
    //   return prevNotes.filter((noteItem, index) => {
    //     return index !== noteId;
    //   });
    // });
  }

  function generateNote(note) {
    return (
      <Note
        key={note.noteId}
        id={note.noteId}
        title={note.title}
        content={note.content}
        onDelete={deleteNote}
      />
    ); // key property should be replaced by a unique id instead of index
  }

  return (
    <div>
      <NewNote onAdd={addNewNote} />
      {isLoading ? <Spinner /> : notesData.map(generateNote)}
    </div>
  );
}

export default Notes;
