import { NoteStatus } from "./NoteStatus";
import { User } from "./User";

export class UserNote {
    noteId: number;
    title: string;
    content: string;
    timestamp: Date;
    noteStatusId: NoteStatus;
    userId: User

    constructor(title, content, userId, noteStatusId = {noteStatusId: 1}) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.noteStatusId = noteStatusId;
    }
}