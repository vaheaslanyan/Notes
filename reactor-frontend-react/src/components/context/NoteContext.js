import { createContext, useState, useEffect } from "react";
import Note from "../notes/Note";

const NoteContext = createContext();

export const NoteProvider = ({children}) => {

    const localURL = "http://localhost:8080/"
    const [notes, setNotes] = useState([])



    useEffect(() => {
        fetchNotes();
    }, [])

    // Fetching data
    const fetchNotes = async () => {
        const response = await fetch(localURL + 'note/' + '1')
        const data = await response.json();
        console.log(data);
        setNotes(data);
    }

    return <NoteContext.Provider value={{
        note: notes
    }}>
        {children}
    </NoteContext.Provider>
}

export default NoteContext;