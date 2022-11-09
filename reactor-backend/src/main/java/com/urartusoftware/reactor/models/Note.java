package com.urartusoftware.reactor.models;

import com.urartusoftware.reactor.daos.NoteDAO;

import java.sql.Timestamp;

public class Note {

    private int noteId;
    private String title;
    private String content;
    private Timestamp timestamp;

    private NoteStatus noteStatusId;
    private User userId;

    /* Constructors -----------------------------------------*/
    public Note(NoteDAO noteDAO) {
        this.noteId = noteDAO.getNoteId();
        this.title = noteDAO.getTitle();
        this.content = noteDAO.getContent();
        this.timestamp = noteDAO.getTimestamp();
        this.noteStatusId = new NoteStatus(noteDAO.getNoteStatusId());
        this.userId = new User(noteDAO.getUserId());
    }

    /* toString ---------------------------------------------*/
    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", userId=" + userId +
                '}';
    }

    /* Getters & Setters ------------------------------------*/
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public NoteStatus getNoteStatusId() {
        return noteStatusId;
    }

    public void setNoteStatusId(NoteStatus noteStatusId) {
        this.noteStatusId = noteStatusId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
