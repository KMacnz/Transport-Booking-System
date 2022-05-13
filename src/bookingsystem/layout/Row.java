package bookingsystem.layout;

public class Row {

    private int number;

    // holds the number of rows 
    public Row(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int row) {
        this.number = row;
    }

    // 2 rows = when numbers match
    @Override
    public boolean equals(Object o) {
        Row row = (Row) o;
        return row.number == this.number;
    }

    // returns number of row as string
    public String toString() {
        return String.valueOf(this.number);
    }
}
