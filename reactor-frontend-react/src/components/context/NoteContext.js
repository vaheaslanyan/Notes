import { createContext, useState, useEffect } from "react";
import Note from "../notes/Note";

const NoteContext = createContext();

export const NoteProvider = ({children}) => {

    const localURL = "http://localhost:8080/";

    const [isLoading, setIsLoading] = useState(true);
    const [notes, setNotes] = useState([]);

    useEffect(() => {
        fetchNotes();
    }, [])

    // Fetching data
    const fetchNotes = async () => {
        const response = await fetch(localURL + 'note/' + '1')
        const data = await response.json();
        // console.log(data);
        setNotes(data);
        setIsLoading(false);
    }

    return <NoteContext.Provider value={{
        note: notes,
        isLoading
    }}>
        {children}
    </NoteContext.Provider>
}

export default NoteContext;