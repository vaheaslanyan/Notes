package com.urartusoftware.reactor.services;

import com.urartusoftware.reactor.daos.NoteDAO;
import com.urartusoftware.reactor.daos.NoteStatusDAO;
import com.urartusoftware.reactor.daos.UserDAO;
import com.urartusoftware.reactor.models.Note;
import com.urartusoftware.reactor.repositories.NoteRepository;
import com.urartusoftware.reactor.repositories.NoteStatusRepository;
import com.urartusoftware.reactor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    NoteRepository noteRepo;
    NoteStatusRepository noteStatusRepo;
    UserRepository userRepo;

    public NoteService(NoteRepository noteRepo, NoteStatusRepository noteStatusRepo, UserRepository userRepo) {
        this.noteRepo = noteRepo;
        this.noteStatusRepo = noteStatusRepo;
        this.userRepo = userRepo;
    }

    public Optional<NoteDAO> getById(int noteId) {
        return noteRepo.findById(noteId);
    }

    public Optional<List<NoteDAO>> getByUserId(int userId) {
//        return noteRepo.findByUserIdOrderByTimestampDesc(userId);
        UserDAO userForNotes = new UserDAO(userId);
        return noteRepo.findByUserIdOrderByTimestampDesc(userForNotes);
    }

    public Optional<NoteDAO> postNote(NoteDAO newNoteDAO) {
        NoteDAO completeNewNote = newNoteDAO;

        Optional<NoteStatusDAO> noteStatusForNote = noteStatusRepo.findById(newNoteDAO.getNoteStatusId().getNoteStatusId());
        Optional<UserDAO> userForNote = userRepo.findById(newNoteDAO.getUserId().getUserId());

        if (!noteStatusForNote.isPresent() || !userForNote.isPresent()) {
            return Optional.empty();
        }

        completeNewNote.setNoteStatusId(noteStatusForNote.get());
        completeNewNote.setUserId(userForNote.get());

        Optional<NoteDAO> savedNoteOptional = Optional.of(noteRepo.save(completeNewNote));
        return savedNoteOptional;
    }

    public void deleteNote(NoteDAO note) {
        noteRepo.delete(note);
    }
}
