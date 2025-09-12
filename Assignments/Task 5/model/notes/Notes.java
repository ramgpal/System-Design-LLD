package model.notes;

public class Notes implements Comparable<Notes>{
    private int value;
    private int count;
    private boolean flag;

    // constructor
    public Notes(int value, int count, boolean flag) {
        this.value = value;
        this.count = count;
        this.flag = flag;
    }

    public int compareTo(Notes note) {
        return note.value - this.value;
    }

    // getter
    public int getValue() {
        return  this.value;
    }

    public int getCount() {
        return this.count;
    }

    public boolean getFlag() {
        return this.flag;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
