package com.urartusoftware.reactor.controllers;

import com.urartusoftware.reactor.daos.NoteDAO;
import com.urartusoftware.reactor.models.Note;
import com.urartusoftware.reactor.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/note")
public class NoteController {

    NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Note>> findAllByUserId(@PathVariable int userId) {
        Optional<List<NoteDAO>> noteListOptional = noteService.getByUserId(userId);

        if (!noteListOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<Note> notesList = noteListOptional.get().stream().map(nDAO -> new Note(nDAO)).collect(Collectors.toList());
        return ResponseEntity.ok(notesList);
    }

    @PostMapping
    public ResponseEntity<Note> postNote(@RequestBody NoteDAO newNoteDAO) {

        Optional<NoteDAO> newNoteOptional = noteService.postNote(newNoteDAO);

        if (!newNoteOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Note savedNote = new Note(newNoteOptional.get());
        return ResponseEntity.ok(savedNote);
    }

}
