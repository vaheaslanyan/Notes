package com.urartusoftware.reactor.daos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="note_status")
public class NoteStatusDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteStatusId;

    @Column
    private String noteStatusName;

    // Other tables referencing noteStatus
    @JsonIgnore
    @OneToMany(mappedBy = "noteStatusId")
    private List<NoteDAO> notes;

    /* Constructors -------------------------------------------------------------------*/
    public NoteStatusDAO() {
    }

    public NoteStatusDAO(int noteStatusId) {
        this.noteStatusId = noteStatusId;
    }

    public NoteStatusDAO(int noteStatusId, String noteStatusName) {
        this.noteStatusId = noteStatusId;
        this.noteStatusName = noteStatusName;
    }

    /* toString -----------------------------------------------------------------------*/
    @Override
    public String toString() {
        return "NoteStatusDAO{" +
                "noteStatusId=" + noteStatusId +
                ", noteStatusName='" + noteStatusName + '\'' +
                '}';
    }

    /* Getters & Setters --------------------------------------------------------------*/
    public int getNoteStatusId() {
        return noteStatusId;
    }

    public void setNoteStatusId(int noteStatusId) {
        this.noteStatusId = noteStatusId;
    }

    public String getNoteStatusName() {
        return noteStatusName;
    }

    public void setNoteStatusName(String noteStatusName) {
        this.noteStatusName = noteStatusName;
    }
}
