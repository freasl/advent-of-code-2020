package day5;

public class BoardingPass {
    private String input;
    private int row;
    private int column;
    private int seatId;
    private int rowsOnPlane;
    private int columnsOnPlane;

    public BoardingPass(String input, int rowsOnPlane, int columnsOnPlane){
        this.input = input;
        this.rowsOnPlane = rowsOnPlane -1;
        this.columnsOnPlane = columnsOnPlane -1;
        this.row = findRow(input);
        this.column = findColumn();
        this.seatId = findSeatId();
    }

    public int findRow(String input){
        var high = this.rowsOnPlane;
        var low = 0;
        int theRow = 0;
        for(int i = 0; i < 7; i++) {
            if ((high - low) > 1) {

                if (input.charAt(i) == 'F') {
                    high = low+((high-low)/2);
                } else if (input.charAt(i) == 'B') {
                    low = low + ((high-low)/2)+1;
                }
            }else if((high-low) == 1){
                if(input.charAt(i) == 'F'){
                    theRow =  low;
                }else if(input.charAt(i) == 'B'){
                    theRow = high;

                }
            }
        }
        return theRow;
    }
    public int findColumn(){
        var high = this.columnsOnPlane;
        var low = 0;
        int theColumn = 0;
        for(int i = 7; i < 10; i++) {
            if ((high - low) > 1) {

                if (input.charAt(i) == 'L') {
                    high = low+((high-low)/2);
                } else if (input.charAt(i) == 'R') {
                    low = low + ((high-low)/2)+1;
                }
            }else if((high-low) == 1){
                if(input.charAt(i) == 'L'){
                    theColumn =  low;
                }else if(input.charAt(i) == 'R'){
                    theColumn = high;

                }
            }
        }
        return theColumn;
    }
    public int findSeatId(){
        return (this.row*8)+this.column;
    }

    // Getter methods
    public String getInput() {
        return input;
    }
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getSeatId() {
        return seatId;
    }

    public int getRowsOnPlane() {
        return rowsOnPlane +1;
    }

    // Setter methods
    public void setInput(String input) {
        this.input = input;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
}
