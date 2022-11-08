package com.urartusoftware.reactor.DAOs;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="notes")
public class NoteDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Timestamp noteTmiestamp;

    @ManyToOne
    @JoinColumn
    private UserDAO userId;

    /* Constructors ------------------------------------------------------------------*/
    public NoteDAO() {
    }

    public NoteDAO(int noteId, String title, String content, Timestamp noteTmiestamp, UserDAO userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    /* toString ----------------------------------------------------------------------*/
    @Override
    public String toString() {
        return "NoteDAO{" +
                "noteId=" + noteId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", noteTmiestamp=" + noteTmiestamp +
                ", userId=" + userId +
                '}';
    }

    /* Getters & Setters--------------------------------------------------------------*/

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

    public Timestamp getNoteTmiestamp() {
        return noteTmiestamp;
    }

    public void setNoteTmiestamp(Timestamp noteTmiestamp) {
        this.noteTmiestamp = noteTmiestamp;
    }

    public UserDAO getUserId() {
        return userId;
    }

    public void setUserId(UserDAO userId) {
        this.userId = userId;
    }
}
