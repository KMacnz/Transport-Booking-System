package bookingsystem.layout;

public class Column {

    private char letter;

    public char getLetter() {
        return this.letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    //take column char input that represents column
    public Column(char letter) {
        this.letter = letter;
    }

    // 2 columns = when letters match
    @Override
    public boolean equals(Object o) {
        Column column = (Column) o;
        return column.letter == this.letter;
    }

    // returns letter of column as string
    public String toString() {
        return String.valueOf(this.letter);
    }
}
