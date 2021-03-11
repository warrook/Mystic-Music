package warrook.mysticmusic.util;

import net.minecraft.util.math.MathHelper;
import warrook.mysticmusic.util.enums.NoteType;

public class Note {
    public final NoteType type;
    private final float pitch;
    private final int duration; //ticks

    public Note(NoteType note, int denominator, int interval) {
        this.type = note;
        this.pitch = note.pitch();
        this.duration = MathHelper.floor((float)interval / denominator);
    }

    public float pitch() { return pitch; }
    public int duration() { return duration; }
}
