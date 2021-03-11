package warrook.mysticmusic.util.enums;

public enum NoteType {
    C4('C', 6/*(float) Math.pow(2.0d, -6.0d / 12.0d)*/),
    D4('D', 8/*(float) Math.pow(2.0d, -4.0d / 12.0d)*/),
    E4('E', 10/*(float) Math.pow(2.0d, -2.0d / 12.0d)*/),
    G4('G', 13/*(float) Math.pow(2.0d, 1.0d / 12.0d)*/),
    A4('A', 15/*(float) Math.pow(2.0d, 3.0d / 12.0d)*/),
    C5('c', 18/*(float) Math.pow(2.0d, 6.0d / 12.0d)*/);

    private final char name;
    private final int noteProperty;
    private final float twelfth;
    NoteType(char name, int note) {
        this.name = name;
        this.noteProperty = note;
        this.twelfth = (float) Math.pow(2.0d, (note - 12.0d) / 12.0d);
    }

    public char character() {
        return this.name;
    }

    public float pitch() {
        return this.twelfth;
    }

    public int noteblock() {
        return this.noteProperty;
    }

    public static NoteType fromChar(char c) {
        switch (c) {
            case 'C':
                return C4;
            case 'D':
                return D4;
            case 'E':
                return E4;
            case 'G':
                return G4;
            case 'A':
                return A4;
            case 'c':
                return C5;
        }
        return null;
    }
}
