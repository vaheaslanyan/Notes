package com.urartusoftware.reactor.models;

import com.urartusoftware.reactor.daos.NoteStatusDAO;

public class NoteStatus {
    private int noteStatusId;
    private String noteStatusName;

    public NoteStatus(NoteStatusDAO noteStatusDAO) {
        this.noteStatusId = noteStatusDAO.getNoteStatusId();
        this.noteStatusName = noteStatusDAO.getNoteStatusName();
    }

    @Override
    public String toString() {
        return "NoteStatus{" +
                "noteStatusId=" + noteStatusId +
                ", noteStatusName='" + noteStatusName + '\'' +
                '}';
    }

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
