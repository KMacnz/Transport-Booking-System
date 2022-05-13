package bookingsystem.layout;

public class SeatPosition {

    //Constructor with input for row and column
    private final Row row;
    private final Column column;

    public SeatPosition(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    // returns a string representation of the position object. e.g. (5,E)
    public String toString() {
        return "(" + row.getNumber() + "," + column.getLetter() + ")";
    }

    // get column
    public Column getColumn() {
        return this.column;
    }

    // get row
    public Row getRow() {
        return this.row;
    }

    // 2 postition object = if same row numbers and column letters
    @Override
    public boolean equals(Object o) {
        SeatPosition position = (SeatPosition) o;
        Row row1 = position.getRow();
        Column column1 = position.getColumn();
        return (this.row.getNumber() == row1.getNumber()) && (this.column.getLetter() == column1.getLetter());
    }
}
