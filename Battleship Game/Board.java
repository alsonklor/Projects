// written by Alson Lor

public class Board {
    int[][] board;
    String[][] displayBoard;
    int totalShots = 0;
    int turns = 1;
    int boatsLeft;
    int boatNumber = 1;     // Determines the number of a boat when it is created.
    int droneCount = 0;
    int missileCount = 0;

    public Board() {
        this.board = new int[8][8];
        this.displayBoard = new String[8][8];
        this.boatsLeft = 5;
        for (int row = 0; row < this.displayBoard.length; row++) {
            for (int col = 0; col < this.displayBoard[row].length; col++) {
                this.displayBoard[row][col] = " - ";
            }   // inner for loop
        }   // outer for loop
    }   // Standard board constructor

    public Board(int expert) {
        this.board = new int[expert][expert];
        this.displayBoard = new String[12][12];
        this.boatsLeft = 10;
        for (int row = 0; row < this.displayBoard.length; row++) {
            for (int col = 0; col < this.displayBoard[row].length; col++) {
                this.displayBoard[row][col] = " - ";
            }   // inner for loop
        }   // outer for loop
    }   // Expert board constructor. "expert" parameter will always be 12.

    public void setBoat(int boatLength, int arrayDimensions) {
        // Method sets up and places boats based on their size and the array dimensions when called. arrayDimension will be 7 for standard game mode and 11 for expert.
        int horizontalOrVertical = (int) ((Math.random() * 10) + 1);
        int constraint = 0;
        int randomRow = (int) ((Math.random() * arrayDimensions) + 1);
        int randomCol = (int) ((Math.random() * arrayDimensions) + 1);

        //////// Boat's length is 2 //////////////

        if (boatLength == 2) {
            if (horizontalOrVertical <= 5) {
                while (constraint == 0) {
                    if (((randomCol + 1) <= arrayDimensions) && (this.board[randomRow][randomCol] == 0) && (this.board[randomRow][randomCol + 1] == 0)) {
                        this.board[randomRow][randomCol] = boatNumber;
                        this.board[randomRow][randomCol + 1] = boatNumber;
                        this.boatNumber++;
                        constraint = 1;
                    }   // if statement (checks to see if the spots next to random coordinate are open.
                    else {
                        randomRow = (int) ((Math.random() * arrayDimensions) + 1);
                        randomCol = (int) ((Math.random() * arrayDimensions) + 1);
                    }   // else statement
                }   // while loop
            }   // if (places the boats horizontally)
            else {
                while (constraint == 0) {
                    if (((randomRow +1) <= arrayDimensions) && (this.board[randomRow][randomCol] == 0) && (this.board[randomRow + 1][randomCol] == 0)) {
                        this.board[randomRow][randomCol] = boatNumber;
                        this.board[randomRow + 1][randomCol] = boatNumber;
                        this.boatNumber++;
                        constraint = 1;
                    }   // if statement (checks to see if the spots next to random coordinate are open.
                    else {
                        randomRow = (int) ((Math.random() * arrayDimensions) + 1);
                        randomCol = (int) ((Math.random() * arrayDimensions) + 1);
                    }   // else statement
                }   // while loop
            }   // else (places the boats vertically)
        }   // if statement

        //////// Boat's length is 3 ////////////

        else if (boatLength == 3) {
            horizontalOrVertical = (int) ((Math.random() * 10) + 1);
            constraint = 0;
            randomRow = (int) ((Math.random() * arrayDimensions) + 1);
            randomCol = (int) ((Math.random() * arrayDimensions) + 1);
            if (horizontalOrVertical <= 5) {
                while (constraint == 0) {
                    if (((randomCol + 1) <= arrayDimensions) && ((randomCol + 2) <= arrayDimensions) && (this.board[randomRow][randomCol] == 0) && (this.board[randomRow][randomCol + 1] == 0) && (this.board[randomRow][randomCol + 2] == 0)) {
                        this.board[randomRow][randomCol] = boatNumber;
                        this.board[randomRow][randomCol + 1] = boatNumber;
                        this.board[randomRow][randomCol + 2] = boatNumber;
                        this.boatNumber++;
                        constraint = 1;
                    }   // if statement (checks to see if the spots next to random coordinate are open.
                    else {
                        randomRow = (int) ((Math.random() * arrayDimensions) + 1);
                        randomCol = (int) ((Math.random() * arrayDimensions) + 1);
                    }   // else statement
                }   // while loop
            }   // if (places the boats horizontally)
            else {
                while (constraint == 0) {
                    if (((randomRow + 1) <= arrayDimensions) && ((randomRow + 2) <= arrayDimensions) && (this.board[randomRow][randomCol] == 0) && (this.board[randomRow + 1][randomCol] == 0) && (this.board[randomRow + 2][randomCol] == 0)) {
                        this.board[randomRow][randomCol] = boatNumber;
                        this.board[randomRow + 1][randomCol] = boatNumber;
                        this.board[randomRow + 2][randomCol] = boatNumber;
                        this.boatNumber++;
                        constraint = 1;
                    }   // if statement (checks to see if the spots next to random coordinate are open.
                    else {
                        randomRow = (int) ((Math.random() * arrayDimensions) + 1);
                        randomCol = (int) ((Math.random() * arrayDimensions) + 1);
                    }   // else statement
                }   // while loop
            }   // else (places the boats vertically)
        }   // else if statement

        ////////// Boat's length is 4 ///////////////

        else if (boatLength == 4) {
            horizontalOrVertical = (int) ((Math.random() * 10) + 1);
            constraint = 0;
            randomRow = (int) ((Math.random() * arrayDimensions) + 1);
            randomCol = (int) ((Math.random() * arrayDimensions) + 1);
            if (horizontalOrVertical <= 5) {
                while (constraint == 0) {
                    if (((randomCol + 1) <= arrayDimensions) && ((randomCol + 2) <= arrayDimensions) && ((randomCol + 3) <= arrayDimensions) && (this.board[randomRow][randomCol] == 0) && (this.board[randomRow][randomCol + 1] == 0) && (this.board[randomRow][randomCol + 2] == 0) && (this.board[randomRow][randomCol + 3] == 0)) {
                        this.board[randomRow][randomCol] = boatNumber;
                        this.board[randomRow][randomCol + 1] = boatNumber;
                        this.board[randomRow][randomCol + 2] = boatNumber;
                        this.board[randomRow][randomCol + 3] = boatNumber;
                        this.boatNumber++;
                        constraint = 1;
                    }   // if statement (checks to see if the spots next to random coordinate are open.
                    else {
                        randomRow = (int) ((Math.random() * arrayDimensions) + 1);
                        randomCol = (int) ((Math.random() * arrayDimensions) + 1);
                    }   // else statement
                }   // while loop
            }   // if (places the boats horizontally)
            else {
                while (constraint == 0) {
                    if (((randomRow + 1) <= arrayDimensions) && ((randomRow + 2) <= arrayDimensions) && ((randomRow + 3) <= arrayDimensions) && (this.board[randomRow][randomCol] == 0) && (this.board[randomRow + 1][randomCol] == 0) && (this.board[randomRow + 2][randomCol] == 0) && (this.board[randomRow + 3][randomCol] == 0)) {
                        this.board[randomRow][randomCol] = boatNumber;
                        this.board[randomRow + 1][randomCol] = boatNumber;
                        this.board[randomRow + 2][randomCol] = boatNumber;
                        this.board[randomRow + 3][randomCol] = boatNumber;
                        this.boatNumber++;
                        constraint = 1;
                    }   // if statement (checks to see if the spots next to random coordinate are open.
                    else {
                        randomRow = (int) ((Math.random() * arrayDimensions) + 1);
                        randomCol = (int) ((Math.random() * arrayDimensions) + 1);
                    }   // else statement
                }   // while loop
            }   // else (places the boats vertically)
        }   // else if statement

        ///////// Boat is of length 5 //////////////

        else if (boatLength == 5) {
            horizontalOrVertical = (int) ((Math.random() * 10) + 1);
            constraint = 0;
            randomRow = (int) ((Math.random() * arrayDimensions) + 1);
            randomCol = (int) ((Math.random() * arrayDimensions) + 1);
            if (horizontalOrVertical <= 5) {
                while (constraint == 0) {
                    if (((randomCol + 1) <= arrayDimensions) && ((randomCol + 2) <= arrayDimensions) && ((randomCol + 3) <= arrayDimensions) && ((randomCol + 4) <= arrayDimensions) && (this.board[randomRow][randomCol] == 0) && (this.board[randomRow][randomCol + 1] == 0) && (this.board[randomRow][randomCol + 2] == 0) && (this.board[randomRow][randomCol + 3] == 0) && (this.board[randomRow][randomCol + 4] == 0)) {
                        this.board[randomRow][randomCol] = boatNumber;
                        this.board[randomRow][randomCol + 1] = boatNumber;
                        this.board[randomRow][randomCol + 2] = boatNumber;
                        this.board[randomRow][randomCol + 3] = boatNumber;
                        this.board[randomRow][randomCol + 4] = boatNumber;
                        this.boatNumber++;
                        constraint = 1;
                    }   // if statement (checks to see if the spots next to random coordinate are open.
                    else {
                        randomRow = (int) ((Math.random() * arrayDimensions) + 1);
                        randomCol = (int) ((Math.random() * arrayDimensions) + 1);
                    }   // else statement
                }   // while loop
            }   // if (places the boats horizontally)
            else {
                while (constraint == 0) {
                    if (((randomRow + 1) <= arrayDimensions) && ((randomRow + 2) <= arrayDimensions) && ((randomRow + 3) <= arrayDimensions) && ((randomRow + 4) <= arrayDimensions) && (this.board[randomRow][randomCol] == 0) && (this.board[randomRow + 1][randomCol] == 0) && (this.board[randomRow + 2][randomCol] == 0) && (this.board[randomRow + 3][randomCol] == 0) && (this.board[randomRow + 4][randomCol] == 0)) {
                        this.board[randomRow][randomCol] = boatNumber;
                        this.board[randomRow + 1][randomCol] = boatNumber;
                        this.board[randomRow + 2][randomCol] = boatNumber;
                        this.board[randomRow + 3][randomCol] = boatNumber;
                        this.board[randomRow + 4][randomCol] = boatNumber;
                        this.boatNumber++;
                        constraint = 1;
                    }   // if statement (checks to see if the spots next to random coordinate are open.
                    else {
                        randomRow = (int) ((Math.random() * arrayDimensions) + 1);
                        randomCol = (int) ((Math.random() * arrayDimensions) + 1);
                    }   // else statement
                }   // while loop
            }   // else (places the boats vertically)
        }   // else if statement

    }   // setBoat method

    public void placeBoatsStandard() {
        //////////////////// Setting up boat of length 2 //////////////////////////////////

        setBoat(2, 7);

        //////////////////// Setting up 3 long boats ////////////////////////////

        setBoat(3, 7);
        setBoat(3, 7);

        //////////////// Setting up boat of length 4 ///////////////////////

        setBoat(4, 7);

        ///////////// Setting up boat of length 5 //////////////////////////

        setBoat(5, 7);

    }   // placeBoats method

    public void placeBoatsExpert() {
        //////////////////// Setting up 2 long boat //////////////////////////////////

        setBoat(2, 11);
        setBoat(2, 11);

        //////////////////// Setting up 3 long boats ////////////////////////////

        setBoat(3, 11);
        setBoat(3, 11);
        setBoat(3, 11);
        setBoat(3, 11);

        //////////////// Setting up boat of length 4 ///////////////////////

        setBoat(4, 11);
        setBoat(4, 11);

        ///////////// Setting up boat of length 5 //////////////////////////

        setBoat(5, 11);
        setBoat(5, 11);

    }   // placeBoats method

    public void display() {
        for (int row = 0; row < this.displayBoard.length; row++) {
            for (int col = 0; col < this.displayBoard[row].length; col++) {
                System.out.print(this.displayBoard[row][col]);
            }   // inner for loop
            System.out.println("");
        }   // outer for loop
    }   // display method

    public boolean checkIfSunk(int boatNumber) {
        //  Checks if the boat has sunk by seeing if its boat number is still on the board.
        int count = 0;
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                if (this.board[row][col] == boatNumber) {
                    count++;
                }   // if statement
            }   // inner for loop
        }   // outer for loop
        if (count > 0) {
            return false;
        }   // if statement
        else {
            return true;
        }   // else if statement
    }   // checkIfSunk method

    public void fire(int x, int y) {
        if ((x < 0) || (x > (this.board.length - 1)) || (y < 0) || (y > (this.board.length - 1))) {
            System.out.println("Penalty!");
            this.turns++;
            this.turns++;
            this.totalShots++;
        }   // if statement
        else if (this.board[x][y] == -2 || this.board[x][y] == -1) {
            System.out.println("Penalty!");
            this.turns++;
            this.turns++;
            this.totalShots++;
        }   // else if statement
        else if (this.board[x][y] == 0) {
            this.board[x][y] = -2;
            this.displayBoard[x][y] = " O ";
            System.out.println("Miss!");
            this.turns++;
            this.totalShots++;
        }   // else if statement
        else if (this.board[x][y] == 1) {
            this.board[x][y] = -1;
            this.displayBoard[x][y] = " X ";
            this.turns++;
            this.totalShots++;
            if (checkIfSunk(1) == true) {
                System.out.println("Sunk!");
            }   // if statement
            else {
                System.out.println("Hit!");
            }   // else statement
        }   // else if statement
        else if (this.board[x][y] == 2) {
            this.board[x][y] = -1;
            this.displayBoard[x][y] = " X ";
            this.turns++;
            this.totalShots++;
            if (checkIfSunk(2) == true) {
                System.out.println("Sunk!");
            }   // if statement
            else {
                System.out.println("Hit!");
            }   // else statement
        }   // else if statement
        else if (this.board[x][y] == 3) {
            this.board[x][y] = -1;
            this.displayBoard[x][y] = " X ";
            this.turns++;
            this.totalShots++;
            if (checkIfSunk(3) == true) {
                System.out.println("Sunk!");
            }   // if statement
            else {
                System.out.println("Hit!");
            }   // else statement
        }   // else if statement
        else if (this.board[x][y] == 4) {
            this.board[x][y] = -1;
            this.displayBoard[x][y] = " X ";
            this.turns++;
            this.totalShots++;
            if (checkIfSunk(4) == true) {
                System.out.println("Sunk!");
            }   // if statement
            else {
                System.out.println("Hit!");
            }   // else statement
        }   // else if statement
        else if (this.board[x][y] == 5) {
            this.board[x][y] = -1;
            this.displayBoard[x][y] = " X ";
            this.turns++;
            this.totalShots++;
            if (checkIfSunk(5) == true) {
                System.out.println("Sunk!");
            }   // if statement
            else {
                System.out.println("Hit!");
            }   // else statement
        }   // else if statement
        else if (this.board[x][y] == 6) {
            this.board[x][y] = -1;
            this.displayBoard[x][y] = " X ";
            this.turns++;
            this.totalShots++;
            if (checkIfSunk(6) == true) {
                System.out.println("Sunk!");
            }   // if statement
            else {
                System.out.println("Hit!");
            }   // else statement
        }   // else if statement
        else if (this.board[x][y] == 7) {
            this.board[x][y] = -1;
            this.displayBoard[x][y] = " X ";
            this.turns++;
            this.totalShots++;
            if (checkIfSunk(7) == true) {
                System.out.println("Sunk!");
            }   // if statement
            else {
                System.out.println("Hit!");
            }   // else statement
        }   // else if statement
        else if (this.board[x][y] == 8) {
            this.board[x][y] = -1;
            this.displayBoard[x][y] = " X ";
            this.turns++;
            this.totalShots++;
            if (checkIfSunk(8) == true) {
                System.out.println("Sunk!");
            }   // if statement
            else {
                System.out.println("Hit!");
            }   // else statement
        }   // else if statement
        else if (this.board[x][y] == 9) {
            this.board[x][y] = -1;
            this.displayBoard[x][y] = " X ";
            this.turns++;
            this.totalShots++;
            if (checkIfSunk(9) == true) {
                System.out.println("Sunk!");
            }   // if statement
            else {
                System.out.println("Hit!");
            }   // else statement
        }   // else if statement
        else if (this.board[x][y] == 10) {
            this.board[x][y] = -1;
            this.displayBoard[x][y] = " X ";
            this.turns++;
            this.totalShots++;
            if (checkIfSunk(10) == true) {
                System.out.println("Sunk!");
            }   // if statement
            else {
                System.out.println("Hit!");
            }   // else statement
        }   // else if statement

    }   // fire method

    public void drone(String direction, int index) {
        int count = 0;
        if (direction.equals("r")) {
            for (int col = 0; col < this.board.length; col++) {
                if ((this.board[index][col] != 0) && (this.board[index][col] != -1) && (this.board[index][col] != -2)) {
                    count++;
                }   // if statement
            }   // for loop
        }   // if statement
        else {
            for (int row = 0; row < this.board.length; row++) {
                if((this.board[row][index] != 0) && (this.board[row][index] != -1) && (this.board[row][index] != -2)) {
                    count++;
                }
            }   // for loop
        }   // else statement
        System.out.println("Drone has scanned " + count + " targets in the area.");
        this.turns++;
        this.totalShots++;
        this.droneCount++;
    }   // drone method

    public void missile(int x, int y) {
        if (this.board[x][y] != -1 && this.board[x][y] != -2) {
            if (this.board[x][y] == 0) {
                this.board[x][y] = -2;
                this.displayBoard[x][y] = " O ";
                System.out.println("Miss!");
            }   // inner if statement
            else {
                if (checkIfSunk(board[x][y]) == true) {
                    this.board[x][y] = -1;
                    this.displayBoard[x][y] = " X ";
                    System.out.println("Sunk!");
                }   // if statement
                else {
                    this.board[x][y] = -1;
                    this.displayBoard[x][y] = " X ";
                    System.out.println("Hit!");
                }   // inner else statement
            }   // outer else statement
        }   // outer if statement
        if (((x - 1) >= 0) && ((y - 1) >= 0)) {
            if (this.board[x - 1][y - 1] != -1 && this.board[x - 1][y - 1] != -2) {
                if (this.board[x - 1][y - 1] == 0) {
                    this.board[x - 1][y - 1] = -2;
                    this.displayBoard[x - 1][y - 1] = " O ";
                    System.out.println("Miss!");
                }   // inner if statement
                else {
                    if (checkIfSunk(board[x - 1][y - 1]) == true) {
                        this.board[x - 1][y - 1] = -1;
                        this.displayBoard[x - 1][y - 1] = " X ";
                        System.out.println("Sunk!");
                    }   // if statement
                    else {
                        this.board[x - 1][y - 1] = -1;
                        this.displayBoard[x - 1][y - 1] = " X ";
                        System.out.println("Hit!");
                    }   // inner else statement
                }   // outer else statement
            }   // if statement
        }   // outer if statement
        if (((y - 1) >= 0)) {
            if (this.board[x][y - 1] != -1 && this.board[x][y - 1] != -2) {
                if (this.board[x][y - 1] == 0) {
                    this.board[x][y - 1] = -2;
                    this.displayBoard[x][y - 1] = " O ";
                    System.out.println("Miss!");
                }   // inner if statement
                else {
                    if (checkIfSunk(board[x][y - 1]) == true) {
                        this.board[x][y - 1] = -1;
                        this.displayBoard[x][y - 1] = " X ";
                        System.out.println("Sunk!");
                    }   // if statement
                    else {
                        this.board[x][y - 1] = -1;
                        this.displayBoard[x][y - 1] = " X ";
                        System.out.println("Hit!");
                    }   // else statement
                }   // outer else statement
            }   // if statement
        }   // outer if statement
        if (((x+1) <= (this.board.length-1)) && ((y-1) >= 0)) {
            if (this.board[x + 1][y - 1] != -1 && this.board[x+1][y-1] != -2) {
                if (this.board[x + 1][y - 1] == 0) {
                    this.board[x + 1][y - 1] = -2;
                    this.displayBoard[x + 1][y - 1] = " O ";
                    System.out.println("Miss!");
                }   // inner if statement
                else {
                    if (checkIfSunk(board[x + 1][y - 1]) == true) {
                        this.board[x + 1][y - 1] = -1;
                        this.displayBoard[x + 1][y - 1] = " X ";
                        System.out.println("Sunk!");
                    }   // if statement
                    else {
                        this.board[x + 1][y - 1] = -1;
                        this.displayBoard[x + 1][y - 1] = " X ";
                        System.out.println("Hit!");
                    }   // inner else statement
                }   // outer else statement
            }   // if statement
        }   // outer if statement
        if ((x-1) >= 0) {
            if (this.board[x-1][y] != -1 && this.board[x-1][y] != -2) {
                if (this.board[x-1][y] == 0) {
                    this.board[x-1][y] = -2;
                    this.displayBoard[x-1][y] = " O ";
                    System.out.println("Miss!");
                }   // inner if statement
                else {
                    if (checkIfSunk(board[x-1][y]) == true) {
                        this.board[x-1][y] = -1;
                        this.displayBoard[x-1][y] = " X ";
                        System.out.println("Sunk!");
                    }   // if statement
                    else {
                        this.board[x-1][y] = -1;
                        this.displayBoard[x-1][y] = " X ";
                        System.out.println("Hit!");
                    }   // inner else statement
                }   // outer else statement
            }   // if statement
        }   // outer if statement
        if ((x+1) <= (this.board.length - 1)) {
            if (this.board[x + 1][y] != -1 && this.board[x+1][y] != -2) {
                if (this.board[x + 1][y] == 0) {
                    this.board[x + 1][y] = -2;
                    this.displayBoard[x + 1][y] = " O ";
                    System.out.println("Miss!");
                }   // inner if statement
                else {
                    if (checkIfSunk(board[x + 1][y]) == true) {
                        this.board[x + 1][y] = -1;
                        this.displayBoard[x + 1][y] = " X ";
                        System.out.println("Sunk!");
                    }   // if statement
                    else {
                        this.board[x + 1][y] = -1;
                        this.displayBoard[x + 1][y] = " X ";
                        System.out.println("Hit!");
                    }   // inner else statement
                }   // outer else statement
            }   // if statement
        }   // outer if statement
        if ((x-1) >= 0 && (y+1) <= (this.board.length - 1)) {
            if (this.board[x - 1][y + 1] != -1 && this.board[x-1][y+1] != -2) {
                if (this.board[x - 1][y + 1] == 0) {
                    this.board[x - 1][y + 1] = -2;
                    this.displayBoard[x - 1][y + 1] = " O ";
                    System.out.println("Miss!");
                }   // inner if statement
                else {
                    if (checkIfSunk(board[x - 1][y + 1]) == true) {
                        this.board[x - 1][y + 1] = -1;
                        this.displayBoard[x - 1][y + 1] = " X ";
                        System.out.println("Sunk!");
                    }   // if statement
                    else {
                        this.board[x - 1][y + 1] = -1;
                        this.displayBoard[x - 1][y + 1] = " X ";
                        System.out.println("Hit!");
                    }   // inner else statement
                }   // outer else statement
            }   // if statement
        }   // outer if statement
        if ((y+1) <= (this.board.length - 1)) {
            if (this.board[x][y + 1] != -1 && this.board[x][y+1] != -2) {
                if (this.board[x][y + 1] == 0) {
                    this.board[x][y + 1] = -2;
                    this.displayBoard[x][y + 1] = " O ";
                    System.out.println("Miss!");
                }   // inner if statement
                else {
                    if (checkIfSunk(board[x][y + 1]) == true) {
                        this.board[x][y + 1] = -1;
                        this.displayBoard[x][y + 1] = " X ";
                        System.out.println("Sunk!");
                    }   // if statement
                    else {
                        this.board[x][y + 1] = -1;
                        this.displayBoard[x][y + 1] = " X ";
                        System.out.println("Hit!");
                    }   // inner else statement
                }   // outer else statement
            }   // if statement
        }   // outer if statement
        if (((x+1) <= (this.board.length - 1)) && ((y+1) <= (this.board.length - 1))) {
            if (this.board[x + 1][y + 1] != -1 && this.board[x+1][y+1] != -2) {
                if (this.board[x + 1][y + 1] == 0) {
                    this.board[x + 1][y + 1] = -2;
                    this.displayBoard[x + 1][y + 1] = " O ";
                    System.out.println("Miss!");
                }   // inner if statement
                else {
                    if (checkIfSunk(board[x + 1][y + 1]) == true) {
                        this.board[x + 1][y + 1] = -1;
                        this.displayBoard[x + 1][y + 1] = " X ";
                        System.out.println("Sunk!");
                    }   // if statement
                    else {
                        this.board[x + 1][y + 1] = -1;
                        this.displayBoard[x + 1][y + 1] = " X ";
                        System.out.println("Hit!");
                    }   // inner else statement
                }   // outer else statement
            }   // if statement
        }   // outer if statement
        this.missileCount++;
        this.turns++;
        this.totalShots++;
    }   // missile method

    public boolean isGameOver() {
        // Checks to see if an boats are left on the board. If not, returns true and the game is done.
        int count = 0;
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                if (this.board[row][col] == 1) {
                    count++;
                }   // if statement
                else if (this.board[row][col] == 2) {
                    count++;
                }   // else if statement
                else if (this.board[row][col] == 3) {
                    count++;
                }   // else if statement
                else if (this.board[row][col] == 4) {
                    count++;
                }   // else if statement
                else if (this.board[row][col] == 5) {
                    count++;
                }   // else if statement
                else if (this.board[row][col] == 6) {
                    count++;
                }   // else if statement
                else if (this.board[row][col] == 7) {
                    count++;
                }   // else if statement
                else if (this.board[row][col] == 8) {
                    count++;
                }   // else if statement
                else if (this.board[row][col] == 9) {
                    count++;
                }   // else if statement
                else if (this.board[row][col] == 10) {
                    count++;
                }   // else if statement
            }   // inner for loop
        }   // outer for loop
        if (count > 0) {
            return false;
        }   // if statement
        else {
            this.turns--;
            return true;
        }   // else if statement
    }   // isGameOver method

    public void debug() {
        // Automatically wins the game. Does this by changing every element in array to -5, therefore isGameOver method will return true.
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                this.board[row][col] = -5;
            }   // inner for loop
        }   // outer for loop
        this.turns++;
        this.totalShots++;
    }   // debug method

    public void print() {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                if (this.board[row][col] == 0) {
                    System.out.print(" - ");
                }   // if statement
                else if (this.board[row][col] == -1) {      // Hit
                    System.out.print(" X ");
                }  // else statement
                else if (this.board[row][col] == -2) {      // Miss
                    System.out.print(" O ");
                }  // else statement
                else if (this.board[row][col] == 1) {
                    System.out.print(" 1 ");
                }  // else statement
                else if (this.board[row][col] == 2) {
                    System.out.print(" 2 ");
                }  // else statement
                else if (this.board[row][col] == 3) {
                    System.out.print(" 3 ");
                }  // else statement
                else if (this.board[row][col] == 4) {
                    System.out.print(" 4 ");
                }  // else statement
                else if (this.board[row][col] == 5) {
                    System.out.print(" 5 ");
                }  // else statement
                else if (this.board[row][col] == 6) {
                    System.out.print(" 6 ");
                }  // else statement
                else if (this.board[row][col] == 7) {
                    System.out.print(" 7 ");
                }  // else statement
                else if (this.board[row][col] == 8) {
                    System.out.print(" 8 ");
                }  // else statement
                else if (this.board[row][col] == 9) {
                    System.out.print(" 9 ");
                }  // else statement
                else if (this.board[row][col] == 10) {
                    System.out.print(" T ");                    // T stands for 10
                }  // else statement
            }   // inner for loop
            System.out.println("");
        }   // outer for loop
    }   // print Method

    public static void main(String[] args) {
    }

}
