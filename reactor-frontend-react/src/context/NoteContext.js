import { createContext, useState, useEffect } from "react";

const NoteContext = createContext();

export const NoteProvider = ({children}) => {

    const localURL = "http://localhost:8080/";

    const [isLoading, setIsLoading] = useState(true);
    const [notesData, setNotesData] = useState([]);

    useEffect(() => {
        fetchNotes();
    }, [])

    // Fetching data
    const fetchNotes = async () => {
        const response = await fetch(localURL + 'note/' + '1')
        const data = await response.json();
        // console.log(data);
        setNotesData(data);
        setIsLoading(false);
    }

    return <NoteContext.Provider value={{
        notesData,
        isLoading
    }}>
        {children}
    </NoteContext.Provider>
}

export default NoteContext;