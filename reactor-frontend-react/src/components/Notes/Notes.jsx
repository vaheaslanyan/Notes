import React, { useState } from "react";
import NewNote from "./NewNote";
import Note from "./Note";
import notesData from "../../notes-data";

function Notes() {
  const [notes, setNotes] = useState(notesData);

  function addNewNote(newNote) {
    setNotes((prevNotes) => {
      return [...notes, newNote];
    });
  }

  function deleteNote(noteId) {
    setNotes(prevNotes => {
      return prevNotes.filter((noteItem, index) => {
        return index !== noteId;
      })
    })
  }

  function generateNote(note, index) {
    return <Note key={index} id={index} noteHeader={note.noteTitle} noteContent={note.noteContent} onDelete={deleteNote}/>; // key property should be replaced by a unique id instead of index
  }

  return (
    <div>
      <NewNote onAdd={addNewNote}/>
      {notes.map(generateNote)}
    </div>
  );
}

export default Notes;
