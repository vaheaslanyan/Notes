import { createContext, useState, useEffect } from "react";

const NoteContext = createContext();

export const NoteProvider = ({ children }) => {
  const localURL = "http://localhost:8080/";

  const [isLoading, setIsLoading] = useState(true);
  const [notesData, setNotesData] = useState([]);

  useEffect(() => {
    fetchNotes();
  }, []);

  // Posting a new note
  const addNote = async (newNote) => {
    const response = await fetch(localURL + "note", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newNote),
    });

    const data = await response.json();
    setNotesData([data, ...notesData]);
  };

  // Fetching notes
  const fetchNotes = async () => {
    const response = await fetch(localURL + "note/" + "1");
    const data = await response.json();
    // console.log(data);
    setNotesData(data);
    setIsLoading(false);
  };

  // Deleting a note
  const deleteNote = async (noteId) => {

    console.log(noteId);

    const response = await fetch(localURL + "note", {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(noteId),
    });

    const data = await response.json();
    
    setNotesData((prevNotes) => {
      return prevNotes.filter((noteItem, index) => {
        return index !== noteId;
      });
    });

    console.log(data)
  }


  return (
    <NoteContext.Provider
      value={{
        notesData,
        isLoading,
        addNote,
        deleteNote,
      }}
    >
      {children}
    </NoteContext.Provider>
  );
};

export default NoteContext;
