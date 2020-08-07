// written by Alson Lor

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int done = 0;
        Scanner endScanner = new Scanner(System.in);
        while (done == 0) {
            System.out.println("Hello welcome to BattleBoats! Please enter 1 to play in standard mode or 2 to play in expert mode.");
            Scanner s = new Scanner(System.in);
            String gameType = s.nextLine();
            int constraint = 0;
            while (constraint == 0) {
                if (gameType.equals("1")) {
                    constraint++;
                }   // if statement
                else if (gameType.equals("2")) {
                    constraint++;
                }   // else if statement
                else {
                    System.out.println("Invalid input. Please enter 1 to play in standard mode or 2 to play in expert.");
                    gameType = s.nextLine();
                }   // else statement
            }   // while loop
            if (gameType.equals("1")) {     // Case where game mode is standard.
                Board newBoard = new Board();
                newBoard.placeBoatsStandard();
                int endGame = 0;
                while (endGame == 0) {
                    try {
                        newBoard.display();
                        System.out.println("Turn " + newBoard.turns);
                        System.out.println("Choose a coordinate to fire on. For example: 0 2 (This will fire on row 0, col 2. Range is from 0-7 for both row and col.)");
                        String coordinate = s.nextLine();
                        if (coordinate.equals("print")) {
                            newBoard.print();
                            System.out.println("");
                        }   // if statement
                        else if (coordinate.equals("debug")) {
                            newBoard.debug();
                        }   // else if statement
                        else if (coordinate.equals("missile")) {
                            if (newBoard.missileCount == 0) {
                                Scanner s2 = new Scanner(System.in);
                                int quitLoop = 0;
                                String missileCoords = "";
                                String[] missileValues = {"temp", "temp"};
                                while (quitLoop == 0) {
                                    try {
                                        System.out.println("Where would you like to launch your missile?");
                                        missileCoords = s2.nextLine();
                                        missileValues = missileCoords.split(" ");
                                        newBoard.missile(Integer.parseInt(missileValues[0]), Integer.parseInt(missileValues[1]));
                                        quitLoop = 1;
                                    }   // try
                                    catch (Exception ex) {
                                        System.out.println("Invalid input. Try again.");
                                    }   // catch
                                }   // while loop
                            }   // if statement
                            else {
                                System.out.println("Missile has already been used the maximum number of times.");
                            }   // else statement
                        }   // else if statement
                        else if (coordinate.equals("drone")) {
                            if (newBoard.droneCount == 0) {
                                Scanner s3 = new Scanner(System.in);
                                int exitValue = 0;
                                int exitValue2 = 0;
                                String rowOrCol = "";
                                String index = "";
                                while (exitValue == 0) {
                                    System.out.println("Would you like to scan a row or column? Type r for row and c for column");
                                    rowOrCol = s3.nextLine();
                                    if (rowOrCol.equals("r")) {
                                        while (exitValue2 == 0) {
                                            try {
                                                System.out.println("Which row or column would you like to scan?");
                                                index = s3.nextLine();
                                                if ((Integer.parseInt(index) < 0) || (Integer.parseInt(index) > (newBoard.board.length - 1))) {
                                                    System.out.println("Invalid input. Please type in a number within the bounds of the board.");
                                                }   // if statement
                                                else {
                                                    exitValue2 = 1;
                                                    exitValue = 1;
                                                }   // else statement
                                            }   // try
                                            catch (Exception except) {
                                                System.out.println("Invalid input. Please type in a number within the bounds of the board.");
                                            }   // catch
                                        }   // while loop
                                    }   // if statement
                                    else if (rowOrCol.equals("c")) {
                                        while (exitValue2 == 0) {
                                            try {
                                                System.out.println("Which row or column would you like to scan?");
                                                index = s3.nextLine();
                                                if ((Integer.parseInt(index) < 0) || (Integer.parseInt(index) > (newBoard.board.length - 1))) {
                                                    System.out.println("Invalid input. Please type in a number within the bounds of the board.");
                                                }   // if statement
                                                else {
                                                    exitValue2 = 1;
                                                    exitValue = 1;
                                                }   // else statement
                                            }   // try
                                            catch (Exception except) {
                                                System.out.println("Invalid input. Please type in a number within the bounds of the board.");
                                            }   // catch
                                        }   // while loop
                                    }   // else if statement
                                    else {
                                        System.out.println("Invalid input. Please type r for row or c for column.");
                                    }   // else statement
                                }   // while loop
                                newBoard.drone(rowOrCol, Integer.parseInt(index));
                            }   // if statement
                            else {
                                System.out.println("Drone has been used the maximum number of times.");
                            }   // else statement
                        }   // else if statement
                        else {
                            String[] coordinateValues = coordinate.split(" ");
                            newBoard.fire(Integer.parseInt(coordinateValues[0]), Integer.parseInt(coordinateValues[1]));
                        }   // else statement
                        if (newBoard.isGameOver() == true) {
                            endGame = 1;
                        }   // if statement
                    }   // try
                    catch (Exception e) {
                        System.out.println("Invalid input. Try again.");
                    }   // catch

                }   // while loop
                System.out.println("Game over! You beat the game in " + newBoard.turns + " turns with " + newBoard.totalShots + " total shots.");
                int checker = 0;
                while (checker == 0) {
                    try {
                        System.out.println("Do you want to play again? Enter y for yes and n for no.");
                        String decision = endScanner.nextLine();
                        if (!decision.equals("n") && !decision.equals("y")) {
                            System.out.println("Invalid input. Try again.");
                        }   // if statement
                        else {
                            if (decision.equals("n")) {
                                done++;
                                checker++;
                            }   // if statement
                            else if (decision.equals("y")) {
                                checker++;
                            }   // else if statement
                        }   // else statement
                    }   // try
                    catch (Exception exception) {
                        System.out.println("Invalid input. Try again.");
                    }   // catch
                }   // while loop
            }   // if statement
            else {                          // Case where game mode is expert.
                Board newBoard = new Board(12);
                newBoard.placeBoatsExpert();
                int endGame = 0;
                while (endGame == 0) {
                    try {
                        newBoard.display();
                        System.out.println("Turn " + newBoard.turns);
                        System.out.println("Choose a coordinate to fire on. For example: 0 2 (This will fire on row 0, col 2. Range is from 0-11 for both row and col.)");
                        String coordinate = s.nextLine();
                        if (coordinate.equals("print")) {
                            newBoard.print();
                            System.out.println("");
                        }   // if statement
                        else if (coordinate.equals("debug")) {
                            newBoard.debug();
                        }   // else if statement
                        else if (coordinate.equals("missile")) {
                            if (newBoard.missileCount <= 1) {
                                Scanner s2 = new Scanner(System.in);
                                int quitLoop = 0;
                                String missileCoords = "";
                                String[] missileValues = {"temp", "temp"};
                                while (quitLoop == 0) {
                                    try {
                                        System.out.println("Where would you like to launch your missile?");
                                        missileCoords = s2.nextLine();
                                        missileValues = missileCoords.split(" ");
                                        newBoard.missile(Integer.parseInt(missileValues[0]), Integer.parseInt(missileValues[1]));
                                        quitLoop = 1;
                                    }   // try
                                    catch (Exception ex) {
                                        System.out.println("Invalid input. Try again.");
                                    }   // catch
                                }   // while loop
                            }   // if statement
                            else {
                                System.out.println("Missile has already been used the maximum number of times.");
                            }   // else statement
                        }   // else if statement
                        else if (coordinate.equals("drone")) {
                            if (newBoard.droneCount <= 1) {
                                Scanner s3 = new Scanner(System.in);
                                int exitValue = 0;
                                int exitValue2 = 0;
                                String rowOrCol = "";
                                String index = "";
                                while (exitValue == 0) {
                                    System.out.println("Would you like to scan a row or column? Type r for row and c for column");
                                    rowOrCol = s3.nextLine();
                                    if (rowOrCol.equals("r")) {
                                        while (exitValue2 == 0) {
                                            try {
                                                System.out.println("Which row or column would you like to scan?");
                                                index = s3.nextLine();
                                                if ((Integer.parseInt(index) < 0) || (Integer.parseInt(index) > (newBoard.board.length - 1))) {
                                                    System.out.println("Invalid input. Please type in a number within the bounds of the board.");
                                                }   // if statement
                                                else {
                                                    exitValue2 = 1;
                                                    exitValue = 1;
                                                }   // else statement
                                            }   // try
                                            catch (Exception except) {
                                                System.out.println("Invalid input. Please type in a number within the bounds of the board.");
                                            }   // catch
                                        }   // while loop
                                    }   // if statement
                                    else if (rowOrCol.equals("c")) {
                                        while (exitValue2 == 0) {
                                            try {
                                                System.out.println("Which row or column would you like to scan?");
                                                index = s3.nextLine();
                                                if ((Integer.parseInt(index) < 0) || (Integer.parseInt(index) > (newBoard.board.length - 1))) {
                                                    System.out.println("Invalid input. Please type in a number within the bounds of the board.");
                                                }   // if statement
                                                else {
                                                    exitValue2 = 1;
                                                    exitValue = 1;
                                                }   // else statement
                                            }   // try
                                            catch (Exception except) {
                                                System.out.println("Invalid input. Please type in a number within the bounds of the board.");
                                            }   // catch
                                        }   // while loop
                                    }   // else if statement
                                    else {
                                        System.out.println("Invalid input. Please type r for row or c for column.");
                                    }   // else statement
                                }   // while loop
                                newBoard.drone(rowOrCol, Integer.parseInt(index));
                            }   // if statement
                            else {
                                System.out.println("Drone has been used the maximum number of times.");
                            }   // else statement
                        }   // else if statement
                        else {
                            String[] coordinateValues = coordinate.split(" ");
                            newBoard.fire(Integer.parseInt(coordinateValues[0]), Integer.parseInt(coordinateValues[1]));
                        }   // else statement
                        if (newBoard.isGameOver() == true) {
                            endGame = 1;
                        }   // if statement
                    }   // try
                    catch (Exception e) {
                        System.out.println("Invalid input. Try again.");
                    }   // catch
                }   // while loop
                System.out.println("Game over! You beat the game in " + newBoard.turns + " turns with " + newBoard.totalShots + " total shots.");
                int checker = 0;
                while (checker == 0) {
                    try {
                        System.out.println("Do you want to play again? Enter y for yes and n for no.");
                        String decision = endScanner.nextLine();
                        if (!decision.equals("n") && !decision.equals("y")) {
                            System.out.println("Invalid input. Try again.");
                        }   // if statement
                        else {
                            if (decision.equals("n")) {
                                done++;
                                checker++;
                            }   // if statement
                            else if (decision.equals("y")) {
                                checker++;
                            }   // else if statement
                        }   // else statement
                    }   // try
                    catch (Exception exception) {
                        System.out.println("Invalid input. Try again.");
                    }   // catch
                }   // while loop
            }   // else statement
        }   // outside while loop
        System.out.println("Thanks for playing!");
    }   // main method
}   // Main class

