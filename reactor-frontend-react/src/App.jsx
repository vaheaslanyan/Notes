import React from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import Spinner from './components/Spinner';
import Notes from './components/notes/Notes';
import { NoteProvider } from './context/NoteContext';

// BACKEND NOT COMPLETED OR CONNECTED

function App() {
    return (
        <NoteProvider>
                <Header />
                <Notes />
                <Footer />
        </NoteProvider>
    )
}

export default App;