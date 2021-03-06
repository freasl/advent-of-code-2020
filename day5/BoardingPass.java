package day5;

/**
 *  This class contains the information of a boardingpass
 *  Methods
 */
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
        this.column = findColumn(input);
        this.seatId = findSeatId();
    }

    /**
     * Finds the correct row for the boardingpass
     * @param input the boardingpass binary input (e.g. "FBFBBFFRLR")
     * @return
     */
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

    /**
     * Finds the correct column for the boardingpass
     * @param input the boardingpass binary input (e.g. "FBFBBFFRLR")
     * @return
     */
    public int findColumn(String input){
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

    /**
     * Calculates the the seat ID as row * 8 + column
     * @return the seat ID of the boardingpass.
     */
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

}
