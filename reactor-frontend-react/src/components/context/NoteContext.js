import { createContext, useState, useEffect } from "react";

const NoteContext = createContext();

export const NoteProvider = ({children}) => {

    const localURL = "http://localhost:8080/"
    const [note, setNotes] = useState([])

    useEffect(() => {
        fetchNotes();
    }, [])

    // Fetching data
    const fetchNotes = async () => {
        const response = await fetch(localURL + 'note/' + '1')
        const data = await response.json();
        console.log(data);

    }

    return <NoteContext.Provider value={{
        note
    }}>
        {children}
    </NoteContext.Provider>
}

export default NoteContext;