import React from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import Notes from './components/notes/Notes';
import { NoteProvider } from './components/context/NoteContext';

// BACKEND NOT COMPLETED OR CONNECTED

function App() {
    return (
        <NoteProvider>
            <div>
                <Header />
                <Notes />
                <Footer />
            </div>
        </NoteProvider>
    )
}

export default App;