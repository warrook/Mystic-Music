package warrook.mysticmusic.util;

import net.minecraft.util.math.MathHelper;
import warrook.mysticmusic.util.enums.NoteType;

public class Song {
    private final int interval;
    private final Note[] notes;
    private final int duration;

    public Song(String tune, String time, int tempo) {
        char[] pitches = tune.toCharArray();
        char[] arr = time.toCharArray();
        interval = MathHelper.floor(tempo / 60.0d * 20);
        notes = new Note[arr.length];
        for (int i = 0; i < arr.length; i++) {
            notes[i] = new Note(NoteType.fromChar(pitches[i]), arr[i], interval);
        }

        int len;
        len = 0;
        for (Note n : notes) {
            len += n.duration();
        }
        duration = len;
    }

    public int duration() { return duration; }
    public Note[] getNotes() { return notes; }
    public int getLength() { return notes.length; }

    public Note get(int at) {
        if (at < notes.length)
            return notes[at];
        return null;
    }
}
