package com.urartusoftware.reactor.services;

import com.urartusoftware.reactor.daos.NoteStatusDAO;
import com.urartusoftware.reactor.repositories.NoteStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteStatusService {

    NoteStatusRepository noteStatusRepository;

    @Autowired
    public NoteStatusService(NoteStatusRepository noteStatusRepository) {
        this.noteStatusRepository = noteStatusRepository;
    }

    public Optional<NoteStatusDAO> getById(int noteStatusId) {
        Optional<NoteStatusDAO> noteStatusOptional = Optional.of(noteStatusRepository.getReferenceById(noteStatusId));
        return noteStatusOptional;
    }

    public Optional<NoteStatusDAO> postNoteStatus(NoteStatusDAO newNoteStatus) {
        Optional<NoteStatusDAO> savedNoteStatusOptional = Optional.of(noteStatusRepository.save(newNoteStatus));
        return savedNoteStatusOptional;
    }

}
