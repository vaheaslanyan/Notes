package com.urartusoftware.reactor.controllers;

import com.urartusoftware.reactor.daos.NoteStatusDAO;
import com.urartusoftware.reactor.models.NoteStatus;
import com.urartusoftware.reactor.services.NoteStatusService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/note-status")
public class NoteStatusController {

    NoteStatusService noteStatusService;

    public NoteStatusController(NoteStatusService noteStatusService) {
        this.noteStatusService = noteStatusService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NoteStatus> getById(@PathVariable int noteStatusId) {
        Optional<NoteStatusDAO> optionalNoteStatus = noteStatusService.getById(noteStatusId);

        if (!optionalNoteStatus.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        NoteStatus noteStatus = new NoteStatus(optionalNoteStatus.get());

        return ResponseEntity.ok(noteStatus);
    }

    @PostMapping
    public ResponseEntity<NoteStatus> postNoteStatus(@RequestBody NoteStatusDAO newNoteStatus) {
        Optional<NoteStatusDAO> newNoteStatusOptional = noteStatusService.postNoteStatus(newNoteStatus);

        if (!newNoteStatusOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        NoteStatus savedNoteStatus = new NoteStatus(newNoteStatusOptional.get());

        return ResponseEntity.ok(savedNoteStatus);
    }

}
