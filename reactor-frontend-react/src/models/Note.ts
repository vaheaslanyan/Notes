export class Note {
    noteId: number;
    title: string;
    content: string;
    timestamp: Date;
    noteStatusId: NoteStatus;
    userId: User
}