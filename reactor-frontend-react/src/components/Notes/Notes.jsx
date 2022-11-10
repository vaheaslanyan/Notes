import React, { useState, useContext } from "react";
import NewNote from "./NewNote";
import Note from "./Note";
import NoteContext from "../context/NoteContext";

function Notes() {

  const { notesData, isLoading } = useContext(NoteContext);

  const [ notes, setNotes ] = useState(notesData);

  function addNewNote(newNote) {
    setNotes((prevNotes) => {
      return [...notesData, newNote];
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
    return <Note key={index} id={index} title={note.title} content={note.content} onDelete={deleteNote}/>; // key property should be replaced by a unique id instead of index
  }

  return (
    <div>
      <NewNote onAdd={addNewNote}/>
      {notesData.map(generateNote)}
    </div>
  );
}

export default Notes;
