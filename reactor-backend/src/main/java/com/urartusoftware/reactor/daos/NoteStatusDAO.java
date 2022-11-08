package com.urartusoftware.reactor.daos;

import javax.persistence.*;

@Entity
@Table(name="note_statuses")
public class NoteStatusDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteStatusId;

    @Column
    private String noteStatusName;

    /* Constructors -------------------------------------------------------------------*/
    public NoteStatusDAO() {
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
